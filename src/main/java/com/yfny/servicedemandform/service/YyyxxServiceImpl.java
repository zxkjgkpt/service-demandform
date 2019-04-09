package com.yfny.servicedemandform.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yfny.corepojo.entity.demandform.YyyxxEntity;
import com.yfny.servicedemandform.mapper.BaseMapper;
import com.yfny.servicedemandform.mapper.YyyxxMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    /**
     * 根据实体中的属性值进行查询，查询条件使用LIKE，并列查询取交集
     *
     * @param   yyyxx    对象实体
     * @return  返回对象列表为查询结果
     */
    public List<YyyxxEntity> findYyyxxByAndCondition(YyyxxEntity yyyxx) {
        return yyyxxMapper.findYyyxxByAndCondition(yyyxx);
    }

    /**
     * 根据实体中的属性值进行查询，查询条件使用LIKE，并列查询取交集，分页返回
     *
     * @param   yyyxx    对象实体
     * @param   pageNum   页数
     * @param   pageSize  每页数量
     * @return  对象列表
     */
    public List<YyyxxEntity> findYyyxxByAndCondition(YyyxxEntity yyyxx, int pageNum, int pageSize) {
        Page<YyyxxEntity> resultPage = PageHelper.startPage(pageNum, pageSize);
        List<YyyxxEntity> resultList = yyyxxMapper.findYyyxxByAndCondition(yyyxx);
        setResultPage(resultPage, resultList);
        return resultList;
    }

    /**
     * 根据实体中的属性值进行查询，查询条件使用LIKE，亦或查询取并集
     *
     * @param   yyyxx    对象实体
     * @return  返回对象列表为查询结果
     */
    public List<YyyxxEntity> findYyyxxByORCondition(YyyxxEntity yyyxx) {
        return yyyxxMapper.findYyyxxByORCondition(yyyxx);
    }

    /**
     * 根据实体中的属性值进行查询，查询条件使用LIKE，亦或查询取并集，分页返回
     *
     * @param   yyyxx    对象实体
     * @param   pageNum   页数
     * @param   pageSize  每页数量
     * @return  对象列表
     */
    public List<YyyxxEntity> findYyyxxByORCondition(YyyxxEntity yyyxx, int pageNum, int pageSize) {
        Page<YyyxxEntity> resultPage = PageHelper.startPage(pageNum, pageSize);
        List<YyyxxEntity> resultList = yyyxxMapper.findYyyxxByORCondition(yyyxx);
        setResultPage(resultPage, resultList);
        return resultList;
    }

}
