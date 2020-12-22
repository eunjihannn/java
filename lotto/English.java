package ch14.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class English {

	static Scanner sc = new Scanner(System.in);
	static Map<String,String> book = new HashMap<>();

	public static void main(String[] args) {
		// 영어단어장

		while(true) {
			System.out.println("┌────영어 단어장────┐");
			System.out.println("  1.단어 등록");
			System.out.println("  2.단어 수정");
			System.out.println("  3.등록된 단어보기");
			System.out.println("  4.단어 삭제");
			System.out.println("  5.프로그램 종료");
			System.out.println("└────────────────┘");
			System.out.print("선택 > ");
			int no = Integer.parseInt(sc.nextLine());

			switch(no) {
			case 1: //단어등록
				enrollment();
				break;
			case 2: //단어수정
				update();
				break;
			case 3: //등록된 단어보기
				check();
				break;
			case 4: //단어삭제
				remove();
				break;
			case 5: //프로그램종료
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			default :
				System.out.println("잘못 입력했습니다.\n다시 입력해주세요.");
			}
		}
	}

	private static void remove() {
		System.out.println("삭제할 영어단어를 입력해주세요.");
		String eng = sc.nextLine();
		if(book.get(eng)!=null) {
			book.remove(eng);
			System.out.println("단어를 정상적으로 삭제하였습니다.");
		} else {
			System.out.println("없는 단어입니다.");
		}
	}

	private static void check() {
		System.out.println("단어장에 등록된 단어를 확인합니다.");
		Set<String> keySet = book.keySet();
		Iterator<String> itr = keySet.iterator();
		while(itr.hasNext()) {
			String key = itr.next();
			String value = book.get(key);
			System.out.println("──────────────────");
			System.out.println("영어단어 : "+key);
			System.out.println("한글 뜻 : "+value);
			System.out.println("──────────────────");
		}
	}

	private static void update() {
		System.out.println("수정할 영어 단어를 입력해주세요.");
		String eng = sc.nextLine();
		if(book.get(eng)!=null) {
			System.out.print("변경할 단어 뜻 > ");
			String kor = sc.nextLine();
			book.put(eng, kor);
			System.out.println("한글 뜻을 수정하였습니다.");
		} else {
			System.out.println("없는 단어입니다.");
		}
	}

	private static void enrollment() {
		System.out.println("단어 등록을 시작합니다.");
		System.out.print("영어 단어 > ");
		String eng = sc.nextLine();
		System.out.print("한글 뜻 > ");
		String kor = sc.nextLine();

		book.put(eng, kor);
	}

}
