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
		// �л� ���� ���� �ý���

		while(true) {
			System.out.println("�������л� �������� �ý��ۦ�����");
			System.out.println("   1.ȸ������");
			System.out.println("   2.�α���");
			System.out.println("   3.�α׾ƿ�");
			System.out.println("   4.����������");
			System.out.println("   5.�Խ���");
			System.out.println("   6.���α׷� ����");
			System.out.println("����������������������������������������");
			System.out.print("���� �� ");
			int num = Integer.parseInt(in.nextLine());

			switch(num) {
			case 1: //ȸ������
				if(eunji==null) {
					signIn();
				} else {
					System.out.println("�̹� �α��� �Ǿ��ֽ��ϴ�.");
				}
				break;
			case 2: //�α���
				if(eunji==null) {
					login();
				} else {
					System.out.println("�̹� �α��εǾ��ֽ��ϴ�.");
				}
				break;
			case 3: //�α׾ƿ�
				logout();
				break;
			case 4: //�α�������
				if(eunji!=null) {
					mypage();
				} else {
					System.out.println("�α��ε� ������ �����ϴ�.");
				}
				break;
			case 5: //�Խ���
				if(eunji!=null) {
					Board();
				} else {
					System.out.println("�α��� �� �̿밡���մϴ�.");
				}
				break;
			case 6:
				System.out.println("���α׷��� �����մϴ�.");
				System.exit(0);
			default :
				jal();
			}
		}
	}

	private static void Board() {
		// �Խ��� ���
		while(true) {
			System.out.println("�Խ����Դϴ�.\n���Ͻô� �޴��� �������ּ���.");
			System.out.println("��������������������������������������");
			System.out.println("  1. �Խñۺ���");
			System.out.println("  2. ���ۼ�");
			System.out.println("  3. �ۻ���");
			System.out.println("  4. ���� �޴� ���ư���");
			System.out.println("��������������������������������������");
			System.out.print("���� �� ");
			int selnum = Integer.parseInt(in.nextLine());

			switch(selnum) {
			case 1: //�Խñ� ����
				if(geul != null) {
					watch();
				} else {
					System.out.println("�ۼ��� �Խñ��� �����ϴ�.");
				}
				break;
			case 2: //���ۼ�
				write();
				break;
			case 3: //�ۻ���
				delete();
				break;
			case 4: //�����޴� ���ư���
				return;
			default :
				jal();
			}
		}

	}

	private static void delete() {
		// �ۻ���
		for(;;) {
			System.out.println("�����Ͻ� ���� �������ּ���.");
			for(int i=0;i<geul.length;i++) {
				if(geul[i].getM()==eunji) {
					System.out.println((i+1)+"��. "+geul[i].getTitle());
					break;
				}
			}
			System.out.print("���� �� ");
			int no = Integer.parseInt(in.nextLine());

			if(geul[no-1]!=null) {
				System.out.println("��й�ȣ�� �Է����ּ���.");
				String pwd = in.nextLine();
				if(pwd.equals(eunji.getPw())) {
					geul[no-1]=null;
					System.out.println("���� ���������� �����Ǿ����ϴ�.");
					return;
				} else {
					System.out.println("��й�ȣ�� �߸��ƽ��ϴ�.\n���� ������ �� �����ϴ�.");
					break;
				}
			} else {
				jal();
			}
		}
	}

	private static void write() {
		// ���ۼ�
		System.out.println("���ۼ��� �����մϴ�.");
		System.out.print("������ �Է����ּ���.\n�� ");
		String title = in.nextLine();
		System.out.print("������ �Է����ּ���.\n�� ");
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
		// �Խñۺ���
		while(true) {
			System.out.println("Ȯ���� �Խñ��� �������ּ���.");
			for(int i=0;i<geul.length;i++) {
				if(geul[i]!=null) {
					System.out.println((i+1)+"��. "+geul[i].getTitle());
				}
			}
			System.out.print("���� �� ");
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
		// ���������� ���
		System.out.println("�̸� : "+eunji.getName());
		if(eunji instanceof Teacher) {
			Teacher te = (Teacher)eunji;
			System.out.println("������ : "+te.getSubject());
		} else {
			Student st = (Student)eunji;
			System.out.println("���� : "+st.getMajor());
		}
	}

	private static void logout() {
		// �α׾ƿ� ���
		if(eunji!=null) {
			eunji=null;
			System.out.println("�α׾ƿ� �Ǿ����ϴ�.");
		} else {
			System.out.println("�α��ε� ������ �����ϴ�.");
		}
	}

	private static void login() {
		// �α��� ���
		int idx = 0;
		System.out.print("���̵� > ");
		String id = in.nextLine();
		System.out.print("��й�ȣ > ");
		String pw = in.nextLine();

		for(int i=0;i<member.length;i++) {
			if((member[i].getId().equals(id))&&(member[i].getPw().equals(pw))){
				System.out.println("�α��� ����");
				eunji = member[i];
				idx = i;
				method(idx);
				return;
			} else if(member[i].getId().equals(id)) {
				System.out.println("��й�ȣ�� Ʋ�Ƚ��ϴ�.");
				return;
			} else if(member[i].getPw().equals(pw)) {
				System.out.println("���̵� Ʋ�Ƚ��ϴ�.");
				return;
			} 
		}
	}

	private static void method(int idx) {
		// �α��� ������ work, test �޼ҵ�� ������
		for(;;) {
			System.out.println("������ ������ �����ϼ���.");
			System.out.println("1.work");
			System.out.println("2.test");
			System.out.print("�� ");
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
		// ȸ������ ���
		System.out.println("ȸ�������� �����մϴ�.");
		System.out.println("���������� �л����� �������ּ���.");
		System.out.println("������������������");
		System.out.println(" 1.������");
		System.out.println(" 2.�л� ");
		System.out.println("������������������");
		System.out.print("���� �� ");
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
		// ������ ȸ������
		System.out.println("�̸��� �Է��ϼ���.");
		String name = in.nextLine();
		System.out.println("���̵� �Է��ϼ���.");
		String id = in.nextLine();
		System.out.println("��й�ȣ�� �Է��ϼ���.");
		String pw = in.nextLine();
		System.out.println("�������� �Է��ϼ���.");
		String subject = in.nextLine();

		tea = new Teacher(name,id,pw,subject);
		return tea;
	}

	private static Member signInStu() {
		// �л� ȸ������
		System.out.println("�̸��� �Է��ϼ���.");
		String name = in.nextLine();
		System.out.println("���̵� �Է��ϼ���.");
		String id = in.nextLine();
		System.out.println("��й�ȣ�� �Է��ϼ���.");
		String pw = in.nextLine();
		System.out.println("������ �Է��ϼ���.");
		String major = in.nextLine();

		stu = new Student(name,id,pw,major);
		return stu;
	}

	private static void jal() {
		System.out.println("�߸� �����̽��ϴ�.\n�ٽ� Ȯ�����ּ���.");
	}

}
