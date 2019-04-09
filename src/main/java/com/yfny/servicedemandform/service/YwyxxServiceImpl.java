package com.yfny.servicedemandform.service;

import com.yfny.corepojo.entity.demandform.YwyxxEntity;
import com.yfny.servicedemandform.mapper.YwyxxMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

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

    /**
     * 根据实体中的属性值进行查询，查询条件使用LIKE，并列查询取交集
     *
     * @param   ywyxx    对象实体
     * @return  返回对象列表为查询结果
     */
    public List<YwyxxEntity> findYwyxxByAndCondition(YwyxxEntity ywyxx) {
        return ywyxxMapper.findYwyxxByAndCondition(ywyxx);
    }

    /**
     * 根据实体中的属性值进行查询，查询条件使用LIKE，并列查询取交集，分页返回
     *
     * @param   ywyxx    对象实体
     * @param   pageNum   页数
     * @param   pageSize  每页数量
     * @return  对象列表
     */
    public List<YwyxxEntity> findYwyxxByAndCondition(YwyxxEntity ywyxx, int pageNum, int pageSize) {
        Page<YwyxxEntity> resultPage = PageHelper.startPage(pageNum, pageSize);
        List<YwyxxEntity> resultList = ywyxxMapper.findYwyxxByAndCondition(ywyxx);
        setResultPage(resultPage, resultList);
        return resultList;
    }

    /**
     * 根据实体中的属性值进行查询，查询条件使用LIKE，亦或查询取并集
     *
     * @param   ywyxx    对象实体
     * @return  返回对象列表为查询结果
     */
    public List<YwyxxEntity> findYwyxxByORCondition(YwyxxEntity ywyxx) {
        return ywyxxMapper.findYwyxxByORCondition(ywyxx);
    }

    /**
     * 根据实体中的属性值进行查询，查询条件使用LIKE，亦或查询取并集，分页返回
     *
     * @param   ywyxx    对象实体
     * @param   pageNum   页数
     * @param   pageSize  每页数量
     * @return  对象列表
     */
    public List<YwyxxEntity> findYwyxxByORCondition(YwyxxEntity ywyxx, int pageNum, int pageSize) {
        Page<YwyxxEntity> resultPage = PageHelper.startPage(pageNum, pageSize);
        List<YwyxxEntity> resultList = ywyxxMapper.findYwyxxByORCondition(ywyxx);
        setResultPage(resultPage, resultList);
        return resultList;
    }

}
