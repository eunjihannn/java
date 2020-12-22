package ch18.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Board {
	private String title;
	private String content;
	private String writer;
	private String password;
	private Date date;
	private Date fixDate;
	
	public Board(String title, String content, String writer, String password, Date date) {
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.password = password;
		this.date = date;
		this.fixDate = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getFixDate() {
		return fixDate;
	}

	public void setFixDate(Date fixDate) {
		this.fixDate = fixDate;
	}

	public void prt() {
		System.out.println("제목 : "+title);
		System.out.println("작성자 : "+writer);
		System.out.println("작성일 : "+dateNow(date));
		System.out.println("수정일 : "+dateNow(fixDate));
		System.out.println("내용 : "+content);
	}

	private String dateNow(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
		return sdf.format(date);
	}

	public void update(String title2, String content2, Date now) {
		this.title = title2;
		this.content = content2;
		this.fixDate = now;
	}

}
