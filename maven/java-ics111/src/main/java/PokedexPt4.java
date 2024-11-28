import java.util.Random;

/**
 * Pokedex.java a driver class for PokemonLITPt4 Objects.
 * 
 * @author: Lisa Miller
 * @since 11/11/2024
 */

public class PokedexPt4 {
	/** array size constant. */
	static final int SIZE = 5;
	/**
	 * hp range.
	 */
	static final int HP_RANGE = 151;

	/**
	 * Creates and tests PokemonLITPt4 objects. it stores 10 in an array of
	 * PokemonLITPt4 and then tests all class methods
	 * 
	 * @param args not used.
	 */
	public static void main(String[] args) {

		int iNum = 0;
		int pNum = 0;
		int pHP = 0;
		String pName = "";
		String pSpecies = "";
		String[] speciesList = { "Bulbasaur", "Venusaur", "Ivysaur",
				//
			"Squirtle", "Wartortle", "Blastoise", "Charmander",
				//
			"Charmeleon", "Charizard", "Caterpie", "Metapod",
				//
			"Butterfree" };
		String[] nameList = { "Alice", "Bob", "Carol", "Dave",
				//
			"Edgar", "Francine", "Grant", "Harriet", "Iggy",
				//
			"Jane", "Kile", "Lana", "Morrie", "Nancy" };
		PokemonLITPt4[] pokedexArr = new PokemonLITPt4[SIZE];
		PokemonLITPt4 tempPoke;
		Random ranGen = new Random();

		System.out.println("I will make 10 PokemonLITPt4,");
		System.out.println("then will print the whole list using toString.");

		for (int i = 0; i < SIZE; i++) {
			// choose a random PokemonLITPt4 from list of species
			pNum = ranGen.nextInt(speciesList.length);
			pSpecies = speciesList[pNum];
			pName = nameList[pNum];
			pHP = ranGen.nextInt(HP_RANGE); // random HP for PokemonLITPt4
			tempPoke = new PokemonLITPt4(pSpecies, pName, pNum, pHP);
			// System.out.println("Adding " + tempPoke);
			// add new PokemonLITPt4 to array. No name
			pokedexArr[i] = tempPoke;

		}

		// print the array of PokemonLITPt4 using toString
		System.out.println("\nPrinting all the PokemonLITPt4 from your Pokedex:");
		System.out.println("****************************************");
		for (int i = 0; i < pokedexArr.length; i++) {
			System.out.println(i + " " + pokedexArr[i] + "\n");
		}

		// Randomly choose 2 to set the species
		System.out.println("\nTesting setSpecies and getSpecies methods.");
		System.out.println("****************************************");
		for (int i = 0; i < 2; i++) {
			// choose a random Pokemon from array
			iNum = ranGen.nextInt(SIZE);
			String out = "\nPokemon[" + iNum + "]'s species before: " + pokedexArr[iNum].getSpecies();
			System.out.println(out);
			// call set Species
			pokedexArr[iNum].setSpecies("Snorlax");
			// call getSpecies and print
			out = "Pokemon[" + iNum + "]'s species after: " + pokedexArr[iNum].getSpecies();
			System.out.println();

		}

		// Randomly choose 2 to set the Number
		System.out.println("\nTesting setNumber and getNumber methods.");
		System.out.println("****************************************");
		for (int i = 0; i < 2; i++) {
			// choose a random Pokemon from array
			iNum = ranGen.nextInt(SIZE);

			String out = "\nPokemon[" + iNum + "]'s Number before: " + pokedexArr[iNum].getNumber();
			System.out.println(out);
			// call set Number
			pokedexArr[iNum].setNumber(ranGen.nextInt(HP_RANGE));
			// call getNumber and print
			out = "Pokemon[" + iNum + "] Number after: " + pokedexArr[iNum].getNumber();
			System.out.println(out);

		}

		// Randomly choose 2 to set the name to same as species
		System.out.println("\nTesting setName and getName methods.");
		System.out.println("****************************************");
		for (int i = 0; i < 2; i++) {
			// choose a random PokemonA19Pt1 from array of PokemonA19Pt1 objects
			iNum = ranGen.nextInt(SIZE);
			String out = "\nPokemon[" + iNum + "]'s name before:\n" + pokedexArr[iNum].getName();
			System.out.println(out);
			// call set name
			pokedexArr[iNum].setName(pokedexArr[iNum].getSpecies());
			// call getSpecies and print
			out = "\nPokemon[" + iNum + "]'s with name changed to its species: " 
             + pokedexArr[iNum].getName();
			System.out.println(out);

		}
		// Randomly choose 2 to set the HP
		System.out.println("\nTesting setHP method.");
		System.out.println("****************************************");
		for (int i = 0; i < 2; i++) {
			// choose a random PokemonA19Pt1 from array of PokemonA19Pt1 objects
			iNum = ranGen.nextInt(SIZE);

			System.out.println("\nPokemon[" + iNum + "]'s HP before:\n" + pokedexArr[iNum].getHP());
			// call set HP
			pokedexArr[iNum].setHP(ranGen.nextInt(HP_RANGE));
			// call getHP and print
			System.out.println("\nPokemon[" + iNum + "]'s HP after:\n" + pokedexArr[iNum].getHP());
		}

		// print the array of PokemonLITPt4 using toString
		System.out.println("\nPrinting all the PokemonLITPt4 from your Pokedex again:");
		System.out.println("****************************************");
		for (int i = 0; i < pokedexArr.length; i++) {
			System.out.println(i + " " + pokedexArr[i] + "\n");
		}
	} // main method

} // class