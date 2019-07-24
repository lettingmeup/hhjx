package com.hhjx.mage.dao;

import org.apache.ibatis.annotations.Mapper;

import com.hhjx.mage.po.SystemFaTbPO;
@Mapper
public interface SystemFaTbPOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SystemFaTbPO record);

    int insertSelective(SystemFaTbPO record);

    SystemFaTbPO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SystemFaTbPO record);

    int updateByPrimaryKey(SystemFaTbPO record);
}