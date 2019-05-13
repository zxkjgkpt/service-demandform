package com.yfny.servicedemandform.future;

import com.yfny.corepojo.entity.demandform.YwyxxEntity;
import com.yfny.servicedemandform.service.YwyxxServiceImpl;
import com.yfny.utilscommon.basemvc.producer.BaseFuture;
import com.yfny.utilscommon.basemvc.producer.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 需求单业务域详情Future
 * Author auto
 * Date  2019-04-03
 */
@Component
public class YwyxxFuture extends BaseFuture<YwyxxEntity> {

    @Autowired
    private YwyxxServiceImpl ywyxxService;

    @Override
    public BaseServiceImpl<YwyxxEntity> getBaseService() {
        return this.ywyxxService;
    }
}
