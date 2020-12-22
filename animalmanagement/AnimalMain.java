package ch12.test;

import java.util.Scanner;

public class AnimalMain {

	static public Scanner sc = new Scanner(System.in);
	static public Animal[] animal = new Animal[100];

	public static void main(String[] args) {
		// 동물관리 프로그램

		while(true) {
			System.out.println("┌───동물 관리 프로그램───┐");
			System.out.println("  1.동물 등록하기");
			System.out.println("  2.BMI계산하기");
			System.out.println("  3.동물 운동시키기");
			System.out.println("  4.등록된 동물 확인하기");
			System.out.println("  5.동물 삭제하기");
			System.out.println("  6.프로그램 종료하기");
			System.out.println("└──────────────────┘");
			System.out.print("선택 > ");
			int no = Integer.parseInt(sc.nextLine());

			switch(no) {
			case 1: //동물 등록하기
				enrollment();
				break;
			case 2: //BMI계산하기
				animalBmi();
				break;
			case 3: //동물운동시키기
				exercise();
				break;
			case 4: //등록 된 동물 확인하기
				check();
				break;
			case 5: //동물 삭제하기
				delete();
				break;
			case 6: //프로그램 종료하기
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
				break;
			default :
				System.out.println("잘못 눌렀습니다.\n다시 선택해주세요.");
			}
		}


	}

	private static void delete() {
		// 동물 삭제하기
		System.out.println("삭제하려는 동물의 번호를 입력하세요.");
		for(int i=0;i<animal.length;i++) {
			if(animal[i]!=null) {
				System.out.println((i+1)+". "+animal[i].getName());
			}
		}
		System.out.print("번호 > ");
		int selNum = Integer.parseInt(sc.nextLine());
		if(animal[selNum-1]!=null) {
			animal[selNum-1]=null;
			System.out.println("동물을 정상적으로 삭제하였습니다.");
		} else {
			System.out.println("번호를 잘못 입력했습니다.");
		}	
	}

	private static void check() {
		// 등록 된 동물 확인하기
		System.out.println("동물을 확인합니다.");
		for(int i=0;i<animal.length;i++) {
			if(animal[i]!=null) {
				System.out.println("────────────────");
				System.out.println((i+1)+"번. "+animal[i].getName());
				animal[i].prt();
				bmijisu(i);
				System.out.println("────────────────");
			}
		}
	}

	private static void bmijisu(int a) {
		// 정상 과체중 구분
		if(animal[a].bmi()>23) {
			System.out.println("BMI지수 : 과체중");
		} else {
			System.out.println("BMI지수 : 정상");
		}
	}

	private static void animalBmi() {
		// BMI계산
		System.out.print("BMI계산하고자하는 동물의 이름을 입력해주세요.\n > ");
		String name = sc.nextLine();
		Animal ani = findAnimal(name);
		double bmi=0;
		if(ani!=null) {
			for(int i=0;i<animal.length;i++) {
				if(name.equals(animal[i].getName())) {
					bmi = animal[i].bmi();
					System.out.print(animal[i].getName()+"의 BMI계산 결과 : ");
					System.out.println(bmi);
					break;
				}
			}
			if(bmi>=23) {
				System.out.println("관리대상입니다.\n운동을 시작하세요.");
			}else {
				System.out.println("정상체중입니다.");
			}
		} else {
			System.out.println("이름을 잘못 입력했습니다.");
		}

	}

	private static Animal findAnimal(String name) {
		// 동물 찾기
		for(int i=0;i<animal.length;i++) {
			if(animal[i]!=null) {
				if(animal[i].getName().equals(name)) {
					return animal[i];
				}
			}
		}
		return null;
	}

	private static void exercise() {
		// 운동
		System.out.print("운동시키려는 동물의 이름을 입력해주세요.\n > ");
		String name = sc.nextLine();
		Animal mal = findAnimal(name);
		if(mal!=null) {
		double bmi=0;
		int a = -1;
		for(int i=0;i<animal.length;i++) {
			if(name.equals(animal[i].getName())) {
				bmi = animal[i].bmi();
				a=i;
				break;
			}
		}
		if(bmi>=23) {
			System.out.println("운동을 시작합니다.");
			int ex = (int)(Math.random()*15);
			System.out.print("운동강도 : "+ex+"\n");
			if(ex<=9) {
				System.out.println("다이어트 성공\n체중 5KG감소");
				animal[a].setWeight(animal[a].getWeight()-5);
			} else {
				System.out.println("다이어트 실패\n체중 5KG증가");
				animal[a].setWeight(animal[a].getWeight()+5);
			}
		}else {
			System.out.println("관리대상이 아닙니다.");
		}
		}else {
			System.out.println("이름을 잘못 입력했습니다.");
		}
	}

	private static void enrollment() {
		// 동물 등록
		System.out.print("동물 이름을 입력하세요.\n> ");
		String name = sc.nextLine();
		System.out.print("동물 나이를 입력하세요.\n> ");
		int age = Integer.parseInt(sc.nextLine());
		System.out.print("동물 키를 입력하세요.\n> ");
		int height = Integer.parseInt(sc.nextLine());
		System.out.print("동물 몸무게를 입력하세요.\n> ");
		int weight = Integer.parseInt(sc.nextLine());

		Animal ani = new Animal(name,age,height,weight);
		int flag = -1;
		for(int i=0;i<animal.length;i++) {
			if(animal[i]==null) {
				animal[i]=ani;
				flag = i;
				break;
			}
		}
		if(flag==-1) {
			System.out.println("동물 등록에 실패하였습니다.");
		} else {
			System.out.println("동물을 정상적으로 등록하였습니다.");
		}
	}

}
