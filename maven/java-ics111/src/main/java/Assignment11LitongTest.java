import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 * 
 * @author Tong Li
 * @since 3/10/2024
 */
public class Assignment11LitongTest {


   /** Fixture initialization (common initialization for all tests). **/
   @Before public void setUp() {
   }


   /** Test A grade range with lowercase a. **/
   @Test public void aGradeTest() {
      String correct = "90 - 100%";
      String got = Assignment11Litong.gradeCriteria("a");
      Assert.assertEquals("String returned for grade \"a\" is incorrect.", got, correct);
   }
      /** Test A grade range with uppercase A. **/
   @Test public void aUpperGradeTest() {
      String correct = "90 - 100%";
      String got = Assignment11Litong.gradeCriteria("A");
      Assert.assertEquals("String returned for grade \"A\" is incorrect.", got, correct);
   }
      /** Test B grade range with lowercase b. **/
   @Test public void bGradeTest() {
      String correct = "80 - 89%";
      String got = Assignment11Litong.gradeCriteria("b");
      Assert.assertEquals("String returned for grade \"b\" is incorrect.", got, correct);
   }
         /** Test B grade range with uppercase B. **/
   @Test public void bUpperGradeTest() {
      String correct = "80 - 89%";
      String got = Assignment11Litong.gradeCriteria("B");
      Assert.assertEquals("String returned for grade \"B\" is incorrect.", got, correct);
   }
   
         /** Test C grade range with lowercase c. **/
   @Test public void cGradeTest() {
      String correct = "70 - 79%";
      String got = Assignment11Litong.gradeCriteria("c");
      Assert.assertEquals("String returned for grade \"c\" is incorrect.", got, correct);
   }
         /** Test C grade range with uppercase C. **/
   @Test public void cUpperGradeTest() {
      String correct = "70 - 79%";
      String got = Assignment11Litong.gradeCriteria("C");
      Assert.assertEquals("String returned for grade \"C\" is incorrect.", got, correct);
   }
   
            /** Test D grade range with lowercase d. **/
   @Test public void dGradeTest() {
      String correct = "60 - 69%";
      String got = Assignment11Litong.gradeCriteria("d");
      Assert.assertEquals("String returned for grade \"d\" is incorrect.", got, correct);
   }
         /** Test D grade range with uppercase D. **/
   @Test public void dUpperGradeTest() {
      String correct = "60 - 69%";
      String got = Assignment11Litong.gradeCriteria("D");
      Assert.assertEquals("String returned for grade \"D\" is incorrect.", got, correct);
   }

            /** Test F grade range with lowercase f. **/
   @Test public void fGradeTest() {
      String correct = "0 - 59%";
      String got = Assignment11Litong.gradeCriteria("f");
      Assert.assertEquals("String returned for grade \"f\" is incorrect.", got, correct);
   }
         /** Test F grade range with uppercase F. **/
   @Test public void fUpperGradeTest() {
      String correct = "0 - 59%";
      String got = Assignment11Litong.gradeCriteria("F");
      Assert.assertEquals("String returned for grade \"F\" is incorrect.", got, correct);
   }
   
    /** Test with invalid input. **/
   @Test public void errorGradeTest() {
      String correct = "ERROR";
      String got = Assignment11Litong.gradeCriteria("aloha");
      Assert.assertEquals("String returned for grade \"aloha\" is incorrect.", got, correct);
   }
   
}