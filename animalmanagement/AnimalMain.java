package ch12.test;

import java.util.Scanner;

public class AnimalMain {

	static public Scanner sc = new Scanner(System.in);
	static public Animal[] animal = new Animal[100];

	public static void main(String[] args) {
		// �������� ���α׷�

		while(true) {
			System.out.println("������������ ���� ���α׷���������");
			System.out.println("  1.���� ����ϱ�");
			System.out.println("  2.BMI����ϱ�");
			System.out.println("  3.���� ���Ű��");
			System.out.println("  4.��ϵ� ���� Ȯ���ϱ�");
			System.out.println("  5.���� �����ϱ�");
			System.out.println("  6.���α׷� �����ϱ�");
			System.out.println("����������������������������������������");
			System.out.print("���� > ");
			int no = Integer.parseInt(sc.nextLine());

			switch(no) {
			case 1: //���� ����ϱ�
				enrollment();
				break;
			case 2: //BMI����ϱ�
				animalBmi();
				break;
			case 3: //�������Ű��
				exercise();
				break;
			case 4: //��� �� ���� Ȯ���ϱ�
				check();
				break;
			case 5: //���� �����ϱ�
				delete();
				break;
			case 6: //���α׷� �����ϱ�
				System.out.println("���α׷��� �����մϴ�.");
				System.exit(0);
				break;
			default :
				System.out.println("�߸� �������ϴ�.\n�ٽ� �������ּ���.");
			}
		}


	}

	private static void delete() {
		// ���� �����ϱ�
		System.out.println("�����Ϸ��� ������ ��ȣ�� �Է��ϼ���.");
		for(int i=0;i<animal.length;i++) {
			if(animal[i]!=null) {
				System.out.println((i+1)+". "+animal[i].getName());
			}
		}
		System.out.print("��ȣ > ");
		int selNum = Integer.parseInt(sc.nextLine());
		if(animal[selNum-1]!=null) {
			animal[selNum-1]=null;
			System.out.println("������ ���������� �����Ͽ����ϴ�.");
		} else {
			System.out.println("��ȣ�� �߸� �Է��߽��ϴ�.");
		}	
	}

	private static void check() {
		// ��� �� ���� Ȯ���ϱ�
		System.out.println("������ Ȯ���մϴ�.");
		for(int i=0;i<animal.length;i++) {
			if(animal[i]!=null) {
				System.out.println("��������������������������������");
				System.out.println((i+1)+"��. "+animal[i].getName());
				animal[i].prt();
				bmijisu(i);
				System.out.println("��������������������������������");
			}
		}
	}

	private static void bmijisu(int a) {
		// ���� ��ü�� ����
		if(animal[a].bmi()>23) {
			System.out.println("BMI���� : ��ü��");
		} else {
			System.out.println("BMI���� : ����");
		}
	}

	private static void animalBmi() {
		// BMI���
		System.out.print("BMI����ϰ����ϴ� ������ �̸��� �Է����ּ���.\n > ");
		String name = sc.nextLine();
		Animal ani = findAnimal(name);
		double bmi=0;
		if(ani!=null) {
			for(int i=0;i<animal.length;i++) {
				if(name.equals(animal[i].getName())) {
					bmi = animal[i].bmi();
					System.out.print(animal[i].getName()+"�� BMI��� ��� : ");
					System.out.println(bmi);
					break;
				}
			}
			if(bmi>=23) {
				System.out.println("��������Դϴ�.\n��� �����ϼ���.");
			}else {
				System.out.println("����ü���Դϴ�.");
			}
		} else {
			System.out.println("�̸��� �߸� �Է��߽��ϴ�.");
		}

	}

	private static Animal findAnimal(String name) {
		// ���� ã��
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
		// �
		System.out.print("���Ű���� ������ �̸��� �Է����ּ���.\n > ");
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
			System.out.println("��� �����մϴ�.");
			int ex = (int)(Math.random()*15);
			System.out.print("����� : "+ex+"\n");
			if(ex<=9) {
				System.out.println("���̾�Ʈ ����\nü�� 5KG����");
				animal[a].setWeight(animal[a].getWeight()-5);
			} else {
				System.out.println("���̾�Ʈ ����\nü�� 5KG����");
				animal[a].setWeight(animal[a].getWeight()+5);
			}
		}else {
			System.out.println("��������� �ƴմϴ�.");
		}
		}else {
			System.out.println("�̸��� �߸� �Է��߽��ϴ�.");
		}
	}

	private static void enrollment() {
		// ���� ���
		System.out.print("���� �̸��� �Է��ϼ���.\n> ");
		String name = sc.nextLine();
		System.out.print("���� ���̸� �Է��ϼ���.\n> ");
		int age = Integer.parseInt(sc.nextLine());
		System.out.print("���� Ű�� �Է��ϼ���.\n> ");
		int height = Integer.parseInt(sc.nextLine());
		System.out.print("���� �����Ը� �Է��ϼ���.\n> ");
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
			System.out.println("���� ��Ͽ� �����Ͽ����ϴ�.");
		} else {
			System.out.println("������ ���������� ����Ͽ����ϴ�.");
		}
	}

}
