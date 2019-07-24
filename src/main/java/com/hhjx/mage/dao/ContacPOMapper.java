package com.hhjx.mage.dao;

import org.apache.ibatis.annotations.Mapper;

import com.hhjx.mage.po.ContacPO;
@Mapper
public interface ContacPOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ContacPO record);

    int insertSelective(ContacPO record);

    ContacPO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ContacPO record);

    int updateByPrimaryKey(ContacPO record);
}