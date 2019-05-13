package com.yfny.servicedemandform.future;

import com.yfny.corepojo.entity.demandform.YyyxxEntity;
import com.yfny.servicedemandform.service.YyyxxServiceImpl;
import com.yfny.utilscommon.basemvc.producer.BaseFuture;
import com.yfny.utilscommon.basemvc.producer.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 需求单应用域详情Future
 * Author auto
 * Date  2019-04-03
 */
@Component
public class YyyxxFuture extends BaseFuture<YyyxxEntity> {

    @Autowired
    private YyyxxServiceImpl yyyxxService;

    @Override
    public BaseServiceImpl<YyyxxEntity> getBaseService() {
        return this.yyyxxService;
    }
}
