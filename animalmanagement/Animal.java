package ch12.test;

public class Animal {
	
	private String name;
	private int age;
	private int height;
	private int weight;
	
	public Animal(String name, int age, int height, int weight) {
		this.name = name;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public double bmi() { //18.5이상 23이하 정상
		double bmi = this.weight/((this.height*0.01)*(this.height*0.01));
		return bmi;
	}
	
	public void prt() {
		System.out.println("나이 : "+this.age+"세");
		System.out.println("키 : "+this.height+"cm");
		System.out.println("몸무게 : " +this.weight+"kg");
	}

}
