package bookstore;

import java.util.Scanner;

public class AdminController {

	public Scanner scan = new Scanner(System.in);

	public AdminController() {
		init();
	}

	private void init() {
		// 관리자 메뉴
		while(true) {
			System.out.println("┌─────관리자 메뉴─────┐");
			System.out.println("   1.회원 정보 보기");
			System.out.println("   2.마이 페이지");
			System.out.println("   3.도서 등록");
			System.out.println("   4.도서확인 / 수정"); 
			System.out.println("   5.로그아웃하기"); 
			System.out.println("   6.프로그램 종료하기");
			System.out.println("└─────────────────┘");
			System.out.print("선택 → ");
			int selNum = Integer.parseInt(scan.nextLine());

			switch(selNum) {
			case 1://회원정보보기
				allMembers();
				break;
			case 2://관리자 마이페이지
				adminPage();
				break;
			case 3://도서등록하기
				inputBooks();
				break;
			case 4://등록된 도서 확인 & 수정 & 삭제
				modifyBooks();
				break;
			case 5://로그아웃하기
				System.out.println("────────────────────────");
				System.out.println("  관리자님 로그아웃 되었습니다.");
				System.out.println("────────────────────────");
				new MainController();
				break;
			case 6://프로그램 종료
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			default :
				System.out.println("잘못 입력했습니다.\n다시 입력해주세요.");

			}
		}
	}

	private void modifyBooks() {
		// 등록된 도서 확인, 수정, 삭제
		while(true) {
			System.out.println("<등록된 도서를 확인합니다.>");
			System.out.println("────────────────────────");
			for(int i=0;i<Main.books.size();i++) {
				System.out.println((i+1)+". "+Main.books.get(i).getTitle());
			}
			System.out.println("────────────────────────");
			System.out.print("(0번을 누르면 뒤로 갑니다.)\n선택 → ");
			int selNum = Integer.parseInt(scan.nextLine());
			if(selNum==0) {
				return;
			} else if(selNum>Main.books.size()||selNum<=0) {
				System.out.println("잘못 입력했습니다.\n다시 확인해주세요.");
			} else {
				while(true) {
					Main.books.get(selNum-1).prt2();
					System.out.println("───────────────────");
					System.out.println("   1.수정 │ 2.뒤로");
					System.out.println("───────────────────");
					System.out.print("선택 → ");
					int no = Integer.parseInt(scan.nextLine());
					if(no==1) {
						modify(selNum-1);
						return;
					} else if(no==2) {
						return;
					} else {
						System.out.println("잘못 입력했습니다.\n다시 입력해주세요.");
					}
				}
			}
		}


	}

	private void modify(int i) {
		// 도서 수정하기
		while(true) {
			System.out.println("┌─────────────────┐");
			System.out.println("  1.책 제목 수정하기");
			System.out.println("  2.작가이름 수정하기");
			System.out.println("  3.내용 수정하기");
			System.out.println("  4.가격 수정하기");
			System.out.println("  5.할인 적용하기");
			System.out.println("  6.품절 처리하기");
			System.out.println("  7.뒤로가기");
			System.out.println("└─────────────────┘");
			System.out.print("선택 → ");
			int num = Integer.parseInt(scan.nextLine());
			switch(num) {
			case 1://책 제목 수정하기
				System.out.print("수정 할 제목을 입력해주세요.\nTITLE > ");
				String title = scan.nextLine();
				Main.books.get(i).setTitle(title);
				System.out.println("책 제목 수정이 정상적으로 완료되었습니다.");
				break;
			case 2://작가이름 수정하기
				System.out.print("수정 할 작가 이름을 입력해주세요.\nWRITER > ");
				String writer = scan.nextLine();
				Main.books.get(i).setWriter(writer);
				System.out.println("작가 이름 수정이 정상적으로 완료되었습니다.");
				break;
			case 3://내용 수정하기
				System.out.print("수정 할 내용을 입력해주세요.\nCONTENT > ");
				String content = scan.nextLine();
				Main.books.get(i).setContent(content);
				System.out.println("책 내용 수정이 정상적으로 완료되었습니다.");
				break;
			case 4://가격 수정하기
				System.out.print("변동 된 가격을 입력해주세요.\nPRICE > ");
				int price = Integer.parseInt(scan.nextLine());
				Main.books.get(i).setPrice(price);
				System.out.println("책 가격 변경이 정상적으로 완료되었습니다.");
				break;
			case 5://할인 적용하기
				while(true) {
					System.out.print("몇 퍼센트 할인을 적용하시겠습니까?\n(5%~80% 적용가능)\n> ");
					int sale = Integer.parseInt(scan.nextLine());
					if(sale>80||sale<5) {
						System.out.println("할인가능한 범위를 벗어났습니다.\n다시 입력해주세요.");
					} else {
						int price2 = Main.books.get(i).getPrice()*(100-sale)/100;
						Main.books.get(i).setPrice(price2);
						System.out.println("할인적용이 완료되었습니다.");
						System.out.println("변경 후 가격 : "+Main.books.get(i).getPrice()+"원");
						return;
					}
				}
			case 6://품절처리하기
				System.out.println("<"+Main.books.get(i).getTitle()+"> 책을 삭제하였습니다.");
				Main.books.remove(i);
				return;
			case 7://뒤로가기
				return;
			default:
				System.out.println("잘못 입력했습니다.\n다시 입력해주세요.");
			}
		}

	}

