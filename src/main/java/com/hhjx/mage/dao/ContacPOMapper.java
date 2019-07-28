package com.hhjx.mage.dao;

import org.apache.ibatis.annotations.Mapper;

import com.hhjx.mage.po.ContacPO;
@Mapper
public interface ContacPOMapper {

    ContacPO selectAll();

    int updateImg(ContacPO po);




}