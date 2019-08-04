package com.hhjx.mage.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.hhjx.mage.bo.ResultData;
import com.hhjx.mage.bo.SystemCliBO;
import com.hhjx.mage.bo.SystemCliListBO;
import com.hhjx.mage.bo.SystemFaBO;
import com.hhjx.mage.bo.SystemFaListBO;
import com.hhjx.mage.dao.SystemCliTbPOMapper;
import com.hhjx.mage.dao.SystemFaTbPOMapper;
import com.hhjx.mage.po.SystemCliTbPO;
import com.hhjx.mage.po.SystemFaTbPO;
import com.hhjx.mage.service.SystemFaService;
@Service
@Transactional
public class SystemFaServiceImpl implements SystemFaService {
	@Autowired
	private SystemFaTbPOMapper  systemFaTbPOMapper;
	@Autowired
	private SystemCliTbPOMapper systemCliTbPOMapper;

	
	@Override
	public String getNameByFaId(int id) {
		String cha = systemFaTbPOMapper.getChaByFaId(id);
		return cha;
	}
	
	@Override
	public ResultData deleteCli(int id) {
		ResultData result = null;
		try {
			int delResult = systemCliTbPOMapper.deleteByPrimaryKey(id);
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
	public ResultData addCli(SystemCliBO reqBO) {
		ResultData result = null;
		SystemCliTbPO po = new SystemCliTbPO();
		po.setFaId(reqBO.getFaId());
		po.setImg(reqBO.getImg());
		try {
			int addResult = systemCliTbPOMapper.insertSelective(po);
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
	public ResultData insertFaData(SystemFaBO reqBO) {
		ResultData result = null;
		SystemFaTbPO po = new SystemFaTbPO();
		po.setCha(reqBO.getCha());
		po.setEng(reqBO.getEng());
		po.setImg(reqBO.getImg());
		try {
			int inResult = systemFaTbPOMapper.insert(po);
			if(inResult<=0) {
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
	public ResultData deleteFaById(int id) {
		ResultData result = null;
		try {
			int faResult = systemFaTbPOMapper.deleteByPrimaryKey(id);
			if(faResult<=0) {
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
	public SystemFaListBO getFaData() {
		SystemFaListBO result = null;
		List<SystemFaBO> boList = new ArrayList<>();
		try {
			List<SystemFaTbPO> poList = systemFaTbPOMapper.selectAll();
			SystemFaBO bo = null;
			for(SystemFaTbPO po:poList){
				bo = new SystemFaBO();
				bo.setCha(po.getCha());
				bo.setEng(po.getEng());
				bo.setId(po.getId());
				bo.setImg(po.getImg());
				boList.add(bo);
			}
			result = new SystemFaListBO();
			result.setBackCode("0000");
			result.setBackDesc("操作成功");
			result.setListBo(boList);
		}catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			e.printStackTrace();
			result = new SystemFaListBO();
			result.setBackCode("9999");
			result.setBackDesc("操作失败");
			return result;
		}
		
		return result;
	}

	@Override
	public SystemCliListBO getCliData(SystemCliBO reqBO) {
		SystemCliListBO result = null;
		try {
			List<SystemCliBO> boList = new ArrayList<>();
			SystemCliBO bo = null;
			List<SystemCliTbPO> poList = systemCliTbPOMapper.selectByFaId(reqBO.getFaId());
			for(SystemCliTbPO po:poList) {
				bo = new SystemCliBO();
				bo.setFaId(po.getFaId());
				bo.setId(po.getId());
				bo.setImg(po.getImg());
				boList.add(bo);
			}
			result = new SystemCliListBO();
			result.setBackCode("0000");
			result.setBackDesc("操作成功");
			result.setList(boList);
		}catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			e.printStackTrace();
			result = new SystemCliListBO();
			result.setBackCode("9999");
			result.setBackDesc("操作失败");
		}
		
		return result;
	}

	


}