	private void inputBooks() {
		// 도서등록하기
		System.out.println("<도서 등록을 시작합니다.>");
		System.out.print("TITLE > ");
		String title = scan.nextLine();
		System.out.print("WRITER > ");
		String writer = scan.nextLine();
		System.out.print("CONTENT > ");
		String content = scan.nextLine();
		System.out.print("PRICE > ");
		int price = Integer.parseInt(scan.nextLine());

		Main.books.add(new Book(title,writer,content,price));
		System.out.println("<"+title+"> 책 등록이 완료되었습니다.");
	}

	private void adminPage() {
		// 관리자 페이지
		while(true) {
			System.out.println("┌──────────────────┐");
			System.out.println("  ID : "+Main.admin.getAdminId());
			System.out.println("  PW : "+Main.admin.getAdminPw());
			System.out.println("  CASH : "+Main.admin.getCash());
			System.out.println("└──────────────────┘");
			System.out.println(" 1.정보수정 │ 2.뒤로");
			System.out.print("선택 → ");
			int selNum = Integer.parseInt(scan.nextLine());
			if(selNum==1) {
				modifyAdmin();
				return;
			}else if(selNum==2) {
				return;
			} else {
				System.out.println("잘못입력했습니다.\n다시 입력해주세요.");
			}
		}
	}

	private void modifyAdmin() {
		// 관리자 정보 수정하기
		while(true) {
			System.out.println("────────────────────");
			System.out.println("  1.아이디 수정");
			System.out.println("  2.비밀번호 수정");
			System.out.println("────────────────────");
			System.out.print("선택 → ");
			int selNum = Integer.parseInt(scan.nextLine());
			
			if(selNum==1) {
				System.out.print("변경하려는 아이디를 입력해주세요.\n> ");
				String id = scan.nextLine();
				Main.admin.setAdminId(id);
				System.out.println("아이디 변경이 정상적으로 완료되었습니다.");
				return;
			}else if(selNum==2) {
				System.out.print("변경하려는 비밀번호를 입력해주세요.\n> ");
				String pw = scan.nextLine();
				Main.admin.setAdminPw(pw);
				System.out.println("비밀번호 변경이 정상적으로 완료되었습니다.");

				return;
			}else {
				System.out.println("잘못 입력했습니다.\n다시 입력해주세요.");
			}
		}
	}

	private void allMembers() {
		// 회원 정보보기
		if(Main.members.size()==0) {
			System.out.println("등록된 회원이 없습니다.");
		} else {
			while(true) {
				System.out.println("──────────────────");
				for(int i=0;i<Main.members.size();i++) {
					System.out.println((i+1)+". "+Main.members.get(i).getName());
				}
				System.out.println("──────────────────");
				System.out.print("선택 → ");
				int no = Integer.parseInt(scan.nextLine());

				if(no>0&&no<=Main.members.size()) {
					Main.members.get(no-1).prt();
					System.out.println("──────────────────");
					System.out.println("1.다른 회원 보기│2.뒤로");
					System.out.println("──────────────────");
					System.out.print("선택 → ");
					int selNum = Integer.parseInt(scan.nextLine());
					if(selNum==1) {
					} else if(selNum==2) {
						return;
					} else {
						System.out.println("번호를 잘못 입력했습니다.\n다시 입력해주세요.");
						return;
					}
				} else {
					System.out.println("번호를 잘못 입력했습니다.");
				}
			}
		}
	}
}
