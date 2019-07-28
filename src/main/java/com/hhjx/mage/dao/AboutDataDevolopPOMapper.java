package com.hhjx.mage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hhjx.mage.po.AboutDataDevolopPO;
@Mapper
public interface AboutDataDevolopPOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AboutDataDevolopPO record);

    int insertSelective(AboutDataDevolopPO record);

    AboutDataDevolopPO selectByPrimaryKey(Integer id);
    
    
    List<AboutDataDevolopPO> selectDep(String type);

    int updateByPrimaryKeySelective(AboutDataDevolopPO record);

    int updateByPrimaryKey(AboutDataDevolopPO record);
}