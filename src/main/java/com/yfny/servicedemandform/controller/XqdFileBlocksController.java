package com.yfny.servicedemandform.controller;

import com.yfny.corepojo.entity.demandform.XqdFileBlocksEntity;
import com.yfny.servicedemandform.future.XqdxxFileBlocksFuture;
import com.yfny.utilscommon.basemvc.producer.BaseController;
import com.yfny.utilscommon.basemvc.producer.BaseFuture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 需求单附件Controller
 * Author auto
 * Date  2019-04-16
 */
@RestController
@RequestMapping(value = "/xqdFileBlocks")
public class XqdFileBlocksController extends BaseController<XqdFileBlocksEntity> {

    @Autowired
    private XqdxxFileBlocksFuture xqdxxFileBlocksFuture;

    @Override
    public BaseFuture<XqdFileBlocksEntity> getBaseFuture() {
        return this.xqdxxFileBlocksFuture;
    }

}
