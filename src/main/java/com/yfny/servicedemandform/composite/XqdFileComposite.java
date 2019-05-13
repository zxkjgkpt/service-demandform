package com.yfny.servicedemandform.composite;

import com.yfny.corepojo.entity.demandform.XqdFileEntity;
import com.yfny.servicedemandform.mapper.XqdFileMapper;
import com.yfny.utilscommon.basemvc.producer.BaseComponent;
import com.yfny.utilscommon.basemvc.producer.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by jisongZhou on 2019/5/9.
 **/
@Component
public class XqdFileComposite extends BaseComponent<XqdFileEntity> {

    @Autowired
    private XqdFileMapper xqdFileMapper;

    public static XqdFileComposite xqdFileComposite;

    @PostConstruct
    public void init() {
        xqdFileComposite = this;
    }

    @Override
    public BaseMapper<XqdFileEntity> getBaseMapper() {
        return xqdFileComposite.xqdFileMapper;
    }

}
