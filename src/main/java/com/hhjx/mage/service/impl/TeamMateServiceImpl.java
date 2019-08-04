package com.hhjx.mage.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.hhjx.mage.bo.ImgBO;
import com.hhjx.mage.bo.ResultData;
import com.hhjx.mage.bo.TeamMateBO;
import com.hhjx.mage.bo.TeamMateListBO;
import com.hhjx.mage.dao.ImgPOMapper;
import com.hhjx.mage.dao.SystemFaTbPOMapper;
import com.hhjx.mage.dao.TeamMatePOMapper;
import com.hhjx.mage.po.ImgPO;
import com.hhjx.mage.po.TeamMatePO;
import com.hhjx.mage.service.TeamMateService;
@Service
@Transactional
public class TeamMateServiceImpl implements TeamMateService {
	@Autowired
	private TeamMatePOMapper teamMatePOMapper;
	@Autowired
	private ImgPOMapper imgPOMapper;
	@Autowired
	private SystemFaTbPOMapper systemFaTbPOMapper;
	
	
	@Override
	public ResultData updateImg(ImgBO reqBO) {
		ResultData result = null;
		ImgPO po = new ImgPO();
		po.setId(reqBO.getId());
		po.setImg(reqBO.getImg());
		try {
			int a = imgPOMapper.updateByPrimaryKey(po);
			if(a<=0) {
				result = new TeamMateListBO();
				result.setBackCode("9999");
				result.setBackDesc("操作失败");
				return result;
			}
			result = new TeamMateListBO();
			result.setBackCode("0000");
			result.setBackDesc("操作成功");
			
		}catch (Exception e) {
			result = new TeamMateListBO();
			result.setBackCode("9999");
			result.setBackDesc("操作失败");
			return result;
		}
		return result;
	}


	@Override
	public TeamMateListBO getAllMate() {
		TeamMateListBO result = null;
		TeamMateBO bo = null;
		try {
			List<TeamMatePO> poList = teamMatePOMapper.selectAll();
			List<TeamMateBO> boList = new ArrayList<>();
			for(TeamMatePO po:poList) {
				bo = new TeamMateBO();
				bo.setId(po.getId());
				bo.setImg(po.getImg());
				bo.setSysFaId(po.getSysFaId());
				String cha = systemFaTbPOMapper.getChaByFaId(po.getSysFaId());
				bo.setCha(cha);
				boList.add(bo);
			}
			result = new TeamMateListBO();
			result.setBackCode("0000");
			result.setBackDesc("操作成功");
			result.setList(boList);
		}catch (Exception e) {
			result = new TeamMateListBO();
			result.setBackCode("9999");
			result.setBackDesc("操作失败");
			return result;
		}
		
		return result;
	}
	
	@Override
	public ResultData delMate(TeamMateBO reqBO) {
		ResultData result = null;
		try {
			int delResult = teamMatePOMapper.deleteByPrimaryKey(reqBO.getId());
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
	public ResultData addMate(TeamMateBO reqBO) {
		ResultData result = null;
		TeamMatePO po = new TeamMatePO();
		po.setImg(reqBO.getImg());
		po.setSysFaId(reqBO.getSysFaId());
		try {
			int addResult = teamMatePOMapper.insertSelective(po);
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
	public TeamMateListBO getMate(TeamMateBO reqBO) {
		TeamMateListBO result = null;
		try {
			List<TeamMateBO> boList = new ArrayList<>();
			TeamMateBO bo = null;
			List<TeamMatePO> poList = teamMatePOMapper.selectByFaId(reqBO.getSysFaId());
			for(TeamMatePO po:poList) {
				bo = new TeamMateBO();
				bo.setId(po.getId());
				bo.setImg(po.getImg());
				bo.setSysFaId(po.getSysFaId());
				boList.add(bo);
			}
			result = new TeamMateListBO();
			result.setBackCode("0000");
			result.setBackDesc("操作成功");
			result.setList(boList);
		}catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			e.printStackTrace();
			result = new TeamMateListBO();
			result.setBackCode("9999");
			result.setBackDesc("操作失败");
			return result;
		}
		
		return result;
	}

	@Override
	public ImgBO getTeamImg() {
		ImgBO bo = null;
		try {
			ImgPO po = imgPOMapper.selectByPrimaryKey();
			bo = new ImgBO();
			bo.setBackCode("0000");
			bo.setBackDesc("操作成功");
			bo.setId(po.getId());
			bo.setImg(po.getImg());
		}catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			e.printStackTrace();
			bo = new ImgBO();
			bo.setBackCode("0000");
			bo.setBackDesc("操作成功");
			return bo;
		}
		
		return bo;
	}

	
}
