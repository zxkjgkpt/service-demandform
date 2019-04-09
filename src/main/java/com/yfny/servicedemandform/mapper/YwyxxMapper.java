package com.yfny.servicedemandform.mapper;

import com.yfny.corepojo.entity.demandform.YwyxxEntity;
import com.yfny.servicedemandform.sqlbuilder.YwyxxSqlBuilder;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * 需求单业务域详情Mapper
 * Author auto
 * Date  2019-04-09
 */
public interface YwyxxMapper extends BaseMapper<YwyxxEntity> {

    /**
     * 根据实体中的属性值进行查询，查询条件使用LIKE，并列查询取交集
     *
     * @param   ywyxx    对象实体
     * @return  返回对象列表为查询结果
     */
    @SelectProvider(type = YwyxxSqlBuilder.class, method = "buildFindYwyxxByAndCondition")
    List<YwyxxEntity> findYwyxxByAndCondition(@Param("ywyxx") YwyxxEntity ywyxx);

    /**
     * 根据实体中的属性值进行查询，查询条件使用LIKE，亦或查询取并集
     *
     * @param   ywyxx    对象实体
     * @return  返回对象列表为查询结果
     */
    @SelectProvider(type = YwyxxSqlBuilder.class, method = "buildFindYwyxxByORCondition")
    List<YwyxxEntity> findYwyxxByORCondition(@Param("ywyxx") YwyxxEntity ywyxx);

    /**
     * 根据外键查询相应对象（一对多关系）
     *
     * @param   xqdh    外键
     * @return  返回对象列表为查询结果
     */
    @Select("select * from imp_xqd_ywyxx where XQDH = #{xqdh}")
    List<YwyxxEntity> findYwyxxByXqdh(String xqdh);

}
