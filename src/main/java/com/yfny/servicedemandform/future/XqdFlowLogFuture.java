package com.yfny.servicedemandform.future;

import com.yfny.corepojo.entity.demandform.XqdFlowLogEntity;
import com.yfny.servicedemandform.service.XqdFlowLogServiceImpl;
import com.yfny.utilscommon.basemvc.producer.BaseFuture;
import com.yfny.utilscommon.basemvc.producer.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 需求单操作记录Future
 * Author auto
 * Date  2019-05-08
 */
@Component
public class XqdFlowLogFuture extends BaseFuture<XqdFlowLogEntity> {

    @Autowired
    private XqdFlowLogServiceImpl xqdFlowLogService;

    @Override
    public BaseServiceImpl<XqdFlowLogEntity> getBaseService() {
        return this.xqdFlowLogService;
    }

}
