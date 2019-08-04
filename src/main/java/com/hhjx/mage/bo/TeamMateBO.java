package com.hhjx.mage.bo;

public class TeamMateBO {
	private Integer id;
    private String cha;
    private String img;

    private Integer sysFaId;
    

	public String getCha() {
		return cha;
	}

	public void setCha(String cha) {
		this.cha = cha;
	}

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

	public Integer getSysFaId() {
		return sysFaId;
	}

	public void setSysFaId(Integer sysFaId) {
		this.sysFaId = sysFaId;
	}

	@Override
	public String toString() {
		return "TeamMateBO [id=" + id + ", img=" + img + ", sysFaId=" + sysFaId + "]";
	}
    

}
