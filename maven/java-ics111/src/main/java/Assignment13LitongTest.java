import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Assignment13  junit test.
 * @author Tong Li
 *
 */
public class Assignment13LitongTest {

	/** A test for the area code part. **/
	@Test
	public void phoneAreaTest() {
		String s = "";
		int val = 0;
		boolean is799 = false;
		for (int i = 0; i < 10000; i++) {
			s = Assignment13LiTong.generateNumber();
			s = s.substring(1, 4);
			try {
				val = Integer.parseInt(s);
				// System.out.println(val);
				Assert.assertTrue("Area code range allows > 799", (val < 800));
				Assert.assertTrue("Area code range allows < 100", (val >= 100));
				if (val == 799) {
					is799 = true;
				}
			} catch (NumberFormatException nfe) {
				Assert.assertTrue("Output string format is incorrect", false);

			}

		}
		Assert.assertTrue("Area range doesn't include 799", is799);
	}

	/** A test for the last four digits. **/
	@Test
	public void phoneLastTest() {
		String s = "";
		int val = 0;
		boolean isLessThan1000 = false;

		for (int i = 0; i < 1000; i++) {
			s = Assignment13LiTong.generateNumber();
			s = s.substring(10);
			try {
				val = Integer.parseInt(s);
				if (val < 1000) {
					isLessThan1000 = true;
				}
			} catch (NumberFormatException nfe) {
				Assert.assertTrue("Output string format is incorrect", false);

			}
			// System.out.println(val);
			Assert.assertTrue("Last 4 range allows > 9999", (val <= 9999));
			Assert.assertTrue("Last 4 not printing four digits or spaces in output", 
             (s.length() == 4));

		}
		Assert.assertTrue("Last 4 range doesn't include values less than 1000", isLessThan1000);
	}

	/** A test for the middle three digits. **/
	@Test
	public void phoneMidTest() {
		String s = "";
		int val = 0;
		boolean is750 = false;
		for (int i = 0; i < 10000; i++) {
			s = Assignment13LiTong.generateNumber();
			s = s.substring(6, 9);
			try {
				val = Integer.parseInt(s);
				// System.out.println(val);
				Assert.assertTrue("Middle three range allows > 750", (val <= 750));
				Assert.assertTrue("Middle three range allows < 100", (val >= 100));
				if (val == 750) {
					is750 = true;
				}
			} catch (NumberFormatException nfe) {
				Assert.assertTrue("Output string format is incorrect", false);

			}

		}
		Assert.assertTrue("Mid 3 range doesn't include 750", is750);
	}

	/**
	 * Fixture initialization (common initialization for all tests).
	 **/
	@Before
	public void setUp() {
	}
}