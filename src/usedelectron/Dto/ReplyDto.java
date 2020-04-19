package usedelectron.Dto;

import java.util.Date;

public class ReplyDto {

	private int cm_num;   //댓글 고유 번호
	private String cm_body; //댓글 내용
	private Date cm_date; //댓글
	private String cm_ur_id;  // 작성자 ID
	
	//게시글 번호 (해당 게시글 번호 댓글 출력시 사용)
	private int cm_bd_num; 
	
	private int cm_groupid;//댓글 그룹 ID
	private int cm_level;  //댓글 레밸 (대댓글시 필요)
	private int cm_orderno; //댓글 정렬 (대댓글시 필요 정렬)
	public int getCm_num() {
		return cm_num;
	}
	public void setCm_num(int cm_num) {
		this.cm_num = cm_num;
	}
	public String getCm_body() {
		return cm_body;
	}
	public void setCm_body(String cm_body) {
		this.cm_body = cm_body;
	}
	public Date getCm_date() {
		return cm_date;
	}
	public void setCm_date(Date cm_date) {
		this.cm_date = cm_date;
	}
	public String getCm_ur_id() {
		return cm_ur_id;
	}
	public void setCm_ur_id(String cm_ur_id) {
		this.cm_ur_id = cm_ur_id;
	}
	public int getCm_bd_num() {
		return cm_bd_num;
	}
	public void setCm_bd_num(int cm_bd_num) {
		this.cm_bd_num = cm_bd_num;
	}
	public int getCm_groupid() {
		return cm_groupid;
	}
	public void setCm_groupid(int cm_groupid) {
		this.cm_groupid = cm_groupid;
	}
	public int getCm_level() {
		return cm_level;
	}
	public void setCm_level(int cm_level) {
		this.cm_level = cm_level;
	}
	public int getCm_orderno() {
		return cm_orderno;
	}
	public void setCm_orderno(int cm_orderno) {
		this.cm_orderno = cm_orderno;
	}
	public ReplyDto(int cm_num, String cm_body, Date cm_date, String cm_ur_id, int cm_bd_num, int cm_groupid, int cm_level,
			int cm_orderno) {
		super();
		this.cm_num = cm_num;
		this.cm_body = cm_body;
		this.cm_date = cm_date;
		this.cm_ur_id = cm_ur_id;
		this.cm_bd_num = cm_bd_num;
		this.cm_groupid = cm_groupid;
		this.cm_level = cm_level;
		this.cm_orderno = cm_orderno;
	}
	@Override
	public String toString() {
		return "Reply [cm_num=" + cm_num + ", cm_body=" + cm_body + ", cm_date=" + cm_date + ", cm_ur_id=" + cm_ur_id
				+ ", cm_bd_num=" + cm_bd_num + ", cm_groupid=" + cm_groupid + ", cm_level=" + cm_level + ", cm_orderno="
				+ cm_orderno + "]";
	}
	
	
	public ReplyDto() {
	
	}
	
	
	
	
	
}
