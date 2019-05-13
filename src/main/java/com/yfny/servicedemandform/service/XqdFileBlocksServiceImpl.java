package com.yfny.servicedemandform.service;

import com.yfny.corepojo.entity.demandform.XqdFileBlocksEntity;
import com.yfny.servicedemandform.mapper.XqdFileBlocksMapper;
import com.yfny.utilscommon.basemvc.producer.BaseMapper;
import com.yfny.utilscommon.basemvc.producer.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 需求单附件ServiceImpl
 * Author auto
 * Date  2019-04-16
 */
@Service
public class XqdFileBlocksServiceImpl extends BaseServiceImpl<XqdFileBlocksEntity> {

    @Autowired
    private XqdFileBlocksMapper xqdFileBlocksMapper;

    @Override
    public BaseMapper<XqdFileBlocksEntity> getBaseMapper() {
        return this.xqdFileBlocksMapper;
    }

}
