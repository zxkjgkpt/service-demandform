package com.yfny.servicedemandform.service;

import com.yfny.corepojo.entity.demandform.XqdFlowLogEntity;
import com.yfny.servicedemandform.mapper.XqdFlowLogMapper;
import com.yfny.utilscommon.basemvc.producer.BaseMapper;
import com.yfny.utilscommon.basemvc.producer.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 需求单操作记录ServiceImpl
 * Author auto
 * Date  2019-05-08
 */
@Service
public class XqdFlowLogServiceImpl extends BaseServiceImpl<XqdFlowLogEntity> {

    @Autowired
    private XqdFlowLogMapper xqdFlowLogMapper;

    @Override
    public BaseMapper<XqdFlowLogEntity> getBaseMapper() {
        return this.xqdFlowLogMapper;
    }

}
