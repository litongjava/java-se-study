import java.util.Random;

/**
 * Pokedex.java a driver class for Pokemon_UHN_Pt2 Objects.
 * 
 * @author: Lisa Miller
 * @since 11/5/2024
 */

public class PokedexPt2 {
	/** array size constant. */
	static final int SIZE = 10;
	/**
	 * HP_RANGE.
	 */
	static final int HP_RANGE = 151;

	/**
	 * Creates and tests Pokemon_UHN_Pt2 objects. it stores 10 in an array of
	 * Pokemon_UHN_Pt2 and then tests all class methods
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
		String[] nameList = { "Alice", "Bob", "Carol", "Dave", "Edgar",
			 //
			 "Francine", "Grant", "Harriet", "Iggy", "Jane", "Kile",
			 //
			 "Lana", "Morrie", "Nancy" };
		PokemonLITPt2[] pokedexArr = new PokemonLITPt2[SIZE];
		PokemonLITPt2 tempPoke;
		Random ranGen = new Random();

		System.out.println("I will make 10 Pokemon_UHN_Pt2,");
		System.out.println("then will print the whole list using toString.");

		for (int i = 0; i < SIZE; i++) {
			// choose a random Pokemon_UHN_Pt2 from list of species
			pNum = ranGen.nextInt(speciesList.length);
			pSpecies = speciesList[pNum];
			pName = nameList[pNum];
			pHP = ranGen.nextInt(HP_RANGE); // random HP for Pokemon_UHN_Pt2
			tempPoke = new PokemonLITPt2(pSpecies, pName, pNum, pHP);
			System.out.println("Adding " + tempPoke);
			// add new Pokemon_UHN_Pt2 to array. No name
			pokedexArr[i] = tempPoke;

		}

		// print the array of Pokemon_UHN_Pt2 using toString
		System.out.println("\nPrinting all the Pokemon_UHN_Pt2 from your Pokedex:");
		System.out.println("****************************************");
		for (int i = 0; i < pokedexArr.length; i++) {
			System.out.println(i + " " + pokedexArr[i] + "\n");
		}

	} // main method

} // class