

/**
 * @author mase
 *
 */
public class errorGetter {
	
	public String getErrors(String badInput) {
		String partialInput = "You have typed invalid character(s): ";
		
//		for(int charCnt = 0; badInput.length()>charCnt; charCnt++) {
//			partialInput += badInput;
//		}	
		
//		return partialInput;
		partialInput += badInput;
		return partialInput;
		
	}//end method
	
}//end class