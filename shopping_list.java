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
    	
    	String itemIdxs		= "";
    	
    	Float runTotal = 0.0f;
    	
    	//instantiate the handler
        UserInputHandler processInput = new UserInputHandler();
        
        //instantiate the session cart
        MySessionCart userCart = new MySessionCart();
        
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
    			if (userCart.mappedItems.isEmpty() == true) {
    				
    				System.out.println("You do not have any items in your cart to purchase/checkout.");
    				
    			} else {
        	        
    				displayPurchases = userCart.completePurchase(itemIdxs, runTotal);
    				System.out.println(displayPurchases);
    			}
    			
    			
    			
    			//exit menu flag
    			checkoutFlag = 1;
    		
    		//Process options
    		} else {
    	        
    	        //show menu
    			if (select == 4) {
    				
        	        userCart.myStore.showCatalog();
    				
        	    //add items to cart
    			} else if (select == 2){
    				
					String itemNum = "-1";
					String priority = "-1";
					
					
					while (Integer.parseInt(itemNum) == -1 || 
							(Integer.parseInt(itemNum) > Integer.parseInt(userCart.myStore.Qty)) ){
						
						itemNum = processInput.getNum("Enter Item Number(#) to add to cart: ", 0);	
						
						if (Integer.parseInt(priority) > Integer.parseInt(userCart.myStore.Qty)) {
						
							System.out.println("Please enter a valid priority");
					
						}
						
					}//end while check for valid item numbers
					
					while (Integer.parseInt(priority) == -1 || 
							(Integer.parseInt(priority) > Integer.parseInt(userCart.myStore.Qty)) ){
						priority = processInput.getNum("Enter the priority for this item (1-7) ", 0);
						
						if (Integer.parseInt(priority) > Integer.parseInt(userCart.myStore.Qty)) {
							System.out.println("Please enter a valid priority");
						}
						
					}//end while check for valid priorities
					
		            
					
					//add to a running Total
					runTotal += userCart.getPricesInCart(itemNum);
					
					if (runTotal > 59) {
						System.out.println("You cannot add to cart, more than $59");
						
						//adjust running Total
						runTotal -= userCart.getPricesInCart(itemNum);
					} else {
						
			            itemIdxs += itemNum.concat("-");
			            
			            //add to session cart
			            userCart.addItem(itemNum, priority);

					}
				
    			} else {
    				
    				//view cart if not empty
    				if (select == 1 && userCart.mappedItems.isEmpty() != true) {
    					
    					System.out.println(userCart.viewCart(itemIdxs));
    				
    				//cart is empty
    				} else if (userCart.mappedItems.isEmpty() == true) {
    					
    					System.out.println("Your cart is empty");
    					
    				}//end if get cart descriptions
    				
    				//check running total
    				if (select == 5) {
    					
    					System.out.print("Your total is: $");
    					System.out.println(runTotal);
    					
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
