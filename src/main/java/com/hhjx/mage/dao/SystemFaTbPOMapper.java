package com.hhjx.mage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hhjx.mage.po.SystemFaTbPO;
@Mapper
public interface SystemFaTbPOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SystemFaTbPO record);

    int insertSelective(SystemFaTbPO record);

    SystemFaTbPO selectByPrimaryKey(Integer id);
    
    List<SystemFaTbPO> selectAll();

    int updateByPrimaryKeySelective(SystemFaTbPO record);

    int updateByPrimaryKey(SystemFaTbPO record);
}