package finaltest;

public class MainController {
	public MainController() {
		init();
	}

	private void init() {
		while(true) {
			System.out.println("┌───────쇼핑몰───────┐");
			System.out.println("   1.회원가입");
			System.out.println("   2.로그인");
			System.out.println("   3.정보 조회 및 수정");
			System.out.println("   4.메뉴");
			System.out.println("   5.로그아웃");
			System.out.println("   6.프로그램 종료");
			System.out.println("└──────────────────┘");
			System.out.print("선택 > ");
			int selNum = Integer.parseInt(Main.scan.nextLine());

			switch(selNum) {
			case 1://판매자, 구매자 회원가입
				if(Main.session==-1) {
					signUp();
				} else {
					System.out.println("이미 로그인되어있습니다.");
				}
				break;
			case 2://로그인
				if(Main.session==-1) {
					signIn();
				} else {
					System.out.println("이미 로그인되어있습니다.");
				}
				break;
			case 3://정보조회 및 수정
				if(Main.session!=-1) {
					lookup();
				} else {
					System.out.println("로그인 된 정보가 없습니다.");
				}
				break;
			case 4://메뉴
				if(Main.session!=-1) {
					if(Main.members.get(Main.session) instanceof Seller) {
						new SellerController();
					} else {
						new BuyerController();
					}
				} else {
					System.out.println("로그인해주세요.");
				}
				break;
			case 5://로그아웃
				if(Main.session!=-1) {
					logout();
				} else {
					System.out.println("로그인 된 정보가 없습니다.");
				}
				break;
			case 6:
				System.out.println("프로그램을 종료합니다.");
				return;
			default :
				System.out.println("잘못 입력했습니다.\n다시 입력해주세요.");
			}
		}
	}

	private void lookup() { // 정보조회 및 수정
		Main.members.get(Main.session).prt();
		for(;;) {
			System.out.println("┌───────────────────┐");
			System.out.println("  1.아이디 변경");
			System.out.println("  2.비밀번호 변경");
			System.out.println("  3.연락처 변경");
			System.out.println("  4.캐쉬충전하기");
			System.out.println("  5.이전 메뉴로 돌아가기");
			System.out.println("└───────────────────┘");
			System.out.print("선택 > ");
			int num = Integer.parseInt(Main.scan.nextLine());

			switch(num) {
			case 1://아이디변경
				modifyId();
				break;
			case 2://비밀번호변경
				modifyPw();
				break;
			case 3://연락처변경
				modifyPnum();
				break;
			case 4://캐쉬충전하기
				modifyCash();
				break;
			case 5://이전 메뉴로 돌아가기
				return;
			default :
				System.out.println("잘못 눌렀습니다.\n다시 입력해주세요.");
			}
		}
	}

	private void modifyCash() { // 캐쉬충전하기
		System.out.println("현재 잔액 : "+Main.members.get(Main.session).getCash());
		System.out.print("충전하실 금액 : ");
		int money = Integer.parseInt(Main.scan.nextLine());
		Main.members.get(Main.session).setCash(Main.members.get(Main.session).getCash()+money);
		System.out.println("충전후 잔액 : "+Main.members.get(Main.session).getCash());
		System.out.println("캐쉬충전이 정상적으로 완료되었습니다.");
	}

	private void modifyPnum() { // 연락처 변경하기
		System.out.print("변경할 연락처 : ");
		String phoneNum = Main.scan.nextLine();
		Main.members.get(Main.session).setpNum(phoneNum);
		System.out.println("연락처 변경이 완료되었습니다.");	
	}

	private void modifyPw() { // 패스워드 변경하기
		System.out.print("변경할 패스워드 : ");
		String pw = Main.scan.nextLine();
		Main.members.get(Main.session).setPw(pw);
		System.out.println("패스워드 변경이 완료되었습니다.");	
	}

	private void modifyId() { // 아이디 변경하기
		System.out.print("변경할 아이디 : ");
		String id = Main.scan.nextLine();
		for(int i=0;i<Main.members.size();i++) {
			if(Main.members.get(i).getId().equals(id)) {
				System.out.print("중복된 아이디가 있습니다.\n다시 입력해주세요.\n>");
				id = Main.scan.nextLine();
				i=0;
			}
			Main.members.get(Main.session).setId(id);
			System.out.println("아이디 변경이 완료되었습니다.");	
		}
	}

	private void logout() { // 로그아웃	
		System.out.println(Main.members.get(Main.session).getName()+"님 로그아웃되었습니다.");
		Main.session=-1;
	}

	private void signIn() { // 로그인
		System.out.println("로그인을 시작합니다.");
		while(true) {
			System.out.print("아이디 > ");
			String id = Main.scan.nextLine();
			System.out.print("비밀번호 > ");
			String pw = Main.scan.nextLine();
			int flag = -1;
			if("관리자".equals(id) && "1234".equals(pw)) {
				new DirectorController();
				flag = -2;
				Main.session = -2;
			} else {
				for(int i=0;i<Main.members.size();i++) {
					if(Main.members.get(i).getId().equals(id)&&Main.members.get(i).getPw().equals(pw)) {
						System.out.println(Main.members.get(i).getName()+"님 로그인 성공");
						Main.session = i;
						if(Main.members.get(i) instanceof Seller) {
							new SellerController();
							return;
						}else if(Main.members.get(i) instanceof Buyer){
							new BuyerController();
							return;
						}
					}
				}
			}
			if(flag==-1) {
				System.out.println("아이디 혹은 비밀번호가 잘못되었습니다.\n다시 입력해주세요.");
			}
		}
	}
	
	private void signUp() { // 회원가입
		System.out.println("회원가입을 시작합니다.");
		while(true) {
			System.out.println("─────────────────");
			System.out.println(" 1.판매자 │ 2.구매자");
			System.out.println("─────────────────");
			System.out.print("선택 > ");
			int no = Integer.parseInt(Main.scan.nextLine());
			if(no==1|no==2) {
				System.out.print("이름을 입력하세요.\n> ");
				String name = Main.scan.nextLine();
				System.out.print("아이디를 입력하세요.\n> ");
				String id = Main.scan.nextLine();
				for(int i=0;i<Main.members.size();i++) {
					if(Main.members.get(i).getId().equals(id)) {
						System.out.print("중복된 아이디가 있습니다.\n다시 입력해주세요.\n>");
						id = Main.scan.nextLine();
						i=0;
					}
				}
				System.out.print("비밀번호를 입력하세요.\n> ");
				String pw = Main.scan.nextLine();
				System.out.print("연락처를 입력하세요.\n> ");
				String phone = Main.scan.nextLine();
				System.out.print("충전하실 금액을 입력하세요.\n> ");
				int money = Integer.parseInt(Main.scan.nextLine());
				System.out.println(name+"님 회원가입이 완료되었습니다.");
				if(no==1) {
					Main.members.add(new Seller(id,pw,name,phone,money));
					return;
				} else {
					Main.members.add(new Buyer(id,pw,name,phone,money));
					return;
				}
			} else {
				System.out.println("잘못 입력했습니다.\n다시 입력해주세요.");
			}
		}
	}
}