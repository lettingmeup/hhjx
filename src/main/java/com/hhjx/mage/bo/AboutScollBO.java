package com.hhjx.mage.bo;

public class AboutScollBO {
	private Integer id;

    private String img;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "AboutScollBO [id=" + id + ", img=" + img + "]";
	}
	
}
