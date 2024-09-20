import java.util.Scanner;

/**
 * Assignment6.
 * 
 * @author Tong Li
 * @since 09/12/2024
 *
 */
public class Assignment6LiTong {
   /**
    * dozen.
    */
	public static final int DOZEN = 12;

	/**
	 * main.
	 * 
	 * @param args input
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Please enter how many dozen cookies you have:");

		String input = scanner.nextLine();
		int num = Integer.parseInt(input);
		int total = num * DOZEN;
		String message = String.format("You have %d dozen of cookies \n" 
          + "Or %d total cookies", num, total);

		System.out.println(message);

		System.out.println("Please enter how many people get cookies:");

		input = scanner.nextLine();
		int peoples = Integer.parseInt(input);
		double peer = (double) total / (double) peoples;

		message = String.format("There are %d people to share the cookies \n" 
          + "Each person will get %1.1f cookies",
				peoples, peer);
		System.out.println(message);

		System.out.println("Goodbye!");

		scanner.close();
	}
}