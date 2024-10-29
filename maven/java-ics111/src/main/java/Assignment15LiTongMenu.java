import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

/**
 * Assignment 15 Menu.
 * 
 * This program generates a list of random phone numbers based on user input.
 * It allows users to set the number of phone numbers to generate, print the list,
 * or exit the program.
 * 
 * @author Tong Li
 * @since 24/10
 *
 */
public class Assignment15LiTongMenu {

  /**
   * Main method to run the program.
   * 
   * @param args command-line arguments
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    boolean keepGoing = true;
    int limit = 100;

    while (keepGoing) {
      System.out.println("Please enter the number of your choice:");
      System.out.println("1 to change the amount of phone numbers to generate (defaults to 100)");
      System.out.println("2 to print a list of phone numbers");
      System.out.println("0 to exit");
      System.out.println("======================================");

      String temp = scanner.nextLine();
      switch (temp) {
      case "0": {
        System.out.println("You have chosen to exit");
        keepGoing = false;
        break;
      }
      case "1": {
        System.out.println("Please enter the amount of phone numbers you want:");
        temp = scanner.nextLine();
        boolean flag = true;
        try {
          limit = Integer.parseInt(temp);
        } catch (NumberFormatException e) {
          flag = false;
        }

        if (flag) {
          System.out.println("The amount of numbers to generate has been changed to " + limit);
        } else {
          System.out.println("You did not give me an integer number.");
          System.out.println("The amount of numbers will stay at: " + limit);
          System.out.println();
          System.out.println("======================================");
        }
        break;
      }
      case "2": {
        System.out.println("Here is your list of phone numbers:");
        for (int i = 0; i < limit; i++) {
          System.out.println((i + 1) + "\t" + generateNumber());
        }
        System.out.println("Happy Calling!");
        break;
      }
      default:
        System.out.println("You didn't enter a valid choice");
        System.out.println("Please try again");
        System.out.println("======================================");
      }
    }

    System.out.println("Aloha!");
    scanner.close();
  }

  /**
   * Generates a random phone number with a 3-digit area code, 3-digit central office code,
   * and a 4-digit line number.
   * 
   * @return formatted phone number as a String
   */
  public static String generateNumber() {
    Random random = new Random();

    int areaCode = random.nextInt(100, 800);

    int middleDigits = random.nextInt(100, 750 + 1);

    int lastDigits = random.nextInt(10000);

    DecimalFormat fourDigitFormat = new DecimalFormat("0000");
    DecimalFormat threeDigitFormat = new DecimalFormat("000");

    String first = threeDigitFormat.format(areaCode);
    String second = threeDigitFormat.format(middleDigits);
    String third = fourDigitFormat.format(lastDigits);
    String phoneNumber = "(" + first + ") " + second + "-" + third;

    return phoneNumber;
  }
}
