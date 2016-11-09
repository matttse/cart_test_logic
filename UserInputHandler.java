import java.util.Arrays;
import java.util.Scanner;

/**
 * @Program_Name UserInputHandler
 * @Author Matthew Tse
 * @Date 07/01/2014 
 *
 */
public class UserInputHandler {
	
	//Declare and initialize global variables
	Scanner keyboardInput;
	String displayText, outputText;
	
	double userDoubleInput = 0.0;
	int userIntInput = 0;
	
	public UserInputHandler() {		
//		System.out.println(displayText);
		keyboardInput = new Scanner(System.in);
		
	}

	public String getString(String inputString) {
		boolean valid = false;
		int tryCnt = 0;
		inputValidator validateInput = new inputValidator();
		System.out.println(inputString);
		
		
		while (valid != true && tryCnt <3) {		

			String input = keyboardInput.nextLine();
			
			//iterate over input checking to make sure each char is Aa-Zz
			valid = validateInput.validate(input, 0, 0);
			
			if (valid == true) {
				
				outputText = processOutput(input);
			
			} else {
			
				System.out.println("Please try again.");
				tryCnt++;
				
			}
			
		}//end while

		if (valid != true) {
			//fail case
			outputText = "You have tried too many times. Please start over.";
		} 

		return outputText;
		
	}//end method
	
	public String getNum(String inputString, int typeFlag) {
		boolean valid = false;
		int tryCnt = 0;
		inputValidator validateInput = new inputValidator();
		System.out.println(inputString);		
		
		while (valid != true && tryCnt <3) {		

			String input = keyboardInput.nextLine();
			
			//iterate over input checking to make sure each position is 0-9
			valid = validateInput.validate(input, 1, typeFlag);
			
			if (valid == true) {
				
				outputText = processOutput(input);
			
			} else {
			
				System.out.println("Please try again.");
				tryCnt++;
				
			}
			
		}//end while

		if (valid != true) {
			//fail case
			outputText = "You have tried too many times. Please restart.";
		} 

		return outputText;
		
	}//end method

	
	public String processOutput(String processInput) {
		String processOuput;
		
		processOuput = processInput.replaceAll("\\s", "");
		
		return processOuput;
	}
	
	public float getAvgNum(Float sum, int numElements) {
		float avg = 0.0f;
		avg = sum / numElements;
		return avg;
	}
	
	public float getSumNum(Float[] arrayNums, int sizeArray) {
		float sum = 0.0f;
		for (int arrayCnt = 0; arrayCnt<sizeArray; arrayCnt++) {
			sum += arrayNums[arrayCnt];
		}
		return sum;
	}
	
	
	
	/*
	 * @Name: confirm
	 * @Function/Purpose: Called from validate.
	 * 
	 * @Parameters: String input, int flag 
	 * (i.e. 0 = String)
	 * @Additionl Comments: All input must be passed as a string.
	 * Flags:
	 * 0 = String
	 * 1 = int
	 * 2 = double
	 * 
	 * */
	public boolean confirmInput() {
		int confirmCntTry = 0;
		boolean valid = false;
		
		System.out.println("Is this correct (yes/no): ");
		String confirmInput = keyboardInput.nextLine();		
		
		while (confirmCntTry < 3){
			
			if("yes".equalsIgnoreCase(confirmInput) || "y".equalsIgnoreCase(confirmInput)) {
				
				confirmCntTry = 3;
				valid = true;
				
			} else if("no".equalsIgnoreCase(confirmInput) || "n".equalsIgnoreCase(confirmInput)) {
				
				confirmCntTry = 3;
				valid = false;
				
			} else {
				
				StringBuffer outputBuffer = new StringBuffer(40);
				String outputMsg = "Please type in yes or no. (Number of tries left: ";
				
				confirmCntTry++;
				outputMsg = outputBuffer.append(3 - confirmCntTry).append(")").toString();
				System.out.println(outputMsg);
				
			}	
			
		}
		return valid;
		
	}//end method
	
}//end class
