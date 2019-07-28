package com.hhjx.mage.service;

import com.hhjx.mage.bo.IndexDataBO;
import com.hhjx.mage.bo.IndexImgListReqBo;
import com.hhjx.mage.bo.IndexScollBO;
import com.hhjx.mage.bo.ResultData;

public interface IndexService {
	//轮播图
  public IndexImgListReqBo getIndexImg();
  public ResultData addImg(IndexScollBO reqBO);
  public ResultData deldte(IndexScollBO reqBO);
  //主数据
  public ResultData update(IndexDataBO reqBO);
  public IndexDataBO getIndexData();
}
