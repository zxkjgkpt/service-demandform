package com.yfny.servicedemandform.sqlbuilder;

import com.yfny.corepojo.entity.demandform.XqdxxEntity;
import org.apache.ibatis.jdbc.SQL;

import java.text.SimpleDateFormat;
import java.util.Map;

/**
 * 需求单详情SqlBuilder
 * Author auto
 * Date  2019-04-03
 */
public class XqdxxSqlBuilder {
    //创建单号
    public String createDh(){
        String sqlResult = new SQL() {{
            SELECT("nextval('xqd')");
            FROM("DUAL");
        }}.toString();
        return sqlResult;
    }
    /**
     * 根据实体中的属性值进行查询，查询条件使用LIKE，多条件并列查询取交集
     *
     * @param xqdxx 对象实体
     * @return Sql语句
     */
    public String buildFindXqdxxByAndCondition(final XqdxxEntity xqdxx) {
        return buildFindXqdxxByCondition(xqdxx, 0);
    }

    /**
     * 根据实体中的属性值进行查询，查询条件使用LIKE，多条件亦或查询取并集
     *
     * @param xqdxx 对象实体
     * @return Sql语句
     */
    public String buildFindXqdxxByORCondition(final XqdxxEntity xqdxx) {
        return buildFindXqdxxByCondition(xqdxx, 1);
    }

