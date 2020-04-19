package usedelectron.Dto;
import java.sql.Date;
public class commantDto {
//댓글 및 덧글 테이블
private int cm_num; //댓글 고유번호
private int cm_bd_num; //게시글번호
private String cm_ur_id; //회원아이디
private String cm_groupid;
private String cm_orderno;
private Date cm_date; //댓글 작성일
private String cm_level;
private String cm_del;
private String cm_body; //댓글 및 덧글 내용
public int getCm_num() {
	return cm_num;
}
public void setCm_num(int cm_num) {
	this.cm_num = cm_num;
}
public int getCm_bd_num() {
	return cm_bd_num;
}
public void setCm_bd_num(int cm_bd_num) {
	this.cm_bd_num = cm_bd_num;
}
public String getCm_ur_id() {
	return cm_ur_id;
}
public void setCm_ur_id(String cm_ur_id) {
	this.cm_ur_id = cm_ur_id;
}
public String getCm_groupid() {
	return cm_groupid;
}
public void setCm_groupid(String cm_groupid) {
	this.cm_groupid = cm_groupid;
}
public String getCm_orderno() {
	return cm_orderno;
}
public void setCm_orderno(String cm_orderno) {
	this.cm_orderno = cm_orderno;
}
public Date getCm_date() {
	return cm_date;
}
public void setCm_date(Date cm_date) {
	this.cm_date = cm_date;
}
public String getCm_level() {
	return cm_level;
}
public void setCm_level(String cm_level) {
	this.cm_level = cm_level;
}
public String getCm_del() {
	return cm_del;
}
public void setCm_del(String cm_del) {
	this.cm_del = cm_del;
}
public String getCm_body() {
	return cm_body;
}
public void setCm_body(String cm_body) {
	this.cm_body = cm_body;
}

	}

