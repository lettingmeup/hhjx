package com.hhjx.mage.bo;

public class SystemFaBO {
	private Integer id;

    private String eng;

    private String cha;

    private String img;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEng() {
		return eng;
	}

	public void setEng(String eng) {
		this.eng = eng;
	}

	public String getCha() {
		return cha;
	}

	public void setCha(String cha) {
		this.cha = cha;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "SystemFaBO [id=" + id + ", eng=" + eng + ", cha=" + cha + ", img=" + img + "]";
	}
    

}
