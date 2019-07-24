package com.hhjx.mage.dao;

import org.apache.ibatis.annotations.Mapper;

import com.hhjx.mage.po.SystemCliTbPO;
@Mapper
public interface SystemCliTbPOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SystemCliTbPO record);

    int insertSelective(SystemCliTbPO record);

    SystemCliTbPO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SystemCliTbPO record);

    int updateByPrimaryKey(SystemCliTbPO record);
}