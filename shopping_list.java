/**
 * @Program_Name shopping_list
 * @Author Matthew Tse
 * @Date 07/14/2014 
 *
 */
import java.util.Arrays;
import java.util.Scanner;
public class shopping_list {
	

	//Main method
    public static void main (String [] args)
    {
    	//initialize and declare global vars
    	int checkoutFlag = 0;
    	String optionOne	= "(1) View Items in Cart";
    	String optionTwo	= "(2) Add Items to Cart";
    	String optionThree	= "(3) Purchase/Checkout";
    	String optionFour	= "(4) Show Menu Items";
    	String optionFive	= "(5) Show Current Total";
    	String option		= "";
    	String cartDetails	= "";
    	String itemIdxs		= "";
    	int cartSize = 0;
    	Float runTotal = 0.0f;
    	
    	//instantiate the handler
        UserInputHandler processInput = new UserInputHandler();
        
        //Note to User:
        System.out.println("Remember, you only have $59, this process will exit when your cart exceeds this cost.");
        
    	while (checkoutFlag == 0 && runTotal <= 59.00) {
    		
    		System.out.println("Please select an option.");
    		
    		option = processInput.getNum(
    					(optionOne.concat("\t")
    						.concat(optionTwo).concat("\n")
    						.concat(optionThree).concat("\t")
    						.concat(optionFour).concat("\n")
    						.concat(optionFive).concat("\n"))
    						, 0);
    		
    		int select = Integer.parseInt(option);
    		
    		//Valid options
    		if (select > 5 || select < 1) {
    			
    			System.out.print("Please select a valid option");
    		
    		//Checkout option
    		} else if (select == 3) {
    			String displayPurchases = "";
    			if (runTotal == 0.0 || cartDetails == "") {
    				
    				System.out.println("You do not have any items in your cart to purchase/checkout.");
    				
    			} else {
    				//instantiate the optionHandler
        	        optionHandler selectInput = new optionHandler();
        	        
    				displayPurchases = selectInput.completePurchase(cartDetails, itemIdxs, runTotal);
    				System.out.println(displayPurchases);
    			}
    			
    			
    			
    			//exit menu flag
    			checkoutFlag = 1;
    		
    		//Process options
    		} else {
				//instantiate the optionHandler
    	        optionHandler selectInput = new optionHandler();
    	        
    	        //show menu
    			if (select == 4) {
    				
        	        selectInput.showMenu();
    				
        	    //add items to cart
    			} else if (select == 2){
    				
					String itemNum = "";
					String priority = "";
					
					itemNum = processInput.getNum("Enter Item Number(#) to add to cart: ", 0);
		            priority = processInput.getString("Enter the priority for this item (A-G) ");
					
					//add to a running Total
					runTotal += selectInput.getPricesInCart(itemNum);
					
					if (runTotal > 59) {
						System.out.println("You cannot add to cart, more than $59");
						
						//adjust running Total
						runTotal -= selectInput.getPricesInCart(itemNum);
					} else {
						
			            itemIdxs += itemNum.concat("-");
			            
			            //add to session cart
						cartDetails += selectInput.addItemToCart(cartDetails, itemNum, cartSize, priority);
						
						//increment cart size
						cartSize++;
					}
				
    			} else {
    				
    				//view cart if not empty
    				if (select == 1 && cartDetails != "") {
    					
    					System.out.println(selectInput.getCartDescription(itemIdxs));
    				
    				//cart is empty
    				} else if (cartDetails == "") {
    					
    					System.out.println("Your cart is empty");
    					
    				}//end if get cart descriptions
    				
    				//check running total
    				if (select == 5 && runTotal != 0) {
    					
    					System.out.print("Your total is: $");
    					System.out.println(runTotal);
    					
    				//no total
    				} else if (runTotal ==0.00) {
    					
    					System.out.println("Your total is $0.00");
    					
    				}//end if running total display
    				
    			}//end if processing options
    		
    		}//end if valid options
    		
    	}//end while order checkout
    	
    	System.out.println("Thank you for your order");
    	exit(0);
       
        
    }//end main method
        
    //standard system exit.
	public static void exit(int status) {
		System.exit(status);
		return;
	}
}//end class
