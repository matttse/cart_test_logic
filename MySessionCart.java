/**
 * @Program_Name MySessionCart
 * @Author Matthew Tse
 * @Date 07/23/2014 
 *
 */

import java.util.*;

public class MySessionCart implements Cart{
	
	private String cartDetail	= "";
	protected String itemName	= "";
	private String itemIdx		= "";
	private String priorityIdx	= "";
	
	Map<String, String> mappedItems = new TreeMap<String, String>();
	
	
	//instantiate the handler
    UserInputHandler process = new UserInputHandler();
    
	//instantiate the the store
	TechStore myStore = new TechStore();
	
	@Override
	public void addItem() {
		
	}
	
	public String addItem(String itemNum, String priority) {
    	
        boolean checkItem		= false;
		boolean checkPriority	= false;
		
		
		if (mappedItems.isEmpty() != true) {
			
	        //check to see if user has already added item to their cart
	        checkItem = process.getMatchedItems(itemIdx, itemNum);
	        
	        checkPriority = process.getMatchedItems(priorityIdx, priority);
	        
		} 
        
        
        if (checkItem == false && checkPriority == false) {
    		cartDetail += itemNum
    				.concat("-")
    				.concat(myStore.getItemName(Integer.parseInt(itemNum)))
    				.concat("-")
    				.concat(priority)
    				.concat("-");
    		
    		mappedItems.put(priority, itemNum);
    		
    		itemIdx		+= itemNum.concat("-");
    		priorityIdx	+= priority.concat("-");
    		
        } else if (checkItem == true) {
        	
        	System.out.println("You already have this item in your cart.");
        	
        } else if (checkPriority == true) {
        	
        	System.out.println("You already selected this priority in your cart.");	
        	
        } else {
        	
        	System.out.print("Error");
        	
        }
        return cartDetail;
		
	}//end method

	@Override
	public void removeItem() {
		// TODO Auto-generated method stub
	}

	@Override
	public void viewItem() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void viewPrice() {
		// TODO Auto-generated method stub
		
	}
	
	public String viewCart(String itemIdxs) {
		
		String itemsInCart = "Your Cart: \n";
		String[] names = itemIdxs.split("-");
		
		if (mappedItems.isEmpty() != true) {
			for (int idx = 0; idx < mappedItems.size(); idx++) {

				itemsInCart += myStore.getItemName(
						Integer.parseInt(names[idx]))
						.concat("\n");
				
			}
		} else {
			System.out.println("You have not mapped any items to the cart yet.");
		}
		
		return itemsInCart;
		
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
		
		totalPrice += Float.parseFloat(myStore.getItemPrice(Integer.parseInt(itemNum)));
				
		return totalPrice;
	}//end method
	
	/*
	 * @Name: completePurchase
	 * @Function/Purpose: finalizes purchases by priority
	 * 
	 * @Parameters: which item was added 
	 * 
	 * @Additional Comments: 
	 * @Return: float running total
	 * 
	 * */
	public String completePurchase(String itemIdxs, Float total) {
		String purchasedItems = "You have purchased:\n";
		Float remainingValue = 0.0f;
		
		//declare/create arraylist for key of mapped items
		List<String> sortedKeys = new ArrayList<String>(mappedItems.keySet());
		
		//Sort the keys by priority
		Collections.sort(sortedKeys);
		
		for (int idx = 0; idx < mappedItems.size(); idx++) {

			String priority = sortedKeys.get(idx);//priority sorted is key
			String iNum = mappedItems.get(priority);//item number is value
			myStore.getItemPrice(Integer.parseInt(iNum));//individual prices of items
			purchasedItems += myStore.getItemName(Integer.parseInt(iNum)).concat("\n");//individual name of items
			
		}
		
		
		System.out.println("Total Price: $".concat(String.format("%.2f", total)));
		remainingValue = 59 - total;
		
		System.out.println("Your remaining value is: ".concat(String.format("%.2f", remainingValue)));
		
		return purchasedItems;
	}//end method


}//end class
