package com.yfny.servicedemandform.composite;

import com.yfny.corepojo.entity.demandform.YyyxxEntity;
import com.yfny.servicedemandform.mapper.YyyxxMapper;
import com.yfny.utilscommon.basemvc.producer.BaseComponent;
import com.yfny.utilscommon.basemvc.producer.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by jisongZhou on 2019/5/9.
 **/
@Component
public class YyyxxComposite extends BaseComponent<YyyxxEntity> {

    @Autowired
    private YyyxxMapper yyyxxMapper;

    public static YyyxxComposite yyyxxComposite;

    @PostConstruct
    public void init() {
        yyyxxComposite = this;
    }

    @Override
    public BaseMapper<YyyxxEntity> getBaseMapper() {
        return yyyxxComposite.yyyxxMapper;
    }

}
