package com.hhjx.mage.dao;

import org.apache.ibatis.annotations.Mapper;

import com.hhjx.mage.po.TeamMatePO;
@Mapper
public interface TeamMatePOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TeamMatePO record);

    int insertSelective(TeamMatePO record);

    TeamMatePO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TeamMatePO record);

    int updateByPrimaryKey(TeamMatePO record);
}