package ch10.test;

import java.util.Scanner;

public class Main {

	static Member[] member = new Member[100];
	static Scanner in = new Scanner(System.in);
	static Teacher tea;
	static Student stu;
	static Member eunji;
	static Board[] geul = new Board[100];

	public static void main(String[] args) {
		// 학사 정보 관리 시스템

		while(true) {
			System.out.println("┌──학사 정보관리 시스템──┐");
			System.out.println("   1.회원가입");
			System.out.println("   2.로그인");
			System.out.println("   3.로그아웃");
			System.out.println("   4.마이페이지");
			System.out.println("   5.게시판");
			System.out.println("   6.프로그램 종료");
			System.out.println("└──────────────────┘");
			System.out.print("선택 → ");
			int num = Integer.parseInt(in.nextLine());

			switch(num) {
			case 1: //회원가입
				if(eunji==null) {
					signIn();
				} else {
					System.out.println("이미 로그인 되어있습니다.");
				}
				break;
			case 2: //로그인
				if(eunji==null) {
					login();
				} else {
					System.out.println("이미 로그인되어있습니다.");
				}
				break;
			case 3: //로그아웃
				logout();
				break;
			case 4: //로그인정보
				if(eunji!=null) {
					mypage();
				} else {
					System.out.println("로그인된 정보가 없습니다.");
				}
				break;
			case 5: //게시판
				if(eunji!=null) {
					Board();
				} else {
					System.out.println("로그인 후 이용가능합니다.");
				}
				break;
			case 6:
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			default :
				jal();
			}
		}
	}

	private static void Board() {
		// 게시판 기능
		while(true) {
			System.out.println("게시판입니다.\n원하시는 메뉴를 선택해주세요.");
			System.out.println("┌─────────────────┐");
			System.out.println("  1. 게시글보기");
			System.out.println("  2. 글작성");
			System.out.println("  3. 글삭제");
			System.out.println("  4. 이전 메뉴 돌아가기");
			System.out.println("└─────────────────┘");
			System.out.print("선택 → ");
			int selnum = Integer.parseInt(in.nextLine());

			switch(selnum) {
			case 1: //게시글 보기
				if(geul != null) {
					watch();
				} else {
					System.out.println("작성된 게시글이 없습니다.");
				}
				break;
			case 2: //글작성
				write();
				break;
			case 3: //글삭제
				delete();
				break;
			case 4: //이전메뉴 돌아가기
				return;
			default :
				jal();
			}
		}

	}

	private static void delete() {
		// 글삭제
		for(;;) {
			System.out.println("삭제하실 글을 선택해주세요.");
			for(int i=0;i<geul.length;i++) {
				if(geul[i].getM()==eunji) {
					System.out.println((i+1)+"번. "+geul[i].getTitle());
					break;
				}
			}
			System.out.print("선택 → ");
			int no = Integer.parseInt(in.nextLine());

			if(geul[no-1]!=null) {
				System.out.println("비밀번호를 입력해주세요.");
				String pwd = in.nextLine();
				if(pwd.equals(eunji.getPw())) {
					geul[no-1]=null;
					System.out.println("글이 정상적으로 삭제되었습니다.");
					return;
				} else {
					System.out.println("비밀번호가 잘못됐습니다.\n글을 삭제할 수 없습니다.");
					break;
				}
			} else {
				jal();
			}
		}
	}

	private static void write() {
		// 글작성
		System.out.println("글작성을 시작합니다.");
		System.out.print("제목을 입력해주세요.\n▷ ");
		String title = in.nextLine();
		System.out.print("내용을 입력해주세요.\n▷ ");
		String text = in.nextLine();

		Board b = new Board(title,text,eunji);

		for(int i=0;i<geul.length;i++) {
			if(geul[i]==null) {
				geul[i]=b;
				break;
			}
		}

	}

