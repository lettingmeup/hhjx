package com.hhjx.mage.po;

public class TeamMatePO {
    private Integer id;

    private String img;

    private Integer sysFaId;

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
        this.img = img == null ? null : img.trim();
    }

    public Integer getSysFaId() {
        return sysFaId;
    }

    public void setSysFaId(Integer sysFaId) {
        this.sysFaId = sysFaId;
    }
}