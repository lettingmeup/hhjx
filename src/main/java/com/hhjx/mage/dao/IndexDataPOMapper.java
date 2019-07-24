package com.hhjx.mage.dao;

import org.apache.ibatis.annotations.Mapper;

import com.hhjx.mage.po.IndexDataPO;
@Mapper
public interface IndexDataPOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IndexDataPO record);

    int insertSelective(IndexDataPO record);

    IndexDataPO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IndexDataPO record);

    int updateByPrimaryKey(IndexDataPO record);
}