	private static void watch() {
		// 게시글보기
		while(true) {
			System.out.println("확인할 게시글을 선택헤주세요.");
			for(int i=0;i<geul.length;i++) {
				if(geul[i]!=null) {
					System.out.println((i+1)+"번. "+geul[i].getTitle());
				}
			}
			System.out.print("선택 → ");
			int num = Integer.parseInt(in.nextLine());
			if(geul[num-1]!=null) {
				geul[num-1].prt();
				return;
			} else {
				jal();
			}
		}
	}

	private static void mypage() {
		// 마이페이지 기능
		System.out.println("이름 : "+eunji.getName());
		if(eunji instanceof Teacher) {
			Teacher te = (Teacher)eunji;
			System.out.println("담당과목 : "+te.getSubject());
		} else {
			Student st = (Student)eunji;
			System.out.println("전공 : "+st.getMajor());
		}
	}

	private static void logout() {
		// 로그아웃 기능
		if(eunji!=null) {
			eunji=null;
			System.out.println("로그아웃 되었습니다.");
		} else {
			System.out.println("로그인된 정보가 없습니다.");
		}
	}

	private static void login() {
		// 로그인 기능
		int idx = 0;
		System.out.print("아이디 > ");
		String id = in.nextLine();
		System.out.print("비밀번호 > ");
		String pw = in.nextLine();

		for(int i=0;i<member.length;i++) {
			if((member[i].getId().equals(id))&&(member[i].getPw().equals(pw))){
				System.out.println("로그인 성공");
				eunji = member[i];
				idx = i;
				method(idx);
				return;
			} else if(member[i].getId().equals(id)) {
				System.out.println("비밀번호가 틀렸습니다.");
				return;
			} else if(member[i].getPw().equals(pw)) {
				System.out.println("아이디가 틀렸습니다.");
				return;
			} 
		}
	}

	private static void method(int idx) {
		// 로그인 성공시 work, test 메소드로 보내기
		for(;;) {
			System.out.println("실행할 업무를 선택하세요.");
			System.out.println("1.work");
			System.out.println("2.test");
			System.out.print("→ ");
			int dodo = Integer.parseInt(in.nextLine());
			if(dodo==1) {
				member[idx].work();
				return;
			} else if(dodo==2) {
				member[idx].test();
				return;
			} else {
				jal();
			}
		}
	}

	private static void signIn() {
		// 회원가입 기능
		System.out.println("회원가입을 시작합니다.");
		System.out.println("선생님인지 학생인지 선택해주세요.");
		System.out.println("─────────");
		System.out.println(" 1.선생님");
		System.out.println(" 2.학생 ");
		System.out.println("─────────");
		System.out.print("선택 → ");
		int sel = Integer.parseInt(in.nextLine());

		if((sel==1)||(sel==2)) {
			if(sel==1) {
				Member m = signInTea();
				save(m);
			} else {
				Member s = signInStu();
				save(s);
			}
		} else {
			jal();
		}
	}

	private static void save(Member a) {
		for(int i=0;i<member.length;i++) {
			if(member[i]==null) {
				member[i]=a;
				break;
			}
		}
	}

	private static Member signInTea() {
		// 선생님 회원가입
		System.out.println("이름을 입력하세요.");
		String name = in.nextLine();
		System.out.println("아이디를 입력하세요.");
		String id = in.nextLine();
		System.out.println("비밀번호를 입력하세요.");
		String pw = in.nextLine();
		System.out.println("담당과목을 입력하세요.");
		String subject = in.nextLine();

		tea = new Teacher(name,id,pw,subject);
		return tea;
	}

	private static Member signInStu() {
		// 학생 회원가입
		System.out.println("이름을 입력하세요.");
		String name = in.nextLine();
		System.out.println("아이디를 입력하세요.");
		String id = in.nextLine();
		System.out.println("비밀번호를 입력하세요.");
		String pw = in.nextLine();
		System.out.println("전공을 입력하세요.");
		String major = in.nextLine();

		stu = new Student(name,id,pw,major);
		return stu;
	}

	private static void jal() {
		System.out.println("잘못 누르셨습니다.\n다시 확인해주세요.");
	}

}
