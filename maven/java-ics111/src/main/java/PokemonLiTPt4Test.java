import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * jUnit test for PokemonLITPt4.java.
 * 
 * @author Lisa Miller
 * @since 11/11/2024
 */
public class PokemonLiTPt4Test {

	/**
	 * Fixture initialization (common initialization for all tests).
	 **/
	@Before
	public void setUp() {
	}

	/**
	 * constructor test. checks that the constructor works.
	 */
	@Test
	public void constructorTest() {
		PokemonLITPt4 p = new PokemonLITPt4("Bulbasaur", "Bobby", 1, 85);
		Assert.assertTrue(" Pokemon constructor not working correctly ", p instanceof PokemonLITPt4);

	}

	/**
	 * toString method test. checks that toString return is properly formatted.
	 */
	@Test
	public void toStringTest() {
		PokemonLITPt4 p = new PokemonLITPt4("Bulbasaur", "Bobby", 1, 85);
		String expected = "Species: Bulbasaur\nName: Bobby\nNumber: 1\nHP: 85";
		Assert.assertEquals(" toString output not correct ", expected, p.toString());

	}

	/**
	 * get species test. Checks that correct Species string is returned correctly
	 */
	@Test
	public void getSpeciesTest() {
		PokemonLITPt4 p = new PokemonLITPt4("Squirtle", "Sammy", 1, 67);
		Assert.assertEquals("getSpecies didn't return correct String.", "Squirtle", p.getSpecies());
	}

	/**
	 * set species test. Checks that info set correctly
	 */
	@Test
	public void setSpeciesTest() {
		PokemonLITPt4 p = new PokemonLITPt4("Pikachu", "Pika", 123, 89);
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
		PokemonLITPt4 p = new PokemonLITPt4("Squirtle", "Sammy", 1, 67);
		Assert.assertEquals("getNumber didn't return correct value.", 1, p.getNumber());

	}

	/**
	 * set number test. Checks that info set correctly
	 */
	@Test
	public void setNumberTest() {
		PokemonLITPt4 p = new PokemonLITPt4("Pikachu", "Pika", 123, 89);
		System.out.println("Pokemon before setNumber " + p);
		p.setNumber(125); // use set method to change number
		System.out.println("Pokemon after setNumber: " + p);
		Assert.assertEquals("setNumber didn't return correct value.", 125, p.getNumber());
	}

	/**
	 * get name test. Checks that correct name string is returned correctly
	 */
	@Test
	public void getNameTest() {
		PokemonLITPt4 p = new PokemonLITPt4("Squirtle", "Sammy", 1, 67);
		Assert.assertEquals("getName didn't return correct String.", "Sammy", p.getName());
	}

	/**
	 * set species test. Checks that info set correctly
	 */
	@Test
	public void setNameTest() {
		PokemonLITPt4 p = new PokemonLITPt4("Pikachu", "Pika", 123, 89);
		System.out.println("Pokemon before setName " + p);
		p.setName("Fred"); // use set method to change species
		System.out.println("Pokemon after setName: " + p);
		Assert.assertEquals("setName test did not return correct species. ", "Fred", p.getName());
	}

	/**
	 * get HP test. Checks that Hp returned correctly
	 */
	@Test
	public void getHPTest() {
		PokemonLITPt4 p = new PokemonLITPt4("Squirtle", "Sammy", 1, 67);
		Assert.assertEquals("getHP didn't return correct value.", 67, p.getHP());

	}

	/**
	 * set HP test. Checks that info set correctly
	 */
	@Test
	public void setHPTest() {
		PokemonLITPt4 p = new PokemonLITPt4("Pikachu", "Pika", 123, 89);
		System.out.println("Pokemon before setHP " + p);
		p.setHP(999); // use set method to change number
		System.out.println("Pokemon after setHP: " + p);
		Assert.assertEquals("setHP didn't return correct value.", 999, p.getHP());
	}
}