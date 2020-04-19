package usedelectron.Dto;

import java.util.Date;

public class savelist_reportDto {
	private int s_r_num; //찜목록 및 신고게시글 번호
	private int bd_num; //중고게시판 게시글번호
	private String ur_id; //회원 아이디
	private String s_r_title; //게시판 제목
	private Date s_r_date; //게시글 작성일
	private String s_r_body; //게시글 내용
	private String s_r_image; //게시판 이미지
	private int s_r_division; //찜목록 및 신고게시판 구분
	
	public int getS_r_num() {
		return s_r_num;
	}
	public void setS_r_num(int s_r_num) {
		this.s_r_num = s_r_num;
	}
	public int getBd_num() {
		return bd_num;
	}
	public void setBd_num(int bd_num) {
		this.bd_num = bd_num;
	}
	public String getUr_id() {
		return ur_id;
	}
	public void setUr_id(String ur_id) {
		this.ur_id = ur_id;
	}
	public String getS_r_title() {
		return s_r_title;
	}
	public void setS_r_title(String s_r_title) {
		this.s_r_title = s_r_title;
	}
	public Date getS_r_date() {
		return s_r_date;
	}
	public void setS_r_date(Date s_r_date) {
		this.s_r_date = s_r_date;
	}
	public String getS_r_body() {
		return s_r_body;
	}
	public void setS_r_body(String s_r_body) {
		this.s_r_body = s_r_body;
	}
	public String getS_r_image() {
		return s_r_image;
	}
	public void setS_r_image(String s_r_image) {
		this.s_r_image = s_r_image;
	}
	public int getS_r_division() {
		return s_r_division;
	}
	public void setS_r_division(int s_r_division) {
		this.s_r_division = s_r_division;
	}
}
