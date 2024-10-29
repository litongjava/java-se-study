import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;


/**
* Junit test for Assignment 8 Fun With Strings.
* @author Tong Li
* @since 9/26/2024
*/
public class UtilitiesLiTongTest {
   /** setup to read System.out. */ 
   private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
   /** redirect System.out. */
   private final PrintStream originalOut = System.out;

   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
      //redirect output to outContent 
      System.setOut(new PrintStream(outContent));
   }
   /** A test for the averageStrings method. **/
   @Test public void averageStringsTest() {
      
      //call method - output goes to outContent
	   UtilitiesLiTong.averageStrings("horse", "cat", "mississippi");
      
      //Platform-indpendent expected output construction, adressess window's newLine issue
      StringWriter expectedStringWriter = new StringWriter();
      PrintWriter printWriter = new PrintWriter(expectedStringWriter);
      printWriter.println("horse is 5 characters long");
      printWriter.println("cat is 3 characters long");
      printWriter.println("mississippi is 11 characters long");
      printWriter.println("The average length of your Strings is: 6.333333 characters.");
   
      printWriter.close();
      String expected = expectedStringWriter.toString();
      Assert.assertEquals("Output from the averageStrings method is not correct.", 
          expected, outContent.toString());
   } 
 
    /** A test for the replaceChars method. **/
   @Test public void replaceCharsTest() {
      String s1 = "The changed first String: horso\n";
      String s2 = "The changed second String: cit\n";
      String s3 = "The changed third String: mizzizzippi\n";
      
      //call method - output is in outContent
      UtilitiesLiTong.replaceChars("horse", "cat", "mississippi");
      //Platform-indpendent expected output construction, adressess window's newLine issue
      StringWriter expectedStringWriter = new StringWriter();
      PrintWriter printWriter = new PrintWriter(expectedStringWriter);
      printWriter.println("Changed horse to horso");
      printWriter.println("Changed cat to cit");
      printWriter.println("Changed mississippi to mizzizzippi");
   
      printWriter.close();
      String expected = expectedStringWriter.toString();
      
      Assert.assertEquals("Output from the replaceChars method is not correct.", 
            expected, outContent.toString());
      
      
   } //end averageStringsTest

   /** Restort System.out. **/
   @After
   public void restoreStreams() {
      System.setOut(originalOut);
   }
  
}