package com.yfny.servicedemandform.controller;

import com.yfny.corepojo.entity.demandform.XqdxxEntity;
import com.yfny.servicedemandform.service.BaseServiceImpl;
import com.yfny.servicedemandform.service.XqdxxServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 需求单详情Controller
 * Author auto
 * Date  2019-03-29
 */
@RestController
@RequestMapping(value = "/xqdxx")
public class XqdxxController extends BaseController<XqdxxEntity> {

    @Autowired
    private XqdxxServiceImpl xqdxxService;

    @Override
    public BaseServiceImpl<XqdxxEntity> getBaseService() {
        return this.xqdxxService;
    }

}
