package com.cluster.midware;

import cn.hutool.core.exceptions.ExceptionUtil;
import com.cluster.midware.config.MidwareServerConfig;
import com.cluster.midware.service.base.ServiceThreadManagerRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: fuyl
 * @create: 2020-09-21 15:06
 **/
@Component
@Order(value = 1)
public class ServerRunner implements ApplicationRunner {
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());
    @Autowired
    private MidwareServerConfig midwareServerConfig;
    @Autowired
    private ServiceThreadManagerRunner serviceThreadManagerRunner;
    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        LOGGER.info("\n--------启动服务 START--------");
        int port = midwareServerConfig.getPort();
        int threadCount = midwareServerConfig.getThreadCount();
        try {
            serviceThreadManagerRunner.submit();
            LOGGER.info("--------服务启动成功 Listen: {}, Thread count: {} -------- ", port, threadCount);

        } catch (Exception e) {
            LOGGER.error("Platform middle-server start failed!Exception: {}", ExceptionUtil.getMessage(e));
        }

    }
}
