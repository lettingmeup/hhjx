package com.hhjx.mage.bo;

public class IndexSystemBO {
	   private Integer id;

	    private String icon;

	    private String title;

	    private String star;

	    private String backImg;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getIcon() {
			return icon;
		}

		public void setIcon(String icon) {
			this.icon = icon;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getStar() {
			return star;
		}

		public void setStar(String star) {
			this.star = star;
		}

		public String getBackImg() {
			return backImg;
		}

		public void setBackImg(String backImg) {
			this.backImg = backImg;
		}

		@Override
		public String toString() {
			return "IndexSystemBO [id=" + id + ", icon=" + icon + ", title=" + title + ", star=" + star + ", backImg="
					+ backImg + "]";
		}

}
