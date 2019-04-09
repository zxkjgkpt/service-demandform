package com.yfny.servicedemandform.mapper;

import com.yfny.corepojo.entity.demandform.YyyxxEntity;
import com.yfny.servicedemandform.sqlbuilder.YyyxxSqlBuilder;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

/**
 * 需求单应用域详情Mapper
 * Author auto
 * Date  2019-04-09
 */
public interface YyyxxMapper extends BaseMapper<YyyxxEntity> {

    /**
     * 根据实体中的属性值进行查询，查询条件使用LIKE，并列查询取交集
     *
     * @param   yyyxx    对象实体
     * @return  返回对象列表为查询结果
     */
    @SelectProvider(type = YyyxxSqlBuilder.class, method = "buildFindYyyxxByAndCondition")
    List<YyyxxEntity> findYyyxxByAndCondition(@Param("yyyxx") YyyxxEntity yyyxx);

    /**
     * 根据实体中的属性值进行查询，查询条件使用LIKE，亦或查询取并集
     *
     * @param   yyyxx    对象实体
     * @return  返回对象列表为查询结果
     */
    @SelectProvider(type = YyyxxSqlBuilder.class, method = "buildFindYyyxxByORCondition")
    List<YyyxxEntity> findYyyxxByORCondition(@Param("yyyxx") YyyxxEntity yyyxx);

    /**
     * 根据外键查询相应对象（一对多关系）
     *
     * @param   xqdh    外键
     * @return  返回对象列表为查询结果
     */
    @Select("select * from imp_xqd_yyyxx where XQDH = #{xqdh}")
    List<YyyxxEntity> findYyyxxByXqdh(String xqdh);

}
