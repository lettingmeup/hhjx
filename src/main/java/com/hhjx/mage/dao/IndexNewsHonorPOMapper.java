package com.hhjx.mage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hhjx.mage.po.IndexNewsHonorPO;
@Mapper
public interface IndexNewsHonorPOMapper {
    int deleteByPrimaryKey(String title);

    int insert(IndexNewsHonorPO record);
    
    int insertList(List<IndexNewsHonorPO> poList);

    int insertSelective(IndexNewsHonorPO record);

    IndexNewsHonorPO selectByPrimaryKey(Integer id);
    
    List<IndexNewsHonorPO> selectByStatus(String status);
    
    List<IndexNewsHonorPO> selectByTitle(String title);

    int updateByPrimaryKeySelective(IndexNewsHonorPO record);

    int updateByPrimaryKey(IndexNewsHonorPO record);
}