/**
 * StudentException to enforce Student validation
 * 
 * @author Lisa Miller
 * @since 11/15/23
 */
public class StudentException extends RuntimeException {

	/**
	 * Constructor calls super class constructor
	 * 
	 * @param message the error message
	 */
	public StudentException(String message) {
		super(message);
	}

}