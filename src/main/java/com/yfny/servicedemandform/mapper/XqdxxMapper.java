package com.yfny.servicedemandform.mapper;

import com.yfny.corepojo.entity.demandform.XqdxxEntity;
import com.yfny.servicedemandform.sqlbuilder.XqdxxSqlBuilder;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

/**
 * 需求单详情Mapper
 * Author auto
 * Date  2019-04-03
 */
public interface XqdxxMapper extends BaseMapper<XqdxxEntity> {

    /**
     * 根据实体中的属性值进行查询，查询条件使用LIKE，并列查询取交集
     *
     * @param   xqdxx    对象实体
     * @return  返回对象列表为查询结果
     */
    @SelectProvider(type = XqdxxSqlBuilder.class, method = "buildFindXqdxxByAndCondition")
    @Results({
            @Result(property = "ywyxxList", column = "XQDH",
                    many = @Many(select = "com.yfny.servicedemandform.mapper.YwyxxMapper.findYwyxxByXqdh", fetchType = FetchType.EAGER)),
            @Result(property = "yyyxxList", column = "XQDH",
                    many = @Many(select = "com.yfny.servicedemandform.mapper.YyyxxMapper.findYyyxxByXqdh", fetchType = FetchType.EAGER))
    })
    List<XqdxxEntity> findXqdxxByAndCondition(@Param("xqdxx") XqdxxEntity xqdxx);

    /**
     * 根据实体中的属性值进行查询，查询条件使用LIKE，亦或查询取并集
     *
     * @param   xqdxx    对象实体
     * @return  返回对象列表为查询结果
     */
    @SelectProvider(type = XqdxxSqlBuilder.class, method = "buildFindXqdxxByORCondition")
    @Results({
            @Result(property = "ywyxxList", column = "XQDH",
                    many = @Many(select = "com.yfny.servicedemandform.mapper.YwyxxMapper.findYwyxxByXqdh", fetchType = FetchType.EAGER)),
            @Result(property = "yyyxxList", column = "XQDH",
                    many = @Many(select = "com.yfny.servicedemandform.mapper.YyyxxMapper.findYyyxxByXqdh", fetchType = FetchType.EAGER))
    })
    List<XqdxxEntity> findXqdxxByORCondition(@Param("xqdxx") XqdxxEntity xqdxx);

}
