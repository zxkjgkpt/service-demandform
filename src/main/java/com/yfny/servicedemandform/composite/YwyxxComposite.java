package com.yfny.servicedemandform.composite;

import com.yfny.corepojo.entity.demandform.YwyxxEntity;
import com.yfny.servicedemandform.mapper.YwyxxMapper;
import com.yfny.utilscommon.basemvc.producer.BaseComponent;
import com.yfny.utilscommon.basemvc.producer.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by jisongZhou on 2019/5/9.
 **/
@Component
public class YwyxxComposite extends BaseComponent<YwyxxEntity> {

    @Autowired
    private YwyxxMapper ywyxxMapper;

    public static YwyxxComposite ywyxxComposite;

    @PostConstruct
    public void init() {
        ywyxxComposite = this;
    }

    @Override
    public BaseMapper<YwyxxEntity> getBaseMapper() {
        return ywyxxComposite.ywyxxMapper;
    }

}
