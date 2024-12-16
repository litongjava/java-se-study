import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * assignment 23.
 * 
 * @author Tong Li
 *
 */
public class Assignment23LiTongPt4 {
	/**
	 * main.
	 * 
	 * @param args not used.
	 */
	public static void main(String[] args) {
		List<ValidatedPokemonLITPt2> team = new ArrayList<>();

		Scanner scan = new Scanner(System.in);
//		int counter = 0;

		System.out.println("Do you want to add a Pokemon to your team? y/n:");
		String yOrN = scan.nextLine();
		while ("y".equalsIgnoreCase(yOrN)) {
			ValidatedPokemonLITPt2 validatedPokemonLITPt2 = new ValidatedPokemonLITPt2();

			System.out.print("What is the Pokemon's species?");
			String species = scan.nextLine();

			try {
				validatedPokemonLITPt2.setSpecies(species);
			} catch (PokemonLITException e) {
				System.out.println("**ERROR**:" + e.getMessage());
				System.out.println("Try again");
			}

			System.out.println("What is the Pokemon's name?");
			String name = scan.nextLine();
			validatedPokemonLITPt2.setName(name);

			boolean hasException = true;
			while (hasException) {
				System.out.println("What is the Pokemon's number?");
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
			hasException = true;
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

			team.add(validatedPokemonLITPt2);
			System.out.println("This Pokemon was added to your team:");
			System.out.println(team.toString());
			System.out.println();
			System.out.println("Do you want to add a Pokemon to your team? y/n:");
			yOrN = scan.nextLine();
		}

		if (team.size() == 0) {
			System.out.print("You don't have any Pokemons in your team.");
			return;
		}

		String msg = "*********** Here is your team of " + team.size() + " Pokemons! ************";
		System.out.println(msg);
		int i = 0;
		for (ValidatedPokemonLITPt2 p : team) {
			System.out.println("Pokemon " + (++i) + " " + p);
		}

		if (team.size() > 0) {
			System.out.println("Do you want to save your Pokemon team to a file? y/n");
			yOrN = scan.nextLine();
			if ("y".equalsIgnoreCase(yOrN)) {
				System.out.println("Enter the filename for your team:");
				String filename = scan.nextLine();
				while (filename.isBlank()) {
					System.out.println("Enter the filename for your team:");
					filename = scan.nextLine();
				}
				filename = filename + ".txt";
				File file = new File(filename);
				try (PrintWriter printWriter = new PrintWriter(new FileWriter(file))) {
//				try (FileWriter writer = new FileWriter(file)) {
					int j = 0;
					for (ValidatedPokemonLITPt2 p : team) {
//						writer.append("Pokemon " + (++j) + " " + p);
						printWriter.print("Pokemon " + (++j) + " " + p);
					}
					System.out.println("Your team was successfully written to: " + filename);
				} catch (IOException e) {
					System.out.print("Failed to save your team to a file");
				}

			}

		}
	}

}
