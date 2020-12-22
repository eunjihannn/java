package bookstore;

import java.util.Scanner;

public class MainController {

	Scanner scan = new Scanner(System.in);

	public MainController() {
		init(); 
	}

	private void init() {
		// 메인 메뉴
		System.out.println("☆밀리의 서재에 오신 것을 환영합니다☆\n");
		while (true) {
			System.out.println("┌───도서관리 프로그램───┐");
			System.out.println("   1.회원가입");
			System.out.println("   2.로그인");
			System.out.println("   3.새로 들어온 도서");
			System.out.println("   4.베스트 셀러");
			System.out.println("   5.전체 도서 확인");
			System.out.println("   6.도서 검색하기");
			System.out.println("   7.프로그램 종료하기");
			System.out.println("└─────────────────┘");
			System.out.print("선택 → ");
			int selNum = Integer.parseInt(scan.nextLine());

			switch (selNum) {
			case 0://더미데이터 삽입
				dummy();
				break;
			case 1: //회원가입하기
				signUp();
				break;
			case 2: //로그인하기
				signIn();
				break;
			case 3: //새로 들어온 도서 확인
				newBooks();
				break;
			case 4: //베스트 셀러
				bestSeller();
				break;
			case 5: //전체 도서확인
				allBooks();
				break;
			case 6://도서검색하기
				searchBooks();
				break;
			case 7: //프로그램 종료하기
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			default:
				System.out.println("잘못 입력했습니다.\n다시 입력해주세요.");
			}
		}

	}

	private void dummy() {
		// 더미데이터 삽입
		Main.books.add(new Book("에이트","이지성","소개 01%가 실천 중인 ‘에이트’를 만나라!"
				+"『리딩으로 리드하라』와 『생각하는 인문학』으로 대한민국에 인문학 돌풍을 일으켰던 이지성"
				+ "저자가... 인공지능을 지배할 수 있는 가장 확실하고 강력한 대응법으로 ‘에이트’를"
				+ "제안한다.",17000));
		Main.books.add(new Book("가장 예쁜 생각을 너에게 주고 싶다.","나태주","우리는 오래 "
				+ "전부터 서로 그리워하고 소망했기에 여기 이렇게 한자리에서 만나게 된 별들이다.",13000));
		Main.books.add(new Book("배려","한상복","이 책은 너와 내가 경쟁하는 삶이 아니라,"
				+ " 함께 배려하며 사는 삶이야말로 진정한 공존의 길임을 보여주는 한국형 자기계발 우화다.",10000));
		Main.books.add(new Book("코로나 이후의 세계","제이슨 솅커","제이슨 솅커는 코로나 이후의 세계는"
				+ " 그 이전과는 절대 같지 않을 것이라고 단언한다.",14800));
		Main.books.add(new Book("데일카네기 자기관리론","데일카네기","데일 카네기가 오랜 시간"
				+ " 동안 수많은 사람에게 건넨 조언!",13900));
		Main.books.add(new Book("부의 대이동","오건영","모두가 주식과 부동산으로 몰려가는 이때,"
				+ "부자들은 왜 달러와 금에 주목하는가?",17000));
		Main.books.add(new Book("너에게 하고 싶은 말","김수민","따뜻한 위로로 기운을 북돋아"
				+ " 주는 책.",13000));
		Main.books.add(new Book("말의 품격","이기주","말과 사람과 품격에 대한 이야기",14500));
		Main.books.add(new Book("하고 싶은 대로 살아도 괜찮아","윤정은","오늘의 고단함도"
				+ " 내일은 시들어 새로운 꽃이 필 것만 같다꽃같이 살자.",13000));
		Main.books.add(new Book("기분이 태도가 되지 않게","레몬 심리","집에서, 회사에서,"
				+ " 인간관계에서 후회가 사라지고 오해가 줄어드는 기분 사용법",14000));

		Main.books.get(0).setCnt(1);
	}

