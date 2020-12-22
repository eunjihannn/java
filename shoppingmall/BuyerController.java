package finaltest;

public class BuyerController {
	public BuyerController() {
		init();
	}

	private void init() { // 구매자 메뉴
		while(true) {
			System.out.println("┌─────구매자 메뉴─────┐");
			System.out.println("  1.전체 상품 보기");
			System.out.println("  2.장바구니");
			System.out.println("  3.이전 메뉴 돌아가기");
			System.out.println("└─────────────────┘");
			System.out.print("선택 > ");
			int selNum = Integer.parseInt(Main.scan.nextLine());
			if(selNum==1) {
				if(Main.products.isEmpty()) {
					System.out.println("등록된 물품이 없습니다.");
				} else {
					allProduct();
				}
			} else if(selNum==2) {
				shoppingBasket();
			} else if(selNum==3) {
				return;
			} else {
				System.out.println("잘못 입력했습니다.\n다시 확인해주세요.");
			}
		}
	}

	private void allProduct()  {// 전체 상품 보기
		while(true) {
			for(int i=0;i<Main.products.size();i++) {
				System.out.println((i+1)+"번. "+Main.products.get(i).getName());
			}
			System.out.print("선택 > ");
			int num = Integer.parseInt(Main.scan.nextLine());
			if(num<=Main.products.size()) {
				Main.products.get(num-1).sales();
				buyMenu(num-1);
				return;
			}else {
				System.out.println("잘못입력했습니다.\n다시 확인해주세요.");
			}
		}
	}

	private void buyMenu(int a) { // 장바구니 담기
		while(true) {
			System.out.println("────────────────────");
			System.out.println(" 1.장바구니 담기│2.뒤로");
			System.out.println("────────────────────");
			System.out.print("선택 > ");
			int num = Integer.parseInt(Main.scan.nextLine());
			if(num==1) {
				System.out.print("장바구니에 담을 수량을 입력해주세요.\n> ");
				for(;;) {
					int gae = Integer.parseInt(Main.scan.nextLine());
					if(gae>0&&gae<=Main.products.get(a).getQuantity()) {
						Main.members.get(Main.session).spBasket.add(new Basket(Main.products.get(a),gae));
						Main.products.get(a).setQuantity(Main.products.get(a).getQuantity()-gae);
						System.out.println(Main.products.get(a).getName()+"제품을 장바구니에 담았습니다.");
						return;
					} else {
						System.out.print("장바구니에 담을 수량이 재고수량을 초과하였습니다.\n다시 입력해주세요.\n> ");
					}
				}
			}else if(num==2) {
				return;
			}else {
				System.out.println("잘못 입력했습니다.\n다시 입력해주세요.");
			}
		}
	}

	private void shoppingBasket() { // 내 장바구니보기
		System.out.println(Main.members.get(Main.session).getName()+"님의 장바구니를 확인합니다.");
		if(!Main.members.get(Main.session).spBasket.isEmpty()) {
			for(int i=0;i<Main.members.get(Main.session).spBasket.size();i++) {
				Main.members.get(Main.session).spBasket.get(i).prt();
			}
			for(;;) {
				System.out.println("─────────────────────────────");
				System.out.println(" 1.장바구니 비우기│2.결제하기│3.뒤로");
				System.out.println("─────────────────────────────");
				System.out.print("선택 > ");
				int selNum = Integer.parseInt(Main.scan.nextLine());
				if(selNum==1) {
					empty();
					return;
				}else if(selNum==2) {
					payment();
					return;
				}else if(selNum==3){
					return;
				}else {
					System.out.println("잘못 입력했습니다./n다시 입력해주세요.");
				}
			}
		} else {
			System.out.println("장바구니가 비었습니다.");
		}
	}

	private void payment() { // 장바구니 품목 결제하기
		int money = 0;
		for(int i=0;i<Main.members.get(Main.session).spBasket.size();i++) {
			money +=Main.members.get(Main.session).spBasket.get(0).getNum()*
					Main.members.get(Main.session).spBasket.get(0).getProduct().getPrice();
		}
		if(Main.members.get(Main.session).getCash()>=money) {
			System.out.println("장바구니에 있는 품목을 모두 결제합니다.");
			Main.members.get(Main.session).setCash(Main.members.get(Main.session).getCash()-money);
			emptyBasket();
			System.out.println(Main.members.get(Main.session).getName()+"님의 결제 후 잔액 : "
					+Main.members.get(Main.session).getCash());
		} else {
			System.out.println("캐쉬가 부족합니다.\n캐쉬를 충전해주세요.");
		}
	}

	private void emptyBasket() { // 결제후 장바구니 비우기
		for(int i=0;i<Main.members.get(Main.session).spBasket.size();i++) {
			int money = Main.members.get(Main.session).spBasket.get(i).getProduct().getPrice()*
					Main.members.get(Main.session).spBasket.get(i).getNum();
			Main.members.get(Main.session).spBasket.get(i).getProduct().getSeller().setCash
			(Main.members.get(Main.session).spBasket.get(i).getProduct().getSeller().getCash()+money);
		}
		Main.members.get(Main.session).spBasket.clear();
	}

	private void empty() { // 장바구니 비우기
		for(int i=0;i<Main.members.get(Main.session).spBasket.size();i++) {
			int gae = Main.members.get(Main.session).spBasket.get(i).getNum();
			for(int j=0;j<Main.products.size();j++) {
				if(Main.members.get(Main.session).spBasket.get(i).getProduct().getName().
						equals(Main.products.get(j).getName()))
					Main.members.get(Main.session).spBasket.get(i).getProduct().setQuantity
					(gae+Main.products.get(j).getQuantity());
			}
		}
		Main.members.get(Main.session).spBasket.clear();
		System.out.println("장바구니를 정상적으로 비웠습니다.");
	}
}
