package study;

import java.util.ArrayList;
import java.util.Scanner;

public class FruitMain {

	static Scanner scan = new Scanner(System.in);
	static ArrayList<Fruit> fruits = new ArrayList<>();
	private static int don = 100000;

	public static void main(String[] args) {
		// 과일가게 운영

		while(true) {
			System.out.println("─────────────────────────────");
			System.out.println("1.조회│2.매입│3.판매│4.자금│5.종료");
			System.out.println("─────────────────────────────");
			System.out.print("선택 > ");
			int num = Integer.parseInt(scan.nextLine());

			switch(num) {
			case 1:
				lookup();
				break;
			case 2:
				purchase();
				break;
			case 3:
				sales();
				break;
			case 4:
				money();
				break;
			case 5:
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			default :
				System.out.println("잘못 입력했습니다.\n다시 입력해주세요.");
			}

		}

	}

	private static void lookup() {
		// 조회기능
		
	}

	private static void purchase() {
		// 매입기능
		System.out.println("과일을 매입합니다.");
		System.out.print("과일 이름 > ");
		String name = scan.nextLine();
		System.out.println("단가 > ");
		int salesPrice = Integer.parseInt(scan.nextLine());
		System.out.println("정가 > ");
		int cost = Integer.parseInt(scan.nextLine());
		System.out.println("수량 > ");
		int no = Integer.parseInt(scan.nextLine());
		
		Fruit fru = new Fruit(name,salesPrice,cost,no);
		
	}

	private static void sales() {
		// 판매기능
		
	}

	private static void money() {
		// 자금
		
	}

}
