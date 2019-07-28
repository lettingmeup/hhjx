package com.hhjx.mage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hhjx.mage.po.TalentPO;
@Mapper
public interface TalentPOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TalentPO record);

    int insertSelective(TalentPO record);

    TalentPO selectByPrimaryKey(Integer id);
    List<TalentPO> selectAll();

    int updateByPrimaryKeySelective(TalentPO record);

    int updateByPrimaryKey(TalentPO record);
}