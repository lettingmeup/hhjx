package com.hhjx.mage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hhjx.mage.po.TeamMatePO;
@Mapper
public interface TeamMatePOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TeamMatePO record);

    int insertSelective(TeamMatePO record);

    TeamMatePO selectByPrimaryKey(Integer id);
    List<TeamMatePO> selectByFaId(Integer id);

    int updateByPrimaryKeySelective(TeamMatePO record);

    int updateByPrimaryKey(TeamMatePO record);
}