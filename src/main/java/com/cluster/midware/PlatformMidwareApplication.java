package com.cluster.midware;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @description:
 * @author: fuyl
 * @create: 2020-09-21 14:42
 **/
@SpringBootApplication(scanBasePackages = {"com.cluster","com.platform"})
public class PlatformMidwareApplication {
    public static void main(String[] args) {
        SpringApplication.run(PlatformMidwareApplication.class);
    }
}
