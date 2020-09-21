package com.cluster.midware.service.push;

import cn.hutool.json.JSONUtil;
import cn.hutool.log.StaticLog;
import com.alibaba.fastjson.JSONObject;
import com.cluster.activemq.platform.service.IMqhandler;
import com.cluster.midware.common.bean.MsgContent;
import com.cluster.midware.common.bean.MsgParam;
import com.cluster.midware.common.consts.Constants;
import com.cluster.midware.config.ServiceBeanConfig;
import com.platform.websocket.manager.PlatformWebsocketManager;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @program: middle-server
 * @description: 居民预约消息更新 - 通知医生居民消息发送更新
 * @author: fuyl
 * @create: 2020-06-10 15:06
 **/
@Slf4j
public class Cmd40102002Handler implements IMqhandler {
    private volatile String doctorid;
    private static Queue queue = new LinkedBlockingQueue();
    @Override
    public void handle(String cmdNo, String cmdMsg) {
        log.info("处理类：[{}]，cmdNo：[{}] 接收成功：[{}]", Cmd40102001Handler.class.getName(),cmdNo,cmdMsg);
        getParams(cmdMsg);
        //2.真正的业务处理方法
        handleMassage(cmdNo,cmdMsg);

    }

    /**
     * 最后处理预约消息的方法
     */
    public synchronized void handleMassage(String cmdNo,String cmdMsg){
        //1.每次有预约问诊消息 先放入队列
        JSONObject jsonObject = null;
        try {
            jsonObject = ServiceBeanConfig.jsonAdaptor.readValue(cmdMsg, JSONObject.class); //线程里面不能允许注入spring实例 采用全局获取的方式
        } catch (IOException e) {
            StaticLog.error("转换json失败：[{}]",e.getMessage());
            e.printStackTrace();
        }
        //拿到需要发送到指定医生的doctorid
        //判断医生是否在线 TODO PC端如何判断是否在线 1.websocket连接是否存在 如果不存在 将消息存到activemq中 待下次PC打开端口先从activemq拉取消息
        //组装发现医生端的消息体
        MsgContent msgContent = new MsgContent();
        msgContent.setCmdNo(Constants.CMD2DOCTOR);
        msgContent.setCmdType(Constants.CMDTYPE);
        MsgParam msgParam = JSONUtil.parseObj(cmdMsg).toBean(MsgParam.class);
        msgContent.setCmdParam(msgParam);
        //发送消息
        PlatformWebsocketManager.sendQueueToDoctor(doctorid, Constants.QUEUEDOCTORNOTIFY,JSONObject.toJSONString(msgContent));
        log.info("向医生[{}]发送消息[{}]：[{}]",doctorid,Constants.QUEUEDOCTORNOTIFY,JSONObject.toJSONString(msgContent));
    }

    public synchronized Map<String,String> getParams(String cmdMsg){
        Map<String,String> paramsMap=new HashMap<>();
        JSONObject jsonObject = null;
        try {
            jsonObject = ServiceBeanConfig.jsonAdaptor.readValue(cmdMsg, JSONObject.class);
        } catch (IOException e) {
            StaticLog.error("读取消息失败：[{}]",e.getMessage());
            e.printStackTrace();
        }
        if(null != jsonObject && null != jsonObject.get(Constants.DOCTORID)){
            this.doctorid = jsonObject.get(Constants.DOCTORID).toString();
        }
        return paramsMap;
    }
}
