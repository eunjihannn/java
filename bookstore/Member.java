package bookstore;

import java.util.ArrayList;
import java.util.List;

public class Member {
	private String name;
	private String id;
	private String pw;
	private int money;
	List<Book> buyBooks = new ArrayList<>();
	List<Book> basketBooks = new ArrayList<>();
	
	public Member(String name, String id, String pw, int money) {
		this.name = name;
		this.id = id;
		this.pw = pw;
		this.money = money;
	}

	public void prt() {
		System.out.println("─────────────────");
		System.out.println("  NAME : "+name);
		System.out.println("  ID : "+id);
		System.out.println("  CASH : "+money);
		System.out.println("─────────────────");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
	
	
	

}
