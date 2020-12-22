package finaltest;

import java.util.ArrayList;
import java.util.List;

public class Member {
	private String id;
	private String pw;
	private String name;
	private String pNum;
	private int cash;
	public List<Basket> spBasket = new ArrayList<>();
	
	public Member(String id, String pw, String name, String pNum, int cash) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.pNum = pNum;
		this.cash = cash;
	}
	
	public void prt() {
		System.out.println("───────────────────");
		System.out.println("이   름 : "+name);
		System.out.println("연락처 : "+pNum);
		System.out.println("캐   쉬 : "+cash+"원");
		System.out.println("───────────────────");
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getpNum() {
		return pNum;
	}

	public void setpNum(String pNum) {
		this.pNum = pNum;
	}

	public int getCash() {
		return cash;
	}

	public void setCash(int cash) {
		this.cash = cash;
	}
	
}
