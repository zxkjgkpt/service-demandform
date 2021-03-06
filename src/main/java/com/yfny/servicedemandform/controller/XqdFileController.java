package com.yfny.servicedemandform.controller;

import com.yfny.corepojo.entity.demandform.XqdFileEntity;
import com.yfny.servicedemandform.future.XqdxxFileFuture;
import com.yfny.utilscommon.basemvc.producer.BaseController;
import com.yfny.utilscommon.basemvc.producer.BaseFuture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 需求单附件Controller
 * Author auto
 * Date  2019-04-10
 */
@RestController
@RequestMapping(value = "/xqdFile")
public class XqdFileController extends BaseController<XqdFileEntity> {

    @Autowired
    private XqdxxFileFuture xqdxxFileFuture;

    @Override
    public BaseFuture<XqdFileEntity> getBaseFuture() {
        return this.xqdxxFileFuture;
    }

}
