package study;

public class Fruit {

	private String name;	
	private int salesPrcie;
	private int originalPrice;
	private int quantity;
	
	public Fruit(String name, int salesPrice, int OriginalPrice, int quantity) {
		this.name = name;
		this.salesPrcie = salesPrice;
		this.originalPrice = OriginalPrice;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(int originalPrice) {
		this.originalPrice = originalPrice;
	}

	public int getSalesPrcie() {
		return salesPrcie;
	}

	public void setSalesPrcie(int salesPrcie) {
		this.salesPrcie = salesPrcie;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
}
