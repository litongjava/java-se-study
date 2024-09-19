/**
 * Assignment 4 after class.
 * 
 * @author Tong Li
 * @since 09/10/24
 */
public class LiTongAssignment4 {
   /**
    * PI.
    */ 
	static final double PI = 3.14159265358979323846;
	/**
	 * Main.
	 * @param args input
	 */
	public static void main(String[] args) {

		// 2 * PI * radius *(height + radius)
		double radius = 3.125;
		double height = 7.3333;
		double area = 2 * PI * radius * (height + radius);

		String resultString = "The area of a cylinder of radius " 
          + radius + " and height " + height + " is " + area;
		System.out.println(resultString);
	}
}
