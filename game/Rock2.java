import java.util.Scanner;

public class Rock2 {

	public static void main(String[] args) {
		// ����Ƚ���� �Է¹޾Ƽ� ���������� ������ ���� �� ���������ν�, ��, �и� ����ϴ� ���α׷�
		// ��ȭ����

		System.out.println("<���� ��������������>");
		Scanner wow = new Scanner(System.in);
		System.out.print("�÷��� �Ͻ� Ƚ���� �Է��ϼ��� > ");
		int num = wow.nextInt();

		String s = "����";
		String r = "����";
		String p = "��";
		int score = 0;
		int sum = 0;

		for (int a=1;a<=num;a++) {
			int player1 = (int)(Math.random()*3)+1;
			int player2 = (int)(Math.random()*3)+1;
			if(player1==1) {
				System.out.println("������ : "+s);
			} else if (player1==2) {
				System.out.println("������ : "+r);
			} else {
				System.out.println("������ : "+p);
			}
			if(player2==1) {
				System.out.println("��ǻ�� : "+s);
			} else if (player2==2) {
				System.out.println("��ǻ�� : "+r);
			} else {
				System.out.println("��ǻ�� : "+p);
			} System.out.println();
			if (player1==player2) {
				sum += 0;
			} else if ((player1==2)&&(player2==1)) {
				sum += 1;
			} else if ((player1==3)&&(player2==2)) {
				sum += 1;
			} else if ((player1==1)&&(player2==3)) {
				sum += 1;
			} else {
				sum -= 1;
			}
		}
		 if (sum>0) {
				System.out.println("*���������� �¸�*");
			} else if (sum==0) {
				System.out.println("*���º�*");
			} else {
				System.out.println("*���������� �й�*");
			}
	}
}