	private void signIn() {
		// 로그인하기
		while (true) {
			System.out.println("───────────────────");
			System.out.print(" 아이디 → ");
			String mId = scan.nextLine();
			System.out.print(" 비밀번호 → ");
			String mPw = scan.nextLine();
			System.out.println("───────────────────");
			int flag = -1;
			String aId = Main.admin.getAdminId();
			String aPw = Main.admin.getAdminPw();
			if(mId.equals(aId)&&mPw.equals(aPw)) {
				System.out.println("관리자님 로그인 되었습니다.");
				new AdminController();
				return;
			}
			for (int i = 0; i < Main.members.size(); i++) {
				if (Main.members.get(i).getId().equals(mId)) {
					if (Main.members.get(i).getPw().equals(mPw)) {
						System.out.println(Main.members.get(i).getName() + " 님 환영합니다.");
						flag=i;
						Main.session = i;
						memberMenu();
						return;
					} else {
						System.out.println("비밀번호가 잘못 되었습니다.\n다시 확인해주세요.");
						flag=i;
						break;
					}
				} else if (Main.members.get(i).getPw().equals(mPw)) {
					System.out.println("아이디가 잘못 되었습니다.\n다시 확인해주세요.");
					flag=i;
					break;
				}
			}
			if (flag == -1) {
				System.out.println("존재하지 않는 회원입니다.\n회원가입을 진행해주세요.");
				System.out.println("────────────────────");
				System.out.println(" 1.회원가입 │ 2.다시 시도");
				System.out.println("────────────────────");
				System.out.print("선택 → ");
				int num = Integer.parseInt(scan.nextLine());
				if (num == 1) {
					signUp();
					return;
				} else if (num == 2) {
					continue;
				}
			}
		}
	}

	private void memberMenu() {
		// 회원 메뉴
		System.out.println("┌───도서관리 프로그램───┐");
		System.out.println("   1.로그아웃");
		System.out.println("   2.마이 페이지");
		System.out.println("   3.새로 들어온 도서");
		System.out.println("   4.베스트 셀러");
		System.out.println("   5.전체 도서 확인");
		System.out.println("   6.도서 검색하기");
		System.out.println("   7.프로그램 종료하기");
		System.out.println("└─────────────────┘");
		System.out.print("선택 → ");
		int selNum = Integer.parseInt(scan.nextLine());

		switch(selNum) {
		case 1: //로그아웃
			logout();
			return;
		case 2: //마이페이지
			myPage();
			break;
		case 3: //새로 들어온 도서
			newBooks();
			break;
		case 4: //베스트 셀러
			bestSeller();
			break;
		case 5: //전체 도서 확인
			allBooks();
			break;
		case 6: //도서 검색하기
			searchBooks();
			break;
		case 7:
			System.out.println("프로그램을 종료합니다.");
			System.exit(0);
			break;
		default :
			System.out.println("잘못 입력했습니다.\n다시 입력해주세요.");
		}
	}

	private void searchBooks() {
		// 도서 검색하기
		System.out.print("찾고자하는 도서를 검색해주세요.> ");
		String title = scan.nextLine();
		int flag=-1;
		for(int i=0;i<Main.books.size();i++) {
			if(Main.books.get(i).getTitle().equals(title)) {
				Main.books.get(i).prt();
				flag=i;
				if(Main.session!=-1) {
					bookMenu(i);
				}
			}
		}
		if(flag==-1) {
			System.out.println("검색한 도서가 없습니다.");
		}

	}

	private void allBooks() {
		// 모든 도서 확인
		if(Main.books.size()>0) {
			System.out.println("──────────────────────────");
			for(int i=0;i<Main.books.size();i++) {
				System.out.println((i+1)+". "+Main.books.get(i).getTitle());
			}
			System.out.println("──────────────────────────");
			System.out.print("(0번을 누르면 뒤로 갑니다.)\n선택 → ");
			while(true) {
				int no = Integer.parseInt(scan.nextLine());
				if(no==0) {
					return;
				}else if(no>0&&no<=Main.books.size()) {
					Main.books.get(no-1).prt();
					if(Main.session!=-1) {
						bookMenu(no-1);
					}
					return;
				} else {
					System.out.println("숫자를 잘못 입력했습니다.\n다시 입력해주세요.");
				}
			}
		} else {
			System.out.println("등록된 도서가 없습니다.");
		}
	}

