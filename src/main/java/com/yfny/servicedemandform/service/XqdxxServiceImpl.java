package com.yfny.servicedemandform.service;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yfny.corepojo.entity.demandform.XqdxxEntity;
import com.yfny.corepojo.entity.demandform.YwyxxEntity;
import com.yfny.corepojo.entity.demandform.YyyxxEntity;
import com.yfny.servicedemandform.mapper.BaseMapper;
import com.yfny.servicedemandform.mapper.XqdxxMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.InvocationTargetException;
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

    @Autowired
    private YwyxxServiceImpl ywyxxService;

    @Autowired
    private YyyxxServiceImpl yyyxxService;

    @Autowired
    private XqdFileServiceImpl xqdFileService;

    @Override
    public BaseMapper<XqdxxEntity> getBaseMapper() {
        return this.xqdxxMapper;
    }

    @Override
    @LcnTransaction //分布式事务注解
    @Transactional  //本地事务注解
    public int insert(XqdxxEntity entity) throws InvocationTargetException, IllegalAccessException {
        if (entity.getYwyxxList() != null && entity.getYwyxxList().size() > 0) {
            for (YwyxxEntity ywyxxEntity : entity.getYwyxxList()) {
                ywyxxService.insert(ywyxxEntity);
            }
        }
        if (entity.getYyyxxList() != null && entity.getYyyxxList().size() > 0) {
            for (YyyxxEntity yyyxxEntity : entity.getYyyxxList()) {
                yyyxxService.insert(yyyxxEntity);
            }
        }
        return super.insert(entity);
    }

    @Override
    @LcnTransaction //分布式事务注解
    @Transactional  //本地事务注解
    public int insertSelective(XqdxxEntity entity) throws InvocationTargetException, IllegalAccessException {
        if (entity.getYwyxxList() != null && entity.getYwyxxList().size() > 0) {
            for (YwyxxEntity ywyxxEntity : entity.getYwyxxList()) {
                ywyxxService.insertSelective(ywyxxEntity);
            }
        }
        if (entity.getYyyxxList() != null && entity.getYyyxxList().size() > 0) {
            for (YyyxxEntity yyyxxEntity : entity.getYyyxxList()) {
                yyyxxService.insertSelective(yyyxxEntity);
            }
        }
        return super.insertSelective(entity);
    }

    @Override
    @LcnTransaction //分布式事务注解
    @Transactional  //本地事务注解
    public int update(XqdxxEntity entity) throws InvocationTargetException, IllegalAccessException {
        deleteRelation(entity.getXqdh());
        if (entity.getYwyxxList() != null && entity.getYwyxxList().size() > 0) {
            for (YwyxxEntity ywyxxEntity : entity.getYwyxxList()) {
                ywyxxService.save(ywyxxEntity);
            }
        }
        if (entity.getYyyxxList() != null && entity.getYyyxxList().size() > 0) {
            for (YyyxxEntity yyyxxEntity : entity.getYyyxxList()) {
                yyyxxService.save(yyyxxEntity);
            }
        }
        return super.update(entity);
    }

    @Override
    @LcnTransaction //分布式事务注解
    @Transactional  //本地事务注解
    public int updateSelective(XqdxxEntity entity) throws InvocationTargetException, IllegalAccessException {
        deleteRelation(entity.getXqdh());
        if (entity.getYwyxxList() != null && entity.getYwyxxList().size() > 0) {
            for (YwyxxEntity ywyxxEntity : entity.getYwyxxList()) {
                ywyxxService.saveSelective(ywyxxEntity);
            }
        }
        if (entity.getYyyxxList() != null && entity.getYyyxxList().size() > 0) {
            for (YyyxxEntity yyyxxEntity : entity.getYyyxxList()) {
                yyyxxService.saveSelective(yyyxxEntity);
            }
        }
        return super.updateSelective(entity);
    }

    @Override
    @LcnTransaction //分布式事务注解
    @Transactional  //本地事务注解
    public int delete(XqdxxEntity entity) {
        deleteRelation(entity.getXqdh());
        return super.delete(entity);
    }

    @Override
    @LcnTransaction //分布式事务注解
    @Transactional  //本地事务注解
    public int deleteByPrimaryKey(Object key) {
        deleteRelation((String) key);
        return super.deleteByPrimaryKey(key);
    }

    @Override
    @LcnTransaction //分布式事务注解
    @Transactional  //本地事务注解
    public int deleteByIds(String ids) {
        String[] foreignKeys = ids.split(",");
        for (String foreignKey : foreignKeys) {
            deleteRelation(foreignKey);
        }
        return super.deleteByIds(ids);
    }

    /**
     * 根据实体中的属性值进行查询，查询条件使用LIKE，并列查询取交集
     *
     * @param xqdxx 对象实体
     * @return 返回对象列表为查询结果
     */
    public List<XqdxxEntity> findXqdxxByAndCondition(XqdxxEntity xqdxx) {
        return xqdxxMapper.findXqdxxByAndCondition(xqdxx);
    }

    /**
     * 根据实体中的属性值进行查询，查询条件使用LIKE，并列查询取交集，分页返回
     *
     * @param xqdxx    对象实体
     * @param pageNum  页数
     * @param pageSize 每页数量
     * @return 对象列表
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
     * @param xqdxx 对象实体
     * @return 返回对象列表为查询结果
     */
    public List<XqdxxEntity> findXqdxxByORCondition(XqdxxEntity xqdxx) {
        return xqdxxMapper.findXqdxxByORCondition(xqdxx);
    }

    /**
     * 根据实体中的属性值进行查询，查询条件使用LIKE，亦或查询取并集，分页返回
     *
     * @param xqdxx    对象实体
     * @param pageNum  页数
     * @param pageSize 每页数量
     * @return 对象列表
     */
    public List<XqdxxEntity> findXqdxxByORCondition(XqdxxEntity xqdxx, int pageNum, int pageSize) {
        Page<XqdxxEntity> resultPage = PageHelper.startPage(pageNum, pageSize);
        List<XqdxxEntity> resultList = xqdxxMapper.findXqdxxByORCondition(xqdxx);
        setResultPage(resultPage, resultList);
        return resultList;
    }

    private void deleteRelation(String foreignKey) {
        YwyxxEntity ywyxxParam = new YwyxxEntity();
        ywyxxParam.setXqdh(foreignKey);
        ywyxxService.delete(ywyxxParam);

        YyyxxEntity yyyxxParam = new YyyxxEntity();
        yyyxxParam.setXqdh(foreignKey);
        yyyxxService.delete(yyyxxParam);
    }

}
