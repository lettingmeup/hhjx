package com.hhjx.mage.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.hhjx.mage.bo.IndexBlockBO;
import com.hhjx.mage.bo.IndexBlockListBO;
import com.hhjx.mage.bo.ResultData;
import com.hhjx.mage.dao.IndexBlockPOMapper;
import com.hhjx.mage.po.IndexBlockPO;
import com.hhjx.mage.service.IndexBlockService;

@Service
@Transactional
public class IndexBlockServiceImpl implements IndexBlockService {
	@Autowired
	private IndexBlockPOMapper IndexBlockPODao;

	@Override
	public IndexBlockListBO getIndexBlock() {
		IndexBlockListBO result = null;
		try {
			IndexBlockBO bo = null;
			List<IndexBlockBO> boList = new ArrayList<>();
			List<IndexBlockPO> poList = IndexBlockPODao.selectaAll();
			for(IndexBlockPO po:poList) {
				bo = new IndexBlockBO();
				bo.setDanwei(po.getDanwei());
				bo.setId(po.getId());
				bo.setNum(po.getNum());
				bo.setSpec(po.getSpec());
				bo.setTitle(po.getTitle());
				boList.add(bo);
			}
			result = new IndexBlockListBO();
			result.setBlockBO(boList);
			result.setBackCode("0000");
			result.setBackDesc("操作成功");
					
		}catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			e.printStackTrace();
			result = new IndexBlockListBO();
			result.setBackCode("9999");
			result.setBackDesc("操作失败");
		}
		return result;
	}

	@Override
	public ResultData updateIndexBlock(IndexBlockBO reqBO) {
		ResultData result = null;
		IndexBlockPO po = new IndexBlockPO();
		po.setDanwei(reqBO.getDanwei());
		po.setId(reqBO.getId());
        po.setNum(reqBO.getNum());
        po.setSpec(reqBO.getSpec());
        po.setTitle(reqBO.getTitle());
		try {
			int updateResult = IndexBlockPODao.updateByPrimaryKeySelective(po);
			if(updateResult<=0) {
				result = new ResultData();
				result.setBackCode("9999");
				result.setBackDesc("操作失败");
				return result;
			}
		}catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			e.printStackTrace();
			result = new ResultData();
			result.setBackCode("9999");
			result.setBackDesc("操作失败");
			return result;
		}
		result = new ResultData();
		result.setBackCode("0000");
		result.setBackDesc("操作成功");
		return result;
	}

}
