/**
 * Checker program for A10 - Pokemon with Exception.
 * 
 * @author: Lisa Miller
 * @since 07/31/2018
 */

public class PokeDriverLITPt2 {
	/** array size constant. */

	static final int HP_RANGE = 300;

	/**
	 * main method.
	 * 
	 * @param args not used.
	 */
	public static void main(String[] args) {

		ValidatedPokemonLITPt2 p1 = new ValidatedPokemonLITPt2("Blubasaur", "Bobby", 1, 34);

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

		System.out.println("\nTesting setHP method.");
		System.out.println("****************************************");
		System.out.println("\nbefore:\n" + p1);

		try {
			p1.setHP(-1);
			System.out.println("This should not print!");
			System.out.println(p1);
		} catch (PokemonLITException pe) {
			System.out.println("EXCEPTION MESSAGE: " + pe.getMessage());
		}

		System.out.println("\nTesting setNumber method.");
		System.out.println("****************************************");

		System.out.println("\nbefore:\n" + p1);
		try {
			p1.setNumber(-1);
			System.out.println("This should not print!");
			System.out.println(p1);
		} catch (PokemonLITException pe) {
			System.out.println("EXCEPTION MESSAGE: " + pe.getMessage());
		}

		System.out.println("\nChecking constructor for empty species: ");
		try {
			p1 = new ValidatedPokemonLITPt2("", "Sam", 1, 56);
			System.out.println("**ERROR**Constructor didn't catch empty species!");
			System.out.println(p1);

		} catch (PokemonLITException pe) {
			System.out.println("Correctly threw exception for empty species in constructor");
			System.out.println("Exception message: " + pe.getMessage());
		}

		System.out.println("\nChecking constructor for empty name -> species: ");
		try {
			p1 = new ValidatedPokemonLITPt2("Squirtle", "", 7, 87);
			System.out.println("Name should be Squirtle too!");
			System.out.println(p1);

		} catch (PokemonLITException pe) {

			System.out.println("**ERROR** Should not throw this exception");
			System.out.println("Exception message: " + pe.getMessage());
		}

		System.out.println("\nChecking constructor for invalid number: ");
		try {
			p1 = new ValidatedPokemonLITPt2("Squirtle", "Sam", -1, 56);
			System.out.println("Constructor didn't catch invalid number!");
			System.out.println(p1);

		} catch (PokemonLITException pe) {
			System.out.println("Correctly threw exception for invalid in constructor");
			System.out.println("Exception message: " + pe.getMessage());
		}

		System.out.println("\nChecking constructor for invalid HP: ");
		try {
			p1 = new ValidatedPokemonLITPt2("Squirtle", "Sam", 7, -90);
			System.out.println("Constructor didn't catch invalid HP!");
			System.out.println(p1);

		} catch (PokemonLITException pe) {
			System.out.println("Correctly threw exception for invalid HP in constructor");
			System.out.println("Exception message: " + pe.getMessage());
		}

	} // main method

} // class