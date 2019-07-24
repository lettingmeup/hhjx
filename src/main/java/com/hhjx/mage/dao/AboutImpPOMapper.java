package com.hhjx.mage.dao;

import org.apache.ibatis.annotations.Mapper;

import com.hhjx.mage.po.AboutImpPO;
@Mapper
public interface AboutImpPOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AboutImpPO record);

    int insertSelective(AboutImpPO record);

    AboutImpPO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AboutImpPO record);

    int updateByPrimaryKey(AboutImpPO record);
}