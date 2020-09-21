package com.cluster.midware.common.spring;

import com.cluster.midware.config.ServiceBeanConfig;
import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @program: platform-aimb
 * @description: 以静态变量保存Spring ApplicationContext 可以在任何代码任何地方任何时候取出ApplicationContext
 * @author: fuyl
 * @create: 2019-07-26 11:49
 **/
@Component
public class SpringContextHolder implements ApplicationContextAware, DisposableBean {

    public static ApplicationContext applicationContext = null;

    public Logger Logger = LoggerFactory.getLogger(SpringContextHolder.class);


    /*** 
    * @Description: 取得静态变量中的applicationcontext
    * @Param: [] 
    * @return: org.springframework.context.ApplicationContext 
    * @Author: fuyl 
    * @Date: 2019/7/26 
    */ 
    public ApplicationContext getApplicationContext(){
        assertContextInjected();
        return applicationContext;
    }

    /**
     * 从静态变量applicationContext中取得Bean, 自动转型为所赋值对象的类型.
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(String name) {
        assertContextInjected();
        return (T) applicationContext.getBean(name);
    }

    /**
     * 从静态变量applicationContext中取得Bean, 自动转型为所赋值对象的类型.
     */
    public static <T> T getBean(Class<T> requiredType) {
        assertContextInjected();
        return applicationContext.getBean(requiredType);
    }

    /**
     * 清除SpringContextHolder中的ApplicationContext为Null.
     */
    public static void clearHolder() {
        applicationContext = null;
    }

    /**
     * 实现ApplicationContextAware接口, 注入Context到静态变量中.
     */
    @Override
    public void setApplicationContext(ApplicationContext appContext) {
        applicationContext = appContext;

//        ServiceBeanConfig.pushConfig = SpringContextHolder.getBean("pushConfig");
//        ServiceBeanConfig.jsonAdaptor = SpringContextHolder.getBean("jsonAdaptor");
//        ServiceBeanConfig.baseComponent = SpringContextHolder.getBean("baseComponent");

        /**middle repo**/
//        ServiceBeanConfig.middleRepoService =  SpringContextHolder.getBean("middleRepoService");
//        ServiceBeanConfig.aimbRepoService = SpringContextHolder.getBean("aimbRepoService");
        ServiceBeanConfig.dataSource = SpringContextHolder.getBean("dataSource");
    }

    /**
     * 实现DisposableBean接口, 在Context关闭时清理静态变量.
     */
    @Override
    public void destroy() throws Exception {
        SpringContextHolder.clearHolder();
    }

    /**
     * 检查ApplicationContext不为空.
     */
    private static void assertContextInjected() {
        Validate.validState(applicationContext != null, "applicaitonContext属性未注入, 请在applicationContext.xml中定义SpringContextHolder.");
    }

}
