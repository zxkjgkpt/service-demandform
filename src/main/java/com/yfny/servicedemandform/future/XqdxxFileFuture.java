package com.yfny.servicedemandform.future;

import com.yfny.corepojo.entity.demandform.XqdFileEntity;
import com.yfny.servicedemandform.service.XqdFileServiceImpl;
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
public class XqdxxFileFuture extends BaseFuture<XqdFileEntity> {

    @Autowired
    private XqdFileServiceImpl xqdFileService;

    @Override
    public BaseServiceImpl<XqdFileEntity> getBaseService() {
        return this.xqdFileService;
    }
}
