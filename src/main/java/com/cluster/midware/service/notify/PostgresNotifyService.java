package com.cluster.midware.service.notify;

import cn.hutool.log.StaticLog;
import com.cluster.midware.bizservice.biznotify.listener.impl.PostgresNotificationListener;
import org.springframework.stereotype.Component;

import static com.cluster.midware.common.consts.Constants.POSTGRES_DESTINATION_ALERT_INSPECTION;

/**
 * @description: postgre 数据库 notify函数通知 启动监听
 * @author: fuyl
 * @create: 2020-09-21 15:43
 **/
@Component
public class PostgresNotifyService implements Runnable{
    private PostgresNotificationListener postgresNotificationListener;

    public long startPostGresNotifyLinstener(){
        StaticLog.info("\n-------- PostgresNotifyService [数据库XXX通知服务] start --------");
        postgresNotificationListener = new PostgresNotificationListener(POSTGRES_DESTINATION_ALERT_INSPECTION);
        if(postgresNotificationListener!=null){
            //1.启动监听目标线程
            postgresNotificationListener.startListener();
            //2.处理目标 发送的notifyno任务
            postgresNotificationListener.addHandler("cmd_4060001",new PostgresNotifyHandler());
        }
        return 1L;
    }
    @Override
    public void run() {
        this.startPostGresNotifyLinstener();
    }
}
