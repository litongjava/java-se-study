import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * ValidatedPokemonLITPt1Test.
 * @author Tong Li.
 *
 */
public class ValidatedPokemonLITPt1Test {

	/**
	 * Fixture initialization (common initialization for all tests).
	 **/
	@Before
	public void setUp() {
	}

	/**
	 * set methods test Checks that info set correctly, no exception thrown for
	 * valid info.
    * @throws PokemonLITException PokemonLITException.
	 */
	@Test
	public void setMethodsTest() throws PokemonLITException {
		ValidatedPokemonLITPt1 p = new ValidatedPokemonLITPt1("Pikachu", "Pika", 123, 89);
		p.setSpecies("Polywrath");
		p.setNumber(62);
		p.setName("Polly");
		p.setHP(125);
		Assert.assertTrue("Name returned matches what set", (p.getName().equals("Polly")));
		Assert.assertTrue("Species returned matches what set",
				(p.getSpecies().equals("Polywrath")));
		Assert.assertTrue("HP returned matches what set", (125 == p.getHP()));
		Assert.assertTrue("Number returned matches what set", (62 == p.getNumber()));
	}

	/**
	 * Test PokemonLITException throwing
    * Test Exception thrown by empty species in constructor.
    * @throws PokemonLITException PokemonLITException.
	 */
	@Test(expected = PokemonLITException.class)
	public void testPokemonLITExceptionConstructorEmptySpecies() throws PokemonLITException {
		ValidatedPokemonLITPt1 p = new ValidatedPokemonLITPt1("", "Squiggy", 7, 45);
	}

	/** 
    * Test Exception thrown by empty species in setSpecies. 
    * @throws PokemonLITException PokemonLITException.
    */
	@Test(expected = PokemonLITException.class)
	public void testPokemonLITExceptionSetSpecies() throws PokemonLITException {
		ValidatedPokemonLITPt1 p = new ValidatedPokemonLITPt1("Squirtle", "Squiggy", 7, 45);
		p.setSpecies("");
	}

	/** Test empty name becomes species in setName. */
	@Test
	public void testEmptyNameSetName() {
		ValidatedPokemonLITPt1 p = new ValidatedPokemonLITPt1("Squirtle", "Squiggy", 7, 45);
		p.setName("");
		Assert.assertTrue(
				"setName method didn't set name to species when parameter string is empty",
				(p.getName().equals(p.getSpecies())));
	}

	/** Test empty name becomes species in constructor. */
	@Test
	public void testEmptyNameConstructor() {
		ValidatedPokemonLITPt1 p = new ValidatedPokemonLITPt1("Squirtle", "", 7, 45);
		Assert.assertTrue("Constructor didn't set name to species when parameter string is empty",
				(p.getName().equals(p.getSpecies())));
	}

}