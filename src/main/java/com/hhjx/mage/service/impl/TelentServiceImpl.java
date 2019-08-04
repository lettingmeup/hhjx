package com.hhjx.mage.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.hhjx.mage.bo.ResultData;
import com.hhjx.mage.bo.TelentBO;
import com.hhjx.mage.bo.TelentListBO;
import com.hhjx.mage.dao.TalentPOMapper;
import com.hhjx.mage.po.TalentPO;
import com.hhjx.mage.service.TelentService;
@Service
@Transactional
public class TelentServiceImpl implements TelentService {
	@Autowired
	private TalentPOMapper talentPOMapper;
	
	@Override
	public ResultData updateTelent(TelentBO reqBO) {
		ResultData result = null;
		TalentPO po = new TalentPO();
		po.setDetail(reqBO.getDetail());
		po.setId(reqBO.getId());
		po.setImg(reqBO.getImg());
		po.setName(reqBO.getName());
		try {
			int upResult = talentPOMapper.updateByPrimaryKey(po);
			if(upResult<=0) {
				result = new ResultData();
				result.setBackCode("9999");
				result.setBackDesc("操作失败");
				return result;
			}
			result = new ResultData();
			result.setBackCode("0000");
			result.setBackDesc("操作成功");
		}catch (Exception e) {
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
	public TelentListBO getTelent() {
		TelentListBO result = null;
		List<TelentBO> boList =  new ArrayList<>();
		try {
			TelentBO bo = null;
			List<TalentPO> poLit = talentPOMapper.selectAll();
			for(TalentPO po:poLit) {
				bo = new TelentBO();
				bo.setDetail(po.getDetail());
				bo.setId(po.getId());
				bo.setImg(po.getImg());
				bo.setName(po.getName());
				boList.add(bo);
			}
			result = new TelentListBO();
			result.setBackCode("0000");
			result.setBackDesc("操作成功");
			result.setList(boList);
		}catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			e.printStackTrace();
			result = new TelentListBO();
			result.setBackCode("9999");
			result.setBackDesc("操作失败");
			return result;
		}
		return result;
	}

	
}
