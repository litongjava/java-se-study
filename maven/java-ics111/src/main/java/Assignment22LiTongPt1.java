import java.util.Scanner;

/**
 * assignment 22.
 * 
 * @author Tong Li
 *
 */
public class Assignment22LiTongPt1 {

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
		while (yOrN.equalsIgnoreCase("y") && counter < SIZE) {

		}
		for (int i = 0; i < SIZE; i++) {

			if ("n".equalsIgnoreCase(yOrN)) {
				if (i == 0) {
					System.out.print("You don't have any Pokemons in your team.");
				} else {
					System.out.println(
							"************ Here is your team of " + i + " Pokemons! **************");
					for (int j = 0; j < i; j++) {
						System.out.println("Pokemon " + (j + 1) + " " + team[j]);
					}
				}
				return;

			} else if (!"y".equalsIgnoreCase(yOrN)) {
				System.out.println("Please input y or n.");
				i--;
				continue;
			}

			System.out.print("Enter Pokemon's species:");
			String species = scan.nextLine();

			System.out.println("Enter Pokemon's name:");
			String name = scan.nextLine();

			System.out.println("Enter Pokemon's number:");
			int number = 0;
			try {
				number = Integer.parseInt(scan.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("you didn't enter a valid nuber.");
				System.out.println("please try again");
				i--;
				continue;
			}

			System.out.println("Enter Pokemon's HP:");
			int hp = 0;
			try {
				hp = Integer.parseInt(scan.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("you didn't enter a valid nuber.");
				System.out.println("please try again");
				i--;
				continue;
			}

			try {
				team[i] = new ValidatedPokemonLITPt2(species, name, number, hp);
			} catch (PokemonLITException e) {
				System.out.println("Error making Pokemon!");
				System.out.println(e.getMessage());
				i--;
				continue;
			}

			System.out.println("This Pokemon was added to your team:");
			System.out.println(team[i].toString());
			System.out.println();

		}
	}

}
