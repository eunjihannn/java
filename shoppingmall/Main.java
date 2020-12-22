package finaltest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	public static Scanner scan = new Scanner(System.in);
	public static List<Member> members = new ArrayList<>();
	public static int session = -1;
	public static List<Product> products = new ArrayList<>();

	public static void main(String[] args) {
		new MainController();
	}
}