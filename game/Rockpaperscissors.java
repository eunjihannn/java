import java.util.Scanner;

public class Rockpaperscissors {

	public static void main(String[] args) {
		// 가위, 바위, 보 게임을 만들어보세요.
		// 컴퓨터와 임의로 하는 게임

		Scanner gawi = new Scanner(System.in);
		String rock = "바위";
		String paper = "보";
		String scissors = "가위";

		System.out.println("<가위 바위 보 게임>\n");
		System.out.print("나 > ");
		String random = gawi.nextLine();
		if ((random.equals(rock))||random.equals(paper)||random.equals(scissors)) {
		int com = (int)(Math.random()*3)+1;
		if (com==1) {
			System.out.print("컴퓨터 > 가위");
		} else if (com==2) {
			System.out.print("컴퓨터 > 바위");
		} else {
			System.out.print("컴퓨터 > 보");
		} 
		} else {
			System.out.println("잘못입력하셨습니다.");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	/*	do {
			int dice1 = (int)(Math.random()*3)+1;
			System.out.println(dice1);
		} while ();

*/








	}

}
