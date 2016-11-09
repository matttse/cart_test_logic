/**
 * @Program_Name example_multiClass_multiTypeInput
 * @Author Matthew Tse
 * @Date 07/01/2014 
 *
 */
import java.util.Arrays;
import java.util.Scanner;
public class example_multiClass_multiTypeInput {

	//Main method
    public static void main (String [] args)
    {
    	//Initialize and declare global vars
    	String name = "";
    	int nameLength = 0;
    	String defaultMsg = "You have entered: ";
    	boolean confirmResult = false;    	
    	Float[] aFloat;    	
    	Float avgNum = 0.0f
    		, maxNum = 0.0f
    		, minNum = 0.0f
    		, sumNum = 0.0f;
    	Float[] runTotal;
    	String outputMsg = "";
    	int numItems = 0;
    	
    	//instantiate the handler
        UserInputHandler processInput = new UserInputHandler();
        
    	//Prompt the user for first input 
        name = processInput.getString("Please enter first name (i.e. Matthew): ");
        
        //check against blank entries
        if (name.length() == 0) {
        	
        	System.out.println("You did not enter anything. Please Try again.");
        	name = processInput.getString("Please enter first name (i.e. Matthew): ");
        	
        } else {
        	
            System.out.print(defaultMsg);
            System.out.println(name);
            
            name += " ";
            nameLength = name.length();

            //Prompt the user for second input
            while (nameLength == name.length()){

    	        name += processInput.getString("Please enter last name (i.e. Tse): ");
    	        
    	        if (nameLength == name.length()) {
    	        	
    	        	System.out.println("You did not enter anything. Please Try again.");
    	        	
    	        }
    	        
            } 
            	
        	System.out.print(defaultMsg);
            System.out.println(name);
            
            //confirm the name is correct
            confirmResult = processInput.confirmInput();
            
            if (confirmResult != true) {
            	
            	System.out.println("Please restart.");
            	exit(0);
            	
            }
            aFloat = new Float[7];
        /*	aFloat = new Float[6];
			System.out.print("aFloat.length = ");
			System.out.println(aFloat.length);
    		for (int idx = 0; idx<=aFloat.length; idx++) {
    			System.out.print("idx = ");
    			System.out.println(idx);
        		try {
            		
            		aFloat[idx] = Float.parseFloat(processInput.getNum("Please enter a number: ", 1));
					System.out.print(defaultMsg);
					outputMsg = "Current total: ";
					System.out.print(outputMsg);		
					System.out.println(processInput.getSumNum(aFloat, idx));
										
				} catch (NumberFormatException nfe) {
					
					System.out.println("You did not enter a number. Please restart.");

				}
        		
        		
        	}*/
        	
        	try {
        		
				aFloat[0] = Float.parseFloat(processInput.getNum("Please enter an integer: ", 0));
				int firstNumInt = aFloat[0].intValue();
				
				System.out.print(defaultMsg);
				System.out.println(firstNumInt);
				
			} catch (NumberFormatException nfe) {
				
				System.out.println("You did not enter a number. Please restart.");
				exit(0);
			}
        	
        	try {
        		runTotal = new Float[2];
        		
				aFloat[1] = Float.parseFloat(processInput.getNum("Please enter a number: ", 2));
				Double secondNumDoub = aFloat[1].doubleValue();
				System.out.print(defaultMsg);
				System.out.println(secondNumDoub);
				
				outputMsg = "Current total: ";
				System.out.print(outputMsg);					
				
				int nextIndex = 0;					
				runTotal[nextIndex++] = aFloat[0];
				runTotal[nextIndex++] = aFloat[1];
				
				System.out.println(processInput.getSumNum(runTotal, 2));
				
			} catch (NumberFormatException nfe) {
				
				System.out.println("You did not enter a number. Please restart.");
				exit(0);
				
			}
    	
        	try {
        		runTotal = new Float[3];
        		
				aFloat[2] = Float.parseFloat(processInput.getNum("Please enter a number: ", 1));
				
				System.out.print(defaultMsg);
				System.out.println(aFloat[2]);
				outputMsg = "Current total: ";
				System.out.print(outputMsg);	
				
				int nextIndex = 0;			
				runTotal[nextIndex++] = aFloat[0];
				runTotal[nextIndex++] = aFloat[1];
				runTotal[nextIndex++] = aFloat[2];
				
				
				System.out.println(processInput.getSumNum(runTotal, 3));
				
			} catch (NumberFormatException nfe) {
				
				System.out.println("You did not enter a number. Please restart.");
				exit(0);
				
			}     
        	
        	try {
        		runTotal = new Float[4];
        		
				aFloat[3] = Float.parseFloat(processInput.getNum("Please enter a number: ", 1));
				
				System.out.print(defaultMsg);
				System.out.println(aFloat[3]);
				outputMsg = "Current total: ";
				System.out.print(outputMsg);	
				
				int nextIndex = 0;			
				runTotal[nextIndex++] = aFloat[0];
				runTotal[nextIndex++] = aFloat[1];
				runTotal[nextIndex++] = aFloat[2];
				runTotal[nextIndex++] = aFloat[3];
				
				
				System.out.println(processInput.getSumNum(runTotal, 4));
				
			} catch (NumberFormatException nfe) {
				
				System.out.println("You did not enter a number. Please restart.");
				exit(0);
				
			}     
            
        	try {
        		runTotal = new Float[5];
        		
				aFloat[4] = Float.parseFloat(processInput.getNum("Please enter a number: ", 1));
				
				System.out.print(defaultMsg);
				System.out.println(aFloat[4]);
				outputMsg = "Current total: ";
				System.out.print(outputMsg);	
				
				int nextIndex = 0;			
				runTotal[nextIndex++] = aFloat[0];
				runTotal[nextIndex++] = aFloat[1];
				runTotal[nextIndex++] = aFloat[2];
				runTotal[nextIndex++] = aFloat[3];
				runTotal[nextIndex++] = aFloat[4];
				
				
				System.out.println(processInput.getSumNum(runTotal, 5));
				
			} catch (NumberFormatException nfe) {
				
				System.out.println("You did not enter a number. Please restart.");
				exit(0);
				
			}     
        	
        	try {
        		runTotal = new Float[6];
        		
				aFloat[5] = Float.parseFloat(processInput.getNum("Please enter a number: ", 1));
				
				System.out.print(defaultMsg);
				System.out.println(aFloat[5]);
				outputMsg = "Current total: ";
				System.out.print(outputMsg);	
				
				int nextIndex = 0;			
				runTotal[nextIndex++] = aFloat[0];
				runTotal[nextIndex++] = aFloat[1];
				runTotal[nextIndex++] = aFloat[2];
				runTotal[nextIndex++] = aFloat[3];
				runTotal[nextIndex++] = aFloat[4];
				runTotal[nextIndex++] = aFloat[5];
				
				
				System.out.println(processInput.getSumNum(runTotal, 6));
				
			} catch (NumberFormatException nfe) {
				
				System.out.println("You did not enter a number. Please restart.");
				exit(0);
				
			}   
        	
        	try {
        		runTotal = new Float[7];
        		
				aFloat[6] = Float.parseFloat(processInput.getNum("Please enter a number: ", 1));
				
				System.out.print(defaultMsg);
				System.out.println(aFloat[6]);
				outputMsg = "Current total: ";
				System.out.print(outputMsg);	
				
				int nextIndex = 0;			
				runTotal[nextIndex++] = aFloat[0];
				runTotal[nextIndex++] = aFloat[1];
				runTotal[nextIndex++] = aFloat[2];
				runTotal[nextIndex++] = aFloat[3];
				runTotal[nextIndex++] = aFloat[4];
				runTotal[nextIndex++] = aFloat[5];
				runTotal[nextIndex++] = aFloat[6];
				
				sumNum = processInput.getSumNum(runTotal, 7);
				System.out.println(sumNum);
				
			} catch (NumberFormatException nfe) {
				
				System.out.println("You did not enter a number. Please restart.");
				exit(0);
				
			}   
        	
            //Report view
            System.out.println("A simple Program");            
            System.out.print("Name: ");
            System.out.println(name);
            System.out.println("All Numerical Inputs: ");
            Arrays.sort(aFloat);
            for (int i = 0; i < 7; i++) {
            	System.out.println(aFloat[i]);
            	minNum = aFloat[0];
            	maxNum = aFloat[6];
            }
            System.out.print("Highest Number: ");
            System.out.println(maxNum);
            System.out.print("Lowest Number: ");
            System.out.println(minNum);
            System.out.print("Average Number: ");
            System.out.println(processInput.getAvgNum(sumNum, 7));

            
            
        }//end if condition top               

    }//end main method
    
    //standard system exit.
	public static void exit(int status) {
		System.exit(status);
		return;
	}

}//end main