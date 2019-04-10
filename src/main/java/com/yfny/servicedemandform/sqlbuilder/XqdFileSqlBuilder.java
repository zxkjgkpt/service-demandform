package com.yfny.servicedemandform.sqlbuilder;

import com.yfny.corepojo.entity.demandform.XqdFileEntity;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 * 需求单附件SqlBuilder
 * Author auto
 * Date  2019-04-10
 */
public class XqdFileSqlBuilder {

    /**
     * 根据实体中的属性值进行查询，查询条件使用LIKE，多条件并列查询取交集
     *
     * @param   xqdFile    对象实体
     * @return  Sql语句
     */
    public String buildFindXqdFileByAndCondition(final XqdFileEntity xqdFile) {
        return buildFindXqdFileByCondition(xqdFile, 0);
    }

    /**
     * 根据实体中的属性值进行查询，查询条件使用LIKE，多条件亦或查询取并集
     *
     * @param   xqdFile    对象实体
     * @return  Sql语句
     */
    public String buildFindXqdFileByORCondition(final XqdFileEntity xqdFile) {
        return buildFindXqdFileByCondition(xqdFile, 1);
    }

    private String buildFindXqdFileByCondition(final XqdFileEntity xqdFile, final int type) {
        String orSql = "";
        if (type == 1) {
            orSql = " || '%'";
        } else {
            orSql = " '%'";
        }
        String finalOrSql = orSql;
        String sqlResult = new SQL(){{
            SELECT("FILE_ID AS fileId," +
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
                    "COLUMN_18 AS column18"
                    );
            FROM("imp_xqd_files");
            if (xqdFile.getFileId() != null && !xqdFile.getFileId().equals("")) {
                WHERE("FILE_ID like #{xqdFile.fileId}" + finalOrSql);
            }
            if (xqdFile.getFileMd5() != null && !xqdFile.getFileMd5().equals("")) {
                WHERE("FILE_MD5 like #{xqdFile.fileMd5}" + finalOrSql);
            }
            if (xqdFile.getBlockNum() != null) {
                WHERE("BLOCK_NUM like #{xqdFile.blockNum}" + finalOrSql);
            }
            if (xqdFile.getBlockNo() != null) {
                WHERE("BLOCK_NO like #{xqdFile.blockNo}" + finalOrSql);
            }
            if (xqdFile.getFileName() != null && !xqdFile.getFileName().equals("")) {
                WHERE("FILE_NAME like #{xqdFile.fileName}" + finalOrSql);
            }
            if (xqdFile.getFileType() != null && !xqdFile.getFileType().equals("")) {
                WHERE("FILE_TYPE like #{xqdFile.fileType}" + finalOrSql);
            }
            if (xqdFile.getFileSize() != null) {
                WHERE("FILE_SIZE like #{xqdFile.fileSize}" + finalOrSql);
            }
            if (xqdFile.getUserId() != null && !xqdFile.getUserId().equals("")) {
                WHERE("USER_ID like #{xqdFile.userId}" + finalOrSql);
            }
            if (xqdFile.getGroupId() != null && !xqdFile.getGroupId().equals("")) {
                WHERE("GROUP_ID like #{xqdFile.groupId}" + finalOrSql);
            }
            if (xqdFile.getPath() != null && !xqdFile.getPath().equals("")) {
                WHERE("PATH like #{xqdFile.path}" + finalOrSql);
            }
            if (xqdFile.getModifDate() != null) {
                WHERE("MODIF_DATE like #{xqdFile.modifDate}" + finalOrSql);
            }
            if (xqdFile.getFileState() != null) {
                WHERE("FILE_STATE like #{xqdFile.fileState}" + finalOrSql);
            }
            if (xqdFile.getVersion() != null && !xqdFile.getVersion().equals("")) {
                WHERE("VERSION like #{xqdFile.version}" + finalOrSql);
            }
            if (xqdFile.getDescription() != null && !xqdFile.getDescription().equals("")) {
                WHERE("DESCRIPTION like #{xqdFile.description}" + finalOrSql);
            }
            if (xqdFile.getApplication() != null) {
                WHERE("APPLICATION like #{xqdFile.application}" + finalOrSql);
            }
            if (xqdFile.getFileAlias() != null && !xqdFile.getFileAlias().equals("")) {
                WHERE("FILE_ALIAS like #{xqdFile.fileAlias}" + finalOrSql);
            }
            if (xqdFile.getColumn17() != null && !xqdFile.getColumn17().equals("")) {
                WHERE("COLUMN_17 like #{xqdFile.column17}" + finalOrSql);
            }
            if (xqdFile.getColumn18() != null && !xqdFile.getColumn18().equals("")) {
                WHERE("COLUMN_18 like #{xqdFile.column18}" + finalOrSql);
            }
        }}.toString();

        if (xqdFile.getOrders() != null && xqdFile.getOrders().size() > 0) {
            Map<String, String> orderMap = xqdFile.getOrders();
            int count = 0;
            sqlResult = sqlResult + " ORDER BY ";
            for (String order : orderMap.keySet()) {
                if (count != 0) {
                    order = ", " + order;
                }
                if (XqdFileEntity.DESC.equals(orderMap.get(order))) {
                    sqlResult = sqlResult + order + " DESC";
                } else {
                    sqlResult = sqlResult + order + " ASC";
                }
                count++;
            }
        }
        return sqlResult;
    }

}
