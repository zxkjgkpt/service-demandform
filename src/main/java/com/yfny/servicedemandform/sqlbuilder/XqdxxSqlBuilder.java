package com.yfny.servicedemandform.sqlbuilder;

import com.yfny.corepojo.entity.demandform.XqdxxEntity;
import org.apache.ibatis.jdbc.SQL;

/**
 * 需求单详情SqlBuilder
 * Author auto
 * Date  2019-04-02
 */
public class XqdxxSqlBuilder {

    /**
     * 根据实体中的属性值进行查询，查询条件使用等号
     *
     * @param   xqdxx    对象实体
     * @return  Sql语句
     */
    public String buildFindXqdxxByCondition(final XqdxxEntity xqdxx) {
        return new SQL(){{
            SELECT("*");
            FROM("imp_xqd_xqdxx");
            if (xqdxx.getXqdh() != null && !xqdxx.getXqdh().equals("")) {
                WHERE("XQDH like #{xqdxx.xqdh} || '%'");
            }
            if (xqdxx.getSqbmmc() != null && !xqdxx.getSqbmmc().equals("")) {
                WHERE("SQBMMC like #{xqdxx.sqbmmc} || '%'");
            }
            if (xqdxx.getTcsj() != null && !xqdxx.getTcsj().equals("")) {
                WHERE("TCSJ like #{xqdxx.tcsj} || '%'");
            }
            if (xqdxx.getXqmc() != null && !xqdxx.getXqmc().equals("")) {
                WHERE("XQMC like #{xqdxx.xqmc} || '%'");
            }
            if (xqdxx.getSqrxm() != null && !xqdxx.getSqrxm().equals("")) {
                WHERE("SQRXM like #{xqdxx.sqrxm} || '%'");
            }
            if (xqdxx.getSqrlxfs() != null && !xqdxx.getSqrlxfs().equals("")) {
                WHERE("SQRLXFS like #{xqdxx.sqrlxfs} || '%'");
            }
            if (xqdxx.getSqryx() != null && !xqdxx.getSqryx().equals("")) {
                WHERE("SQRYX like #{xqdxx.sqryx} || '%'");
            }
            if (xqdxx.getXqfl() != null && !xqdxx.getXqfl().equals("")) {
                WHERE("XQFL like #{xqdxx.xqfl} || '%'");
            }
            if (xqdxx.getQwwcsj() != null && !xqdxx.getQwwcsj().equals("")) {
                WHERE("QWWCSJ like #{xqdxx.qwwcsj} || '%'");
            }
            if (xqdxx.getCjrid() != null && !xqdxx.getCjrid().equals("")) {
                WHERE("CJRID like #{xqdxx.cjrid} || '%'");
            }
            if (xqdxx.getCjsj() != null && !xqdxx.getCjsj().equals("")) {
                WHERE("CJSJ like #{xqdxx.cjsj} || '%'");
            }
            if (xqdxx.getShrid() != null && !xqdxx.getShrid().equals("")) {
                WHERE("SHRID like #{xqdxx.shrid} || '%'");
            }
            if (xqdxx.getDshr() != null && !xqdxx.getDshr().equals("")) {
                WHERE("SHR like #{xqdxx.dshr} || '%'");
            }
            if (xqdxx.getShyj() != null && !xqdxx.getShyj().equals("")) {
                WHERE("SHYJ like #{xqdxx.shyj} || '%'");
            }
            if (xqdxx.getShsj() != null && !xqdxx.getShsj().equals("")) {
                WHERE("SHSJ like #{xqdxx.shsj} || '%'");
            }
            if (xqdxx.getGdzt() != null && !xqdxx.getGdzt().equals("")) {
                WHERE("GDZT like #{xqdxx.gdzt} || '%'");
            }
            if (xqdxx.getTjsj() != null && !xqdxx.getTjsj().equals("")) {
                WHERE("TJSJ like #{xqdxx.tjsj} || '%'");
            }
            if (xqdxx.getXqzs() != null && !xqdxx.getXqzs().equals("")) {
                WHERE("XQZS like #{xqdxx.xqzs} || '%'");
            }
            if (xqdxx.getZzid() != null && !xqdxx.getZzid().equals("")) {
                WHERE("ZZID like #{xqdxx.zzid} || '%'");
            }
            if (xqdxx.getBmjb() != null && !xqdxx.getBmjb().equals("")) {
                WHERE("BMJB like #{xqdxx.bmjb} || '%'");
            }
            if (xqdxx.getWjshqr() != null && !xqdxx.getWjshqr().equals("")) {
                WHERE("WJSHQR like #{xqdxx.wjshqr} || '%'");
            }
            if (xqdxx.getSshrid() != null && !xqdxx.getSshrid().equals("")) {
                WHERE("SSHRID like #{xqdxx.sshrid} || '%'");
            }
            if (xqdxx.getSshr() != null && !xqdxx.getSshr().equals("")) {
                WHERE("SSHR like #{xqdxx.sshr} || '%'");
            }
            if (xqdxx.getSshyj() != null && !xqdxx.getSshyj().equals("")) {
                WHERE("SSHYJ like #{xqdxx.sshyj} || '%'");
            }
            if (xqdxx.getSshsj() != null && !xqdxx.getSshsj().equals("")) {
                WHERE("SSHSJ like #{xqdxx.sshsj} || '%'");
            }
            if (xqdxx.getWshrid() != null && !xqdxx.getWshrid().equals("")) {
                WHERE("WSHRID like #{xqdxx.wshrid} || '%'");
            }
            if (xqdxx.getWshr() != null && !xqdxx.getWshr().equals("")) {
                WHERE("WSHR like #{xqdxx.wshr} || '%'");
            }
            if (xqdxx.getWshyj() != null && !xqdxx.getWshyj().equals("")) {
                WHERE("WSHYJ like #{xqdxx.wshyj} || '%'");
            }
            if (xqdxx.getWshsj() != null && !xqdxx.getWshsj().equals("")) {
                WHERE("WSHSJ like #{xqdxx.wshsj} || '%'");
            }
            if (xqdxx.getZylb() != null && !xqdxx.getZylb().equals("")) {
                WHERE("ZYLB like #{xqdxx.zylb} || '%'");
            }
            if (xqdxx.getShtlsj() != null) {
                WHERE("SHTLSJ like #{xqdxx.shtlsj} || '%'");
            }
            if (xqdxx.getSjshqr() != null && !xqdxx.getSjshqr().equals("")) {
                WHERE("SJSHQR like #{xqdxx.sjshqr} || '%'");
            }
            if (xqdxx.getTaskId() != null && !xqdxx.getTaskId().equals("")) {
                WHERE("TASK_ID like #{xqdxx.taskId} || '%'");
            }
            if (xqdxx.getOrders() != null && xqdxx.getOrders().length > 0) {
                ORDER_BY(xqdxx.getOrders());
            }
        }}.toString();
    }
}
