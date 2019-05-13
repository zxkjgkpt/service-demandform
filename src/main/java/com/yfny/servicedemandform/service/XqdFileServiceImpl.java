package com.yfny.servicedemandform.service;

import com.yfny.corepojo.entity.demandform.XqdFileEntity;
import com.yfny.servicedemandform.mapper.XqdFileMapper;
import com.yfny.utilscommon.basemvc.producer.BaseMapper;
import com.yfny.utilscommon.basemvc.producer.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 需求单附件ServiceImpl
 * Author auto
 * Date  2019-04-10
 */
@Service
public class XqdFileServiceImpl extends BaseServiceImpl<XqdFileEntity> {

    @Autowired
    private XqdFileMapper xqdFileMapper;

    @Override
    public BaseMapper<XqdFileEntity> getBaseMapper() {
        return this.xqdFileMapper;
    }

}
