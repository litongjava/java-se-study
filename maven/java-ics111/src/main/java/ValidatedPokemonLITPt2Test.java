import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * test.
 * 
 * @author Tong Li
 *
 */
public class ValidatedPokemonLITPt2Test {

	/**
	 * Fixture initialization (common initialization for all tests).
	 **/
	@Before
	public void setUp() {
	}

	/**
	 * set methods test Checks that info set correctly, no exception thrown for
	 * valid info.
	 * 
	 * @throws PokemonLITException PokemonLITException.
	 */
	@Test
	public void setMethodsTest() throws PokemonLITException {
		ValidatedPokemonLITPt2 p = new ValidatedPokemonLITPt2("Pikachu", "Pika", 123, 89);
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
	 * Test PokemonLITException throwing.
	 * 
	 * @throws PokemonLITException PokemonLITException.
	 */
	@Test(expected = PokemonLITException.class)
	public void testPokemonLITExceptionConstructorEmptySpecies() throws PokemonLITException {
		ValidatedPokemonLITPt2 p = new ValidatedPokemonLITPt2("", "Squiggy", 7, 45);
	}

	/**
	 * Test Exception thrown by empty species in setSpecies.
	 * 
	 * @throws PokemonLITException PokemonLITException.
	 */
	@Test(expected = PokemonLITException.class)
	public void testPokemonLITExceptionSetSpecies() throws PokemonLITException {
		ValidatedPokemonLITPt2 p = new ValidatedPokemonLITPt2("Squirtle", "Squiggy", 7, 45);
		p.setSpecies("");
	}

	/** Test empty name becomes species in setName. */
	@Test
	public void testEmptyNameSetName() {
		ValidatedPokemonLITPt2 p = new ValidatedPokemonLITPt2("Squirtle", "Squiggy", 7, 45);
		p.setName("");
		Assert.assertTrue(
				"setName method didn't set name to species when parameter string is empty",
				(p.getName().equals(p.getSpecies())));
	}

	/** Test empty name becomes species in constructor. */
	@Test
	public void testEmptyNameConstructor() {
		ValidatedPokemonLITPt2 p = new ValidatedPokemonLITPt2("Squirtle", "", 7, 45);
		Assert.assertTrue("Constructor didn't set name to species when parameter string is empty",
				(p.getName().equals(p.getSpecies())));
	}

	/**
	 * Test Exception thrown by too low number in setNumber.
	 * 
	 * @throws PokemonLITException PokemonLITException.
	 */
	@Test(expected = PokemonLITException.class)
	public void testPokemonLITExceptionSetNumberLo() throws PokemonLITException {
		ValidatedPokemonLITPt2 p = new ValidatedPokemonLITPt2("Bulbasaur", "Bebe", 1, 900);
		p.setNumber(-98);
	}

	/**
	 * Test Exception thrown by too high number in setNumber.
	 * 
	 * @throws PokemonLITException PokemonLITException.
	 */
	@Test(expected = PokemonLITException.class)
	public void testPokemonLITExceptionSetNumberHi() throws PokemonLITException {
		ValidatedPokemonLITPt2 p = new ValidatedPokemonLITPt2("Bulbasaur", "Bebe", 1, 900);
		p.setNumber(876);
	}

	/**
	 * Test Exception thrown by too high number in constructor.
	 * 
	 * @throws PokemonLITException PokemonLITException.
	 */
	@Test(expected = PokemonLITException.class)
	public void testPokemonLITExceptionConstructorNumOutRangeHi() throws PokemonLITException {
		ValidatedPokemonLITPt2 p = new ValidatedPokemonLITPt2("Bulbasaur", "Bebe", 900, 45);
	}

	/**
	 * Test Exception thrown by too low number in constructor.
	 * 
	 * @throws PokemonLITException PokemonLITException.
	 */
	@Test(expected = PokemonLITException.class)
	public void testPokemonLITExceptionConstructorNumOutRangeLo() throws PokemonLITException {
		ValidatedPokemonLITPt2 p = new ValidatedPokemonLITPt2("Bulbasaur", "Bebe", -5, 45);
	}

	/**
	 * Test Exception thrown by too high HP in setHP.
	 * 
	 * @throws PokemonLITException PokemonLITException.
	 */
	@Test(expected = PokemonLITException.class)
	public void testPokemonLITExceptionSetHPHi() throws PokemonLITException {
		ValidatedPokemonLITPt2 p = new ValidatedPokemonLITPt2("Bulbasaur", "Bebe", 1, 900);
		p.setHP(500);
	}

	/**
	 * Test Exception thrown by too low HP in setHP.
	 * 
	 * @throws PokemonLITException PokemonLITException.
	 */
	@Test(expected = PokemonLITException.class)
	public void testPokemonLITExceptionSetHPLo() throws PokemonLITException {
		ValidatedPokemonLITPt2 p = new ValidatedPokemonLITPt2("Bulbasaur", "Bebe", 1, 900);
		p.setHP(-56);
	}

	/**
	 * Test Exception thrown by too high HP in constructor.
	 * 
	 * @throws PokemonLITException PokemonLITException.
	 */
	@Test(expected = PokemonLITException.class)
	public void testPokemonLITExceptionConstructorHPOutRangeHi() throws PokemonLITException {
		ValidatedPokemonLITPt2 p = new ValidatedPokemonLITPt2("Bulbasaur", "Bebe", 1, 900);
	}

	/**
	 * Test Exception thrown by too low HP in constructor.
	 * 
	 * @throws PokemonLITException PokemonLITException.
	 */
	@Test(expected = PokemonLITException.class)
	public void testPokemonLITExceptionConstructorHPOutRangeLo() throws PokemonLITException {
		ValidatedPokemonLITPt2 p = new ValidatedPokemonLITPt2("Bulbasaur", "Bebe", 1, -8);
	}

}