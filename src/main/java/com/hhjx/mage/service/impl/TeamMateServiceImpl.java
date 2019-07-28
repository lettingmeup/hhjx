package com.hhjx.mage.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.hhjx.mage.bo.ImgBO;
import com.hhjx.mage.bo.TeamMateBO;
import com.hhjx.mage.bo.TeamMateListBO;
import com.hhjx.mage.dao.ImgPOMapper;
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
