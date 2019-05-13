package com.yfny.servicedemandform.service;

import com.yfny.corepojo.entity.demandform.YyyxxEntity;
import com.yfny.servicedemandform.mapper.YyyxxMapper;
import com.yfny.utilscommon.basemvc.producer.BaseMapper;
import com.yfny.utilscommon.basemvc.producer.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 需求单应用域详情ServiceImpl
 * Author auto
 * Date  2019-04-09
 */
@Service
public class YyyxxServiceImpl extends BaseServiceImpl<YyyxxEntity> {

    @Autowired
    private YyyxxMapper yyyxxMapper;

    @Override
    public BaseMapper<YyyxxEntity> getBaseMapper() {
        return this.yyyxxMapper;
    }

}
