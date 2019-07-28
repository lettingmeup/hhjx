package com.hhjx.mage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hhjx.mage.po.AboutScrollPO;
@Mapper
public interface AboutScrollPOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AboutScrollPO record);

    int insertSelective(AboutScrollPO record);

    AboutScrollPO selectByPrimaryKey(Integer id);
    List<AboutScrollPO> selectAll();
    int updateByPrimaryKeySelective(AboutScrollPO record);

    int updateByPrimaryKey(AboutScrollPO record);
}