import java.util.Random;

/**
 * Pokedex.java a driver class for PokemonLITPt3 Objects.
 * 
 * @author: Lisa Miller
 * @since 11/11/2024
 */

public class PokedexPt3 {
	/** array size constant. */
	static final int SIZE = 5;
   /**
    * HP_RANGE.
    */
	static final int HP_RANGE = 151;

	/**
	 * Creates and tests PokemonLITPt3 objects. it stores 10 in an array of
	 * PokemonLITPt3 and then tests all class methods
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
			"Squirtle", "Wartortle",
				//
			"Blastoise", "Charmander", "Charmeleon",
				//
			"Charizard", "Caterpie", "Metapod", "Butterfree" };
		String[] nameList = { "Alice", "Bob", "Carol", "Dave", "Edgar",
				//
			"Francine", "Grant", "Harriet", "Iggy", "Jane",
				//
			"Kile", "Lana", "Morrie", "Nancy" };
		PokemonLITPt3[] pokedexArr = new PokemonLITPt3[SIZE];
		PokemonLITPt3 tempPoke;
		Random ranGen = new Random();

		System.out.println("I will make 10 PokemonLITPt3,");
		System.out.println("then will print the whole list using toString.");

		for (int i = 0; i < SIZE; i++) {
			// choose a random PokemonLITPt3 from list of species
			pNum = ranGen.nextInt(speciesList.length);
			pSpecies = speciesList[pNum];
			pName = nameList[pNum];
			pHP = ranGen.nextInt(HP_RANGE); // random HP for PokemonLITPt3
			tempPoke = new PokemonLITPt3(pSpecies, pName, pNum, pHP);
			// System.out.println("Adding " + tempPoke);
			// add new PokemonLITPt3 to array. No name
			pokedexArr[i] = tempPoke;

		}

		// print the array of PokemonLITPt3 using toString
		System.out.println("\nPrinting all the PokemonLITPt3 from your Pokedex:");
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
			System.out.println("\nPokemon[" + iNum + "]'s species before: " 
             + pokedexArr[iNum].getSpecies());
			// call set Species
			pokedexArr[iNum].setSpecies("Snorlax");
			// call getSpecies and print
			System.out.println("Pokemon[" + iNum + "]'s species after: " 
             + pokedexArr[iNum].getSpecies());

		}

		// Randomly choose 2 to set the Number
		System.out.println("\nTesting setNumber and getNumber methods.");
		System.out.println("****************************************");
		for (int i = 0; i < 2; i++) {
			// choose a random Pokemon from array
			iNum = ranGen.nextInt(SIZE);

			System.out.println("\nPokemon[" + iNum + "]'s Number before: " 
             + pokedexArr[iNum].getNumber());
			// call set Number
			pokedexArr[iNum].setNumber(ranGen.nextInt(HP_RANGE));
			// call getNumber and print
			System.out.println("Pokemon[" + iNum + "] Number after: " + pokedexArr[iNum].getNumber());

		}

		// print the array of PokemonLITPt3 using toString
		System.out.println("\nPrinting all the PokemonLITPt3 from your Pokedex again:");
		System.out.println("****************************************");
		for (int i = 0; i < pokedexArr.length; i++) {
			System.out.println(i + " " + pokedexArr[i] + "\n");
		}
	} // main method

} // class