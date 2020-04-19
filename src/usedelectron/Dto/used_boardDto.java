package usedelectron.Dto;

import java.util.Date;

//중고게시판
public class used_boardDto {
	private int bd_num; 
	private String bd_ur_id;
	private String bd_title; 
	private String bd_sellbuy;
	private String bd_write; 
	private String bd_image;
	private Date bd_date;
	private int ur_num;
	private String bd_delimage;
	private int bd_readCount;
	private String bd_price;
	
	
	
	public int getBd_readCount() {
		return bd_readCount;
	}
	public String getBd_price() {
		return bd_price;
	}
	public void setBd_price(String bd_price) {
		this.bd_price = bd_price;
	}
	public void setBd_readCount(int bd_readCount) {
		this.bd_readCount = bd_readCount;
	}
	public String getBd_delimage() {
		return bd_delimage;
	}
	public void setBd_delimage(String bd_delimage) {
		this.bd_delimage = bd_delimage;
	}
	public int getBd_num() {
		return bd_num;
	}
	public void setBd_num(int bd_num) {
		this.bd_num = bd_num;
	}
	public String getBd_ur_id() {
		return bd_ur_id;
	}
	public void setBd_ur_id(String bd_ur_id) {
		this.bd_ur_id = bd_ur_id;
	}
	public String getBd_title() {
		return bd_title;
	}
	public void setBd_title(String bd_title) {
		this.bd_title = bd_title;
	}
	public String getBd_sellbuy() {
		return bd_sellbuy;
	}
	public void setBd_sellbuy(String bd_sellbuy) {
		this.bd_sellbuy = bd_sellbuy;
	}
	public String getBd_write() {
		return bd_write;
	}
	public void setBd_write(String bd_write) {
		this.bd_write = bd_write;
	}
	public String getBd_image() {
		return bd_image;
	}
	public void setBd_image(String bd_image) {
		this.bd_image = bd_image;
	}
	public Date getBd_date() {
		return bd_date;
	}
	public void setBd_date(Date bd_date) {
		this.bd_date = bd_date;
	}
	public int getUr_num() {
		return ur_num;
	}
	public void setUr_num(int ur_num) {
		this.ur_num = ur_num;
	}
	
	
	
}
