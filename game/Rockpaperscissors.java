import java.util.Scanner;

public class Rockpaperscissors {

	public static void main(String[] args) {
		// ����, ����, �� ������ ��������.
		// ��ǻ�Ϳ� ���Ƿ� �ϴ� ����

		Scanner gawi = new Scanner(System.in);
		String rock = "����";
		String paper = "��";
		String scissors = "����";

		System.out.println("<���� ���� �� ����>\n");
		System.out.print("�� > ");
		String random = gawi.nextLine();
		if ((random.equals(rock))||random.equals(paper)||random.equals(scissors)) {
		int com = (int)(Math.random()*3)+1;
		if (com==1) {
			System.out.print("��ǻ�� > ����");
		} else if (com==2) {
			System.out.print("��ǻ�� > ����");
		} else {
			System.out.print("��ǻ�� > ��");
		} 
		} else {
			System.out.println("�߸��Է��ϼ̽��ϴ�.");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	/*	do {
			int dice1 = (int)(Math.random()*3)+1;
			System.out.println(dice1);
		} while ();

*/








	}

}
