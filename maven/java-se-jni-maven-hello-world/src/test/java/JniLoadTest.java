import com.litongjava.Print;

public class JniLoadTest {
  public static void main(String[] args) {
    com.github.fommil.jni.JniLoader.load("java-se-jni-maven-hello-world-1.0.dll");
    Print print = new Print();
    print.print();
  }
}
