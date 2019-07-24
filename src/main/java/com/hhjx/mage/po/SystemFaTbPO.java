package com.hhjx.mage.po;

public class SystemFaTbPO {
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
        this.eng = eng == null ? null : eng.trim();
    }

    public String getCha() {
        return cha;
    }

    public void setCha(String cha) {
        this.cha = cha == null ? null : cha.trim();
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }
}