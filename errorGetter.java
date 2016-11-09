

/**
 * @author mase
 *
 */
public class ErrorGetter {
	
	public String getErrors(String badInput) {
		String partialInput = "You have typed invalid character(s): ";

		partialInput += badInput;
		return partialInput;
		
	}//end method
	
}//end class