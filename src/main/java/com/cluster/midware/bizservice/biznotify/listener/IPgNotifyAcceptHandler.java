package com.cluster.midware.bizservice.biznotify.listener;


import com.cluster.midware.bizservice.biznotify.bean.PostgresNotice;

/**
 * @description: postgres消息接收处理器
 * @author: fuyl
 * @create: 2020-08-30 10:37
 **/

public interface IPgNotifyAcceptHandler {

    /**
     * 接收postgres通知
     * @param notifyparam
     * @return PostgresNotice
     */
    PostgresNotice acceptNotification(String notifyparam);
}
