package usedelectron.Dto;

import java.util.Date;
//회원 테이블
public class MemberDto {
	private int ur_num; //회원고유번호
	private String ur_id; //회원아이디
	private String ur_passwd; //회원 비밀번호
	private String ur_name; //회원명
	private String ur_phone; //회원 휴대폰번호
	private Date ur_date; //가입일
	private int ur_ben; //정지여부 1:정지 0:정지아님
	private String ur_localip; //로컬 아이피(정지를  ip로 차단)
	private int ur_class; //유저등급 0:유저 1:관리자
	private String ur_address; //주소
	
	public MemberDto() {}
	
	public MemberDto(String ur_id, String ur_passwd) {
		super();
		this.ur_id = ur_id;
		this.ur_passwd = ur_passwd;
	}

	public MemberDto(String ur_id) {
		super();
		this.ur_id = ur_id;
	}
	
	public MemberDto(String ur_id, String ur_passwd, String ur_name, String ur_phone, String ur_localip, String ur_address) {
		super();
		this.ur_id = ur_id;
		this.ur_passwd = ur_passwd;
		this.ur_name = ur_name;
		this.ur_phone = ur_phone;
		this.ur_localip = ur_localip;
		this.ur_address = ur_address;
	}
	
	
	public MemberDto(int ur_num, String ur_id, String ur_passwd, String ur_name, String ur_phone, Date ur_date,
			int ur_ben, String ur_localip, int ur_class, String ur_address) {
		super();
		this.ur_num = ur_num;
		this.ur_id = ur_id;
		this.ur_passwd = ur_passwd;
		this.ur_name = ur_name;
		this.ur_phone = ur_phone;
		this.ur_date = ur_date;
		this.ur_ben = ur_ben;
		this.ur_localip = ur_localip;
		this.ur_class = ur_class;
		this.ur_address = ur_address;
	}

	public String getUr_address() {
		return ur_address;
	}
	public void setUr_adress(String ur_address) {
		this.ur_address = ur_address;
	}
	public int getUr_num() {
		return ur_num;
	}
	public void setUr_num(int ur_num) {
		this.ur_num = ur_num;
	}
	public String getUr_id() {
		return ur_id;
	}
	public void setUr_id(String ur_id) {
		this.ur_id = ur_id;
	}
	public String getUr_passwd() {
		return ur_passwd;
	}
	public void setUr_passwd(String ur_passwd) {
		this.ur_passwd = ur_passwd;
	}
	public String getUr_name() {
		return ur_name;
	}
	public void setUr_name(String ur_name) {
		this.ur_name = ur_name;
	}
	public String getUr_phone() {
		return ur_phone;
	}
	public void setUr_phone(String ur_phone) {
		this.ur_phone = ur_phone;
	}
	public Date getUr_date() {
		return ur_date;
	}
	public void setUr_date(Date ur_date) {
		this.ur_date = ur_date;
	}
	public int getUr_ben() {
		return ur_ben;
	}
	public void setUr_ben(int ur_ben) {
		this.ur_ben = ur_ben;
	}
	public String getUr_localip() {
		return ur_localip;
	}
	public void setUr_localip(String ur_localip) {
		this.ur_localip = ur_localip;
	}
	public int getUr_class() {
		return ur_class;
	}
	public void setUr_class(int ur_class) {
		this.ur_class = ur_class;
	}

	@Override
	public String toString() {
		return "MemberDto [ur_num=" + ur_num + ", ur_id=" + ur_id + ", ur_passwd=" + ur_passwd + ", ur_name=" + ur_name
				+ ", ur_phone=" + ur_phone + ", ur_date=" + ur_date + ", ur_ben=" + ur_ben + ", ur_localip="
				+ ur_localip + ", ur_class=" + ur_class + ", ur_adress=" + ur_address + "]";
	}
	
}
