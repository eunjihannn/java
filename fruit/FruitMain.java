package study;

import java.util.ArrayList;
import java.util.Scanner;

public class FruitMain {

	static Scanner scan = new Scanner(System.in);
	static ArrayList<Fruit> fruits = new ArrayList<>();
	private static int don = 100000;

	public static void main(String[] args) {
		// ���ϰ��� �

		while(true) {
			System.out.println("����������������������������������������������������������");
			System.out.println("1.��ȸ��2.���Ԧ�3.�ǸŦ�4.�ڱݦ�5.����");
			System.out.println("����������������������������������������������������������");
			System.out.print("���� > ");
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
				System.out.println("���α׷��� �����մϴ�.");
				System.exit(0);
			default :
				System.out.println("�߸� �Է��߽��ϴ�.\n�ٽ� �Է����ּ���.");
			}

		}

	}

	private static void lookup() {
		// ��ȸ���
		
	}

	private static void purchase() {
		// ���Ա��
		System.out.println("������ �����մϴ�.");
		System.out.print("���� �̸� > ");
		String name = scan.nextLine();
		System.out.println("�ܰ� > ");
		int salesPrice = Integer.parseInt(scan.nextLine());
		System.out.println("���� > ");
		int cost = Integer.parseInt(scan.nextLine());
		System.out.println("���� > ");
		int no = Integer.parseInt(scan.nextLine());
		
		Fruit fru = new Fruit(name,salesPrice,cost,no);
		
	}

	private static void sales() {
		// �Ǹű��
		
	}

	private static void money() {
		// �ڱ�
		
	}

}
