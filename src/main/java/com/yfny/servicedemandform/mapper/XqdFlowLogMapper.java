package com.yfny.servicedemandform.mapper;

import com.yfny.corepojo.entity.demandform.XqdFlowLogEntity;
import com.yfny.servicedemandform.sqlbuilder.XqdFlowLogSqlBuilder;
import com.yfny.utilscommon.basemvc.producer.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * 需求单操作记录Mapper
 * Author auto
 * Date  2019-05-08
 */
public interface XqdFlowLogMapper extends BaseMapper<XqdFlowLogEntity> {

    /**
     * 根据实体中的属性值进行查询，查询条件使用LIKE，并列查询取交集
     *
     * @param   xqdFlowLog    对象实体
     * @return  返回对象列表为查询结果
     */
    @SelectProvider(type = XqdFlowLogSqlBuilder.class, method = "buildFindXqdFlowLogByAndCondition")
    List<XqdFlowLogEntity> findListByAndCondition(@Param("xqdFlowLog") XqdFlowLogEntity xqdFlowLog);

    /**
     * 根据实体中的属性值进行查询，查询条件使用LIKE，亦或查询取并集
     *
     * @param   xqdFlowLog    对象实体
     * @return  返回对象列表为查询结果
     */
    @SelectProvider(type = XqdFlowLogSqlBuilder.class, method = "buildFindXqdFlowLogByORCondition")
    List<XqdFlowLogEntity> findListByORCondition(@Param("xqdFlowLog") XqdFlowLogEntity xqdFlowLog);

}
