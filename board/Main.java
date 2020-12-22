package ch18.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ch18.controller.LoginController;
import ch18.vo.Board;
import ch18.vo.Person;

public class Main {
	
	public static Scanner scan =  new Scanner(System.in);
	public static int session = -1;
	public static List<Person> people = new ArrayList<>();
	public static List<Board> boards = new ArrayList<>();

	public static void main(String[] args) {
		new LoginController();
	}

}
