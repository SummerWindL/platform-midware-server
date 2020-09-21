package com.cluster.midware.service.push;

import cn.hutool.log.StaticLog;
import com.cluster.activemq.platform.common.MqConst;
import com.cluster.activemq.platform.mq.consumer.MqConsumer;
import org.springframework.stereotype.Service;

import static com.cluster.midware.common.consts.Constants.*;

/**
 * @description: 向DOCTOR推送消息
 * @author: fuyl
 * @create: 2020-09-21 17:20
 **/
@Service(value = "pushMsg2DoctorService")
public class PushMsg2DoctorService implements Runnable{
    private MqConsumer consumer = null;

    private long initService(){
        //内部启动线程 保持客户端访问
        StaticLog.info("\n-------- PushMsg2DoctorService consumer start --------");
        consumer = new MqConsumer(MqConst.QUEUE, DESTINATION_SS_DXMSG_UPDATE);
        consumer.addHandler(SS_DXMSG_UPDATE_001,new Cmd40102001Handler());
        consumer.addHandler(SS_DXMSG_UPDATE_002,new Cmd40102002Handler());
        return 1L;

    }


    @Override
    public void run() {
        this.initService();
    }
}
