import java.util.Random;

/**
 * Assignment 15.
 * 
 * @author Tong Li
 * @since Oct 29
 *
 */
public class Assignment16LiTong {
	/**
	 * size.
	 */
	static final int SIZE = 25;
	/**
	 * min.
	 */
	static final int MIN = 5;
	/**
	 * max.
	 */
	static final int MAX = 45;

	/**
	 * main.
	 * 
	 * @param args input
	 */
	public static void main(String[] args) {
		Random random = new Random();
		int[] number = new int[SIZE];
		for (int i = 0; i < SIZE; i++) {
			number[i] = random.nextInt(MIN, MAX + 1);
		}
		System.out.println("Array:");
		for (int i = 0; i < SIZE; i++) {
			System.out.println(number[i]);
		}
		System.out.println("-------------------------------------------------------------");
		System.out.println("Histograms:");
		for (int i = SIZE - 1; i > 0; i--) {
			System.out.print(number[i] + "\t");
			for (int j = 0; j < number[i]; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
