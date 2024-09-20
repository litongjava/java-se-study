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
		scan.close();
		return s;
	}
	/**
	 * scan next line.
	 * @return int
	 */
	public static int readUserInt() {
	  Scanner scan = new Scanner(System.in);
    String s = scan.nextLine();
    scan.close();
    return Integer.parseInt(s);
	}
}
