import java.text.DecimalFormat;
import java.util.Random;

/**
 * Assignment 13.
 * 
 * @author Tong Li
 * @since 17/10
 *
 */
public class AssignmentLiTong13 {
	/**
	 * main.
	 * 
	 * @param args input
	 */
	public static void main(String[] args) {
		String output = "Here's your next number to call:\t" + generateNumber();
		System.out.println(output);
//		for (int i = 0; i < 10000; i++) {
//			String output = "Here's your next number to call:\t" + generateNumber();
//			System.out.println(output);
//		}

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
		int middleDigits = random.nextInt(100, 750);

		// The last 4 digits can be any digits
		// You must allow numbers from 0000 up to 9999
		int lastDigits = random.nextInt(10000);

		// Format the phone number
		DecimalFormat fourDigitFormat = new DecimalFormat("0000");
		DecimalFormat threeDigitFormat = new DecimalFormat("000");

		String phoneNumber = "(" + threeDigitFormat.format(areaCode) + ") " + threeDigitFormat.format(middleDigits)
				+ "-" + fourDigitFormat.format(lastDigits);

		// returning generated phone number
		return phoneNumber;
	}
}
