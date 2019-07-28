package com.hhjx.mage.bo;

public class IndexBlockBO {
	private Integer id;

    private String title;

    private Integer num;

    private String spec;

    private String danwei;

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

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	public String getDanwei() {
		return danwei;
	}

	public void setDanwei(String danwei) {
		this.danwei = danwei;
	}

	@Override
	public String toString() {
		return "IndexBlockBO [id=" + id + ", title=" + title + ", num=" + num + ", spec=" + spec + ", danwei=" + danwei
				+ "]";
	}
    
}
