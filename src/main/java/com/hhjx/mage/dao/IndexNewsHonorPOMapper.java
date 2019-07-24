package com.hhjx.mage.dao;

import org.apache.ibatis.annotations.Mapper;

import com.hhjx.mage.po.IndexNewsHonorPO;
@Mapper
public interface IndexNewsHonorPOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IndexNewsHonorPO record);

    int insertSelective(IndexNewsHonorPO record);

    IndexNewsHonorPO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IndexNewsHonorPO record);

    int updateByPrimaryKey(IndexNewsHonorPO record);
}