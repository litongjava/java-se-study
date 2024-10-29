import java.util.Scanner;

/**
 * Assignment11.
 * @author Tong Li
 * @since 03/10/2024
 *
 */
public class Assignment11Litong {

	/**
	 * main.
	 * @param args input
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a letter grade to see the scoring criteria");
		String grade = scanner.nextLine().trim(); 

		String result = gradeCriteria(grade);

		if (!"ERROR".equals(result)) {
			System.out.println("The criteria for a grade of " + grade.toUpperCase() + " is " + result);
		} else {
			System.out.println("You didn't enter a valid letter grade");
		}

		System.out.println("Goodbye!");
	}

	/**
	 * grade.
	 * @param letter grade
	 * @return str
	 */
	public static String gradeCriteria(String letter) {
		return switch (letter.toUpperCase()) {
			case "A" -> "90 - 100%";
			case "B" -> "80 - 89%";
			case "C" -> "70 - 79%";
			case "D" -> "60 - 69%";
			case "F" -> "0 - 59%";
			default -> "ERROR";
		};
	}
	/*
	public static String gradeCriteria(String letter) {
		switch (letter.toUpperCase()) {
		   case "A":
			   return "90 - 100%";
		   case "B":
			   return "80 - 89%";
		   case "C":
			   return "70 - 79%";
		   case "D":
			   return "60 - 69%";
		   case "F":
			   return "0 - 59%";
		   default:
			   return "ERROR";
		}
	}
	*/
}
