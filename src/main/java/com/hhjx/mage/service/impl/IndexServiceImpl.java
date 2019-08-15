package com.hhjx.mage.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.hhjx.mage.bo.IndexDataBO;
import com.hhjx.mage.bo.IndexImgListReqBo;
import com.hhjx.mage.bo.IndexScollBO;
import com.hhjx.mage.bo.ResultData;
import com.hhjx.mage.dao.IndexDataPOMapper;
import com.hhjx.mage.dao.IndexScrollPOMapper;
import com.hhjx.mage.po.IndexDataPO;
import com.hhjx.mage.po.IndexScrollPO;
import com.hhjx.mage.service.IndexService;

@Service
@Transactional
public class IndexServiceImpl implements IndexService {
	//轮播图
	@Autowired
	private IndexScrollPOMapper indexScrollDao;
	//主数据
	@Autowired
	private IndexDataPOMapper indexDataPOMapper;
	
	@Override
	public IndexDataBO getIndexData() {
		IndexDataBO result = new IndexDataBO();
		try {
		IndexDataPO po = indexDataPOMapper.getIndexData();
		result.setId(po.getId());
		result.setP2AboutCha(po.getP2AboutCha());
		result.setP2AboutDetail(po.getP2AboutDetail());
		result.setP2AboutEng(po.getP2AboutEng());
		result.setP3NewsCha(po.getP3NewsCha());
		result.setP3NewsEng(po.getP3NewsEng());
		result.setP4TeamCha(po.getP4TeamCha());
		result.setP4TeamDetail(po.getP4TeamDetail());
		result.setP4TeamEng(po.getP4TeamEng());
		result.setP6Cha(po.getP6Cha());
		result.setP6Detail(po.getP6Detail());
		result.setP6Eng(po.getP6Eng());
		result.setP6Eng2(po.getP6Eng2());
		result.setP3NewsBackImg(po.getP3NewsBackImg());
		result.setP2AboutSideImg(po.getP2AboutSideImg());
		result.setP4TeamImg(po.getP4TeamImg());
		result.setP6Img(po.getP6Img());
		result.setBackCode("0000");
		result.setBackDesc("操作成功");
		}catch(Exception e) {
			e.printStackTrace();
			result.setBackCode("9999");
			result.setBackDesc("操作失败");
			return result;
		}
		return result;
	}
	
	@Override
	public ResultData update(IndexDataBO reqBO) {
		ResultData result = null;
		IndexDataPO po = new IndexDataPO();
		po.setId(reqBO.getId());
		po.setP2AboutCha(reqBO.getP2AboutCha());
		po.setP2AboutDetail(reqBO.getP2AboutDetail());
		po.setP2AboutEng(reqBO.getP2AboutEng());
	    po.setP3NewsCha(reqBO.getP3NewsCha());
	    po.setP3NewsEng(reqBO.getP3NewsEng());
	    po.setP4TeamCha(reqBO.getP4TeamCha());
	    po.setP4TeamDetail(reqBO.getP4TeamDetail());
	    po.setP4TeamEng(reqBO.getP4TeamEng());
	    po.setP6Cha(reqBO.getP6Cha());
	    po.setP6Detail(reqBO.getP6Detail());
	    po.setP2AboutSideImg(reqBO.getP2AboutSideImg());
	    po.setP3NewsBackImg(reqBO.getP3NewsBackImg());
	    po.setP4TeamImg(reqBO.getP4TeamImg());
	    po.setP6Img(reqBO.getP6Img());
	    po.setP6Eng(reqBO.getP6Eng());
	    po.setP6Eng2(reqBO.getP6Eng2());
	    po.setP2AboutSideImg(reqBO.getP2AboutSideImg());
	    po.setP3NewsBackImg(reqBO.getP3NewsBackImg());
	    po.setP6Img(reqBO.getP6Img());
	    try {
		int updateResult =  indexDataPOMapper.updateByPrimaryKeySelective(po);
		if(updateResult>0) {
			result = new ResultData();
			result.setBackCode("0000");
			result.setBackDesc("操作成功");
		}else {
			result = new ResultData();
			result.setBackCode("9999");
			result.setBackDesc("操作失败");
		}
	    }catch(Exception e) {
	    	result = new ResultData();
	    	TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			e.printStackTrace();
			result.setBackCode("9999");
			result.setBackDesc("操作失败");
			return result;
	    }
		return result;
	}

	@Override
	public IndexImgListReqBo getIndexImg() {
		IndexImgListReqBo result = null;
		IndexScollBO bo = null;
		List<IndexScollBO> boList = new ArrayList<>();
		try {
		List<IndexScrollPO> poList = indexScrollDao.selectAllImg();
		for(IndexScrollPO po:poList) {
			bo = new IndexScollBO();
			bo.setId(po.getId());
			bo.setSrc(po.getSrc());
			boList.add(bo);
		}
		result = new IndexImgListReqBo();
		result.setImgList(boList);
		result.setBackCode("0000");
		result.setBackDesc("操作成功");
		}catch(Exception e) {
			result = new IndexImgListReqBo();
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			e.printStackTrace();
			result.setBackCode("9999");
			result.setBackDesc("操作失败");
			return result;
		}
		return result;
	}

	@Override
	public ResultData addImg(IndexScollBO reqBO) {
		ResultData result = null;
		IndexScrollPO po = new IndexScrollPO();
		po.setId(reqBO.getId());
		po.setSrc(reqBO.getSrc());
		try {
		int addImgResult = indexScrollDao.insert(po);
		if(addImgResult>0) {
			result = new ResultData();
			result.setBackCode("0000");
			result.setBackDesc("操作成功");
		}else {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			result = new ResultData();
			result.setBackCode("9999");
			result.setBackDesc("操作失败");
		}
		}catch(Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			e.printStackTrace();
			result = new ResultData();
			result.setBackCode("9999");
			result.setBackDesc("操作失败");
			return result;
		}
		return result;
	}

	@Override
	public ResultData deldte(IndexScollBO reqBO) {
		ResultData result = null;
		try {
		int delResult = indexScrollDao.deleteByPrimaryKey(reqBO.getId());
		if(delResult>0) {
			result = new ResultData();
			result.setBackCode("0000");
			result.setBackDesc("操作成功");
		}else {
			result = new ResultData();
			result.setBackCode("9999");
			result.setBackDesc("操作失败");
		}
		}catch(Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			e.printStackTrace();
			result = new ResultData();
			result.setBackCode("9999");
			result.setBackDesc("操作失败");
			return result;
		}
		return result;
	}

	

	

}
