public class HelloWorld {
  public static void main(String[] args) {
    System.out.println("Hello world");
    // get java version
    String javaVersion = System.getProperty("java.version");
    System.out.println(javaVersion);

    int currentTrackIndex = 4;
    int playMaxTracks = 2;
    int mod=currentTrackIndex % playMaxTracks;
    System.out.println(mod);
    boolean b = currentTrackIndex % playMaxTracks >= playMaxTracks;
    System.out.println(b);
  }
}