    private String buildFindXqdxxByCondition(final XqdxxEntity xqdxx, final int type) {
        String orSql = "";
        if (type == 1) {
            orSql = " || '%'";
        } else {
            orSql = " '%'";
        }
        String finalOrSql = orSql;
        String sqlResult = new SQL() {{
            SELECT("*, TASK_ID AS taskId");
            FROM("imp_xqd_xqdxx");
            if (xqdxx.getXqdh() != null && !xqdxx.getXqdh().equals("")) {
                //将中文逗号替换成英文逗号
                xqdxx.setXqdh(xqdxx.getXqdh().replace("，", ","));
                WHERE("XQDH IN (" + xqdxx.getXqdh() + ")");
            }
            if (xqdxx.getSqbmmc() != null && !xqdxx.getSqbmmc().equals("")) {
                WHERE("SQBMMC like #{xqdxx.sqbmmc}" + finalOrSql);
            }
            if (xqdxx.getTcsj() != null && !xqdxx.getTcsj().equals("")) {
                WHERE("TCSJ like #{xqdxx.tcsj}" + finalOrSql);
            }
            if (xqdxx.getXqmc() != null && !xqdxx.getXqmc().equals("")) {
                WHERE("XQMC like #{xqdxx.xqmc}" + finalOrSql);
            }
            if (xqdxx.getSqrxm() != null && !xqdxx.getSqrxm().equals("")) {
                WHERE("SQRXM like #{xqdxx.sqrxm}" + finalOrSql);
            }
            if (xqdxx.getSqrlxfs() != null && !xqdxx.getSqrlxfs().equals("")) {
                WHERE("SQRLXFS like #{xqdxx.sqrlxfs}" + finalOrSql);
            }
            if (xqdxx.getSqryx() != null && !xqdxx.getSqryx().equals("")) {
                WHERE("SQRYX like #{xqdxx.sqryx}" + finalOrSql);
            }
            if (xqdxx.getXqfl() != null && !xqdxx.getXqfl().equals("")) {
                WHERE("XQFL like #{xqdxx.xqfl}" + finalOrSql);
            }
            if (xqdxx.getQwwcsj() != null && !xqdxx.getQwwcsj().equals("")) {
                WHERE("QWWCSJ like #{xqdxx.qwwcsj}" + finalOrSql);
            }
            if (xqdxx.getCjrid() != null && !xqdxx.getCjrid().equals("")) {
                WHERE("CJRID like #{xqdxx.cjrid}" + finalOrSql);
            }
            if (xqdxx.getCjsj() != null && !xqdxx.getCjsj().equals("")) {
                WHERE("CJSJ like #{xqdxx.cjsj}" + finalOrSql);
            }
            if (xqdxx.getShrid() != null && !xqdxx.getShrid().equals("")) {
                WHERE("SHRID like #{xqdxx.shrid}" + finalOrSql);
            }
            if (xqdxx.getDshr() != null && !xqdxx.getDshr().equals("")) {
                WHERE("SHR like #{xqdxx.dshr}" + finalOrSql);
            }
            if (xqdxx.getShyj() != null && !xqdxx.getShyj().equals("")) {
                WHERE("SHYJ like #{xqdxx.shyj}" + finalOrSql);
            }
            if (xqdxx.getShsj() != null && !xqdxx.getShsj().equals("")) {
                WHERE("SHSJ like #{xqdxx.shsj}" + finalOrSql);
            }
            if (xqdxx.getGdzt() != null && !xqdxx.getGdzt().equals("")) {
                WHERE("GDZT like #{xqdxx.gdzt}" + finalOrSql);
            }
            if (xqdxx.getTjsj() != null && !xqdxx.getTjsj().equals("")) {
                WHERE("TJSJ like #{xqdxx.tjsj}" + finalOrSql);
            }
            if (xqdxx.getXqzs() != null && !xqdxx.getXqzs().equals("")) {
                WHERE("XQZS like #{xqdxx.xqzs}" + finalOrSql);
            }
            if (xqdxx.getZzid() != null && !xqdxx.getZzid().equals("")) {
                //将中文逗号替换成英文逗号
                xqdxx.setZzid(xqdxx.getZzid().replace("，", ","));
                WHERE("ZZID IN (" + xqdxx.getZzid() + ")");
            }
            if (xqdxx.getBmjb() != null && !xqdxx.getBmjb().equals("")) {
                WHERE("BMJB like #{xqdxx.bmjb}" + finalOrSql);
            }
            if (xqdxx.getWjshqr() != null && !xqdxx.getWjshqr().equals("")) {
                WHERE("WJSHQR like #{xqdxx.wjshqr}" + finalOrSql);
            }
            if (xqdxx.getSshrid() != null && !xqdxx.getSshrid().equals("")) {
                WHERE("SSHRID like #{xqdxx.sshrid}" + finalOrSql);
            }
            if (xqdxx.getSshr() != null && !xqdxx.getSshr().equals("")) {
                WHERE("SSHR like #{xqdxx.sshr}" + finalOrSql);
            }
            if (xqdxx.getSshyj() != null && !xqdxx.getSshyj().equals("")) {
                WHERE("SSHYJ like #{xqdxx.sshyj}" + finalOrSql);
            }
            if (xqdxx.getSshsj() != null && !xqdxx.getSshsj().equals("")) {
                WHERE("SSHSJ like #{xqdxx.sshsj}" + finalOrSql);
            }
            if (xqdxx.getWshrid() != null && !xqdxx.getWshrid().equals("")) {
                WHERE("WSHRID like #{xqdxx.wshrid}" + finalOrSql);
            }
            if (xqdxx.getWshr() != null && !xqdxx.getWshr().equals("")) {
                WHERE("WSHR like #{xqdxx.wshr}" + finalOrSql);
            }
            if (xqdxx.getWshyj() != null && !xqdxx.getWshyj().equals("")) {
                WHERE("WSHYJ like #{xqdxx.wshyj}" + finalOrSql);
            }
            if (xqdxx.getWshsj() != null && !xqdxx.getWshsj().equals("")) {
                WHERE("WSHSJ like #{xqdxx.wshsj}" + finalOrSql);
            }
            if (xqdxx.getZylb() != null && !xqdxx.getZylb().equals("")) {
                WHERE("ZYLB like #{xqdxx.zylb}" + finalOrSql);
            }
            if (xqdxx.getShtlsj() != null) {
                WHERE("SHTLSJ like #{xqdxx.shtlsj}" + finalOrSql);
            }
            if (xqdxx.getSjshqr() != null && !xqdxx.getSjshqr().equals("")) {
                WHERE("SJSHQR like #{xqdxx.sjshqr}" + finalOrSql);
            }
            if (xqdxx.getTaskId() != null && !xqdxx.getTaskId().equals("")) {
                WHERE("TASK_ID like #{xqdxx.taskId}" + finalOrSql);
            }
            if (xqdxx.getFjbz() != null && !xqdxx.getFjbz().equals("")) {
                if (xqdxx.getFjbz().equals("TRUE")) {
                    WHERE("XQDH IN (SELECT PATH FROM imp_xqd_files)");
                } else {
                    WHERE("XQDH NOT IN (SELECT PATH FROM imp_xqd_files)");
                }

            }
            if (xqdxx.getStartTime() != null && !xqdxx.getStartTime().equals("")) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String date = null;
                try {
                    date = sdf.format(sdf.parse(xqdxx.getStartTime()));
                    xqdxx.setStartTime(date);
                    WHERE("CJSJ >= #{xqdxx.startTime}" + finalOrSql);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            if (xqdxx.getEndTime() != null && !xqdxx.getEndTime().equals("")) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String date = null;
                try {
                    date = sdf.format(sdf.parse(xqdxx.getEndTime()));
                    xqdxx.setEndTime(date);
                    WHERE("CJSJ <= #{xqdxx.endTime}" + finalOrSql);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }}.toString();

        if (xqdxx.getOrders() != null && xqdxx.getOrders().size() > 0) {
            Map<String, String> orderMap = xqdxx.getOrders();
            int count = 0;
            sqlResult = sqlResult + " ORDER BY ";
            for (String order : orderMap.keySet()) {
                if (count != 0) {
                    order = ", " + order;
                }
                if (XqdxxEntity.DESC.equals(orderMap.get(order))) {
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
