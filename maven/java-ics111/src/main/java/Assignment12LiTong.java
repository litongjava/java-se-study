import java.util.Scanner;

/**
 * Assignment 12.
 * 
 * @author Tong Li
 * @since 8/10/2024
 *
 */
public class Assignment12LiTong {

	/**
	 * tolerance.
	 */
	public static final double TOL = 0.2;

	/**
	 * main.
	 * 
	 * @param args input
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String temp;
		double d1, d2, de;
		double tolerance = 0.2;
		System.out.println("Press enter two times fast");
		temp = scanner.nextLine();
		d1 = System.currentTimeMillis();
		temp = scanner.nextLine();
		d2 = System.currentTimeMillis();
		d1 /= 1000;
		d2 /= 1000;
		System.out.println("Time 1 = " + d1);
		System.out.println("Time 2 = " + d2);
		boolean isSame = compareDoubles(d1, 2);
		if (isSame) {
			System.out.println("It is " + isSame + " that your presses were fast");
		} else {
			System.out.println("It is " + isSame + " that your presses were fast");
		}

	}
	/**
	 * compareDoubles.
	 * @param i d1
	 * @param j d2
	 * @return boolean
	 */
	public static boolean compareDoubles(double i, double j) {
		double de = Math.abs(i - j);
		return de > TOL;
	}

}
