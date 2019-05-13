package com.yfny.servicedemandform.composite;

import com.yfny.corepojo.entity.demandform.XqdFlowLogEntity;
import com.yfny.servicedemandform.mapper.XqdFlowLogMapper;
import com.yfny.utilscommon.basemvc.producer.BaseComponent;
import com.yfny.utilscommon.basemvc.producer.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by jisongZhou on 2019/5/9.
 **/
@Component
public class XqdFlowLogComposite extends BaseComponent<XqdFlowLogEntity> {

    @Autowired
    private XqdFlowLogMapper xqdFlowLogMapper;

    public static XqdFlowLogComposite xqdFlowLogComposite;

    @PostConstruct
    public void init() {
        xqdFlowLogComposite = this;
    }

    @Override
    public BaseMapper<XqdFlowLogEntity> getBaseMapper() {
        return xqdFlowLogComposite.xqdFlowLogMapper;
    }

}
