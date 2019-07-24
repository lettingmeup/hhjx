package com.hhjx.mage.dao;

import org.apache.ibatis.annotations.Mapper;

import com.hhjx.mage.po.TalentPO;
@Mapper
public interface TalentPOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TalentPO record);

    int insertSelective(TalentPO record);

    TalentPO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TalentPO record);

    int updateByPrimaryKey(TalentPO record);
}