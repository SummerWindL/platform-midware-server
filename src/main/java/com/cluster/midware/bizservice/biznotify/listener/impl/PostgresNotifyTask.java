package com.cluster.midware.bizservice.biznotify.listener.impl;

import com.cluster.midware.bizservice.biznotify.listener.PostgresNotificationRunner;
import org.springframework.stereotype.Service;

/**
 * @description: 真正的启动线程类
 * @author: fuyl
 * @create: 2020-08-29 17:02
 **/
@Service
public class PostgresNotifyTask implements PostgresNotificationRunner {

    @Override
    public void run(Runnable runnable) {
        PostgresNotificationImpl impl = (PostgresNotificationImpl) runnable;
        Thread thread = new Thread(impl);
        thread.start();
    }
}
