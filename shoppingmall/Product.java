package finaltest;

public class Product {
	private Seller seller;
	private String name;
	private int originalPrice;
	private int price;
	private int quantity;
	
	public Product(Seller seller, String name, int originalPrice, int price, int quantity) {
		this.seller = seller;
		this.name = name;
		this.originalPrice = originalPrice;
		this.price = price;
		this.quantity = quantity;
	}
	
	public void prt() {
		System.out.println("───────────────────");
		System.out.println("이름 : "+name);
		System.out.println("원가 : "+originalPrice+"원");
		System.out.println("정가 : "+price+"원");
		System.out.println("수량 : "+quantity+"개");
		System.out.println("───────────────────");
	}
	
	public void sales() {
		System.out.println("───────────────────");
		System.out.println("이름 : "+name);
		System.out.println("가격 : "+price+"원");
		System.out.println("재고수량 : "+quantity+"개");
		System.out.println("───────────────────");
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
