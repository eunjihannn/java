package bookstore;

public class Book {
	private String title;
	private String writer;
	private String content;
	private int price;
	private int cnt;
	
	public Book(String title, String writer, String content, int price) {
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.price = price;
	}
	
	public void prt() {
		System.out.println("──────────────────────────");
		System.out.println(" 제   목 : "+title);
		System.out.println(" 줄거리 : "+content);
		System.out.println(" 작   가 : "+writer);
		System.out.println(" 판매료 : "+price+"원");
		System.out.println("──────────────────────────");
	}
	
	public void prt2() {
		System.out.println("──────────────────────────");
		System.out.println(" 제   목 : "+title);
		System.out.println(" 줄거리 : "+content);
		System.out.println(" 작   가 : "+writer);
		System.out.println(" 판매료 : "+price+"원");
		System.out.println(" 판매 된 수량 : "+cnt+"권");
		System.out.println(" 수익 : "+(cnt*price)+"원");
		System.out.println("──────────────────────────");
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
}
