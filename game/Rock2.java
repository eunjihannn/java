import java.util.Scanner;

public class Rock2 {

	public static void main(String[] args) {
		// 게임횟수를 입력받아서 가위바위보 게임을 진행 후 최종적으로승, 무, 패를 출력하는 프로그램
		// 심화문제

		System.out.println("<랜덤 가위바위보게임>");
		Scanner wow = new Scanner(System.in);
		System.out.print("플레이 하실 횟수를 입력하세요 > ");
		int num = wow.nextInt();

		String s = "가위";
		String r = "바위";
		String p = "보";
		int score = 0;
		int sum = 0;

		for (int a=1;a<=num;a++) {
			int player1 = (int)(Math.random()*3)+1;
			int player2 = (int)(Math.random()*3)+1;
			if(player1==1) {
				System.out.println("한은지 : "+s);
			} else if (player1==2) {
				System.out.println("한은지 : "+r);
			} else {
				System.out.println("한은지 : "+p);
			}
			if(player2==1) {
				System.out.println("컴퓨터 : "+s);
			} else if (player2==2) {
				System.out.println("컴퓨터 : "+r);
			} else {
				System.out.println("컴퓨터 : "+p);
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
				System.out.println("*한은지님의 승리*");
			} else if (sum==0) {
				System.out.println("*무승부*");
			} else {
				System.out.println("*한은지님의 패배*");
			}
	}
}


