package com.hhjx.mage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hhjx.mage.po.IndexScrollPO;
@Mapper
public interface IndexScrollPOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IndexScrollPO record);

    int insertSelective(IndexScrollPO record);
    
    List<IndexScrollPO> selectAllImg();

    IndexScrollPO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IndexScrollPO record);

    int updateByPrimaryKey(IndexScrollPO record);
}