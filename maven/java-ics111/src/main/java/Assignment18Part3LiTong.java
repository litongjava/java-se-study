import java.util.Scanner;

/**
 * Assgnment 18.
 * 
 * @author Tong Li
 * @since 7 Nov
 *
 */
public class Assignment18Part3LiTong {
	/**
	 * main.
	 * 
	 * @param args input
	 */
	public static void main(String[] args) {
		System.out.println("Please enter a line of multiple words separated by spaces:");
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		System.out.println("Here are the words in you entered:");
		String[] inputArray = input.split(" ");
		for (int i = 0; i < inputArray.length; i++) {
			System.out.println(inputArray[i]);
		}
		System.out.println();

		String smallestWord = inputArray[0];
		for (int i = 0; i < inputArray.length - 1; i++) {
			for (int j = 1; j < inputArray.length; j++) {
				int compareResult = inputArray[i].compareTo(inputArray[j]);

				System.out.println("Comparing \"" + inputArray[i] + "\" and \"" + inputArray[j] + "\"");

				if (compareResult > 0) {
					smallestWord = inputArray[i];
				}
				System.out.println(smallestWord + " is still the first.");
			}

		}
		System.out.println();
		System.out.println("In your list " + smallestWord + " is the first word alphabetically.");

	}
}
