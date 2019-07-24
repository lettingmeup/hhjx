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
	private IndexDataPOMapper indexDataPOMapper;
	
	
	@Override
	public ResultData update(IndexDataBO reqBO) {
		IndexDataPO po = new IndexDataPO();
		po.setId(reqBO.getId());
		po.setP2AboutCha(reqBO.getP2AboutCha());
		int updateResult =  indexDataPOMapper.updateByPrimaryKeySelective(po);
		return null;
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
