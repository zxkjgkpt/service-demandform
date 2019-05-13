package com.yfny.servicedemandform.service;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.yfny.corepojo.entity.demandform.*;
import com.yfny.servicedemandform.mapper.XqdxxMapper;
import com.yfny.utilscommon.basemvc.producer.BaseMapper;
import com.yfny.utilscommon.basemvc.producer.BaseServiceImpl;
import com.yfny.utilscommon.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    private XqdFileBlocksServiceImpl xqdFileBlocksService;

    @Override
    public BaseMapper<XqdxxEntity> getBaseMapper() {
        return this.xqdxxMapper;
    }

    @Override
    @LcnTransaction //分布式事务注解
    @Transactional  //本地事务注解
    public int insert(XqdxxEntity entity) {
        setPKValue(entity);
        if (entity.getYwyxxList() != null && entity.getYwyxxList().size() > 0) {
            for (YwyxxEntity ywyxxEntity : entity.getYwyxxList()) {
                ywyxxEntity.setXqdh(entity.getXqdh());
                ywyxxService.insert(ywyxxEntity);
            }
        }
        if (entity.getYyyxxList() != null && entity.getYyyxxList().size() > 0) {
            for (YyyxxEntity yyyxxEntity : entity.getYyyxxList()) {
                yyyxxEntity.setXqdh(entity.getXqdh());
                yyyxxService.insert(yyyxxEntity);
            }
        }
        updateXqdFilePath(entity);
        return super.insert(entity);
    }

//    @Override
//    @LcnTransaction //分布式事务注解
//    @Transactional  //本地事务注解
//    public int insertSelective(XqdxxEntity entity) {
////        setPKValue(entity);
////        if (entity.getYwyxxList() != null && entity.getYwyxxList().size() > 0) {
////            for (YwyxxEntity ywyxxEntity : entity.getYwyxxList()) {
////                ywyxxEntity.setXqdh(entity.getXqdh());
////                ywyxxService.insertSelective(ywyxxEntity);
////            }
////        }
////        if (entity.getYyyxxList() != null && entity.getYyyxxList().size() > 0) {
////            for (YyyxxEntity yyyxxEntity : entity.getYyyxxList()) {
////                yyyxxEntity.setXqdh(entity.getXqdh());
////                yyyxxService.insertSelective(yyyxxEntity);
////            }
////        }
////        updateXqdFilePath(entity);
//        return super.insertSelective(entity);
//    }

    @Override
    @LcnTransaction //分布式事务注解
    @Transactional  //本地事务注解
    public int update(XqdxxEntity entity) {
        deleteRelation(entity.getXqdh());
        if (entity.getYwyxxList() != null && entity.getYwyxxList().size() > 0) {
            for (YwyxxEntity ywyxxEntity : entity.getYwyxxList()) {
                ywyxxEntity.setXqdh(entity.getXqdh());
                ywyxxService.save(ywyxxEntity);
            }
        }
        if (entity.getYyyxxList() != null && entity.getYyyxxList().size() > 0) {
            for (YyyxxEntity yyyxxEntity : entity.getYyyxxList()) {
                yyyxxEntity.setXqdh(entity.getXqdh());
                yyyxxService.save(yyyxxEntity);
            }
        }
        updateXqdFilePath(entity);
        return super.update(entity);
    }

    @Override
    @LcnTransaction //分布式事务注解
    @Transactional  //本地事务注解
    public int updateSelective(XqdxxEntity entity) {
        deleteRelation(entity.getXqdh());
        if (entity.getYwyxxList() != null && entity.getYwyxxList().size() > 0) {
            for (YwyxxEntity ywyxxEntity : entity.getYwyxxList()) {
                ywyxxEntity.setXqdh(entity.getXqdh());
                ywyxxService.saveSelective(ywyxxEntity);
            }
        }
        if (entity.getYyyxxList() != null && entity.getYyyxxList().size() > 0) {
            for (YyyxxEntity yyyxxEntity : entity.getYyyxxList()) {
                yyyxxEntity.setXqdh(entity.getXqdh());
                yyyxxService.saveSelective(yyyxxEntity);
            }
        }
        updateXqdFilePath(entity);
        return super.updateSelective(entity);
    }

    @Override
    @LcnTransaction //分布式事务注解
    @Transactional  //本地事务注解
    public int delete(XqdxxEntity entity) {
        deleteRelation(entity.getXqdh());
        deleteXqdFile(entity.getXqdh());
        return super.delete(entity);
    }

    @Override
    @LcnTransaction //分布式事务注解
    @Transactional  //本地事务注解
    public int deleteByPrimaryKey(Object key) {
        deleteRelation((String) key);
        deleteXqdFile((String) key);
        return super.deleteByPrimaryKey(key);
    }

    @Override
    @LcnTransaction //分布式事务注解
    @Transactional  //本地事务注解
    public int deleteByIds(String ids) {
        String[] foreignKeys = ids.split(",");
        for (String foreignKey : foreignKeys) {
            deleteRelation(foreignKey);
            deleteXqdFile(foreignKey);
        }
        return super.deleteByIds(ids);
    }

    private void deleteRelation(String foreignKey) {
        YwyxxEntity ywyxxParam = new YwyxxEntity();
        ywyxxParam.setXqdh(foreignKey);
        ywyxxService.delete(ywyxxParam);

        YyyxxEntity yyyxxParam = new YyyxxEntity();
        yyyxxParam.setXqdh(foreignKey);
        yyyxxService.delete(yyyxxParam);

    }

    private void deleteXqdFile(String foreignKey) {
        XqdFileEntity xqdFileParam = new XqdFileEntity();
        xqdFileParam.setPath(foreignKey);

        List<XqdFileEntity> xqdFileList = xqdFileService.findList(xqdFileParam, null, null);
        if (xqdFileList != null) {
            for (XqdFileEntity xqdFile : xqdFileList) {
                XqdFileBlocksEntity xqdFileBlocks = new XqdFileBlocksEntity();
                xqdFileBlocks.setFileMd5(xqdFile.getFileMd5());
                xqdFileBlocksService.delete(xqdFileBlocks);
            }
            xqdFileService.delete(xqdFileParam);
        }
    }

    private void updateXqdFilePath(XqdxxEntity entity) {
        if (entity.getXqdFileList() != null && entity.getXqdFileList().size() > 0) {
            for (XqdFileEntity xqdFileEntity : entity.getXqdFileList()) {
                if (StringUtils.isNotBlank(xqdFileEntity.getFileMd5())) {
                    XqdFileEntity xqdFile = new XqdFileEntity();
                    xqdFile.setFileMd5(xqdFileEntity.getFileMd5());
                    xqdFile = xqdFileService.selectOne(xqdFileEntity);
                    if (xqdFile != null) {
                        xqdFile.setPath(entity.getXqdh());
                        xqdFileService.updateSelective(xqdFile);
                    }
                }
            }
        }
    }

}
