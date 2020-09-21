package com.cluster.midware.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: fuyl
 * @create: 2020-09-21 15:09
 **/
@Data
@Configuration
@ConfigurationProperties(prefix = "middle.server")
public class MidwareServerConfig {
    private String ip = "127.0.0.1";
    private int port;
    private int threadCount;
    /**
     * 服务类型 producer、consumer
     */
    private String serviceType;
    /**
     * mq类型 topic queue
     */
    private String mqType;
    /**
     * mq名称 自定义名称
     */
    private String mqName;

    private String cmdNo;

    private String cmdMsg;

    private int sleepTime;

    private boolean isOpenTestMode;
}
