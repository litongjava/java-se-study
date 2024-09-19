/**
 * Assignment7.
 * 
 * @author Tong Li
 * @since 09/15/2024
 *
 */
public class Assignment7LiTong {

	/**
	 * main.
	 * 
	 * @param args input
	 */
	public static void main(String[] args) {
		int i1 = 7;
		int i2 = 9;
		int i3 = 34;
		int i4 = 4567;

		double d1 = 2.5;
		double d2 = 0.987;
		double dTotal = 0.0;

		String s1 = "Lisa";
		String sRet = "";

		UtilitiesLiTong.add(i1, i2); // method call for add taking in ints

		i1 = 340;
		i2 = -95;

		// call add again, it will do its task with the new values of i1 and i2
		UtilitiesLiTong.add(i1, i2); 

		// call add again, it will do its task with the values in i3 and i4
		UtilitiesLiTong.add(i3, i4); 

		// call add with doubles, the other add method will run.
		UtilitiesLiTong.add(d1, d2); 

		// call of non-void methods
		// this method returns the total back here, it is assigned to dTotal
		dTotal = UtilitiesLiTong.addAndReturn(d1, d2);

		System.out.println("Got back from method: " + dTotal); // printing what came back

		// calling the method that takes in and returns a string
		sRet = UtilitiesLiTong.sayHello(s1); 

		System.out.println(sRet); // print out what was returned from sayHello

		// here we call sayHello from inside a print statement.
		// we send the hardcodede String "Sally" to the method
		// The String returned from sayHello is then sent to println and printed.
		System.out.println(UtilitiesLiTong.sayHello("Sally"));

		System.out.println("Please enter your name:"); // print canary
		s1 = UtilitiesLiTong.readUserString();
		System.out.println("Your name is: " + s1); // print canary

	}
}