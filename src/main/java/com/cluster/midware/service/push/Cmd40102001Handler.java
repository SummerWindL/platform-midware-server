package com.cluster.midware.service.push;

import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSONObject;
import com.cluster.activemq.platform.service.IMqhandler;
import com.cluster.midware.common.bean.MsgContent;
import com.cluster.midware.common.bean.MsgParam;
import com.cluster.midware.common.consts.Constants;
import com.cluster.midware.config.ServiceBeanConfig;
import com.platform.websocket.manager.PlatformWebsocketManager;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @program: middle-server
 * @description: 居民预约问诊更新 - 通知医生预约问诊更新消息
 * cmdNo 后台命令
 * @author: fuyl
 * @create: 2020-06-10 15:05
 **/
@Slf4j
public class Cmd40102001Handler implements IMqhandler {
    private volatile String doctorid;
    private static Queue<Map<String,JSONObject>> queue = new LinkedBlockingQueue();

    @Override
    public void handle(String cmdNo, String cmdMsg) {
        log.info("处理类：[{}]，cmdNo：[{}] 接收成功：[{}]", Cmd40102001Handler.class.getName(),cmdNo,cmdMsg);
        setParam(cmdMsg);
        //2.真正的业务处理方法
        handleMassage(cmdMsg);

    }

    /**
     * 最后处理预约消息的方法
     */
    public synchronized void handleMassage(String cmdMsg){
        //从队列中取 根据doctorid 查询对应的json消息体
        //拿到需要发送到指定医生的doctorid
        //判断医生是否在线 TODO PC端如何判断是否在线 1.websocket连接是否存在 如果不存在 将消息存到activemq中 待下次PC打开端口先从activemq拉取消息
        //组装发现医生端的消息体
        MsgContent msgContent = new MsgContent();
        //采用发往医生端cmd命令
        msgContent.setCmdNo(Constants.CMD2DOCTOR);
        msgContent.setCmdType(Constants.CMDTYPE);
        MsgParam msgParam = JSONUtil.parseObj(cmdMsg).toBean(MsgParam.class);
        msgContent.setCmdParam(msgParam);

        //发送
        PlatformWebsocketManager.sendQueueToDoctor(doctorid, Constants.QUEUEDOCTORNOTIFY,JSONObject.toJSONString(msgContent));
        log.info("向医生[{}]发送消息[{}]：[{}]",doctorid, Constants.QUEUEDOCTORNOTIFY,JSONObject.toJSONString(msgContent));
    }

    /**
     * 为doctorid 赋值
     * @param cmdMsg
     * @return
     */
    public synchronized void setParam(String cmdMsg){
        JSONObject jsonObject = null;
        try {
            jsonObject = ServiceBeanConfig.jsonAdaptor.readValue(cmdMsg, JSONObject.class);
        } catch (IOException e) {
            log.error("读取消息失败：[{}]",e.getMessage());
            e.printStackTrace();
        }
        if(null != jsonObject && null != jsonObject.get(Constants.APPOINTDOCTORID)){
            this.doctorid = jsonObject.get(Constants.APPOINTDOCTORID).toString();
        }

    }
}
