package com.hhjx.mage.service.impl;

import com.hhjx.mage.bo.ContacBO;
import com.hhjx.mage.bo.ResultData;
import com.hhjx.mage.dao.ContacPOMapper;
import com.hhjx.mage.po.ContacPO;
import com.hhjx.mage.service.ContacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ContacServiceImpl implements ContacService {

    @Autowired
    private ContacPOMapper contacPODao;

    @Override
    public ResultData updateImg(ContacBO bo) {
        ResultData result = null;
        ContacPO po = null;
        try {
            po = new ContacPO();
            po.setId(1);
            po.setQq(bo.getQq());
            po.setWechat(bo.getWechat());
            po.setBackground(bo.getBackground());
            int count =contacPODao.updateImg(po);
            if (count >0){
                result = new ResultData();
                result.setBackCode("0000");
                result.setBackDesc("操作成功");
            }else {
                result = new ResultData();
                result.setBackCode("9999");
                result.setBackDesc("操作失败");
                return result;
            }
        }catch (Exception e){
            e.printStackTrace();
            result = new ResultData();
            result.setBackCode("9999");
            result.setBackDesc("操作失败");
            return result;
        }
        return result;
    }

    @Override
    public ContacBO selectAll() {
        ContacBO bo = null;
        try {
            ContacPO po = contacPODao.selectAll();
            bo = new ContacBO();
            bo.setId(po.getId());
            bo.setQq(po.getQq());
            bo.setWechat(po.getWechat());
            bo.setBackground(po.getBackground());
            bo.setBackCode("0000");
            bo.setBackDesc("操作成功");
        }catch (Exception e){
            e.printStackTrace();
            bo = new ContacBO();
            bo.setBackCode("9999");
            bo.setBackDesc("操作失败");
            return bo;
        }
        return bo;
    }
}
