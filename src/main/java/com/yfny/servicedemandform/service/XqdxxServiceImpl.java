package com.yfny.servicedemandform.service;

import com.yfny.corepojo.entity.demandform.XqdxxEntity;
import com.yfny.servicedemandform.mapper.XqdxxMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.BaseMapper;

/**
 * 需求单详情ServiceImpl
 * Author auto
 * Date  2019-03-29
 */
@Service
public class XqdxxServiceImpl extends BaseServiceImpl<XqdxxEntity> {

    @Autowired
    private XqdxxMapper xqdxxMapper;

    @Override
    public BaseMapper<XqdxxEntity> getBaseMapper() {
        return this.xqdxxMapper;
    }

}
