package com.hhjx.mage.bo;

import java.util.List;

public class IndexImgListReqBo extends ResultData {

	private List<IndexScollBO> imgList;

	public List<IndexScollBO> getImgList() {
		return imgList;
	}

	public void setImgList(List<IndexScollBO> imgList) {
		this.imgList = imgList;
	}

	@Override
	public String toString() {
		return "IndexImgListReqBo [imgList=" + imgList + "]";
	}
	
}
