package com.yfny.servicedemandform.controller;

import com.yfny.corepojo.entity.demandform.XqdFileEntity;
import com.yfny.servicedemandform.service.BaseServiceImpl;
import com.yfny.servicedemandform.service.XqdFileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 需求单附件Controller
 * Author auto
 * Date  2019-04-10
 */
@RestController
@RequestMapping(value = "/xqdFile")
public class XqdFileController extends BaseController<XqdFileEntity> {

    @Autowired
    private XqdFileServiceImpl xqdFileService;

    @Override
    public BaseServiceImpl<XqdFileEntity> getBaseService() {
        return this.xqdFileService;
    }

    /**
     * 根据实体中的属性值进行查询，查询条件使用LIKE，并列查询取交集
     *
     * @param   xqdFile    对象实体
     * @return  返回对象列表为查询结果
     */
    @PostMapping(value = "/findXqdFileByAndCondition")
    @ResponseBody
    public List<XqdFileEntity> findXqdFileByAndCondition1(@RequestBody XqdFileEntity xqdFile) throws Exception {
        List<XqdFileEntity> result = xqdFileService.findXqdFileByAndCondition(xqdFile);
        if (result == null) {
            result = new ArrayList<>();
        }
        return result;
    }

    /**
     * 根据实体中的属性值进行查询，查询条件使用LIKE，并列查询取交集，分页返回
     *
     * @param   xqdFile    对象实体
     * @param   pageNum   页数
     * @param   pageSize  每页数量
     * @return  返回对象列表为查询结果
     */
    @PostMapping(value = "/findXqdFileByAndCondition/{pageNum}/{pageSize}")
    @ResponseBody
    public List<XqdFileEntity> findXqdFileByAndCondition2(@RequestBody XqdFileEntity xqdFile,
                @PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) throws Exception {
        List<XqdFileEntity> result = xqdFileService.findXqdFileByAndCondition(xqdFile, pageNum, pageSize);
        if (result == null) {
            result = new ArrayList<>();
        }
        return result;
    }

    /**
     * 根据实体中的属性值进行查询，查询条件使用LIKE，亦或查询取并集
     *
     * @param   xqdFile    对象实体
     * @return  返回对象列表为查询结果
     */
    @PostMapping(value = "/findXqdFileByORCondition")
    @ResponseBody
    public List<XqdFileEntity> findXqdFileByORCondition1(@RequestBody XqdFileEntity xqdFile) throws Exception {
        List<XqdFileEntity> result = xqdFileService.findXqdFileByORCondition(xqdFile);
        if (result == null) {
            result = new ArrayList<>();
        }
        return result;
    }

    /**
     * 根据实体中的属性值进行查询，查询条件使用LIKE，亦或查询取并集，分页返回
     *
     * @param   xqdFile    对象实体
     * @param   pageNum   页数
     * @param   pageSize  每页数量
     * @return  返回对象列表为查询结果
     */
    @PostMapping(value = "/findXqdFileByORCondition/{pageNum}/{pageSize}")
    @ResponseBody
    public List<XqdFileEntity> findXqdFileByORCondition2(@RequestBody XqdFileEntity xqdFile,
                @PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) throws Exception {
        List<XqdFileEntity> result = xqdFileService.findXqdFileByORCondition(xqdFile, pageNum, pageSize);
        if (result == null) {
            result = new ArrayList<>();
        }
        return result;
    }

}