	private void bookMenu(int BookNo) {
		// 
		while(true) {
			System.out.println("──────────────────────────");
			System.out.println(" 1.장바구니│2.구매하기│3.뒤로");
			System.out.println("──────────────────────────");
			System.out.print("선택 → ");
			int selNum = Integer.parseInt(scan.nextLine());
			switch(selNum) {
			case 1://장바구니 담기
				Main.members.get(Main.session).basketBooks.add(Main.books.get(BookNo));
				System.out.println(Main.members.get(Main.session).getName()+"님의 장바구니에 "
						+Main.books.get(BookNo).getTitle()+"책이 담겼습니다.");
				memberMenu();
				return;
			case 2://구매하기
				if(Main.members.get(Main.session).getMoney()>Main.books.get(BookNo).getPrice()) {
					Main.members.get(Main.session).buyBooks.add(Main.books.get(BookNo));
					int cash = Main.members.get(Main.session).getMoney()-Main.books.get(BookNo).getPrice();
					Main.members.get(Main.session).setMoney(cash);
					int adminCash = Main.admin.getCash()+Main.books.get(BookNo).getPrice();
					Main.admin.setCash(adminCash);
					Main.books.get(BookNo).setCnt(Main.books.get(BookNo).getCnt()+1);
					System.out.println(Main.members.get(Main.session).getName()+"님  <"
							+Main.books.get(BookNo).getTitle()+"> 책 구매가 완료되었습니다.");
					System.out.println(Main.members.get(Main.session).getName()+
							"님 현재 잔액 : "+cash+"원");
				} else {
					System.out.println("캐쉬가 부족합니다.\n캐쉬를 충전해주세요.");
				}
				memberMenu();
				return;
			case 3://뒤로
				memberMenu();
				return;
			default :
				System.out.println("잘못 입력했습니다.\n다시 입력해주세요.");
			}
		}

	}

	private void bestSeller() {
		// 베스트 셀러
		int max = 0;
		int flag=-1;
		for(int i=0;i<Main.books.size();i++) {
			if(Main.books.get(i).getCnt()>max) {
				max=Main.books.get(i).getCnt();
				flag=i;
			}
		}
		if(flag==-1) {
			System.out.println("판매된 도서가 없습니다.");
		}else {
			System.out.println("금주의 베스트 셀러입니다.");
			Main.books.get(flag).prt();
			if(Main.session!=-1) {
				bookMenu(flag);
			}
		}
	}

	private void newBooks() {
		// 새로 들어온 도서
		if(Main.books.size()==0) {
			System.out.println("등록된 도서가 없습니다.");
		}else {
			int no = Main.books.size()-1;
			System.out.println("새로 들어온 도서입니다.");
			Main.books.get(no).prt();
			if(Main.session!=-1) {
				bookMenu(no);
			}
		}
	}

	private void myPage() {
		// 마이페이지
		while(true) {
			System.out.println("☆"+Main.members.get(Main.session).getName()
					+"님 마이페이지☆");
			System.out.println("┌──────────────────┐");
			System.out.println("  1.나의 정보 확인");
			System.out.println("  2.장바구니 확인");
			System.out.println("  3.구매한 도서 목록");
			System.out.println("  4.캐쉬 확인 / 충전");
			System.out.println("  5.뒤로 돌아가기");
			System.out.println("└──────────────────┘");
			System.out.print("선택 → ");
			int selNum = Integer.parseInt(scan.nextLine());
			switch(selNum) {
			case 1: //나의 정보확인 &수정
				check();
				break;
			case 2://장바구니 확인
				myBasket();
				break;
			case 3://구매한 도서 목록 확인
				myBook();
				break;
			case 4: //캐쉬 확인 & 수정
				myCash();
				break;
			case 5: //뒤로 돌아가기
				memberMenu();
				return;
			default :
				System.out.println("잘못 입력했습니다.\n다시 입력해주세요.");
			}
		}

	}

	private void myCash() {
		// 나의 캐쉬 확인 & 충전
		System.out.println("현재 나의 캐쉬는 "+Main.members.get(Main.session).getMoney()
				+"원 입니다.");
		while(true) {
			System.out.println("─────────────────────");
			System.out.println(" 1.캐쉬충전 │ 2.뒤로");
			System.out.println("─────────────────────");
			System.out.print("선택 → ");
			int no = Integer.parseInt(scan.nextLine());

			if(no==1) {
				System.out.print("충전하실 금액을 입력해주세요.\n> ");
				int cash = Integer.parseInt(scan.nextLine());
				Main.members.get(Main.session).setMoney(
						Main.members.get(Main.session).getMoney()+cash);
				System.out.println("캐쉬 충전이 완료되었습니다.\n충전 후 잔액은 "+
						Main.members.get(Main.session).getMoney()+"원 입니다.");
				return;
			}else if(no==2) {
				return;
			}else {
				System.out.println("잘못 입력했습니다.\n다시 입력해주세요.");
			}



		}
	}

