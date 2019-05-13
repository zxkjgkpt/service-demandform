package com.yfny.servicedemandform.future;

import com.yfny.corepojo.entity.demandform.XqdFileBlocksEntity;
import com.yfny.servicedemandform.service.XqdFileBlocksServiceImpl;
import com.yfny.utilscommon.basemvc.producer.BaseFuture;
import com.yfny.utilscommon.basemvc.producer.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 需求单附件Future
 * Author auto
 * Date  2019-04-03
 */
@Component
public class XqdxxFileBlocksFuture extends BaseFuture<XqdFileBlocksEntity> {

    @Autowired
    private XqdFileBlocksServiceImpl xqdFileBlocksService;

    @Override
    public BaseServiceImpl<XqdFileBlocksEntity> getBaseService() {
        return this.xqdFileBlocksService;
    }


}
