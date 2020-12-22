package ch18.controller;

import java.util.Date;

import ch18.main.Main;
import ch18.vo.Board;

public class BoardController {
	public BoardController() {
		init();
	}

	private void init() {
		boolean run = true;
		while(run) {
			System.out.println(Main.people.get(Main.session).getName()+"님 환영합니다.");
			System.out.println("1.게시판 보기");
			System.out.println("2.게시글 작성");
			System.out.println("3.내 글 보기");
			System.out.println("4.로그아웃");
			System.out.print("선택 > ");

			int selNum = Integer.parseInt(Main.scan.nextLine());

			switch(selNum) {
			case 1://게시판 보기
				if(viewBoard()) {
					detailBoard();
				}
				break;
			case 2://게시글 작성
				writerBoard();
				break;
			case 3://내글 보기
				myBoard();
				break;
			case 4://로그아웃
				System.out.println("로그아웃 합니다.");
				Main.session = -1;
				run=false;
				break;
			default :
				System.out.println("잘못 입력했습니다.\n다시 입력해주세요.");
			}
		}
	}

	private void myBoard() { // 내 글 보기
		System.out.println("내 글 조회");
		for(int i=0;i<Main.boards.size();i++) {
			if(Main.boards.get(i).getWriter().equals(Main.people.get(Main.session).getName())) {
				System.out.println((i+1)+"번째 게시글 : "+Main.boards.get(i).getTitle());
			}
		}
		System.out.println("게시글 조회(0번 입력시 돌아가기)");
		int selNum = Integer.parseInt(Main.scan.nextLine());
		if(selNum == 0) {
			return;
		} else {
			myBoardMenu(selNum-1);
		}
	}

	private void myBoardMenu(int i) {
		while(true) {
			System.out.println("1.게시글 내용 보기");
			System.out.println("2.게시글 변경");
			System.out.println("3.게시글 삭제");
			System.out.println("4.돌아가기");

			int num = Integer.parseInt(Main.scan.nextLine());

			switch(num) {
			case 1://게시글 내용 보기
				Main.boards.get(i).prt();
				break;
			case 2://게시글 변경
				updateMyBoard(i);
				break;
			case 3://게시글 삭제
				deleteMyBoard(i);
				return;
			case 4:
				return;
			default :
				System.out.println("잘못 입력했습니다.\n다시 확인해주세요.");
			}
		}
	}

	private void updateMyBoard(int i) { // 게시글 변경
		System.out.println("해당 게시글을 변경합니다.");
		if(chkPw(i)) {
			System.out.println("글 제목을 작성하세요.");
			String title = Main.scan.nextLine();
			System.out.println("글 내용을 작성하세요.");
			String content = Main.scan.nextLine();
			Date now = new Date();
			Main.boards.get(i).update(title,content,now);
			System.out.println("갱신이 완료 되었습니다.");
		} else {
			System.out.println("비밀번호가 틀렸습니다.");
		}
		
	}

	private void deleteMyBoard(int i) { // 게시글 삭제
		System.out.println("해당 게시글을 삭제합니다.");
		if(chkPw(i)) {
			Main.boards.remove(i);
		} else {
			System.out.println("비밀번호가 틀렸습니다.");
		}	
	}

	private boolean chkPw(int i) {
		System.out.println("게시글의 비밀번호를 입력하세요.");
		String password = Main.scan.nextLine();
		if(Main.boards.get(i).getPassword().equals(password)) {
			return true;
		} else {
			return false;
		}
	}

	private void detailBoard() {
		System.out.println("게시글 번호를 입력하세요.(0번 입력시 뒤로 돌아갑니다.)");
		int selNum = Integer.parseInt(Main.scan.nextLine());
		if(selNum!=0) {
			Main.boards.get(selNum-1).prt();
		}else {
			return;
		}
	}

	private boolean viewBoard() {
		System.out.println("게시판 조회");
		if(Main.boards.size()!=0) {
			for(int i=0;i<Main.boards.size();i++) {
				System.out.println((i+1)+"번째 게시글 : "+Main.boards.get(i).getTitle());
			}
		} else {
			System.out.println("게시글이 없습니다.");
			return false;
		}
		return true;
	}

	private void writerBoard() {
		System.out.println("글 작성을 시작합니다.");
		System.out.println("글 제목을 작성하세요.");
		String title = Main.scan.nextLine();
		String writer = Main.people.get(Main.session).getName();
		System.out.println("글 내용을 작성하세요.");
		String content = Main.scan.nextLine();
		System.out.println("비밀번호를 작성하세요.");
		String password = Main.scan.nextLine();
		Date now = new Date();
		Main.boards.add(new Board(title,content,writer,password,now));
		System.out.println("게시글 저장 완료");
	}
}
