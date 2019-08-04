package com.hhjx.mage.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.hhjx.mage.bo.AboutDeployerBO;
import com.hhjx.mage.bo.AboutDeployerListBO;
import com.hhjx.mage.bo.AboutImpBO;
import com.hhjx.mage.bo.AboutScollBO;
import com.hhjx.mage.bo.AboutScollList;
import com.hhjx.mage.bo.ResultData;
import com.hhjx.mage.dao.AboutDataDevolopPOMapper;
import com.hhjx.mage.dao.AboutImpPOMapper;
import com.hhjx.mage.dao.AboutScrollPOMapper;
import com.hhjx.mage.po.AboutDataDevolopPO;
import com.hhjx.mage.po.AboutImpPO;
import com.hhjx.mage.po.AboutScrollPO;
import com.hhjx.mage.service.AboutService;

@Service
@Transactional
public class AboutServiceImpl implements AboutService {
	@Autowired
	private AboutImpPOMapper aboutImpPODao;
	@Autowired
	private AboutScrollPOMapper aboutScrollPODao;
	@Autowired
	private AboutDataDevolopPOMapper aboutDataDevolopPODao;
	
	@Override
	public ResultData updateDep(AboutDeployerBO reqBO) {
		ResultData result = null;
		AboutDataDevolopPO po = new AboutDataDevolopPO();
		po.setId(reqBO.getId());
		po.setImg(reqBO.getImg());
		try {
			int upResult = aboutDataDevolopPODao.updateByPrimaryKeySelective(po);
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
	public ResultData update(AboutImpBO reqBO) {
		ResultData result = null;
		AboutImpPO po = new AboutImpPO();
		po.setId(reqBO.getId());
		po.setP1Cha(reqBO.getP1Cha());
		po.setP1Eng(reqBO.getP1Eng());
		po.setP1Img(reqBO.getP1Img());
		po.setP2Cha(reqBO.getP2Cha());
		po.setP2Detail(reqBO.getP2Detail());
		po.setP2Eng(reqBO.getP2Eng());
		po.setPeImg(reqBO.getPeImg());
		try {
			int upResult = aboutImpPODao.updateByPrimaryKeySelective(po);
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
	public ResultData delete(int id) {
		ResultData result = null;
		try {
			int delResult = aboutScrollPODao.deleteByPrimaryKey(id);
			if(delResult<=0) {
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
	public ResultData insert(AboutScollBO reqBO) {
		ResultData result = null;
		AboutScrollPO po = new AboutScrollPO();
		po.setImg(reqBO.getImg());
		try {
			int addResult = aboutScrollPODao.insert(po);
			if(addResult<=0) {
				result = new ResultData();
				result.setBackCode("9999");
				result.setBackDesc("操作失败");
				return result;
			}
			result = new ResultData();
			result.setBackCode("0000");
			result.setBackDesc("操作成功");
		}catch (Exception e) {
			result = new ResultData();
			result.setBackCode("9999");
			result.setBackDesc("操作失败");
			return result;
		}
		return result;
	}
	@Override
	public AboutImpBO getAboutMeData() {
		AboutImpBO result = null;
		try {
			AboutImpPO po = aboutImpPODao.selectAll();
			result = new AboutImpBO();
			result.setId(po.getId());
			result.setP1Cha(po.getP1Cha());
			result.setP1Eng(po.getP1Eng());
			result.setP1Img(po.getP1Img());
			result.setP2Cha(po.getP2Cha());
			result.setP2Detail(po.getP2Detail());
			result.setP2Eng(po.getP2Eng());
			result.setPeImg(po.getPeImg());
			result.setBackCode("0000");
			result.setBackDesc("操作成功");
		}catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			e.printStackTrace();
			result = new AboutImpBO();
			result.setBackCode("9999");
			result.setBackDesc("操作失败");
			return result;
		}
		
		return result;
	}
	@Override
	public AboutScollList getScoll() {
		AboutScollList result = null;
		try {
			AboutScollBO bo = null;
			List<AboutScollBO> boList = new ArrayList<>();
			List<AboutScrollPO> poList = aboutScrollPODao.selectAll();
			for(AboutScrollPO po:poList) {
				bo = new AboutScollBO();
				bo.setId(po.getId());
				bo.setImg(po.getImg());
				boList.add(bo);
			}
			result = new AboutScollList();
			result.setBackCode("0000");
			result.setBackDesc("操作成功");
			result.setScollList(boList);
		}catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			e.printStackTrace();
			result = new AboutScollList();
			result.setBackCode("9999");
			result.setBackDesc("操作失败");
		}
		
		return result;
	}
	@Override
	public AboutDeployerListBO getDeplo(AboutDeployerBO reqBO) {
		AboutDeployerListBO result = null;
		try {
			AboutDeployerBO bo = null;
			List<AboutDeployerBO> boList = new ArrayList<>();
			List<AboutDataDevolopPO> poList = aboutDataDevolopPODao.selectDep(reqBO.getType());
			for(AboutDataDevolopPO po:poList){
				bo = new AboutDeployerBO();
				bo.setId(po.getId());
				bo.setImg(po.getImg());
				bo.setType(po.getType());
				boList.add(bo);
			}
                result = new AboutDeployerListBO();
                result.setBackCode("0000");
                result.setBackDesc("操作成功");
                result.setList(boList);
		}catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			e.printStackTrace();
			 result = new AboutDeployerListBO();
             result.setBackCode("9999");
             result.setBackDesc("操作失败");
             return result;
		}
		
		return result;
	}
	
}
