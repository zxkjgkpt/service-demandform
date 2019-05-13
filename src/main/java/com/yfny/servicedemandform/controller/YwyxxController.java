package com.yfny.servicedemandform.controller;

import com.yfny.corepojo.entity.demandform.YwyxxEntity;
import com.yfny.servicedemandform.future.YwyxxFuture;
import com.yfny.utilscommon.basemvc.producer.BaseController;
import com.yfny.utilscommon.basemvc.producer.BaseFuture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 需求单业务域详情Controller
 * Author auto
 * Date  2019-04-09
 */
@RestController
@RequestMapping(value = "/ywyxx")
public class YwyxxController extends BaseController<YwyxxEntity> {

    @Autowired
    private YwyxxFuture ywyxxFuture;

    @Override
    public BaseFuture<YwyxxEntity> getBaseFuture() {
        return this.ywyxxFuture;
    }

}
