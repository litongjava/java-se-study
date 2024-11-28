/**
 * Checker program for A10 - Pokemon with Exception.
 * 
 * @author: Lisa Miller
 * @since 07/31/2018
 */

public class PokeDriverLITPt1 {
	/** array size constant. */
	static final int HP_RANGE = 300;
	/**
	 * Creates and tests Pokemon objects. it stores 10 in an array of Pokemon and
	 * then tests all class methods
	 * 
	 * @param args not used.
	 */
	public static void main(String[] args) {

		ValidatedPokemonLITPt1 p1 = new ValidatedPokemonLITPt1("Blubasaur", "Bobby", 1, 34);

		System.out.println("\nTesting setSpecies method exception.");
		System.out.println("****************************************");
		System.out.println("\nbefore:\n" + p1);
		// call set species
		try {
			p1.setSpecies("");
			System.out.println("********** This should not print! ***************");
			System.out.println(p1);
		} catch (PokemonLITException pe) {
			System.out.println("setSpecies correctly threw Exception.");
			System.out.println("EXCEPTION MESSAGE: " + pe.getMessage());
		}

		System.out.println("\nTesting setName method.");
		System.out.println("****************************************");
		System.out.println("\nbefore:\n" + p1);
		try {
			p1.setName("");
			System.out.println("\nName should be Bulbasaur now");
			System.out.println("after:\n" + p1);
		} catch (PokemonLITException pe) {
			System.out.println("ERROR*** Should not print EXCEPTION MESSAGE: " + pe.getMessage());
		}

		System.out.println("\nChecking constructor for empty species: ");
		try {
			p1 = new ValidatedPokemonLITPt1("", "Sam", 1, 56);
			System.out.println("**ERROR**Constructor didn't catch empty species!");
			System.out.println(p1);

		} catch (PokemonLITException pe) {
			System.out.println("Correctly threw exception for empty species in constructor");
			System.out.println("Exception message: " + pe.getMessage());
		}

		System.out.println("\nChecking constructor for empty name -> species: ");
		try {
			p1 = new ValidatedPokemonLITPt1("Squirtle", "", 7, 87);
			System.out.println("Name should be Squirtle too!");
			System.out.println(p1);

		} catch (PokemonLITException pe) {

			System.out.println("**ERROR** Should not throw this exception");
			System.out.println("Exception message: " + pe.getMessage());
		}

	} // main method

} // class