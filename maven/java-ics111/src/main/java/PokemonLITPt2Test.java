import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * jUnit test for Pokemon_UHN_Pt2.java.
 * 
 * @author Lisa Miller
 * @since 11/5/2024
 */
public class PokemonLITPt2Test {

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
		PokemonLITPt2 p = new PokemonLITPt2("Bulbasaur", "Bobby", 1, 85);
		Assert.assertTrue(" Pokemon constructor not working correctly ", p instanceof PokemonLITPt2);

	}

	/**
	 * toString method test. checks that toString return is properly formatted.
	 */
	@Test
	public void toStringTest() {
		PokemonLITPt2 p = new PokemonLITPt2("Bulbasaur", "Bobby", 1, 85);
		Assert.assertEquals(" toString output not correct ", 
            "Species: Bulbasaur\nName: Bobby\nNumber: 1\nHP: 85",
				p.toString());

	}
}