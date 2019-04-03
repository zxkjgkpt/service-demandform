package com.yfny.servicedemandform.service;

import com.yfny.corepojo.entity.demandform.XqdxxEntity;
import com.yfny.servicedemandform.mapper.XqdxxMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

/**
 * 需求单详情ServiceImpl
 * Author auto
 * Date  2019-04-03
 */
@Service
public class XqdxxServiceImpl extends BaseServiceImpl<XqdxxEntity> {

    @Autowired
    private XqdxxMapper xqdxxMapper;

    @Override
    public BaseMapper<XqdxxEntity> getBaseMapper() {
        return this.xqdxxMapper;
    }

    /**
     * 根据实体中的属性值进行查询，查询条件使用LIKE，并列查询取交集
     *
     * @param   xqdxx    对象实体
     * @return  返回对象列表为查询结果
     */
    public List<XqdxxEntity> findXqdxxByAndCondition(XqdxxEntity xqdxx) {
        return xqdxxMapper.findXqdxxByAndCondition(xqdxx);
    }

    /**
     * 根据实体中的属性值进行查询，查询条件使用LIKE，并列查询取交集，分页返回
     *
     * @param   xqdxx    对象实体
     * @param   pageNum   页数
     * @param   pageSize  每页数量
     * @return  对象列表
     */
    public List<XqdxxEntity> findXqdxxByAndCondition(XqdxxEntity xqdxx, int pageNum, int pageSize) {
        Page<XqdxxEntity> resultPage = PageHelper.startPage(pageNum, pageSize);
        List<XqdxxEntity> resultList = xqdxxMapper.findXqdxxByAndCondition(xqdxx);
        setResultPage(resultPage, resultList);
        return resultList;
    }

    /**
     * 根据实体中的属性值进行查询，查询条件使用LIKE，亦或查询取并集
     *
     * @param   xqdxx    对象实体
     * @return  返回对象列表为查询结果
     */
    public List<XqdxxEntity> findXqdxxByORCondition(XqdxxEntity xqdxx) {
        return xqdxxMapper.findXqdxxByORCondition(xqdxx);
    }

    /**
     * 根据实体中的属性值进行查询，查询条件使用LIKE，亦或查询取并集，分页返回
     *
     * @param   xqdxx    对象实体
     * @param   pageNum   页数
     * @param   pageSize  每页数量
     * @return  对象列表
     */
    public List<XqdxxEntity> findXqdxxByORCondition(XqdxxEntity xqdxx, int pageNum, int pageSize) {
        Page<XqdxxEntity> resultPage = PageHelper.startPage(pageNum, pageSize);
        List<XqdxxEntity> resultList = xqdxxMapper.findXqdxxByORCondition(xqdxx);
        setResultPage(resultPage, resultList);
        return resultList;
    }

}
