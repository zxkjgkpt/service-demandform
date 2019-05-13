package com.yfny.servicedemandform.mapper;

import com.yfny.corepojo.entity.demandform.XqdFileBlocksEntity;
import com.yfny.servicedemandform.sqlbuilder.XqdFileBlocksSqlBuilder;
import com.yfny.utilscommon.basemvc.producer.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * 需求单附件Mapper
 * Author auto
 * Date  2019-04-16
 */
public interface XqdFileBlocksMapper extends BaseMapper<XqdFileBlocksEntity> {

    /**
     * 根据实体中的属性值进行查询，查询条件使用LIKE，并列查询取交集
     *
     * @param   xqdFileBlocks    对象实体
     * @return  返回对象列表为查询结果
     */
    @SelectProvider(type = XqdFileBlocksSqlBuilder.class, method = "buildFindXqdFileBlocksByAndCondition")
    List<XqdFileBlocksEntity> findListByAndCondition(@Param("xqdFileBlocks") XqdFileBlocksEntity xqdFileBlocks);

    /**
     * 根据实体中的属性值进行查询，查询条件使用LIKE，亦或查询取并集
     *
     * @param   xqdFileBlocks    对象实体
     * @return  返回对象列表为查询结果
     */
    @SelectProvider(type = XqdFileBlocksSqlBuilder.class, method = "buildFindXqdFileBlocksByORCondition")
    List<XqdFileBlocksEntity> findListByORCondition(@Param("xqdFileBlocks") XqdFileBlocksEntity xqdFileBlocks);

}
