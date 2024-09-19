package com.litongjava.bytebuffer;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.*;
import java.util.HashMap;
import java.util.Map;

public class FileCacheExample {
    
    // 缓存文件内容的 Map，key 是文件路径，value 是文件内容的 ByteBuffer
    private Map<String, ByteBuffer> fileCache = new HashMap<>();

    // 读取指定目录下的所有文件，并将其内容存储到内存中
    public void loadDirectoryToMemory(String dirPath) throws IOException {
        Path directory = Paths.get(dirPath);
        DirectoryStream<Path> stream = Files.newDirectoryStream(directory);
        
        for (Path filePath : stream) {
            if (Files.isRegularFile(filePath)) {
                // 读取文件内容到 ByteBuffer 中
                try (FileChannel fileChannel = FileChannel.open(filePath, StandardOpenOption.READ)) {
                    ByteBuffer buffer = ByteBuffer.allocateDirect((int) fileChannel.size());
                    fileChannel.read(buffer);
                    buffer.flip();  // 切换到读模式
                    fileCache.put(filePath.toString(), buffer);  // 将文件内容缓存
                }
            }
        }
    }

    // 从内存中获取文件内容
    public String getFileContent(String filePath) {
        ByteBuffer buffer = fileCache.get(filePath);
        if (buffer != null) {
            // 将 ByteBuffer 中的数据读取为字符串
            byte[] bytes = new byte[buffer.remaining()];
            buffer.get(bytes);  // 将数据读到 byte 数组
            buffer.rewind();  // 重置 buffer 为初始状态，方便下次读取
            return new String(bytes);
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        FileCacheExample example = new FileCacheExample();
        
        // 指定要加载的目录
        String directoryPath = "testDir";
        example.loadDirectoryToMemory(directoryPath);
        
        // 从缓存中获取文件内容
        String filePath = "testDir/test.txt";
        String content = example.getFileContent(filePath);
        if (content != null) {
            System.out.println("File Content:");
            System.out.println(content);
        } else {
            System.out.println("File not found in cache.");
        }
    }
}
