package com.cluster.midware.common.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: middle-server
 * @description:
 * @author: fuyl
 * @create: 2020-06-20 16:32
 **/
@Data
public class MsgContent implements Serializable {
    private static final long serialVersionUID = -8839925506608028819L;
    private String cmdNo;
    private String cmdType;
    private Object cmdParam;
}
