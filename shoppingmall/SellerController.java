package finaltest;

public class SellerController {
	public SellerController() {
		init();
	}

	private void init() { // 판매자 메뉴
		while(true) {
			System.out.println("┌─────판매자 메뉴─────┐");
			System.out.println("  1.물품 등록");
			System.out.println("  2.내가 등록한 물품 보기");
			System.out.println("  3.전체 물품 보기");
			System.out.println("  4.이전 메뉴로 돌아가기");
			System.out.println("└──────────────────┘");
			System.out.print("선택 > ");
			int selNo = Integer.parseInt(Main.scan.nextLine());

			switch(selNo) {
			case 1://물품 등록
				input();
				break;
			case 2://자기 물품 보기
				if(Main.products.isEmpty()) {
					System.out.println("등록된 물품이 없습니다.");
				} else {
					myProduct();
				}
				break;
			case 3://전체 물품 보기  
				if(Main.products.isEmpty()) {
					System.out.println("등록된 물품이 없습니다.");
				} else {
					allProduct();
				}
				break;
			case 4://이전메뉴로 돌아가기
				new MainController();
			default :
				System.out.println("잘못 입력했습니다.\n다시 입력해주세요.");
			}
		}
	}

	private void allProduct() { // 전체 물품 보기
		System.out.println("전체 물품을 조회합니다.");
		for(;;) {
			for(int i=0;i<Main.products.size();i++) {
				System.out.println((i+1)+"번 ."+Main.products.get(i).getName());
			}
			System.out.print("선택 > ");
			int selNum = Integer.parseInt(Main.scan.nextLine());
			if(selNum<=Main.products.size()) {
				Main.products.get(selNum-1).prt();
				return;
			} else {
				System.out.println("잘못 입력했습니다.\n다시 입력해주세요.");
			}
		}
	}

	private void myProduct() { // 내가 등록한 물품보기
		System.out.println("내가 등록한 물품을 조회합니다.");
		while(true) {
			for(int i=0;i<Main.products.size();i++) {
				if(Main.products.get(i).getSeller().getName().
						equals(Main.members.get(Main.session).getName())) {
					System.out.println((i+1)+"번 ."+Main.products.get(i).getName());
				}
			}
			for(;;) {
				System.out.print("선택 > ");
				int num = Integer.parseInt(Main.scan.nextLine());
				if(num<=Main.products.size()) {
					if(Main.members.get(Main.session).getName().
							equals(Main.products.get(num-1).getSeller().getName())) {
						Main.products.get(num-1).prt();
						myProductMenu(num-1);
						return;
					} else {
						System.out.println("잘못 입력했습니다.\n다시 입력해주세요.");
					}
				} else {
					System.out.println("잘못 입력했습니다.\n다시 입력해주세요.");
				}
			}
		}
	}

	private void myProductMenu(int a) { // 물품 수정, 삭제
		while(true) {
			System.out.println("─────────────────────");
			System.out.println(" 1.수정 │ 2.삭제 │ 3.뒤로");
			System.out.println("─────────────────────");
			System.out.print("선택 > ");
			int num = Integer.parseInt(Main.scan.nextLine());
			if(num==1) {
				modify(a);
				return;
			} else if(num==2) {
				remove(a);
				return;
			} else if(num==3) {
				return;
			} else {
				System.out.println("잘못 누르셨습니다.\n다시 확인해주세요.");
			}
		}
	}

	private void remove(int a) {	// 물풀 삭제
		System.out.println(Main.products.get(a).getName()+"물품 삭제를 완료하였습니다.");
		int money = Main.products.get(a).getOriginalPrice()*Main.products.get(a).getQuantity();
		Main.products.get(a).getSeller().setCash(Main.products.get(a).getSeller().getCash()+money);
		Main.products.remove(a);
	}

	private void modify(int a) { // 물품 수정
		System.out.println("수정하실 항목을 선택해주세요.");
		System.out.println("──────────────────────────────");
		System.out.println("1.이름│2.원가│3.정가│4.수량│5.뒤로");
		System.out.println("──────────────────────────────");
		System.out.print("선택 > ");
		int num = Integer.parseInt(Main.scan.nextLine());
		switch(num) {	
		case 1:
			System.out.println("변경 할 이름을 입력해주세요.");
			String name = Main.scan.nextLine();
			Main.products.get(a).setName(name);
			System.out.println("제품 이름 변경이 완료되었습니다.");
			return;
		case 2:
			System.out.println("변경 할 원가를 입력해주세요.");
			int modifyPrice = Integer.parseInt(Main.scan.nextLine());
			int differencePrice = modifyPrice-Main.products.get(a).getOriginalPrice();
			if(Main.products.get(a).getSeller().getCash()>=Main.products.get(a).getQuantity()*differencePrice) {
				Main.products.get(a).setOriginalPrice(modifyPrice);
				int money = Main.products.get(a).getQuantity()*differencePrice;
				Main.products.get(a).getSeller().setCash(Main.products.get(a).getSeller().getCash()-money);;
				System.out.println("제품 원가 변경이 완료되었습니다.");
			} else {
				System.out.println("캐쉬가 부족합니다.\n원가 수정에 실패하였습니다.");
			}
			return;
		case 3:
			System.out.println("변경 할 정가를 입력해주세요.");
			int price = Integer.parseInt(Main.scan.nextLine());
			Main.products.get(a).setPrice(price);
			System.out.println("제품 정가 변경이 완료되었습니다.");
			return;
		case 4:
			System.out.println("변경 할 수량을 입력해주세요.");
			int quantity = Integer.parseInt(Main.scan.nextLine());
			if(Main.products.get(a).getSeller().getCash()>=Main.products.get(a).getOriginalPrice()*quantity) {
				Main.products.get(a).setQuantity(quantity);
				int money = Main.products.get(a).getOriginalPrice()*quantity;
				Main.products.get(a).getSeller().setCash(Main.products.get(a).getSeller().getCash()-money);
				System.out.println("제품 수량 변경이 완료되었습니다.");
			} else {
				System.out.println("캐쉬가 부족합니다.\n수량 변경에 실패하였습니다.");
			}
			return;
		case 5:
			return;
		default :
			System.out.println("잘못 입력했습니다.\n다시 입력해주세요.");
		}
	}

	private void input() { // 물품 등록
		System.out.println("물품등록을 시작합니다.");
		System.out.print("물품 이름 > ");
		String name = Main.scan.nextLine();
		System.out.print("원가 > ");
		int oPrice = Integer.parseInt(Main.scan.nextLine());
		System.out.print("정가 > ");
		int price = Integer.parseInt(Main.scan.nextLine());
		System.out.print("수량 > ");
		int num = Integer.parseInt(Main.scan.nextLine());
		if((oPrice*num)<=Main.members.get(Main.session).getCash()) {
			Main.products.add(new Product((Seller)Main.members.get(Main.session),name,oPrice,price,num));
			Main.members.get(Main.session).setCash(Main.members.get(Main.session).getCash()-(oPrice*num));
			System.out.println("상품등록이 정상적으로 완료되었습니다.");
		} else {
			System.out.println("상품등록에 실패하였습니다.\n캐쉬를 충전해주세요.");
		}
	}
}