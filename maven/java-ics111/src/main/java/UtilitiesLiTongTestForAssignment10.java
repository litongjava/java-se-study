import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
* Junit test for Assignment 10.
* @author Lisa Miller
* @since 9/26/24
*/
public class UtilitiesLiTongTestForAssignment10 {
   
   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
      
   }
   /** A test for the calculating A from correct range. **/
   @Test public void calculateATest() {
      String s1 = "You got an A";
      String sRet = "";
      
      //loop over acceptable range
      for(int i = 90; i <= 100; i++){      
         //call method
         sRet = UtilitiesLiTong.calculateGrade(i);
         assertEquals("Output from calculateGrade method is not correct for " + i + " score.", s1, sRet);
      }
      
   } //end calculateATest

   /** A test for the calculating B from 87. **/
   @Test public void calculateBTest() {
      String s1 = "You got a B";
      String sRet = "";
      
      //loop over acceptable B range
      for(int i = 80; i < 90; i++){
      
         //call method
         sRet = UtilitiesLiTong.calculateGrade(i);
         assertEquals("Output from calculateGrade method is not correct for " 
         + i + " score.", s1, sRet);
      }
      
   } //end calculateBTest
   
   
   /** A test for the calculating C. **/
   @Test public void calculateCTest() {
      String s1 = "You got a C";
      String sRet = "";
      //loop over acceptable C range
      for(int i = 70; i < 80; i++){
          //call method
         assertEquals("Output from calculateGrade method is not correct for " + i + " score.", s1, UtilitiesLiTong.calculateGrade(i));
      }
      
      
   } //end calculateCTest
 
       /** A test for the calculating D. **/
   @Test public void calculateDTest() {
      String s1 = "You got a D";
      //loop over acceptable B range
      for(int i = 60; i < 70; i++){
         //call method
         assertEquals("Output from calculateGrade method is not correct for " + i + " score.", s1, UtilitiesLiTong.calculateGrade(i));
      }
   } //end calculateDTest
   
   /** A test for the calculating F. **/
   @Test public void calculateFTest() {
      String s1 = "You got an F";
      
      //loop over acceptable B range
      for(int i = 0; i < 60; i++){
         //call method
         assertEquals("Output from calculateGrade method is not correct for " + i + " score.", s1, UtilitiesLiTong.calculateGrade(i));
      }
   } //end calculateFTest
  
} // end JUnit test