package usedelectron.Dto;

import java.sql.Date;
//공지사항 테이블
public class NoticeDto {
	private int ur_class;
	private int nt_num; //공지사항 번호
	private String nt_title; //공지글 제목
	private Date nt_date; //공지일
	private String nt_body; // 공지내용
	
	
	public int getNt_num() {
		return nt_num;
	}
	public void setNt_num(int nt_num) {
		this.nt_num = nt_num;
	}
	public int getUr_class() {
		return ur_class;
	}
	public void setUr_class(int ur_class) {
		this.ur_class = ur_class;
	}
	public String getNt_title() {
		return nt_title;
	}
	public void setNt_title(String nt_title) {
		this.nt_title = nt_title;
	}
	public Date getNt_date() {
		return nt_date;
	}
	public void setNt_date(Date nt_date) {
		this.nt_date = nt_date;
	}
	public String getNt_body() {
		return nt_body;
	}
	public void setNt_body(String nt_body) {
		this.nt_body = nt_body;
	}
}
