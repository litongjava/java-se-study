/**
 * Assignment 17
 * 
 * @author Tong Li
 * @since Oct 31
 *
 */
public class Assignment17part1Litong {
	/**
	 * main.
	 * 
	 * @param args command line args eg:2 4 5 9 Lisa 18 234. 2 4 5 -1 Lisa 0 234.
	 */
	public static void main(String[] args) {
		if (args.length < 1) {
			System.out.println("This program requires a list of integer values.");
			System.out.println("You must enter at least one integer on the commandline.");
		} else {
			System.out.println("Got your list, converting it to integers.");
			System.out.println("");
			int[] numbers = new int[args.length];

			int counter = 0;
			for (int i = 0; i < args.length; i++) {
				try {
					numbers[counter] = Integer.parseInt(args[i]);
					counter++;
				} catch (NumberFormatException e) {
					System.out.println("The argument \"" + args[i] + "\" was not a valid integer");
					System.out.println("It will be skipped");
					System.out.println();

				}
			}
			System.out.println("I got " + counter + " integers from you.");
			System.out.println("Here they are:");
			for (int i = 0; i < counter; i++) {
				System.out.print(numbers[i] + " ");

			}

		}
	}
}