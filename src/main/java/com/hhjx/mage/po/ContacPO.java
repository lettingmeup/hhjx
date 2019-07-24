package com.hhjx.mage.po;

public class ContacPO {
    private Integer id;

    private String qq;

    private String wechat;
    
    private String background;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getWechat() {
		return wechat;
	}

	public void setWechat(String wechat) {
		this.wechat = wechat;
	}

	public String getBackground() {
		return background;
	}

	public void setBackground(String background) {
		this.background = background;
	}

	@Override
	public String toString() {
		return "ContacPO [id=" + id + ", qq=" + qq + ", wechat=" + wechat + ", background=" + background + "]";
	}
    

    
}