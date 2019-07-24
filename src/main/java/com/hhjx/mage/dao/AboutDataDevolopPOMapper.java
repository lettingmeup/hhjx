package com.hhjx.mage.dao;

import org.apache.ibatis.annotations.Mapper;

import com.hhjx.mage.po.AboutDataDevolopPO;
@Mapper
public interface AboutDataDevolopPOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AboutDataDevolopPO record);

    int insertSelective(AboutDataDevolopPO record);

    AboutDataDevolopPO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AboutDataDevolopPO record);

    int updateByPrimaryKey(AboutDataDevolopPO record);
}