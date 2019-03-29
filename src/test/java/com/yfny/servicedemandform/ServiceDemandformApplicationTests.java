package com.yfny.servicedemandform;

import com.yfny.utilscommon.generator.entity.RequestInfo;
import com.yfny.utilscommon.generator.invoker.ProducerInvoker;
import com.yfny.utilscommon.generator.invoker.TestInvoker;
import com.yfny.utilscommon.generator.invoker.base.Invoker;
import com.yfny.utilscommon.util.CodeInfoUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.MethodParameter;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceDemandformApplicationTests {

    @Test
    public void contextLoads() {
        List<RequestInfo> requestInfoList = CodeInfoUtils.getRequestInfos();
        for (RequestInfo requestInfo : requestInfoList) {
            System.out.println("****************************************************");
            System.out.println("url: " + requestInfo.getUrl());
            System.out.println("methodName: " + requestInfo.getMethodName());
            System.out.println("requestMethod: " + requestInfo.getRequestMethod());
            String requestMethod = requestInfo.getRequestMethod();
            for (MethodParameter parameter : requestInfo.getRequestParams()) {
                System.out.println("requestParams: " + parameter.getParameter().getName() + "  requestParamsType: " + parameter.getParameter().getType());
            }
            System.out.println("****************************************************");
        }
    }
    
    @Test
    public void producerInvokerTest() {
        Invoker invoker = new ProducerInvoker.Builder()
                .setClassName("Xqdxx")
                .setDescription("需求单详情")
                .setFirst(true)
                .build();
        invoker.execute();
    }

    @Test
    public void initUnitTest() {
        Invoker invoker = new TestInvoker.Builder()
                .build();
        invoker.execute();
    }

}
