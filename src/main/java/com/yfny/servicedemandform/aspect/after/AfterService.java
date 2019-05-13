package com.yfny.servicedemandform.aspect.after;

import com.yfny.servicedemandform.composite.XqdxxComposite;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created by jisongZhou on 2019/5/8.
 **/
@Aspect
@Component
public class AfterService {

    /**
     * 后置通知
     *
     * @param jp
     */
    @After(value = "execution(public * com.yfny.servicedemandform.service.XqdxxServiceImpl.insertSelective(..))")
    public void afterInsert(JoinPoint jp) {
        XqdxxComposite.xqdxxComposite.clear();
    }

}
