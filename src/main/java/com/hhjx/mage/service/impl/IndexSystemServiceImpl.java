package com.hhjx.mage.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.hhjx.mage.bo.IndexSystemBO;
import com.hhjx.mage.bo.IndexSystemListBO;
import com.hhjx.mage.bo.ResultData;
import com.hhjx.mage.dao.IndexSystemPOMapper;
import com.hhjx.mage.po.IndexSystemPO;
import com.hhjx.mage.service.IndexSystemService;

@Service
@Transactional
public class IndexSystemServiceImpl implements IndexSystemService {

	@Autowired
	private IndexSystemPOMapper IndexSystemPODao;
	@Override
	public IndexSystemListBO getIndexSystem() {
		IndexSystemListBO result = null;
		List<IndexSystemBO> boList = new ArrayList<>();
		try {
			IndexSystemBO bo = null;
			List<IndexSystemPO> poList = IndexSystemPODao.selectAll();
			for(IndexSystemPO po:poList) {
				bo = new IndexSystemBO();
				bo.setBackImg(po.getBackImg());
				bo.setIcon(po.getIcon());
				bo.setId(po.getId());
				bo.setStar(po.getStar());
				bo.setTitle(po.getTitle());
				boList.add(bo);
			}
			
		}catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			e.printStackTrace();
			result = new IndexSystemListBO();
			result.setBackCode("9999");
			result.setBackDesc("操作失败");
			return result;
		}
		result = new IndexSystemListBO();
		result.setBackCode("0000");
		result.setBackDesc("操作成功");
		result.setSysBO(boList);
		return result;
	}

	@Override
	public ResultData updateIndexSystem(IndexSystemBO reqBO) {
		ResultData result = null;
		IndexSystemPO po = new IndexSystemPO();
		po.setBackImg(reqBO.getBackImg());
		po.setIcon(reqBO.getIcon());
		po.setId(reqBO.getId());
		po.setStar(reqBO.getStar());
		po.setTitle(reqBO.getTitle());
		try {
			int upResult = IndexSystemPODao.updateByPrimaryKeySelective(po);
			if(upResult<=0) {
				result = new ResultData();
				result.setBackCode("9999");
				result.setBackDesc("操作失败");
				return result;
			}
		}catch (Exception e) {
			result = new ResultData();
			result.setBackCode("9999");
			result.setBackDesc("操作失败");
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			e.printStackTrace();
			return result;
		}
		result = new ResultData();
		result.setBackCode("0000");
		result.setBackDesc("操作成功");
		return result;
	}

}
