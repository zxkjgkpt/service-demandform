package com.yfny.servicedemandform.service;

import com.yfny.corepojo.entity.demandform.YwyxxEntity;
import com.yfny.servicedemandform.mapper.YwyxxMapper;
import com.yfny.utilscommon.basemvc.producer.BaseMapper;
import com.yfny.utilscommon.basemvc.producer.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 需求单业务域详情ServiceImpl
 * Author auto
 * Date  2019-04-09
 */
@Service
public class YwyxxServiceImpl extends BaseServiceImpl<YwyxxEntity> {

    @Autowired
    private YwyxxMapper ywyxxMapper;

    @Override
    public BaseMapper<YwyxxEntity> getBaseMapper() {
        return this.ywyxxMapper;
    }

}
