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
 * Date  2019-04-03
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
     * 根据实体中的属性值进行查询，查询条件使用LIKE，并列查询取交集
     *
     * @param   xqdxx    对象实体
     * @return  返回对象列表为查询结果
     */
    @PostMapping(value = "/findXqdxxByAndCondition")
    @ResponseBody
    public List<XqdxxEntity> findXqdxxByAndCondition1(@RequestBody XqdxxEntity xqdxx) throws Exception {
        List<XqdxxEntity> result = xqdxxService.findXqdxxByAndCondition(xqdxx);
        if (result == null) {
            result = new ArrayList<>();
        }
        return result;
    }

    /**
     * 根据实体中的属性值进行查询，查询条件使用LIKE，并列查询取交集，分页返回
     *
     * @param   xqdxx    对象实体
     * @param   pageNum   页数
     * @param   pageSize  每页数量
     * @return  返回对象列表为查询结果
     */
    @PostMapping(value = "/findXqdxxByAndCondition/{pageNum}/{pageSize}")
    @ResponseBody
    public List<XqdxxEntity> findXqdxxByAndCondition2(@RequestBody XqdxxEntity xqdxx,
                @PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) throws Exception {
        List<XqdxxEntity> result = xqdxxService.findXqdxxByAndCondition(xqdxx, pageNum, pageSize);
        if (result == null) {
            result = new ArrayList<>();
        }
        return result;
    }

    /**
     * 根据实体中的属性值进行查询，查询条件使用LIKE，亦或查询取并集
     *
     * @param   xqdxx    对象实体
     * @return  返回对象列表为查询结果
     */
    @PostMapping(value = "/findXqdxxByORCondition")
    @ResponseBody
    public List<XqdxxEntity> findXqdxxByORCondition1(@RequestBody XqdxxEntity xqdxx) throws Exception {
        List<XqdxxEntity> result = xqdxxService.findXqdxxByORCondition(xqdxx);
        if (result == null) {
            result = new ArrayList<>();
        }
        return result;
    }

    /**
     * 根据实体中的属性值进行查询，查询条件使用LIKE，亦或查询取并集，分页返回
     *
     * @param   xqdxx    对象实体
     * @param   pageNum   页数
     * @param   pageSize  每页数量
     * @return  返回对象列表为查询结果
     */
    @PostMapping(value = "/findXqdxxByORCondition/{pageNum}/{pageSize}")
    @ResponseBody
    public List<XqdxxEntity> findXqdxxByORCondition2(@RequestBody XqdxxEntity xqdxx,
                @PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) throws Exception {
        List<XqdxxEntity> result = xqdxxService.findXqdxxByORCondition(xqdxx, pageNum, pageSize);
        if (result == null) {
            result = new ArrayList<>();
        }
        return result;
    }

}
