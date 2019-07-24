package com.hhjx.mage.dao;

import org.apache.ibatis.annotations.Mapper;

import com.hhjx.mage.po.IndexScrollPO;
@Mapper
public interface IndexScrollPOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IndexScrollPO record);

    int insertSelective(IndexScrollPO record);

    IndexScrollPO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IndexScrollPO record);

    int updateByPrimaryKey(IndexScrollPO record);
}