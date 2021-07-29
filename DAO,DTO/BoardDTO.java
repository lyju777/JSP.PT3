package com.koreait.member;

public class BoardDTO {
	private int b_idx;
	private String b_userid;
	private String b_title;
	private String b_content;
	private String b_regdate;
	private int b_hit;
	private int b_like;
	private String b_img;
	private String b_file;
	
	public int getB_idx() {
		return b_idx;
	}
	public void setB_idx(int b_idx) {
		this.b_idx = b_idx;
	}
	public String getB_userid() {
		return b_userid;
	}
	public void setB_userid(String b_userid) {
		this.b_userid = b_userid;
	}
	public String getB_title() {
		return b_title;
	}
	public void setB_title(String b_title) {
		this.b_title = b_title;
	}
	public String getB_content() {
		return b_content;
	}
	public void setB_content(String b_content) {
		this.b_content = b_content;
	}
	public String getB_regdate() {
		return b_regdate;
	}
	public void setB_regdate(String b_regdate) {
		this.b_regdate = b_regdate;
	}
	public int getB_hit() {
		return b_hit;
	}
	public void setB_hit(int b_hit) {
		this.b_hit = b_hit;
	}
	public int getB_like() {
		return b_like;
	}
	public void setB_like(int b_like) {
		this.b_like = b_like;
	}
	public String getB_img() {
		return b_img;
	}
	public void setB_img(String b_img) {
		this.b_img = b_img;
	}
	public String getB_file() {
		return b_file;
	}
	public void setB_file(String b_file) {
		this.b_file = b_file;
	}
	@Override
	public String toString() {
		return "BoardDTO [b_idx=" + b_idx + ", b_userid=" + b_userid + ", b_title=" + b_title + ", b_content="
				+ b_content + ", b_regdate=" + b_regdate + ", b_hit=" + b_hit + ", b_like=" + b_like + ", b_img="
				+ b_img + ", b_file=" + b_file + "]";
	}
	
}