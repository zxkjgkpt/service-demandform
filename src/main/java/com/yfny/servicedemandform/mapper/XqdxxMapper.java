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
 * Date  2019-04-02
 */
public interface XqdxxMapper extends BaseMapper<XqdxxEntity> {

    /**
     * 根据实体中的属性值进行查询，查询条件使用等号
     * @param   xqdxx    对象实体
     * @param   orders   排序字段
     * @return  对象列表
     */
    @SelectProvider(type = XqdxxSqlBuilder.class, method = "buildFindXqdxxByCondition")
    List<XqdxxEntity> findXqdxxByCondition(@Param("xqdxx") XqdxxEntity xqdxx, @Param("orders") String[] orders);

}
