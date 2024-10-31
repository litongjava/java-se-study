import java.util.Random;
import java.util.Scanner;

/**
 * Assignment 15.
 * 
 * @author Tong Li
 * @since Oct 29
 *
 */
public class Assignment16pt2LiTong {
	/**
	 * size.
	 */
	static final int SIZE = 25;

	/**
	 * main.
	 * 
	 * @param args input
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int min = 0;
		int max = 0;
		boolean keepGoing = true;
		while (keepGoing) {
			boolean minNumKeepGoing = true;
			boolean isException = false;
			while (minNumKeepGoing) {
				System.out.println("Please enter the minimum number value:");
				String temp = scanner.nextLine();

				try {
					min = Integer.parseInt(temp);
				} catch (NumberFormatException e) {
					System.out.println("You did not give me an integer number.");
					isException = true;
				}
				if (!isException) {
					if (min < 0) {
						System.out.println("Random range values must be non-negative");
					} else {
						minNumKeepGoing = false;
					}
				}
				isException = false;

			}
			boolean maxNumKeepGoing = true;
			while (maxNumKeepGoing) {
				System.out.println("Please enter a maximum number value (greater than the minimum):");
				String temp = scanner.nextLine();
				try {
					max = Integer.parseInt(temp);
				} catch (NumberFormatException e) {
					System.out.println("You did not give me an integer number.");
					isException = true;

				}
				if (!isException) {
					if (max < 0) {
						System.out.println("Random range values must be non-negative");
					} else {
						maxNumKeepGoing = false;
					}
				}
				isException = false;

			}
			if (max - min > 0) {
				keepGoing = false;
			} else {
				System.out.println("Your minimum is not less than your maximum!");
			}
		}

		Random random = new Random();
		int[] number = new int[SIZE];
		for (int i = 0; i < SIZE; i++) {
			number[i] = random.nextInt(min, max + 1);
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