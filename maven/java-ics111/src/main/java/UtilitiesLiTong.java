import java.util.Scanner;

/**
 * Utils.
 * @author Tong Lis
 *
 */
public class UtilitiesLiTong {
	
   /**
    * PI.
    */
	public static final double PI = 3.141592653589793;
	
   /**
	 * dozen.
	 */
	public static final int DOZEN = 12;
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
	/**
	 * replaceChars.
	 * @param firstStr firstStr
 	 * @param secondStr secondStr
	 * @param thirdStr thirdStr
	 */
	public static void replaceChars(String firstStr, String secondStr, String thirdStr) {
		String firstStrReplaced = firstStr.replace('e', 'o');
		String secondStrReplaced = secondStr.replace('a', 'i');
		String thirdStrReplaced = thirdStr.replace('s', 'z');
		
		System.out.printf("Changed %s to %s\n", firstStr, firstStrReplaced);
		System.out.printf("Changed %s to %s\n", secondStr, secondStrReplaced);
		System.out.printf("Changed %s to %s\n", thirdStr, thirdStrReplaced);
		
	}
	
	/**
	 * readUserDouble.
	 * @return double
	 */
	public static double readUserDouble() {
		Scanner scan = new Scanner(System.in);
  	   String s = scan.nextLine();
  	   return  Double.parseDouble(s);
   
	}
   
	/**
	 * cylinder Area.
	 * @param r r
	 * @param h height
	 * @return double
	 */
	public static double cylinderArea(double r, double h) {
		return 2 * PI * r * (r + h);
	}
	
	/**
	 * print text.
	 * @param text text
	 */
	public static void printText(String text) {
		System.out.println(text);
	}
   /**
    * println.
    */
	public static void println() {
		System.out.println();
		
	}
	/**
	 * calculateGrade.
	 * @param num score
	 * @return String
	 */
	public static String calculateGrade(int num) {
	   String grade;
	   if (num >= 90 && num <= 100) {
		   grade = "an A";  
	   } else if (num >= 80 && num < 90) {		   
		   grade = "a B";
	   } else if (num >= 70 && num < 90) {
		   grade = "a C";
	   } else if (num >= 60 && num < 70) {
		   grade = "a D";
	   } else {
		   grade = "an F";
	   }
	   return "You got " + grade;
	}

}
