/**
 * @Program_Name TechStore
 * @Author Matthew Tse
 * @Date 07/23/2014 
 *
 */

public class TechStore extends Product{
	
	private String itemMenu =
			  "Motherboard"
			+ "-"
			+ "CPU"
			+ "-"
			+ "Video Card"
			+ "-"
			+ "Case"
			+ "-"
			+ "Power Supply"
			+ "-"
			+ "CPU Cooler"
			+ "-"
			+ "RAM";
	private String prices = 
			  "19.99"
			+ "-"
			+ "19.99"
			+ "-"
			+ "29.99"
			+ "-"
			+ "7.99"
			+ "-"
			+ "10.99"
			+ "-"
			+ "7.99"
			+ "-"
			+ "14.99";
	private String[] itemName = itemMenu.split("-");
	private String[] priceIdx = prices.split("-");
	private String menuLength = Integer.toString(itemName.length);
	
	public TechStore() {
		super();
		
		this.Qty = menuLength;
		
		for (int itemCnt = 0; itemCnt < itemName.length; itemCnt++) {
	
			this.Name = itemName[itemCnt];
			
			this.Price = priceIdx[itemCnt];
			
			
		}//end for loop
		
	}
	
	public void showCatalog() {
		
		for (int itemCnt = 0; itemCnt < Integer.parseInt(menuLength); itemCnt++) {
			
			System.out.println(itemName[itemCnt].concat("\t$")
					.concat(priceIdx[itemCnt].concat("\n")));
			
		}//end for loop
		
	}
	
	public String getItemName(int num) {
		
		return itemName[num - 1];
	}
	
	public String getItemPrice(int num) {
		
		return priceIdx[num - 1];
	}
}