	private void myBook() {
		// 구매한 도서 목록 확인
		if(Main.members.get(Main.session).buyBooks.size()!=0) {
			System.out.println(Main.members.get(Main.session).getName()+"님의 구매한 도서 목록입니다.");
			System.out.println("─────────────────────");
			for(int i=0;i<Main.members.get(Main.session).buyBooks.size();i++) {
				System.out.println((i+1)+". "+Main.members.get(Main.session)
				.buyBooks.get(i).getTitle());
			}
			System.out.println("─────────────────────");
		} else {
			System.out.println("구매한 도서가 없습니다.");
		}
	}

	private void myBasket() {
		// 나의 장바구니 확인
		if(Main.members.get(Main.session).basketBooks.size()!=0) {
			while(true) {
				System.out.println(Main.members.get(Main.session).getName()+"님의 장바구니를 확인합니다.");
				System.out.println("─────────────────────");
				for(int i=0;i<Main.members.get(Main.session).basketBooks.size();i++) {
					System.out.println((i+1)+". "+Main.members.get(Main.session).basketBooks.get(i).getTitle());
				}
				System.out.println("──────────────────────");
				System.out.println("  1.구매하기 │ 2.뒤로가기");
				System.out.println("──────────────────────");
				System.out.print("선택 → ");
				int no = Integer.parseInt(scan.nextLine());
				if(no==1) {
					while(true) {
						System.out.println("──────────────────────");
						System.out.println("  1.전체구매 │ 2.선택구매");
						System.out.println("──────────────────────");
						System.out.print("선택 → ");
						int selNum = Integer.parseInt(scan.nextLine());
						switch(selNum) {
						case 1:
							buyAll();
							return;
						case 2:
							buySelectBooks();
							return;
						default :
							System.out.println("잘못 입력했습니다.\n다시 입력해주세요.");
						}
					}
				}else if(no==2) {
					return;
				} else {
					System.out.println("잘못 입력했습니다.\n다시 입력해주세요.");
				}
			}
		} else {
			System.out.println("장바구니가 비었습니다.");
		}
	}

	private void buySelectBooks() {
		// 선택 도서 구매
		while(true) {
			System.out.print("구매하려는 도서의 번호를 입력하세요.\n > ");
			int BookNo = Integer.parseInt(scan.nextLine());
			if(0<BookNo&&BookNo<=Main.members.get(Main.session).basketBooks.size()) {
				if(Main.members.get(Main.session).getMoney()>=Main.members.get(Main.session)
						.basketBooks.get(BookNo-1).getPrice()) {
					System.out.println("<"+Main.members.get(Main.session).basketBooks.get(BookNo-1).getTitle()+"> 책을 구매 완료했습니다.");
					Main.members.get(Main.session).basketBooks.get(BookNo-1).setCnt(Main.members.get(Main.session).basketBooks.get(BookNo-1).getCnt()+1);
					Main.members.get(Main.session).setMoney(Main.members.get(Main.session).getMoney()-Main.members.get(Main.session).basketBooks.get(BookNo-1).getPrice());
					Main.admin.setCash(Main.admin.getCash()+Main.members.get(Main.session).basketBooks.get(BookNo-1).getPrice());
					Main.members.get(Main.session).buyBooks.add(Main.members.get(Main.session).basketBooks.get(BookNo-1));
					Main.members.get(Main.session).basketBooks.remove(BookNo-1);
					System.out.println(Main.members.get(Main.session).getName()+"님의 현재 잔액 : "+
							Main.members.get(Main.session).getMoney()+"원");
					return;
				} else {
					System.out.println("캐쉬가 부족합니다.\n캐쉬를 충전해주세요.");
					return;
				}
			} else {
				System.out.println("번호를 잘못 입력하셨습니다.\n다시 입력해주세요.");
			}
		}
	}

