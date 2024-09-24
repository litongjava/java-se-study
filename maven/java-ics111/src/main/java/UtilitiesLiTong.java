import java.util.Scanner;

/**
 * Utils.
 * @author Tong Lis
 *
 */
public class UtilitiesLiTong {
	/**
	 * static method that adds two ints and prints the result.
	 * 
	 * @param i the first number
	 * @param j the second number
	 */
	public static void add(int i, int j) {
		// total is a local variable
		int total = 0;
		total = i + j;
		System.out.println(i + " + " + j + " = " + total);

	} // end add method

	/**
	 * adds two doubles and prints the result.
	 * 
	 * @param i the first number
	 * @param j the second number
	 */
	public static void add(double i, double j) {
		// total is a local variable
		double total = 0;
		total = i + j;
		System.out.println(i + " + " + j + " = " + total);

	} // end add method

	/**
	 * adds two doubles and returns the result.
	 * 
	 * @param i the first number
	 * @param j the second number
	 * @return the sum.
	 */
	public static double addAndReturn(double i, double j) {
		double total = i + j;
		return total;

	}

	/**
	 * Returns a String "Hello" + argument String.
	 * 
	 * @param name The person's name.
	 * @return a new String with Hello added to it.
	 */
	public static String sayHello(String name) {
		String s = "Hello " + name;
		return s;
	}
	
	/**
	 * scan next line.
	 * @return string.
	 */
	public static String readUserString() {
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
		return s;
	}
	/**
	 * scan next line.
	 * @return int
	 */
	public static int readUserInt() {
	   Scanner scan = new Scanner(System.in);
      String s = scan.nextLine();
      return Integer.parseInt(s);
	}
	
	/**
	 * print length and average of input strings.
	 * @param s1 s1
	 * @param s2 s2
	 * @param s3 s3
	 */
	public static void averageStrings(String s1, String s2, String s3) {
		int s1Length = s1.trim().length();
		int s2Length = s2.trim().length();
		int s3Length = s3.trim().length();
		System.out.printf("%s is %d characters long\n", s1, s1Length);
		System.out.printf("%s is %d characters long\n", s2, s2Length);
		System.out.printf("%s is %d characters long\n", s3, s3Length);
		
		double average = ((double) s1Length + (double) s2Length + (double) s3Length) / 3;
		System.out.printf("The average length of your Strings is: %f characters.\n", average);
	}
}
