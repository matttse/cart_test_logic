import java.util.Arrays;

/**
 * 
 */

/**
 * @author mase
 *
 */
public class optionHandler {
	
	//global vars declared and intialized
	private String itemDescription =      		
			//Item Name
			"Motherboard-CPU-Video Card-Case-Power Supply-CPU Cooler-RAM";
	private String[] shoppingList = itemDescription.split("-");
	private String itemPrices =
			//Item Prices
			"19.99-19.99-29.99-7.99-10.99-7.99-14.99";
	private String[] priceIdx = itemPrices.split("-");

	
	/*
	 * @Name: showMenu
	 * @Function/Purpose: shows a menu of items
	 * 
	 * @Parameters: none 
	 * 
	 * @Additional Comments: 
	 * @Return: null
	 * 
	 * */
	public void showMenu() {
		
        //Display Item Menu
        for (int idx = 0 ; idx < shoppingList.length ; idx++) { 
        	
        	if (idx % 2 == 0) {
            	//Item Names
            	System.out.println("Name: ".concat(shoppingList[idx]));
            	
        	} else {
        		//Item Prices
        		System.out.println("\t$".concat(shoppingList[idx]));
        		
        	}
        }
		
	}//end method
	
	/*
	 * @Name: getCart
	 * @Function/Purpose: shows all items in given cart
	 * 
	 * @Parameters: String complete cart details 
	 * 
	 * @Additional Comments: 
	 * @Return: cart
	 * 
	 * */
	public String getCartDescription(String itemIdxs) {
		String itemsInCart = "Your Cart: \n";
		String[] items = itemIdxs.split("-");

		for (int idx = 0 ; idx < items.length ; idx++) {

			itemsInCart += shoppingList[Integer.parseInt(items[idx]) - 1].concat("\n");	

		}
		
		return itemsInCart;
	}//end method
	
	/*
	 * @Name: getItemInCart
	 * @Function/Purpose: shows a specific item in the cart
	 * 
	 * @Parameters: String complete cart details, String itemNum to select from cart 
	 * 
	 * @Additional Comments: 
	 * @Return: String item
	 * 
	 * */
	public String getItemInCart(String cartDetails, String itemNum) {
		
		int selectIdx;
		selectIdx = 1 + ((Integer.parseInt(itemNum) - 1) * 3);
		
		if (Integer.parseInt(itemNum) == 1) {
			selectIdx = 0;
		}
		
		String[] parsedCart = cartDetails.split("-");
		return parsedCart[selectIdx];
		
	}//end method
	
	/*
	 * @Name: addItemToCart
	 * @Function/Purpose: adds an item with details to cart
	 * 
	 * @Parameters: String complete cart details, String item Number, int the size of the cart, String the priority 
	 * 
	 * @Additional Comments: 
	 * @Return: String complete cart
	 * 
	 * */
	public String addItemToCart(String cartDetails, String itemNum, int cartSize, String priority) {

		String cartList		= "";

		boolean duplicateCheck = false;
		int itemIdx = Integer.parseInt(itemNum) - 1;
				
    	//instantiate the handler
        UserInputHandler process = new UserInputHandler();
        
        duplicateCheck = process.getMatchedItems(cartDetails, itemNum);
        
        if (duplicateCheck == false) {

    		cartList += itemNum
    				.concat("-")
    				.concat(shoppingList[itemIdx])
    				.concat("-")
    				.concat(priority)
    				.concat("-");
    		
        } else {
        	
        	System.out.println("You already have this item in your cart.");
        	
        }
		
		return cartList;
		
	}//end method
	
	/*
	 * @Name: getPricesInCart
	 * @Function/Purpose: adds up running total for prices in cart
	 * 
	 * @Parameters: which item was added 
	 * 
	 * @Additional Comments: 
	 * @Return: float running total
	 * 
	 * */
	public float getPricesInCart(String itemNum) {
		float totalPrice = 0.0f;
		totalPrice += Float.parseFloat(priceIdx[Integer.parseInt(itemNum) - 1]);
		return totalPrice;
	}//end method
	
	/*
	 * @Name: getPricesInCart
	 * @Function/Purpose: adds up running total for prices in cart
	 * 
	 * @Parameters: which item was added 
	 * 
	 * @Additional Comments: 
	 * @Return: float running total
	 * 
	 * */
	public String completePurchase(String cartDetails, String itemIdxs, Float total) {
		String purchasedItems = "You have purchased:\n";
		Float remainingValue = 0.0f;
//		System.out.print("\nDEBUG\n");
//		System.out.print(cartDetails);
//		System.out.println("\nDEBUG");

//		for (String items : cartDetails.split("-")) {
//			int priorityIdx = Integer.parseInt(items) + 3;
//			System.out.println("\nDEBUG");
//			System.out.println(priorityIdx);
//			
//			System.out.println("\nDEBUG");
//		}
		
		for (String items : itemIdxs.split("-")) {
			
			int itemIdx = Integer.parseInt(items) - 1;
			purchasedItems += shoppingList[itemIdx]
					.concat("\t$")
					.concat(priceIdx[itemIdx])
					.concat("\n");

			
		}
		
		System.out.println("Total Price $: ".concat(String.valueOf(total)));
		remainingValue = 59 - total;
		
		System.out.println("Your remaining value is: ".concat(String.format("%.2f", remainingValue)));
		
		return purchasedItems;
	}//end method
}//end class
