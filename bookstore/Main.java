package bookstore;

import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static List<Book> books = new ArrayList<>();
	public static List<Member> members = new ArrayList<>();
	public static int session = -1;
	public static Admin admin = new Admin(0);
	
	public static void main(String[] args) {
		
		new MainController();

	}

}