package com.hhjx.mage.dao;

import org.apache.ibatis.annotations.Mapper;

import com.hhjx.mage.po.ImgPO;
@Mapper
public interface ImgPOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ImgPO record);

    int insertSelective(ImgPO record);

    ImgPO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ImgPO record);

    int updateByPrimaryKey(ImgPO record);
}