package com.yfny.servicedemandform.sqlbuilder;

import com.yfny.corepojo.entity.demandform.YyyxxEntity;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 * 需求单应用域详情SqlBuilder
 * Author auto
 * Date  2019-04-09
 */
public class YyyxxSqlBuilder {

    /**
     * 根据实体中的属性值进行查询，查询条件使用LIKE，多条件并列查询取交集
     *
     * @param   yyyxx    对象实体
     * @return  Sql语句
     */
    public String buildFindYyyxxByAndCondition(final YyyxxEntity yyyxx) {
        return buildFindYyyxxByCondition(yyyxx, 0);
    }

    /**
     * 根据实体中的属性值进行查询，查询条件使用LIKE，多条件亦或查询取并集
     *
     * @param   yyyxx    对象实体
     * @return  Sql语句
     */
    public String buildFindYyyxxByORCondition(final YyyxxEntity yyyxx) {
        return buildFindYyyxxByCondition(yyyxx, 1);
    }

    private String buildFindYyyxxByCondition(final YyyxxEntity yyyxx, final int type) {
        String orSql = "";
        if (type == 1) {
            orSql = " || '%'";
        } else {
            orSql = " '%'";
        }
        String finalOrSql = orSql;
        String sqlResult = new SQL(){{
            SELECT("*");
            FROM("imp_xqd_yyyxx");
            if (yyyxx.getYyybs() != null && !yyyxx.getYyybs().equals("")) {
                WHERE("YYYBS like #{yyyxx.yyybs}" + finalOrSql);
            }
            if (yyyxx.getXqdh() != null && !yyyxx.getXqdh().equals("")) {
                WHERE("XQDH like #{yyyxx.xqdh}" + finalOrSql);
            }
            if (yyyxx.getYyy() != null && !yyyxx.getYyy().equals("")) {
                WHERE("YYY like #{yyyxx.yyy}" + finalOrSql);
            }
            if (yyyxx.getYy() != null && !yyyxx.getYy().equals("")) {
                WHERE("YY like #{yyyxx.yy}" + finalOrSql);
            }
            if (yyyxx.getYymkmc() != null && !yyyxx.getYymkmc().equals("")) {
                WHERE("YYMKMC like #{yyyxx.yymkmc}" + finalOrSql);
            }
            if (yyyxx.getYymkms() != null && !yyyxx.getYymkms().equals("")) {
                WHERE("YYMKMS like #{yyyxx.yymkms}" + finalOrSql);
            }
            if (yyyxx.getYygnmc() != null && !yyyxx.getYygnmc().equals("")) {
                WHERE("YYGNMC like #{yyyxx.yygnmc}" + finalOrSql);
            }
            if (yyyxx.getYygdms() != null && !yyyxx.getYygdms().equals("")) {
                WHERE("YYGDMS like #{yyyxx.yygdms}" + finalOrSql);
            }
            if (yyyxx.getFgnxq() != null && !yyyxx.getFgnxq().equals("")) {
                WHERE("FGNXQ like #{yyyxx.fgnxq}" + finalOrSql);
            }
        }}.toString();

        if (yyyxx.getOrders() != null && yyyxx.getOrders().size() > 0) {
            Map<String, String> orderMap = yyyxx.getOrders();
            int count = 0;
            sqlResult = sqlResult + " ORDER BY ";
            for (String order : orderMap.keySet()) {
                if (count != 0) {
                    order = ", " + order;
                }
                if (YyyxxEntity.DESC.equals(orderMap.get(order))) {
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
