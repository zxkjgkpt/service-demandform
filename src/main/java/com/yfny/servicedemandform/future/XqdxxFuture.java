package com.yfny.servicedemandform.future;

import com.yfny.corepojo.entity.demandform.XqdxxEntity;
import com.yfny.servicedemandform.service.XqdxxServiceImpl;
import com.yfny.utilscommon.basemvc.producer.BaseFuture;
import com.yfny.utilscommon.basemvc.producer.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 需求单详情Future
 * Author auto
 * Date  2019-04-03
 */
@Component
public class XqdxxFuture extends BaseFuture<XqdxxEntity> {

    @Autowired
    private XqdxxServiceImpl xqdxxService;

    @Override
    public BaseServiceImpl<XqdxxEntity> getBaseService() {
        return this.xqdxxService;
    }
}
