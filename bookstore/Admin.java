package bookstore;

public class Admin {
	
	private String adminId = "admin";
	private String adminPw = "1234";
	private int cash;
	
	public Admin(int cash) {
		this.cash = cash;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getAdminPw() {
		return adminPw;
	}
	public void setAdminPw(String adminPw) {
		this.adminPw = adminPw;
	}
	public int getCash() {
		return cash;
	}
	public void setCash(int cash) {
		this.cash = cash;
	}
	
	

}
