package com.yfny.servicedemandform.composite;

import com.yfny.corepojo.entity.demandform.XqdxxEntity;
import com.yfny.servicedemandform.mapper.XqdxxMapper;
import com.yfny.utilscommon.basemvc.producer.BaseComponent;
import com.yfny.utilscommon.basemvc.producer.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by jisongZhou on 2019/5/9.
 **/
@Component
public class XqdxxComposite extends BaseComponent<XqdxxEntity> {

    @Autowired
    private XqdxxMapper xqdxxMapper;

    public static XqdxxComposite xqdxxComposite;

    @PostConstruct
    public void init() {
        xqdxxComposite = this;
    }

    @Override
    public BaseMapper<XqdxxEntity> getBaseMapper() {
        return xqdxxComposite.xqdxxMapper;
    }

}
