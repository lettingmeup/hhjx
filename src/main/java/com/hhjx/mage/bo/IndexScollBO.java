package com.hhjx.mage.bo;

public class IndexScollBO {
	 private Integer id;

	    private String src;

	    public Integer getId() {
	        return id;
	    }

	    public void setId(Integer id) {
	        this.id = id;
	    }

	    public String getSrc() {
	        return src;
	    }

	    public void setSrc(String src) {
	        this.src = src == null ? null : src.trim();
	    }
}
