package ch11;

import java.util.Scanner;

public class BankApplication {

	private static Account[] accountArray = new Account[100];
	private static Scanner scanner = new Scanner(System.in);
	private static int cnt = 0;

	public static void main(String[] args) {
		
		
		boolean run = true;
		while(run) {
			System.out.println("────────────────────────────────────────────");
			System.out.println(" 1.계좌생성 | 2.계좌목록 | 3.예금 | 4. 출금 | 5.종료");
			System.out.println("────────────────────────────────────────────");
			System.out.print("선택 ▷ ");
			int no = Integer.parseInt(scanner.nextLine());

			switch(no) {
			case 1://계좌생성
				createAccount();
				break;
			case 2://계좌목록
				if(cnt!=0) {
					accountList();
				} else {
					System.out.println("등록된 계좌가 없습니다.");
				}
				break;
			case 3://예금
				deposit();
				break;
			case 4://출금
				withdraw();
				break;
			case 5://종료
				System.out.println("프로그램을 종료합니다.");
				run = false;
				break;
			default :
				System.out.println("잘못 누르셨습니다.\n다시 입력해주세요.");

			}
		}

	}

	private static void withdraw() { // 출금하기
		System.out.println("────────");
		System.out.println("   출    금");
		System.out.println("────────");
		System.out.print("계좌번호 : ");
		String ano = scanner.nextLine();
		for(int i=0;i<accountArray.length;i++) {
			if(ano.equals(accountArray[i].getAno())) {
				System.out.print("출금액 : ");
				int money = Integer.parseInt(scanner.nextLine());
				if(money<=accountArray[i].getBalance()) {
					accountArray[i].setBalance(accountArray[i].getBalance()-money);
					System.out.println("결과 : 출금이 성공되었습니다.");
					return;
				} else {
					System.out.println("잔액이 부족합니다.");
					break;
				}
			}
		}
	}

	private static void deposit() { // 예금하기
		System.out.println("────────");
		System.out.println("   예    금");
		System.out.println("────────");
		System.out.print("계좌번호 : ");
		String ano = scanner.nextLine();
		for(int i=0;i<accountArray.length;i++) {
			if(ano.equals(accountArray[i].getAno())) {
				System.out.print("예금액 : ");
				int money = Integer.parseInt(scanner.nextLine());
				accountArray[i].setBalance(accountArray[i].getBalance()+money);
				System.out.println("결과:예금이 성공되었습니다.");
				return;
			}
		}
	}

	private static void accountList() { // 계좌목록보기
		System.out.println("────────");
		System.out.println("   계좌목록");
		System.out.println("────────");
		for(int i=0;i<accountArray.length;i++) {
			if(accountArray[i]!=null) {
				accountArray[i].prt();
			}
		}
	}

	private static void createAccount() { // 계좌생성
		System.out.println("────────");
		System.out.println("   계좌생성");
		System.out.println("────────");
		System.out.print("계좌번호 : ");
		String ano = scanner.nextLine();
		System.out.print("계좌주 : ");
		String owner = scanner.nextLine();
		System.out.print("초기입금액 : ");
		int balance = Integer.parseInt(scanner.nextLine());

		Account a = new Account(ano,owner,balance);
		if(save(a)) {
			System.out.println("결과:계좌가 생성되었습니다.");
			cnt++;
		}
		else {
			System.out.println("계좌개설을 실패하였습니다.");
		}
	}

	private static boolean save(Account a) {
		// 계좌저장
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
