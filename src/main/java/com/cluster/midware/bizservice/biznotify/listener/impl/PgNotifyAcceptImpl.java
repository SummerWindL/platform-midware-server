package com.cluster.midware.bizservice.biznotify.listener.impl;

import cn.hutool.json.JSONUtil;
import com.cluster.midware.bizservice.biznotify.bean.PostgresNotice;
import com.cluster.midware.bizservice.biznotify.listener.IPgNotifyAcceptHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @description: default转换类
 * @author: fuyl
 * @create: 2020-08-30 10:45
 **/

public class PgNotifyAcceptImpl implements IPgNotifyAcceptHandler {
    private static Logger log = LoggerFactory.getLogger(PgNotifyAcceptImpl.class);
    /**
     * 接收postgres通知
     *
     * @return PostgresNotificationMsg
     */
    @Override
    public PostgresNotice acceptNotification(String notifyparam) {
        PostgresNotice notice = null;
        try{
            notice = JSONUtil.parseObj(notifyparam).toBean(PostgresNotice.class);
        }catch (Exception e){
            log.error("消息转换失败：{}",e.getMessage());
            e.printStackTrace();
        }

        return notice;
    }
}
