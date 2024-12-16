/**
* Validated Student Object definition with class methods.
* Throw StudentException if invalid instance variables are attempted.
* @author Lisa Miller
* @since 11/15/2023
*/
public class Student {
   //define instance variables
   
   /** The Student name. */
   private String name;
   /** The Student ID number. */
   private int id;
   /** The Student grade point average. 
   * By default is -1 for new students.
   */
   private double gpa = -1.0;
   
   /** Constructor. 
   * @param newName is the Student's name.
   * @param newID is the Student's ID number.
   * @param newGPA is the Student's current GPA.
   */
   public Student(String newName, int newID, double newGPA) {
   
      //this.name = newName;
      //use set method to validate
      this.setName(newName);
     // this.id = newID;
      this.setID(newID);
      //this.gpa = newGPA;
      this.setGPA(newGPA);
   }
   
   /** Constructor. 
   * @param newName is the Student's name.
   * @param newID is the Student's ID number.
   */
   public Student(String newName, int newID) {  
      //this.name = newName;
      //use set method to validate
      this.setName(newName);
     // this.id = newID;
      this.setID(newID);
   }
   
   //********** Class methods ************
   /** toString.
   * @return a String representation of the Student
   */
   public String toString() {
      String s = "Name: " + this.name + " ID: " 
            + this.id + " GPA: " + this.gpa;
      return s;
   }
   
   //********** Accessor "Get" methods *************
   /**
   * Gets the Student name.
   * @return The Student's name
   */
   public String getName() {
      return this.name;
   }
   /**
   * Gets the Student ID number.
   * @return The Student's ID
   */
   public int getID() {
      return this.id;
   }
   /**
   * Gets the Student GPA.
   * @return The Student's GPA
   */
   public double getGPA() {
      return this.gpa;
   }
   
   //******* Mutator "Set" methods ************
   /**
   * Sets the Student name String.
   * @param n the new Student name.
   * @throws StudentException if String n is empty
   */
   public void setName(String n) throws StudentException {
      //if n String is not empty its allowed
      if(n.trim().length() > 0){
         this.name = n;
      } else {
         throw new StudentException("Student name cannot be empty");
      } 
   }
   
   /**
   * Sets the Student ID number.
   * @param i the new Student ID.
   * @throws StudentException if i is < 1000
   */
   public void setID(int i) throws StudentException {
      if(i >= 1000) {
         this.id = i;
      } else {
         throw new StudentException("Student ID must be at least 1000");
      }
   }
   
   /**
   * Sets the Student GPA value.
   * @param g the new Student GPA.
   * @throws StudentException if g is > 4.0
   */
   public void setGPA(double g) throws StudentException {
      if(g <= 4.0) {
         this.gpa = g;
      } else {
         throw new StudentException("Student GPA cannot be greater than 4.0");
      }   
   }

}