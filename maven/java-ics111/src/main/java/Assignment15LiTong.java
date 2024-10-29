import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

/**
 * Assignment 15.
 * 
 * @author Tong Li
 * @since 24/10
 *
 */
public class Assignment15LiTong {
	/**
	 * main.
	 * 
	 * @param args input
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean keepGoing = true;
		while (keepGoing) {
			System.out.println("Enter how many phone numbers do you want or enter 0 to quit:");
			String temp = scanner.nextLine();
			boolean flag = true;
			int limit = 0;
			try {
				limit = Integer.parseInt(temp);
			} catch (NumberFormatException e) {
				flag = false;
			}

			if (flag) {
				if (limit == 0) {
					keepGoing = false;
					System.out.println("You have chosen to quit. Goodbye!");
				} else {
					System.out.println("Here is your list of phone numbers:");

					for (int i = 0; i < limit; i++) {
						System.out.println(i + "\t" + generateNumber());
					}
					System.out.println("Happy Calling!");
				}

			} else {
				System.out.println("I cannot print your list of phone numbers.");
				System.out.println("You did not give me an integer number.");
			}

		}

	}

	/**
	 * generate a phone number with 10 digits.
	 * 
	 * @return formatted phone number as a String
	 */
	public static String generateNumber() {
		Random random = new Random();

		// The first 3 digits are the area code and can not begin with 0, 8 or 9
		int areaCode = random.nextInt(100, 800);

		// The second 3 digits can not be greater than 750 and not less than 100.
		// 750 - 100 + 1 = 651
		// java 1.8
		// int middleDigits = random.nextInt(651) + 100;
		int middleDigits = random.nextInt(100, 750 + 1);

		// The last 4 digits can be any digits
		// You must allow numbers from 0000 up to 9999
		int lastDigits = random.nextInt(10000);

		// Format the phone number
		DecimalFormat fourDigitFormat = new DecimalFormat("0000");
		DecimalFormat threeDigitFormat = new DecimalFormat("000");

		String first = threeDigitFormat.format(areaCode);
		String second = threeDigitFormat.format(middleDigits);
		String third = fourDigitFormat.format(lastDigits);
		String phoneNumber = "(" + first + ") " + second + "-" + third;

		// returning generated phone number
		return phoneNumber;
	}
}
