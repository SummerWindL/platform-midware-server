package com.cluster.midware.common.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: middle-server
 * @description: 消息内容
 * @author: fuyl
 * @create: 2020-06-20 17:32
 **/
@Data
public class MsgParam implements Serializable {
    private static final long serialVersionUID = 1753530971582628486L;
    private String hospcode;
    private String appointserialid;
    private String doctorid;
    private String ssid;
    private String serialid;
}
