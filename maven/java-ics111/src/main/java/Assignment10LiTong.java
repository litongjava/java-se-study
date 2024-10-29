
/**
 * Assignment 10.
 * @author Tong Li
 *
 */
public class Assignment10LiTong {
	/**
	 * main.
	 * args input
    * @param args input
	 */
	public static void main(String[] args) {
		System.out.println("Please enter a grade between 0~100");
		
		try {
			int num = UtilitiesLiTong.readUserInt();
			if (num > 100) {
				System.out.println("You made a mistake, the score that you entered is larger than 100, "
						+ "it should be a number from 0~100");
			} else if (num < 0) {
				System.out.println("You made a mistake, the score that you entered is less than 0, "
						+ "it should be a number from 0~100");
			} else {
				String grade = UtilitiesLiTong.calculateGrade(num);
				System.out.println(grade);
			}
		} catch (NumberFormatException e) {
			System.out.println("You made a mistake, "
					+ "the score that you enter should be a number from 0~100");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Bye bye from the main");
		
		
		
	}
}
