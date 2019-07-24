package com.hhjx.mage.po;

public class AboutImpPO {
    private Integer id;

    private String p1Eng;

    private String p1Cha;

    private String p1Img;

    private String p2Eng;

    private String p2Cha;

    private String p2Detail;

    private String peImg;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getP1Eng() {
        return p1Eng;
    }

    public void setP1Eng(String p1Eng) {
        this.p1Eng = p1Eng == null ? null : p1Eng.trim();
    }

    public String getP1Cha() {
        return p1Cha;
    }

    public void setP1Cha(String p1Cha) {
        this.p1Cha = p1Cha == null ? null : p1Cha.trim();
    }

    public String getP1Img() {
        return p1Img;
    }

    public void setP1Img(String p1Img) {
        this.p1Img = p1Img == null ? null : p1Img.trim();
    }

    public String getP2Eng() {
        return p2Eng;
    }

    public void setP2Eng(String p2Eng) {
        this.p2Eng = p2Eng == null ? null : p2Eng.trim();
    }

    public String getP2Cha() {
        return p2Cha;
    }

    public void setP2Cha(String p2Cha) {
        this.p2Cha = p2Cha == null ? null : p2Cha.trim();
    }

    public String getP2Detail() {
        return p2Detail;
    }

    public void setP2Detail(String p2Detail) {
        this.p2Detail = p2Detail == null ? null : p2Detail.trim();
    }

    public String getPeImg() {
        return peImg;
    }

    public void setPeImg(String peImg) {
        this.peImg = peImg == null ? null : peImg.trim();
    }
}