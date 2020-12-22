package finaltest;

public class Basket {
	
	private Product product;
	private int num;
	
	public Basket(Product product, int num) {
		this.product = product;
		this.num = num;
	}
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	public void prt() {
		System.out.println("───────────────────");
		System.out.println("제품이름 : "+product.getName());
		System.out.println("제품가격 : "+product.getPrice());
		System.out.println("수량 : "+num);
		System.out.println("───────────────────");
	}
}
