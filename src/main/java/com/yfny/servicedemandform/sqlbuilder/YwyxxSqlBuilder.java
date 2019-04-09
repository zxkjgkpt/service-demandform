package com.yfny.servicedemandform.sqlbuilder;

import com.yfny.corepojo.entity.demandform.YwyxxEntity;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 * 需求单业务域详情SqlBuilder
 * Author auto
 * Date  2019-04-09
 */
public class YwyxxSqlBuilder {

    /**
     * 根据实体中的属性值进行查询，查询条件使用LIKE，多条件并列查询取交集
     *
     * @param   ywyxx    对象实体
     * @return  Sql语句
     */
    public String buildFindYwyxxByAndCondition(final YwyxxEntity ywyxx) {
        return buildFindYwyxxByCondition(ywyxx, 0);
    }

    /**
     * 根据实体中的属性值进行查询，查询条件使用LIKE，多条件亦或查询取并集
     *
     * @param   ywyxx    对象实体
     * @return  Sql语句
     */
    public String buildFindYwyxxByORCondition(final YwyxxEntity ywyxx) {
        return buildFindYwyxxByCondition(ywyxx, 1);
    }

    private String buildFindYwyxxByCondition(final YwyxxEntity ywyxx, final int type) {
        String orSql = "";
        if (type == 1) {
            orSql = " || '%'";
        } else {
            orSql = " '%'";
        }
        String finalOrSql = orSql;
        String sqlResult = new SQL(){{
            SELECT("*");
            FROM("imp_xqd_ywyxx");
            if (ywyxx.getYwybs() != null && !ywyxx.getYwybs().equals("")) {
                WHERE("YWYBS like #{ywyxx.ywybs}" + finalOrSql);
            }
            if (ywyxx.getXqdh() != null && !ywyxx.getXqdh().equals("")) {
                WHERE("XQDH like #{ywyxx.xqdh}" + finalOrSql);
            }
            if (ywyxx.getSsywy() != null && !ywyxx.getSsywy().equals("")) {
                WHERE("SSYWY like #{ywyxx.ssywy}" + finalOrSql);
            }
            if (ywyxx.getSsywfl() != null && !ywyxx.getSsywfl().equals("")) {
                WHERE("SSYWFL like #{ywyxx.ssywfl}" + finalOrSql);
            }
            if (ywyxx.getSsywmc() != null && !ywyxx.getSsywmc().equals("")) {
                WHERE("SSYWMC like #{ywyxx.ssywmc}" + finalOrSql);
            }
            if (ywyxx.getSsywms() != null && !ywyxx.getSsywms().equals("")) {
                WHERE("SSYWMS like #{ywyxx.ssywms}" + finalOrSql);
            }
            if (ywyxx.getSsywgfcl() != null && !ywyxx.getSsywgfcl().equals("")) {
                WHERE("SSYWGFCL like #{ywyxx.ssywgfcl}" + finalOrSql);
            }
            if (ywyxx.getYwlcmc() != null && !ywyxx.getYwlcmc().equals("")) {
                WHERE("YWLCMC like #{ywyxx.ywlcmc}" + finalOrSql);
            }
            if (ywyxx.getYwlcms() != null && !ywyxx.getYwlcms().equals("")) {
                WHERE("YWLCMS like #{ywyxx.ywlcms}" + finalOrSql);
            }
            if (ywyxx.getYwlcgfcl() != null && !ywyxx.getYwlcgfcl().equals("")) {
                WHERE("YWLCGFCL like #{ywyxx.ywlcgfcl}" + finalOrSql);
            }
            if (ywyxx.getLcjdmc() != null && !ywyxx.getLcjdmc().equals("")) {
                WHERE("LCJDMC like #{ywyxx.lcjdmc}" + finalOrSql);
            }
            if (ywyxx.getLcjdms() != null && !ywyxx.getLcjdms().equals("")) {
                WHERE("LCJDMS like #{ywyxx.lcjdms}" + finalOrSql);
            }
            if (ywyxx.getLcjdgfcl() != null && !ywyxx.getLcjdgfcl().equals("")) {
                WHERE("LCJDGFCL like #{ywyxx.lcjdgfcl}" + finalOrSql);
            }
        }}.toString();

        if (ywyxx.getOrders() != null && ywyxx.getOrders().size() > 0) {
            Map<String, String> orderMap = ywyxx.getOrders();
            int count = 0;
            sqlResult = sqlResult + " ORDER BY ";
            for (String order : orderMap.keySet()) {
                if (count != 0) {
                    order = ", " + order;
                }
                if (YwyxxEntity.DESC.equals(orderMap.get(order))) {
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
