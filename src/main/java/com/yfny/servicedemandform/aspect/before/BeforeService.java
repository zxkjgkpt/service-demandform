package com.yfny.servicedemandform.aspect.before;

import com.yfny.corepojo.entity.demandform.XqdxxEntity;
import com.yfny.corepojo.entity.demandform.YwyxxEntity;
import com.yfny.corepojo.entity.demandform.YyyxxEntity;
import com.yfny.servicedemandform.composite.XqdxxComposite;
import com.yfny.servicedemandform.composite.YwyxxComposite;
import com.yfny.servicedemandform.composite.YyyxxComposite;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by jisongZhou on 2019/5/8.
 **/
@Aspect
@Component
public class BeforeService {

    /**
     * 前置通知
     */
    @Before(value = "execution(public * com.yfny.utilscommon.basemvc.producer.BaseServiceImpl.insertSelective(..))")
    public void doBefore(JoinPoint joinPoint) {
        //获取参数
        Object[] args = joinPoint.getArgs();
        XqdxxEntity param = (XqdxxEntity) args[0];

        XqdxxComposite xqdxxComposite = XqdxxComposite.xqdxxComposite;
        xqdxxComposite.clear();
        xqdxxComposite.setParam(param);
        List<YwyxxEntity> ywyxxList = param.getYwyxxList();
        List<YyyxxEntity> yyyxxList = param.getYyyxxList();
        if (ywyxxList != null && ywyxxList.size() > 0) {
            for (YwyxxEntity ywyxxEntity : ywyxxList) {
                ywyxxEntity.setXqdh(param.getXqdh());
                YwyxxComposite ywyxxComposite0 = YwyxxComposite.ywyxxComposite;
                YwyxxComposite ywyxxComposite = new YwyxxComposite();
                ywyxxComposite.setBaseMapper(ywyxxComposite0.getBaseMapper());
                ywyxxComposite.setParam(ywyxxEntity);
                xqdxxComposite.add(ywyxxComposite);
            }
        }
        if (yyyxxList != null && yyyxxList.size() > 0) {
            for (YyyxxEntity yyyxxEntity : yyyxxList) {
                yyyxxEntity.setXqdh(param.getXqdh());
                YyyxxComposite yyyxxComposite0 = YyyxxComposite.yyyxxComposite;
                YyyxxComposite yyyxxComposite = new YyyxxComposite();
                yyyxxComposite.setBaseMapper(yyyxxComposite0.getBaseMapper());
                yyyxxComposite.setParam(yyyxxEntity);
                xqdxxComposite.add(yyyxxComposite);
            }
        }

    }

}
