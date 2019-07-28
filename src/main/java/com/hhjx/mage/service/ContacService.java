package com.hhjx.mage.service;

import com.hhjx.mage.bo.ContacBO;
import com.hhjx.mage.bo.ResultData;

public interface ContacService {

    ResultData updateImg(ContacBO bo);

    ContacBO selectAll();

}
