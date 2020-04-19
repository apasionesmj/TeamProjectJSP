package usedelectron.Dto;

import java.util.Date;

public class ReportDto {

private int s_r_num;
private String s_r_body;
private String s_r_ur_id;
private String s_r_image;
private int s_r_bd_num;
private int s_r_division;
private String s_r_title;
private Date s_r_date;
public int getS_r_num() {
	return s_r_num;
}
public void setS_r_num(int s_r_num) {
	this.s_r_num = s_r_num;
}
public String getS_r_body() {
	return s_r_body;
}
public void setS_r_body(String s_r_body) {
	this.s_r_body = s_r_body;
}
public String getS_r_ur_id() {
	return s_r_ur_id;
}
public void setS_r_ur_id(String s_r_ur_id) {
	this.s_r_ur_id = s_r_ur_id;
}
public String getS_r_image() {
	return s_r_image;
}
public void setS_r_image(String s_r_image) {
	this.s_r_image = s_r_image;
}
public int getS_r_bd_num() {
	return s_r_bd_num;
}
public void setS_r_bd_num(int s_r_bd_num) {
	this.s_r_bd_num = s_r_bd_num;
}
public int getS_r_division() {
	return s_r_division;
}
public void setS_r_division(int s_r_division) {
	this.s_r_division = s_r_division;
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
public ReportDto(int s_r_num, String s_r_body, String s_r_ur_id, String s_r_image, int s_r_bd_num, int s_r_division,
		String s_r_title, Date s_r_date) {
	super();
	this.s_r_num = s_r_num;
	this.s_r_body = s_r_body;
	this.s_r_ur_id = s_r_ur_id;
	this.s_r_image = s_r_image;
	this.s_r_bd_num = s_r_bd_num;
	this.s_r_division = s_r_division;
	this.s_r_title = s_r_title;
	this.s_r_date = s_r_date;
}
		
public ReportDto() {
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "ReportDto [s_r_num=" + s_r_num + ", s_r_body=" + s_r_body + ", s_r_ur_id=" + s_r_ur_id + ", s_r_image="
			+ s_r_image + ", s_r_bd_num=" + s_r_bd_num + ", s_r_division=" + s_r_division + ", s_r_title=" + s_r_title
			+ ", s_r_date=" + s_r_date + "]";
}

	
	
	
}
