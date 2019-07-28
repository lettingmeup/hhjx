package com.hhjx.mage.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.hhjx.mage.bo.NewsAndHonorBO;
import com.hhjx.mage.bo.NewsAndHonorListBO;
import com.hhjx.mage.dao.IndexNewsHonorPOMapper;
import com.hhjx.mage.po.IndexNewsHonorPO;
import com.hhjx.mage.service.NewsAndHonorService;
@Service
@Transactional
public class NewsAndHonorServiceImpl implements NewsAndHonorService {
	@Autowired
	private IndexNewsHonorPOMapper indexNewsHonorPOMapper;

	@Override
	public NewsAndHonorListBO getList(String status) {
		NewsAndHonorListBO result = null;
		try {
			List<NewsAndHonorBO> boList = new ArrayList<>();
			NewsAndHonorBO bo = null;
			List<IndexNewsHonorPO> listPO = indexNewsHonorPOMapper.selectByStatus(status);
			for(IndexNewsHonorPO po:listPO) {
				bo = new NewsAndHonorBO();
				bo.setId(po.getId());
				bo.setImg(po.getImg());
				bo.setIndex(po.getIndex());
				bo.setStatus(po.getStatus());
				bo.setTitle(po.getTitle());
				bo.setText(po.getText());
				boList.add(bo);
			}
			result = new NewsAndHonorListBO();
			result.setBackCode("0000");
			result.setBackDesc("操作成功");
			result.setNewsBO(boList);
		}catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			result = new NewsAndHonorListBO();
			e.printStackTrace();
			result.setBackCode("9999");
			result.setBackDesc("操作失败");
			return result;
		}
		
		return result;
	}

	@Override
	public NewsAndHonorListBO getNewsByTitle(String title) {
		NewsAndHonorListBO result = null;
		try {
			List<NewsAndHonorBO> boList = new ArrayList<>();
			NewsAndHonorBO bo = null;
			List<IndexNewsHonorPO> listPO = indexNewsHonorPOMapper.selectByTitle(title);
			for(IndexNewsHonorPO po:listPO) {
				bo = new NewsAndHonorBO();
				bo.setId(po.getId());
				bo.setImg(po.getImg());
				bo.setIndex(po.getIndex());
				bo.setStatus(po.getStatus());
				bo.setTitle(po.getTitle());
				bo.setText(po.getText());
				boList.add(bo);
			}
			result = new NewsAndHonorListBO();
			result.setBackCode("0000");
			result.setBackDesc("操作成功");
			result.setNewsBO(boList);
		}catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			e.printStackTrace();
			result = new NewsAndHonorListBO();
			e.printStackTrace();
			result.setBackCode("9999");
			result.setBackDesc("操作失败");
			return result;
		}
		
		return result;
	}

}
