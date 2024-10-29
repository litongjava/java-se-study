
/**
 * Assignment 9.
 * 
 * @author Tong Li
 * @since 26/09/2024
 *
 */
public class Assignment9Litong {

	/**
	 * main.
	 * 
	 * @param args input
	 */
	public static void main(String[] args) {
		UtilitiesLiTong.printText("Enter the radius of your cylinder:");
		try {
			double radius = UtilitiesLiTong.readUserDouble();
			System.out.printf("The radius is %.3f\n", radius);

			UtilitiesLiTong.println();
			UtilitiesLiTong.printText("Enter the height of your cylinder:");

			double height = UtilitiesLiTong.readUserDouble();
			System.out.printf("The height is %.3f\n", height);

			double area = UtilitiesLiTong.cylinderArea(radius, height);
			System.out.printf("The area of a cylinder with radius %.3f and height %.3f is %f \n",
             radius, height, area);

		} catch (NumberFormatException e) {
			UtilitiesLiTong.printText("You didn't enter a valid number");
		} catch (Exception e) {
			e.printStackTrace();
		}
		UtilitiesLiTong.println();
		UtilitiesLiTong.printText("Goodbye!");

	}
}
