package com.hhjx.mage.bo;

public class SystemCliBO {
	private Integer id;

    private Integer faId;

    private String img;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFaId() {
		return faId;
	}

	public void setFaId(Integer faId) {
		this.faId = faId;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "SystemCliBO [id=" + id + ", faId=" + faId + ", img=" + img + "]";
	}
	

}
