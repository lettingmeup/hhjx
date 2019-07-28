package com.hhjx.mage.bo;

public class TelentBO {
	 private Integer id;

	    private String name;

	    private String detail;

	    private String img;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDetail() {
			return detail;
		}

		public void setDetail(String detail) {
			this.detail = detail;
		}

		public String getImg() {
			return img;
		}

		public void setImg(String img) {
			this.img = img;
		}

		@Override
		public String toString() {
			return "TelentBO [id=" + id + ", name=" + name + ", detail=" + detail + ", img=" + img + "]";
		}
		

}
