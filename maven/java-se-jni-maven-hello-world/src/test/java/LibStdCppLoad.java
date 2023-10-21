import java.io.File;

/**
 * Created by litonglinux@qq.com on 10/21/2023_3:55 AM
 */
public class LibStdCppLoad {
  public static void main(String[] args) {

    String filename = "libstdc++-6.dll";
    String[] javLibraryPaths = System.getProperty("java.library.path").split(File.pathSeparator);
    for (String path : javLibraryPaths) {
      File file = new File(path, filename);
      if (file.exists()) {
        String fullPath = file.getAbsolutePath();
        System.out.println(fullPath);
        System.load(fullPath);
      }
    }

//    String fullPathToDll= "D:\\msys64\\mingw64\\bin\\" + filename;
//    System.load(fullPathToDll);
  }
}
