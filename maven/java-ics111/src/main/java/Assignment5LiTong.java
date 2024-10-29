import java.util.Scanner;

/**
 * Assignment5 in class.
 * @author Ti Litong
 * @since 09/12/2024
 *
 */
public class Assignment5LiTong {

    /**
     * main.
     * @param args input
     */
   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);

      System.out.println("Please enter the radius of your cylinder:");

      String radiusInput = scanner.nextLine();
      double radius = Double.parseDouble(radiusInput);
        
      System.out.println("You entered a radius of: " + radius);

      System.out.println("Please enter the height of your cylinder:");

      String heightInput = scanner.nextLine();
      double height = Double.parseDouble(heightInput);

      System.out.println("You entered a height of: " + height);

      double area = 2 * Math.PI * radius * (radius + height);

      System.out.println("The area of a cylinder of radius " 
          + radius + " and height " + height + " is " + area);
        
      scanner.close();
   }
}