/**
 * Assignment 8.
 * @author Tong Li
 * @since 24/09/2024
 */
public class Assignment8LiTong {

	/**
	 * main.
	 * @param args input
	 */
	public static void main(String[] args) {
		System.out.println("Please enter your first string:");
	   String firstStr = UtilitiesLiTong.readUserString();
	   System.out.println("Please enter your second string:");
	   String secondStr = UtilitiesLiTong.readUserString();
	   System.out.println("Please enter your third string:");
	   String thirdStr = UtilitiesLiTong.readUserString();
	    
	   System.out.println("The first String you entered is: " + firstStr);
	   System.out.println("The second String you entered is: " + secondStr);
	   System.out.println("The third String you entered is: " + thirdStr);
	    
	   System.out.println();
	   UtilitiesLiTong.averageStrings(firstStr, secondStr, thirdStr);
	   System.out.println();
	   UtilitiesLiTong.replaceChars(firstStr, secondStr, thirdStr);
	   System.out.println();
	   System.out.println("Good bye!");
	    
	    //scan.close();
	    
	}
}
