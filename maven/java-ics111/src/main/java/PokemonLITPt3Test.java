import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * jUnit test for PokemonLITPt3.java.
 * 
 * @author Lisa Miller
 * @since 11/11/2024
 */
public class PokemonLITPt3Test {

	/**
	 * Fixture initialization (common initialization for all tests).
	 **/
	@Before
	public void setUp() {
	}

	/**
	 * get species test. Checks that correct Species string is returned correctly
	 */
	@Test
	public void getSpeciesTest() {
		PokemonLITPt3 p = new PokemonLITPt3("Squirtle", "Sammy", 1, 67);
		Assert.assertEquals("getSpecies didn't return correct String.", "Squirtle", p.getSpecies());
	}

	/**
	 * set species test. Checks that info set correctly
	 */
	@Test
	public void setSpeciesTest() {
		PokemonLITPt3 p = new PokemonLITPt3("Pikachu", "Pika", 123, 89);
		System.out.println("Pokemon before setSpecies " + p);
		p.setSpecies("ElectraBuzz"); // use set method to change species
		System.out.println("Pokemon after setSpecies: " + p);
		String message = "setSpecies test did not return correct species. ";
		Assert.assertEquals(message, "ElectraBuzz", p.getSpecies());
	}

	/**
	 * get number test. Checks that number returned correctly
	 */
	@Test
	public void getNumberTest() {
		PokemonLITPt3 p = new PokemonLITPt3("Squirtle", "Sammy", 1, 67);
		Assert.assertEquals("getNumber didn't return correct value.", 1, p.getNumber());

	}

	/**
	 * set number test. Checks that info set correctly
	 */
	@Test
	public void setNumberTest() {
		PokemonLITPt3 p = new PokemonLITPt3("Pikachu", "Pika", 123, 89);
		System.out.println("Pokemon before setNumber " + p);
		p.setNumber(125); // use set method to change number
		System.out.println("Pokemon after setNumber: " + p);
		Assert.assertEquals("setNumber didn't return correct value.", 125, p.getNumber());
	}
}