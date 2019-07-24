package com.hhjx.mage.dao;

import org.apache.ibatis.annotations.Mapper;

import com.hhjx.mage.po.IndexBlockPO;
@Mapper
public interface IndexBlockPOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IndexBlockPO record);

    int insertSelective(IndexBlockPO record);

    IndexBlockPO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IndexBlockPO record);

    int updateByPrimaryKey(IndexBlockPO record);
}