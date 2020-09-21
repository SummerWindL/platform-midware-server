package com.cluster.midware.config;

import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * @program: middle-server
 * @description: 业务Bean获取 供线程方法调用
 * @author: fuyl
 * @create: 2020-06-03 16:43
 **/
@Component
public class ServiceBeanConfig {
//    public static  PushConfig pushConfig = null ; //    SpringContextHolder.getBean("pushConfig");
//    public static  JsonAdaptor jsonAdaptor = null ; //    SpringContextHolder.getBean("jsonAdaptor");
//    public static  BaseComponent baseComponent = null ; //    SpringContextHolder.getBean("baseComponent");

    /**middle repo**/
//    public static  MiddleRepoService middleRepoService = null ; //    SpringContextHolder.getBean("middleRepoService");
//    public static  AimbRepoService aimbRepoService = null ; //    SpringContextHolder.getBean("aimbRepoService");

    public static DataSource dataSource = null;

//    public StompWebsocketNotifier stompWebsocketNotifier = SpringContextHolder.getBean("stompWebsocketNotifier");
}
