import java.util.Scanner;

/**
 * assignment 22.
 * 
 * @author Tong Li
 *
 */
public class Assignment22LiTongPt2 {

  /**
   * size.
   */
  static final int SIZE = 6;

  /**
   * main.
   * 
   * @param args not used.
   */
  public static void main(String[] args) {
    ValidatedPokemonLITPt2[] team = new ValidatedPokemonLITPt2[SIZE];

    Scanner scan = new Scanner(System.in);
    int counter = 0;

    System.out.println("Do you want to add a Pokemon to your team? y/n:");
    String yOrN = scan.nextLine();
    while (counter < SIZE && "y".equalsIgnoreCase(yOrN)) {
      ValidatedPokemonLITPt2 validatedPokemonLITPt2 = new ValidatedPokemonLITPt2();

      System.out.print("Enter Pokemon's species:");
      String species = scan.nextLine();

      try {
        validatedPokemonLITPt2.setSpecies(species);
      } catch (PokemonLITException e) {
        System.out.println("**ERROR**:" + e.getMessage());
        System.out.println("Try again");
      }

      System.out.println("Enter Pokemon's name:");
      String name = scan.nextLine();
      validatedPokemonLITPt2.setName(name);

      boolean hasException = true;
      while (hasException) {
        System.out.println("Enter Pokemon's number:");
        int number = 0;
        try {
          number = Integer.parseInt(scan.nextLine());
          System.out.println("Your Pokemon's number is " + number);
          validatedPokemonLITPt2.setNumber(number);
          hasException = false;
        } catch (NumberFormatException e) {
          System.out.println("**ERROR**: You didn't enter a valid integer number");
          System.out.println("please try again");
          hasException = true;
        } catch (PokemonLITException e) {
          System.out.println("**ERROR**:" + e.getMessage());
          System.out.println("please try again");
          hasException = true;
        }
      }

      while (hasException) {
        System.out.println("Enter Pokemon's HP:");
        int hp = 0;
        try {
          hp = Integer.parseInt(scan.nextLine());
          System.out.println("Your Pokemon's HP is " + hp);
          validatedPokemonLITPt2.setHP(hp);
          hasException = false;
        } catch (NumberFormatException e) {
          System.out.println("**ERROR**: You didn't enter a valid integer number");
          System.out.println("please try again");
          hasException = true;
        } catch (PokemonLITException e) {
          System.out.println("**ERROR**:" + e.getMessage());
          System.out.println("please try again");
          hasException = true;
        }
      }

      System.out.println("This Pokemon was added to your team:");
      System.out.println(team[counter].toString());
      System.out.println();
      counter++;
      System.out.println("Do you want to add a Pokemon to your team? y/n:");
      yOrN = scan.nextLine();
    }

    if (counter == 0) {
      System.out.print("You don't have any Pokemons in your team.");
      return;
    }

    for (int i = 0; i < counter; i++) {
      String msg = "*********** Here is your team of " + (counter + 1) + " Pokemons! ************";
      System.out.println(msg);
      System.out.println("Pokemon " + (i + 1) + " " + team[i]);
    }
  }

}
