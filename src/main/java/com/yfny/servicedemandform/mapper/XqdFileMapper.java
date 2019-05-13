package com.yfny.servicedemandform.mapper;

import com.yfny.corepojo.entity.demandform.XqdFileEntity;
import com.yfny.servicedemandform.sqlbuilder.XqdFileSqlBuilder;
import com.yfny.utilscommon.basemvc.producer.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * 需求单附件Mapper
 * Author auto
 * Date  2019-04-10
 */
public interface XqdFileMapper extends BaseMapper<XqdFileEntity> {

    /**
     * 根据实体中的属性值进行查询，查询条件使用LIKE，并列查询取交集
     *
     * @param   xqdFile    对象实体
     * @return  返回对象列表为查询结果
     */
    @SelectProvider(type = XqdFileSqlBuilder.class, method = "buildFindXqdFileByAndCondition")
    List<XqdFileEntity> findListByAndCondition(@Param("xqdFile") XqdFileEntity xqdFile);

    /**
     * 根据实体中的属性值进行查询，查询条件使用LIKE，亦或查询取并集
     *
     * @param   xqdFile    对象实体
     * @return  返回对象列表为查询结果
     */
    @SelectProvider(type = XqdFileSqlBuilder.class, method = "buildFindXqdFileByORCondition")
    List<XqdFileEntity> findListByORCondition(@Param("xqdFile") XqdFileEntity xqdFile);

    /**
     * 根据外键查询相应对象（一对多关系）
     *
     * @param   path    外键
     * @return  返回对象列表为查询结果
     */
    @Select("select " +
            "FILE_ID AS fileId," +
            "FILE_MD5 AS fileMd5," +
            "BLOCK_NUM AS blockNum," +
            "BLOCK_NO AS blockNo," +
            "FILE_NAME AS fileName," +
            "FILE_TYPE AS fileType," +
            "FILE_SIZE AS fileSize," +
            "USER_ID AS userId," +
            "GROUP_ID AS groupId," +
            "PATH AS path," +
            "MODIF_DATE AS modifDate," +
            "FILE_STATE AS fileState," +
            "VERSION AS version," +
            "DESCRIPTION AS description," +
            "APPLICATION AS application," +
            "FILE_ALIAS AS fileAlias," +
            "COLUMN_17 AS column17," +
            "COLUMN_18 AS column18" +
            " from imp_xqd_files where PATH = #{path}")
    List<XqdFileEntity> findXqdFileByPath(String path);

}
