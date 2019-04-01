package com.yfny.servicedemandform.controller;

import com.yfny.corepojo.entity.demandform.XqdxxEntity;
import com.yfny.servicedemandform.service.BaseServiceImpl;
import com.yfny.servicedemandform.service.XqdxxServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 需求单详情Controller
 * Author auto
 * Date  2019-04-02
 */
@RestController
@RequestMapping(value = "/xqdxx")
public class XqdxxController extends BaseController<XqdxxEntity> {

    @Autowired
    private XqdxxServiceImpl xqdxxService;

    @Override
    public BaseServiceImpl<XqdxxEntity> getBaseService() {
        return this.xqdxxService;
    }

    /**
     * 根据实体中的属性值进行查询，查询条件使用等号
     * @param   xqdxx    对象实体
     * @param   orders    排序字段
     * @return  对象列表
     */
    @PostMapping(value = "/findXqdxxByCondition")
    @ResponseBody
    public List<XqdxxEntity> findXqdxxByCondition1(XqdxxEntity xqdxx, String... orders) throws Exception {
        List<XqdxxEntity> result = xqdxxService.findXqdxxByCondition(xqdxx, orders);
        if (result == null) {
            result = new ArrayList<>();
        }
        return result;
    }

    /**
     * 根据实体中的属性值进行查询，查询条件使用等号，分页返回
     * @param   xqdxx    对象实体
     * @param   pageNum   页数
     * @param   pageSize  每页数量
     * @param   orders    排序字段
     * @return  对象列表
     */
    @PostMapping(value = "/findXqdxxByCondition/{pageNum}/{pageSize}")
    @ResponseBody
    public List<XqdxxEntity> findXqdxxByCondition2(XqdxxEntity xqdxx,
                @PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize, String... orders) throws Exception {
        List<XqdxxEntity> result = xqdxxService.findXqdxxByCondition(xqdxx, pageNum, pageSize, orders);
        if (result == null) {
            result = new ArrayList<>();
        }
        return result;
    }

}
