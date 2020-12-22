package ch14.test;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Lotto {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		// 로또번호(1부터 45까지 6개)를 뽑아서 출력합니다.

		while(true) {
			System.out.println("┌────로또 게임────┐");
			System.out.println("  1.게임실행");
			System.out.println("  2.당첨번호");
			System.out.println("  3.프로그램 종료");
			System.out.println("└──────────────┘");
			System.out.print("선택 > ");
			int num = Integer.parseInt(scan.nextLine());

			switch(num) {
			case 1://게임실행
				play();
				break;
			case 2://당첨번호
				lotto();
				break;
			case 3:
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
				break;
			default :
				System.out.println("잘못 입력했습니다.\n다시 입력해주세요.");
			}
		}
	}

	private static void lotto() {
		// 당첨번호
		Set<Integer> chucheom = new TreeSet<>();
		System.out.println("☆2행운의 번호 6개☆");
		for(;;) {
			int lotto = (int)(Math.random()*45)+1;
			chucheom.add(lotto);
			if(chucheom.size()==6) {
				break;
			}
		}
		Iterator<Integer> num = chucheom.iterator();
		while(num.hasNext()) {
			System.out.print(num.next()+"  ");
		}
		System.out.println();
	}

	private static void play() {
		// 게임실행
		System.out.println("로또게임을 시작합니다.");
		System.out.print("게임 하실 횟수를 입력해주세요. > ");
		int playNo = Integer.parseInt(scan.nextLine());
		System.out.print("수동으로 플레이하실 횟수를 선택해주세요. > ");
		int sudong = Integer.parseInt(scan.nextLine());
		if(sudong>0) {
			System.out.println("수동으로 번호를 뽑습니다.\n번호를 선택해주세요.");
		}
		int flag=1;
		for(int i=0;i<sudong;i++) {
			System.out.println(flag+"번째 로또번호");
			flag++;
			sudong();
		}
		System.out.print("자동으로 번호를 뽑습니다.\n");
		int jadong = playNo-sudong;
		for(int i=0;i<jadong;i++) {
			System.out.println(flag+"번째 로또번호");
			flag++;
			jadong();
		}
	}

	private static void sudong() {
		// 로또번호 수동으로 찍기

		Set<Integer> lotto = new TreeSet<>();
		for(;;) {
			int lottoNo = Integer.parseInt(scan.nextLine());
			if(lottoNo<=45&&lottoNo>0) {
				lotto.add(lottoNo);
			} else {
				System.out.println("숫자를 잘못 입력했습니다.\n다시 입력해주세요.");
			}
			if(lotto.size()==6) {
				break;
			}
		}
		Iterator<Integer> itr = lotto.iterator();
		while(itr.hasNext()) {
			System.out.print(itr.next()+" ");
		}
		System.out.println();

	}

	private static void jadong() {
		// 로또번호 자동으로 찍기
		Set<Integer> lottoNo = new TreeSet<>();

		for(;;) {
			int lotto = (int)(Math.random()*45)+1;
			lottoNo.add(lotto);
			if(lottoNo.size()==6) {
				break;
			}
		}
		Iterator<Integer> itr = lottoNo.iterator();
		while(itr.hasNext()) {
			System.out.print(itr.next()+" ");
		}
		System.out.println();
	}

}
