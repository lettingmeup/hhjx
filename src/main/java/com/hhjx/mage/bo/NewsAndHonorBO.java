package com.hhjx.mage.bo;

public class NewsAndHonorBO {
	private Integer id;

    private String title;

    private Integer index;

    private String text;

    private String img;

    private String status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "NewsAndHonorBO [id=" + id + ", title=" + title + ", index=" + index + ", text=" + text + ", img=" + img
				+ ", status=" + status + "]";
	}
	
}
