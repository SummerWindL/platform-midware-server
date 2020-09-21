package com.cluster.midware.service.notify;

import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSONObject;
import com.cluster.midware.bizservice.biznotify.listener.IPgNotifyHandler;
import com.cluster.midware.common.bean.MsgContent;
import com.cluster.midware.common.consts.Constants;
import com.platform.websocket.manager.PlatformWebsocketManager;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;

import static com.cluster.midware.common.consts.Constants.TOPICDOCTORNOTIFY;

/**
 * @description: 真正业务处理类 线程类
 * @author: fuyl
 * @create: 2020-09-21 15:46
 **/
@Slf4j
public class PostgresNotifyHandler implements IPgNotifyHandler {
    /**
     * 处理通知消息
     *
     * @param notifyno     命令号
     * @param notifytype   通知类型
     * @param notifyparams 参数
     */
    @Override
    public void handlerPgNotification(String notifyno, String notifytype, String notifyparams) {
        log.info("接收到 notifyno: {}, notifytype: {}, 参数 notifyparams: {}",notifyno,notifytype,notifyparams);
        Cmd4060001Bean cmd4060001Bean = JSONUtil.parseObj(notifyparams).toBean(Cmd4060001Bean.class);
        if(!ObjectUtils.isEmpty(cmd4060001Bean)){
            //构造发送给前端的命令体
            //组装发送医生端的消息体
            MsgContent msgContent = new MsgContent();
            msgContent.setCmdNo(Constants.CMD2DOCTOR_SS_ALERT_INSPECTION_DATA_UPDATE);
            msgContent.setCmdType(Constants.CMDTYPE);
            msgContent.setCmdParam(cmd4060001Bean);
            PlatformWebsocketManager.sendTopicToDoctor("",TOPICDOCTORNOTIFY, JSONObject.toJSONString(msgContent));
            log.info("向医生广播消息[{}]：[{}]", TOPICDOCTORNOTIFY, JSONObject.toJSONString(msgContent));
        }
    }
    @Data
    public static class Cmd4060001Bean{
        private String ssid;
        private String hospcode;
    }
}
