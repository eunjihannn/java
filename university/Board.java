package ch10.test;

public class Board {

	private String title;
	private String text;
	private Member m;
	
	public Board(String title, String text, Member m) {
		this.title = title;
		this.text = text;
		this.m = m;
	}
	
	public void prt() {
		System.out.println("��������������������������������������");
		System.out.println("�ۼ��� : "+m.getName());
		System.out.println("��   �� : "+title);
		System.out.println("��   �� : "+text);
		System.out.println("��������������������������������������");
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Member getM() {
		return m;
	}
	public void setM(Member m) {
		this.m = m;
	}
	
	
}
