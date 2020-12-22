package finaltest;

public class DirectorController {

	static int num = 0;
	boolean run = true; {
		while (run) {
			System.out.println("┌─────────관리자 메뉴──────────┐");
			System.out.println("  1.구매자/판매자 조회 및 수정/삭제");
			System.out.println("  2.상품 조회");
			System.out.println("  3.돌아가기");
			System.out.println("└───────────────────────────┘");
			System.out.print("선택 > ");
			int selNum = Integer.parseInt(Main.scan.nextLine()); 	
			switch (selNum) {
			case 1 :
				if(Main.members.isEmpty()) {
					System.out.println("등록된 회원이 없습니다.");
				} else {
					search();
				}
				break;
			case 2 :
				if(Main.products.isEmpty()) {
					System.out.println("등록된 상품이 없습니다.");
				} else {
					lookfor();
				}
				break;
			case 3 :
				new MainController();
			default :
				System.out.println("잘못 눌렀습니다.\n다시 입력해주세요.");
			}
		}
	}
	
	private void search() {
		System.out.println("----------------------------------");
		int memberNum = -1;
		for(int i=0;i<Main.members.size();i++) {
			System.out.println((i+1)+"번. "+Main.members.get(i).getName());
			memberNum=i;
		}
		System.out.print("원하시는 이름이 포함된 번호를 입력 > ");
		num = Integer.parseInt(Main.scan.nextLine());
		if (memberNum==num-1) {
			Main.members.get(num-1).prt();
			System.out.println("─────────────────────");
			System.out.println(" 1.갱신 │ 2.삭제 │ 3.뒤로");
			System.out.println("─────────────────────");
			System.out.print("선택 > ");
			int selNum2 = Integer.parseInt(Main.scan.nextLine());
			if (selNum2 == 1) {
				revise();
			} else if (selNum2 == 2){
				Main.members.remove(num-1);
				System.out.print("고객의 데이터가 삭제되었습니다.\n");
				num = 0;
			} else if (selNum2 == 3) {
				num = 0;
				return;
			} else {
				System.out.println("잘못입력했습니다.\n다시 확인해주세요.");	
			}
		} else {
			System.out.println("잘못입력했습니다.\n다시 확인해주세요.");
		}
	}
	
	private void revise() {
		boolean run = true;
		while (run) {
			System.out.println("┌──────────────┐");
			System.out.println("  1.이름 갱신");
			System.out.println("  2.연락처 갱신");
			System.out.println("  3.캐쉬량 갱신");
			System.out.println("  4.돌아가기");
			System.out.println("└──────────────┘");
			System.out.print("선택 > ");
			int selNum = Integer.parseInt(Main.scan.nextLine()); 	
			switch (selNum) {
			case 1 :
				System.out.print("갱신할 이름 : ");
				String name = Main.scan.nextLine();
				Main.members.get(num-1).setName(name);
				System.out.println("이름 갱신이 완료되었습니다.");
				break;
			case 2:
				System.out.print("갱신할 연락처 : ");
				String phoneNum = Main.scan.nextLine();
				Main.members.get(num-1).setpNum(phoneNum);
				System.out.println("연락처 갱신이 완료되었습니다.");
				break;
			case 3:
				System.out.print("갱신할 캐쉬량 : ");
				int cash = Integer.parseInt(Main.scan.nextLine());
				Main.members.get(num-1).setCash(cash);
				System.out.println("캐쉬량 갱신이 완료되었습니다.");
				break;
			case 4:
				num = 0;
				return;
			default :
				System.out.println("잘못 눌렀습니다.\n다시 입력해주세요.");
			}
		}
	}


	private void lookfor() {
		if(Main.products.isEmpty()) {
			System.out.println("등록된 물품이 없습니다.");
		} else {
			for(int i=0;i<Main.products.size();i++) {
				System.out.println((i+1)+"번. "+Main.members.get(i).getName());
			}
			System.out.print("선택 > ");
			int selNum = Integer.parseInt(Main.scan.nextLine());
			if(Main.products.get(selNum-1)!=null) {
				Main.products.get(selNum-1).prt();
				return;
			}
		}
	}
}
