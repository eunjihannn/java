package ch11;

import java.util.Scanner;

public class BankApplication {

	private static Account[] accountArray = new Account[100];
	private static Scanner scanner = new Scanner(System.in);
	private static int cnt = 0;

	public static void main(String[] args) {
		
		
		boolean run = true;
		while(run) {
			System.out.println("����������������������������������������������������������������������������������������");
			System.out.println(" 1.���»��� | 2.���¸�� | 3.���� | 4. ��� | 5.����");
			System.out.println("����������������������������������������������������������������������������������������");
			System.out.print("���� �� ");
			int no = Integer.parseInt(scanner.nextLine());

			switch(no) {
			case 1://���»���
				createAccount();
				break;
			case 2://���¸��
				if(cnt!=0) {
					accountList();
				} else {
					System.out.println("��ϵ� ���°� �����ϴ�.");
				}
				break;
			case 3://����
				deposit();
				break;
			case 4://���
				withdraw();
				break;
			case 5://����
				System.out.println("���α׷��� �����մϴ�.");
				run = false;
				break;
			default :
				System.out.println("�߸� �����̽��ϴ�.\n�ٽ� �Է����ּ���.");

			}
		}

	}

	private static void withdraw() { // ����ϱ�
		System.out.println("����������������");
		System.out.println("   ��    ��");
		System.out.println("����������������");
		System.out.print("���¹�ȣ : ");
		String ano = scanner.nextLine();
		for(int i=0;i<accountArray.length;i++) {
			if(ano.equals(accountArray[i].getAno())) {
				System.out.print("��ݾ� : ");
				int money = Integer.parseInt(scanner.nextLine());
				if(money<=accountArray[i].getBalance()) {
					accountArray[i].setBalance(accountArray[i].getBalance()-money);
					System.out.println("��� : ����� �����Ǿ����ϴ�.");
					return;
				} else {
					System.out.println("�ܾ��� �����մϴ�.");
					break;
				}
			}
		}
	}

	private static void deposit() { // �����ϱ�
		System.out.println("����������������");
		System.out.println("   ��    ��");
		System.out.println("����������������");
		System.out.print("���¹�ȣ : ");
		String ano = scanner.nextLine();
		for(int i=0;i<accountArray.length;i++) {
			if(ano.equals(accountArray[i].getAno())) {
				System.out.print("���ݾ� : ");
				int money = Integer.parseInt(scanner.nextLine());
				accountArray[i].setBalance(accountArray[i].getBalance()+money);
				System.out.println("���:������ �����Ǿ����ϴ�.");
				return;
			}
		}
	}

	private static void accountList() { // ���¸�Ϻ���
		System.out.println("����������������");
		System.out.println("   ���¸��");
		System.out.println("����������������");
		for(int i=0;i<accountArray.length;i++) {
			if(accountArray[i]!=null) {
				accountArray[i].prt();
			}
		}
	}

	private static void createAccount() { // ���»���
		System.out.println("����������������");
		System.out.println("   ���»���");
		System.out.println("����������������");
		System.out.print("���¹�ȣ : ");
		String ano = scanner.nextLine();
		System.out.print("������ : ");
		String owner = scanner.nextLine();
		System.out.print("�ʱ��Աݾ� : ");
		int balance = Integer.parseInt(scanner.nextLine());

		Account a = new Account(ano,owner,balance);
		if(save(a)) {
			System.out.println("���:���°� �����Ǿ����ϴ�.");
			cnt++;
		}
		else {
			System.out.println("���°����� �����Ͽ����ϴ�.");
		}
	}

	private static boolean save(Account a) {
		// ��������
		boolean boo = false;
		for(int i=0;i<accountArray.length;i++) {
			if(accountArray[i]==null) {
				accountArray[i]=a;
				boo=true;
				break;
			}
		}
		return boo;
	}

}
