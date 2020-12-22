package ch14.test;

import java.util.Random;
import java.util.TreeSet;

public class Lotto2 {
	static Random r = new Random();
	static TreeSet<Integer> set = new TreeSet<>();

	public static void main(String[] args) {
		// 로또(선생님)
		while(set.size()<6) {
			int num = r.nextInt(45)+1;
			set.add(num);
		}
		for(int num:set) {
			System.out.print(num+", ");
		}
	}

}
