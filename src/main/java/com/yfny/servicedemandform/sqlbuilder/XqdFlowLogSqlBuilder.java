package com.yfny.servicedemandform.sqlbuilder;

import com.yfny.corepojo.entity.demandform.XqdFlowLogEntity;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 * 需求单操作记录SqlBuilder
 * Author auto
 * Date  2019-05-08
 */
public class XqdFlowLogSqlBuilder {

    /**
     * 根据实体中的属性值进行查询，查询条件使用LIKE，多条件并列查询取交集
     *
     * @param   xqdFlowLog    对象实体
     * @return  Sql语句
     */
    public String buildFindXqdFlowLogByAndCondition(final XqdFlowLogEntity xqdFlowLog) {
        return buildFindXqdFlowLogByCondition(xqdFlowLog, 0);
    }

    /**
     * 根据实体中的属性值进行查询，查询条件使用LIKE，多条件亦或查询取并集
     *
     * @param   xqdFlowLog    对象实体
     * @return  Sql语句
     */
    public String buildFindXqdFlowLogByORCondition(final XqdFlowLogEntity xqdFlowLog) {
        return buildFindXqdFlowLogByCondition(xqdFlowLog, 1);
    }

    private String buildFindXqdFlowLogByCondition(final XqdFlowLogEntity xqdFlowLog, final int type) {
        String orSql = "";
        if (type == 1) {
            orSql = " || '%'";
        } else {
            orSql = " '%'";
        }
        String finalOrSql = orSql;
        String sqlResult = new SQL() {{
            SELECT(
                    "ID AS id," +
                    "DH AS dh," +
                    "LX AS lx," +
                    "GDZT AS gdzt," +
                    "KSSJ AS kssj," +
                    "JSSJ AS jssj," +
                    "CLRID AS clrid," +
                    "CLRMC AS clrmc," +
                    "RZJL AS rzjl," +
                    "ZFYY AS zfyy"
                   );
            FROM("imp_flow_log");
            if (xqdFlowLog.getId() != null && !xqdFlowLog.getId().equals("")) {
                WHERE("ID like #{xqdFlowLog.id}" + finalOrSql);
            }
            if (xqdFlowLog.getDh() != null && !xqdFlowLog.getDh().equals("")) {
                WHERE("DH like #{xqdFlowLog.dh}" + finalOrSql);
            }
            if (xqdFlowLog.getLx() != 0) {
                WHERE("LX like #{xqdFlowLog.lx}" + finalOrSql);
            }
            if (xqdFlowLog.getGdzt() != null && !xqdFlowLog.getGdzt().equals("")) {
                WHERE("GDZT like #{xqdFlowLog.gdzt}" + finalOrSql);
            }
            if (xqdFlowLog.getKssj() != null && !xqdFlowLog.getKssj().equals("")) {
                WHERE("KSSJ like #{xqdFlowLog.kssj}" + finalOrSql);
            }
            if (xqdFlowLog.getJssj() != null && !xqdFlowLog.getJssj().equals("")) {
                WHERE("JSSJ like #{xqdFlowLog.jssj}" + finalOrSql);
            }
            if (xqdFlowLog.getClrid() != null && !xqdFlowLog.getClrid().equals("")) {
                WHERE("CLRID like #{xqdFlowLog.clrid}" + finalOrSql);
            }
            if (xqdFlowLog.getClrmc() != null && !xqdFlowLog.getClrmc().equals("")) {
                WHERE("CLRMC like #{xqdFlowLog.clrmc}" + finalOrSql);
            }
            if (xqdFlowLog.getRzjl() != null && !xqdFlowLog.getRzjl().equals("")) {
                WHERE("RZJL like #{xqdFlowLog.rzjl}" + finalOrSql);
            }
            if (xqdFlowLog.getZfyy() != null && !xqdFlowLog.getZfyy().equals("")) {
                WHERE("ZFYY like #{xqdFlowLog.zfyy}" + finalOrSql);
            }
        }}.toString();

        if (xqdFlowLog.getOrders() != null && xqdFlowLog.getOrders().size() > 0) {
            Map<String, String> orderMap = xqdFlowLog.getOrders();
            int count = 0;
            sqlResult = sqlResult + " ORDER BY ";
            for (String order : orderMap.keySet()) {
                if (count != 0) {
                    order = ", " + order;
                }
                if (XqdFlowLogEntity.DESC.equals(orderMap.get(order))) {
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
