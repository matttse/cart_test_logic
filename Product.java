/**
 * @Program_Name Product
 * @Author Matthew Tse
 * @Date 07/23/2014 
 *
 */
public abstract class Product {
	
	//Declarations and initializations
	protected String Name	= "";
	protected String Price	= "";
	protected String Qty	= "";
	
	/**
	 * @return the name
	 */
	protected String getName() {
		return Name;
	}
	/**
	 * @param name the name to set
	 */
	protected void setName(String name) {
		Name = name;
	}
	/**
	 * @return the price
	 */
	protected String getPrice() {
		return Price;
	}
	/**
	 * @param price the price to set
	 */
	protected void setPrice(String price) {
		Price = price;
	}
	/**
	 * @return the qty
	 */
	protected String getQty() {
		return Qty;
	}
	/**
	 * @param qty the qty to set
	 */
	protected void setQty(String qty) {
		Qty = qty;
	}
	

}
