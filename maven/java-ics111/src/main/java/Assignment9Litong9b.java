/**
 * Assignment 9.
 * 
 * @author Tong Li
 * @since 1/10/2024
 *
 */
public class Assignment9Litong9b {

	/**
	 * main.
	 * 
	 * @param args input
	 */
	public static void main(String[] args) {
		System.out.println("Please enter how many dozen cookies you have:");

		try {
			int num = UtilitiesLiTong.readUserInt();
			int total = num * UtilitiesLiTong.DOZEN;
			String message = String.format("You have %d dozen of cookies \n" 
	          + "Or %d total cookies", num, total);

			System.out.println(message);

			System.out.println("Please enter how many people get cookies:");

			
			int peoples = UtilitiesLiTong.readUserInt();
			double peer = (double) total / (double) peoples;

			message = String.format("There are %d people to share the cookies \n" 
	          + "Each person will get %1.1f cookies",
					peoples, peer);
			
			System.out.println(message);
		} catch (NumberFormatException e) {
			System.out.println("You didn't enter a valid number!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	

		System.out.println("Goodbye!");
	}
}