package com.yfny.servicedemandform.service;

import com.yfny.corepojo.entity.demandform.XqdFileEntity;
import com.yfny.servicedemandform.mapper.BaseMapper;
import com.yfny.servicedemandform.mapper.XqdFileMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    /**
     * 根据实体中的属性值进行查询，查询条件使用LIKE，并列查询取交集
     *
     * @param   xqdFile    对象实体
     * @return  返回对象列表为查询结果
     */
    public List<XqdFileEntity> findXqdFileByAndCondition(XqdFileEntity xqdFile) {
        return xqdFileMapper.findXqdFileByAndCondition(xqdFile);
    }

    /**
     * 根据实体中的属性值进行查询，查询条件使用LIKE，并列查询取交集，分页返回
     *
     * @param   xqdFile    对象实体
     * @param   pageNum   页数
     * @param   pageSize  每页数量
     * @return  对象列表
     */
    public List<XqdFileEntity> findXqdFileByAndCondition(XqdFileEntity xqdFile, int pageNum, int pageSize) {
        Page<XqdFileEntity> resultPage = PageHelper.startPage(pageNum, pageSize);
        List<XqdFileEntity> resultList = xqdFileMapper.findXqdFileByAndCondition(xqdFile);
        setResultPage(resultPage, resultList);
        return resultList;
    }

    /**
     * 根据实体中的属性值进行查询，查询条件使用LIKE，亦或查询取并集
     *
     * @param   xqdFile    对象实体
     * @return  返回对象列表为查询结果
     */
    public List<XqdFileEntity> findXqdFileByORCondition(XqdFileEntity xqdFile) {
        return xqdFileMapper.findXqdFileByORCondition(xqdFile);
    }

    /**
     * 根据实体中的属性值进行查询，查询条件使用LIKE，亦或查询取并集，分页返回
     *
     * @param   xqdFile    对象实体
     * @param   pageNum   页数
     * @param   pageSize  每页数量
     * @return  对象列表
     */
    public List<XqdFileEntity> findXqdFileByORCondition(XqdFileEntity xqdFile, int pageNum, int pageSize) {
        Page<XqdFileEntity> resultPage = PageHelper.startPage(pageNum, pageSize);
        List<XqdFileEntity> resultList = xqdFileMapper.findXqdFileByORCondition(xqdFile);
        setResultPage(resultPage, resultList);
        return resultList;
    }

}
