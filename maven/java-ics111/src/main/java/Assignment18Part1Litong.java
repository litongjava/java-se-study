import java.util.Scanner;

/**
 * Assignment 18.
 * 
 * @author Tong Li
 * @since 7 Nov
 */
public class Assignment18Part1Litong {

	/**
	 * main. 
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
		for (int i = 0; i < inputArray.length - 1; i++) {


			int compareResult = inputArray[i].compareTo(inputArray[i + 1]);

			System.out.println("Comparing \"" + inputArray[i] + "\" and \"" 
					+ inputArray[i + 1] + "\"");

			if (compareResult == 0) {
				System.out.println("* The word \"" + inputArray[i] + "\" is repeated");
			} else if (compareResult < 0) {
				System.out.println("* \"" + inputArray[i] + "\" comes before \"" 
						+ inputArray[i + 1] + "\" alphabetically");
			} else {
				System.out.println("* \"" + inputArray[i] + "\" comes after \"" 
						+ inputArray[i + 1] + "\" alphabetically");
			}
		}

	}
}
