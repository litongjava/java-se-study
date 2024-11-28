import java.util.Scanner;

/**
 * Assgnment 18.
 * 
 * @author Tong Li
 * @since 7 Nov
 *
 */
public class Assignment18Part2LiTong {
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
				int compareResult = smallestWord.compareTo(inputArray[i+1]);

				System.out.println("Comparing \"" + smallestWord + "\" and \"" 
						+ inputArray[i+1] + "\"");

				if (compareResult > 0) {
					smallestWord = inputArray[i+1];
				}
				System.out.println(smallestWord + " is still the first.");
			
		}
		System.out.println();
		System.out.println("In your list " + smallestWord + " is the first word alphabetically.");

	}
}
