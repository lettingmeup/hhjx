package com.hhjx.mage.dao;

import org.apache.ibatis.annotations.Mapper;

import com.hhjx.mage.po.IndexSystemPO;
@Mapper
public interface IndexSystemPOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IndexSystemPO record);

    int insertSelective(IndexSystemPO record);

    IndexSystemPO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IndexSystemPO record);

    int updateByPrimaryKey(IndexSystemPO record);
}