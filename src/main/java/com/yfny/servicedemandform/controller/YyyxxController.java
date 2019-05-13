package com.yfny.servicedemandform.controller;

import com.yfny.corepojo.entity.demandform.YyyxxEntity;
import com.yfny.servicedemandform.future.YyyxxFuture;
import com.yfny.utilscommon.basemvc.producer.BaseController;
import com.yfny.utilscommon.basemvc.producer.BaseFuture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 需求单应用域详情Controller
 * Author auto
 * Date  2019-04-09
 */
@RestController
@RequestMapping(value = "/yyyxx")
public class YyyxxController extends BaseController<YyyxxEntity> {

    @Autowired
    private YyyxxFuture yyyxxFuture;

    @Override
    public BaseFuture<YyyxxEntity> getBaseFuture() {
        return this.yyyxxFuture;
    }

}
