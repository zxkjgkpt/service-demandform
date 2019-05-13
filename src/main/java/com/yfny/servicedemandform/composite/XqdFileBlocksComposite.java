package com.yfny.servicedemandform.composite;

import com.yfny.corepojo.entity.demandform.XqdFileBlocksEntity;
import com.yfny.servicedemandform.mapper.XqdFileBlocksMapper;
import com.yfny.utilscommon.basemvc.producer.BaseComponent;
import com.yfny.utilscommon.basemvc.producer.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by jisongZhou on 2019/5/9.
 **/
@Component
public class XqdFileBlocksComposite extends BaseComponent<XqdFileBlocksEntity> {

    @Autowired
    private XqdFileBlocksMapper xqdFileBlocksMapper;

    public static XqdFileBlocksComposite xqdFileBlocksComposite;

    @PostConstruct
    public void init() {
        xqdFileBlocksComposite = this;
    }

    @Override
    public BaseMapper<XqdFileBlocksEntity> getBaseMapper() {
        return xqdFileBlocksComposite.xqdFileBlocksMapper;
    }

}
