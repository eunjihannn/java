package ch18.controller;

import java.util.jar.Attributes.Name;

import ch18.main.Main;
import ch18.vo.Person;

public class LoginController {
	public LoginController() {
		init();
	}

	private void init() {
		boolean run = true;
		while(run) {
			System.out.println("게시판 프로그램");
			System.out.println("1. 게시판 보기");
			System.out.println("2. 회원가입");
			System.out.println("3. 로그인");
			System.out.println("4. 프로그램 종료");
			System.out.print("선택 > ");

			int selNum = Integer.parseInt(Main.scan.nextLine());

			switch(selNum) {
			case 1://게시믈 조회
				
				break;
			case 2://회원가입
				signUp();
				break;
			case 3://로그인
				signIn();
				break;
			case 4://프로그램 종료
				System.out.println("프로그램 종료");
				run = false;
				break;
			default :
				System.out.println("잘못 입력했습니다.\n다시 확인해주세요.");
			}	
		}
	}

	private void signIn() { // 로그인
		if(Main.session!=-1) {
			System.out.println("로그인을 합니다.");
			System.out.println("아이디를 입력하세요");
			String id = Main.scan.nextLine();
			System.out.println("비밀번호를 입력하세요");
			String password = Main.scan.nextLine();
			int idx = chkIdPw(id,password);
			if(idx==-1) {
				System.out.println("아이디 또는 비밀번호가 잘못 되었습니다.");
			} else {
				Main.session = idx;
				System.out.println("로그인 성공");
				new BoardController();
			}

		} else {
			System.out.println("이미 로그인 되어있습니다.");
		}
	}

	private int chkIdPw(String id, String password) {
		for(int i=0;i<Main.people.size();i++) {
			if(Main.people.get(i).getId().equals(id)&&
					Main.people.get(i).getPassword().equals(password)) {
				return i;
			}
		}
		return -1;
	}

	private void signUp() { // 회원가입
		System.out.println("회원 가입");
		System.out.println("아이디를 입력하세요");
		String id = Main.scan.nextLine();
		if(chkId(id)) {
			System.out.println("비밀번호를 입력하세요");
			String password = Main.scan.nextLine();
			System.out.println("이름을 입력하세요");
			String name = Main.scan.nextLine();
			Main.people.add(new Person(id,password,name));
			System.out.println("회원 가입 완료");
		} else {
			System.out.println("가입 된 아이디가 있습니다.");
			return;
		}
	}

	private boolean chkId(String id) {
		for(int i=0;i<Main.people.size();i++) {
			if(Main.people.get(i).getId().equals(id)) {
				return false;
			}
		}
		return true;
	}
}