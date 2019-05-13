package com.yfny.servicedemandform.sqlbuilder;

import com.yfny.corepojo.entity.demandform.XqdFileBlocksEntity;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 * 需求单附件SqlBuilder
 * Author auto
 * Date  2019-04-16
 */
public class XqdFileBlocksSqlBuilder {

    /**
     * 根据实体中的属性值进行查询，查询条件使用LIKE，多条件并列查询取交集
     *
     * @param   xqdFileBlocks    对象实体
     * @return  Sql语句
     */
    public String buildFindXqdFileBlocksByAndCondition(final XqdFileBlocksEntity xqdFileBlocks) {
        return buildFindXqdFileBlocksByCondition(xqdFileBlocks, 0);
    }

    /**
     * 根据实体中的属性值进行查询，查询条件使用LIKE，多条件亦或查询取并集
     *
     * @param   xqdFileBlocks    对象实体
     * @return  Sql语句
     */
    public String buildFindXqdFileBlocksByORCondition(final XqdFileBlocksEntity xqdFileBlocks) {
        return buildFindXqdFileBlocksByCondition(xqdFileBlocks, 1);
    }

    private String buildFindXqdFileBlocksByCondition(final XqdFileBlocksEntity xqdFileBlocks, final int type) {
        String orSql = "";
        if (type == 1) {
            orSql = " || '%'";
        } else {
            orSql = " '%'";
        }
        String finalOrSql = orSql;
        String sqlResult = new SQL(){{
            SELECT("BLOCK_ID AS blockId," +
                    "FILE_MD5 AS fileMd5," +
                    "BLOCK_NO AS blockNo," +
                    "BLOCK_MD5 AS blockMd5," +
                    "BLOCK_STATUS AS blockStatus," +
                    "BLOCK_SIZE AS blockSize," +
                    "MODIF_DATE AS modifDate," +
                    "PATH AS path," +
                    "COLUMN_9 AS column9," +
                    "COLUMN_10 AS column10," +
                    "COLUMN_11 AS column11"
            );
            FROM("imp_xqd_fileblocks");
            if (xqdFileBlocks.getBlockId() != null && !xqdFileBlocks.getBlockId().equals("")) {
                WHERE("BLOCK_ID like #{xqdFileBlocks.blockId}" + finalOrSql);
            }
            if (xqdFileBlocks.getFileMd5() != null && !xqdFileBlocks.getFileMd5().equals("")) {
                WHERE("FILE_MD5 like #{xqdFileBlocks.fileMd5}" + finalOrSql);
            }
            if (xqdFileBlocks.getBlockNo() != null) {
                WHERE("BLOCK_NO like #{xqdFileBlocks.blockNo}" + finalOrSql);
            }
            if (xqdFileBlocks.getBlockMd5() != null && !xqdFileBlocks.getBlockMd5().equals("")) {
                WHERE("BLOCK_MD5 like #{xqdFileBlocks.blockMd5}" + finalOrSql);
            }
            if (xqdFileBlocks.getBlockStatus() != null) {
                WHERE("BLOCK_STATUS like #{xqdFileBlocks.blockStatus}" + finalOrSql);
            }
            if (xqdFileBlocks.getBlockSize() != null) {
                WHERE("BLOCK_SIZE like #{xqdFileBlocks.blockSize}" + finalOrSql);
            }
            if (xqdFileBlocks.getModifDate() != null) {
                WHERE("MODIF_DATE like #{xqdFileBlocks.modifDate}" + finalOrSql);
            }
            if (xqdFileBlocks.getPath() != null && !xqdFileBlocks.getPath().equals("")) {
                WHERE("PATH like #{xqdFileBlocks.path}" + finalOrSql);
            }
            if (xqdFileBlocks.getColumn9() != null && !xqdFileBlocks.getColumn9().equals("")) {
                WHERE("COLUMN_9 like #{xqdFileBlocks.column9}" + finalOrSql);
            }
            if (xqdFileBlocks.getColumn10() != null && !xqdFileBlocks.getColumn10().equals("")) {
                WHERE("COLUMN_10 like #{xqdFileBlocks.column10}" + finalOrSql);
            }
            if (xqdFileBlocks.getColumn11() != null && !xqdFileBlocks.getColumn11().equals("")) {
                WHERE("COLUMN_11 like #{xqdFileBlocks.column11}" + finalOrSql);
            }
        }}.toString();

        if (xqdFileBlocks.getOrders() != null && xqdFileBlocks.getOrders().size() > 0) {
            Map<String, String> orderMap = xqdFileBlocks.getOrders();
            int count = 0;
            sqlResult = sqlResult + " ORDER BY ";
            for (String order : orderMap.keySet()) {
                if (count != 0) {
                    order = ", " + order;
                }
                if (XqdFileBlocksEntity.DESC.equals(orderMap.get(order))) {
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
