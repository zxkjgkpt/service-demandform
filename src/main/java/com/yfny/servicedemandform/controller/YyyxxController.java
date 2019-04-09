package com.yfny.servicedemandform.controller;

import com.yfny.corepojo.entity.demandform.YyyxxEntity;
import com.yfny.servicedemandform.service.BaseServiceImpl;
import com.yfny.servicedemandform.service.YyyxxServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 需求单应用域详情Controller
 * Author auto
 * Date  2019-04-09
 */
@RestController
@RequestMapping(value = "/yyyxx")
public class YyyxxController extends BaseController<YyyxxEntity> {

    @Autowired
    private YyyxxServiceImpl yyyxxService;

    @Override
    public BaseServiceImpl<YyyxxEntity> getBaseService() {
        return this.yyyxxService;
    }

    /**
     * 根据实体中的属性值进行查询，查询条件使用LIKE，并列查询取交集
     *
     * @param   yyyxx    对象实体
     * @return  返回对象列表为查询结果
     */
    @PostMapping(value = "/findYyyxxByAndCondition")
    @ResponseBody
    public List<YyyxxEntity> findYyyxxByAndCondition1(@RequestBody YyyxxEntity yyyxx) throws Exception {
        List<YyyxxEntity> result = yyyxxService.findYyyxxByAndCondition(yyyxx);
        if (result == null) {
            result = new ArrayList<>();
        }
        return result;
    }

    /**
     * 根据实体中的属性值进行查询，查询条件使用LIKE，并列查询取交集，分页返回
     *
     * @param   yyyxx    对象实体
     * @param   pageNum   页数
     * @param   pageSize  每页数量
     * @return  返回对象列表为查询结果
     */
    @PostMapping(value = "/findYyyxxByAndCondition/{pageNum}/{pageSize}")
    @ResponseBody
    public List<YyyxxEntity> findYyyxxByAndCondition2(@RequestBody YyyxxEntity yyyxx,
                @PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) throws Exception {
        List<YyyxxEntity> result = yyyxxService.findYyyxxByAndCondition(yyyxx, pageNum, pageSize);
        if (result == null) {
            result = new ArrayList<>();
        }
        return result;
    }

    /**
     * 根据实体中的属性值进行查询，查询条件使用LIKE，亦或查询取并集
     *
     * @param   yyyxx    对象实体
     * @return  返回对象列表为查询结果
     */
    @PostMapping(value = "/findYyyxxByORCondition")
    @ResponseBody
    public List<YyyxxEntity> findYyyxxByORCondition1(@RequestBody YyyxxEntity yyyxx) throws Exception {
        List<YyyxxEntity> result = yyyxxService.findYyyxxByORCondition(yyyxx);
        if (result == null) {
            result = new ArrayList<>();
        }
        return result;
    }

    /**
     * 根据实体中的属性值进行查询，查询条件使用LIKE，亦或查询取并集，分页返回
     *
     * @param   yyyxx    对象实体
     * @param   pageNum   页数
     * @param   pageSize  每页数量
     * @return  返回对象列表为查询结果
     */
    @PostMapping(value = "/findYyyxxByORCondition/{pageNum}/{pageSize}")
    @ResponseBody
    public List<YyyxxEntity> findYyyxxByORCondition2(@RequestBody YyyxxEntity yyyxx,
                @PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) throws Exception {
        List<YyyxxEntity> result = yyyxxService.findYyyxxByORCondition(yyyxx, pageNum, pageSize);
        if (result == null) {
            result = new ArrayList<>();
        }
        return result;
    }

}