	private void buyAll() {
		// 전체 도서 구매
		int totalPrice = 0;
		for(int i=0;i<Main.members.get(Main.session).basketBooks.size();i++) {
			totalPrice+=Main.members.get(Main.session).basketBooks.get(i).getPrice();
		}
		if(totalPrice<=Main.members.get(Main.session).getMoney()) {
			System.out.println("장바구니에 있는 도서를 모두 구매하였습니다.");
			Main.members.get(Main.session).setMoney(Main.members.get(Main.session).getMoney()-totalPrice);
			Main.admin.setCash(Main.admin.getCash()+totalPrice);
			for(int i=0;i<Main.members.get(Main.session).basketBooks.size();i++) {
				Main.members.get(Main.session).buyBooks.add(Main.members.get(Main.session).basketBooks.get(i));
				Main.members.get(Main.session).basketBooks.get(i).setCnt(Main.members.get(Main.session).basketBooks.get(i).getCnt()+1);
			}
			Main.members.get(Main.session).basketBooks.clear();;
			System.out.println(Main.members.get(Main.session).getName()+"님의 현재 잔액 : "+
			Main.members.get(Main.session).getMoney());
		} else {
			System.out.println(Main.members.get(Main.session).getName()+"님 캐쉬가 부족합니다.");
		}

	}

	private void check() {
		// 나의 정보 확인
		Main.members.get(Main.session).prt();
		while(true) {
			System.out.println("─────────────────");
			System.out.println(" 1.정보변경│2.뒤로 가기");
			System.out.println("─────────────────");
			System.out.print("선택 → ");
			int selNum = Integer.parseInt(scan.nextLine());
			if(selNum==1) {
				modify();
				return;
			} else if(selNum==2) {
				return;
			} else {
				System.out.println("잘못 입력했습니다.\n다시 입력해주세요.");
			}
		}		
	}

	private void modify() {
		// 나의 정보 수정
		while(true) {
			System.out.println("┌──────────────────┐");
			System.out.println("  1.아이디 변경");
			System.out.println("  2.비밀번호 변경");
			System.out.println("  3.뒤로 가기");
			System.out.println("└──────────────────┘");
			System.out.print("선택 → ");
			int selNum = Integer.parseInt(scan.nextLine());

			switch(selNum) {
			case 1://아이디 변경
				System.out.print("변경할 아이디를 입력해주세요.\n>  ");
				String id = scan.nextLine();
				id = checkId(id);
				Main.members.get(Main.session).setId(id);
				System.out.println(Main.members.get(Main.session).getName()
						+"님 아이디 변경이 완료되었습니다.");
				break;
			case 2://비밀번호 변경
				System.out.print("변경할 아이디를 입력해주세요.\n>  ");
				String pw = scan.nextLine();
				Main.members.get(Main.session).setPw(pw);
				System.out.println(Main.members.get(Main.session).getName()
						+"님 비밀번호 변경이 완료되었습니다.");
				break;
			case 3://뒤로가기
				return;
			default :
				System.out.println("잘못 입력했습니다.\n다시 입력해주세요.");
			}

		}
	}

	private void logout() {
		// 로그아웃
		String name = Main.members.get(Main.session).getName();
		System.out.println(name+"님 로그아웃 되었습니다.");
		Main.session = -1;
	}

	private void signUp() {
		// 회원가입하기
		System.out.println("회원가입을 시작합니다.");
		System.out.print("이름을 입력해주세요.\n> ");
		String name = scan.nextLine();
		System.out.print("아이디를 입력해주세요.\n> ");
		String id = scan.nextLine();
		id = checkId(id);
		System.out.print("비밀번호를 입력해주세요.\n> ");
		String pw = scan.nextLine();
		System.out.print("충전할 금액을 입력해주세요.\n> ");
		int money = Integer.parseInt(scan.nextLine());

		Main.members.add(new Member(name, id, pw, money));
		System.out.println(name+"님 회원가입을 축하드립니다!");
	}

	private String checkId(String id) {
		// 아이디체크
		while(true) {
			if(Main.admin.getAdminId().equals(id)) {
				System.out.print("사용할 수 없는 아이디입니다.\n다시 입력해주세요.\n> ");
				id = scan.nextLine();
			} else if(!Main.admin.getAdminId().equals(id)) {
				for(int i=0;i<Main.members.size();i++) {
					if(Main.members.get(i).getId().equals(id)) {
						System.out.print("중복 된 아이디가 있습니다.\n다시 입력해주세요.\n> ");
						id = scan.nextLine();
						i=0;
					} 
				}
				return id;
			}

		}
	}
}
