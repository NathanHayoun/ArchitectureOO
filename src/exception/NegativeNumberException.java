package exception;
/**
 * @author Raphael
 *
 */
public class NegativeNumberException extends Exception {

	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = 7530007673194602212L;

	/**
	 * 
	 */
	public NegativeNumberException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public NegativeNumberException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public NegativeNumberException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public NegativeNumberException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public NegativeNumberException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
