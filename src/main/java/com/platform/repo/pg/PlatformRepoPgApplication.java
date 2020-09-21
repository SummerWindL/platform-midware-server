package com.platform.repo.pg;

import com.platform.repo.pg.repo.base.impl.CommonCustomRepositoryImpl;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @program: platform-repo-pg
 * @description:
 * @author: fuyl
 * @create: 2020-06-19 17:41
 **/
@EnableAutoConfiguration
@ComponentScan
@Configuration
@EnableJpaRepositories(repositoryBaseClass = CommonCustomRepositoryImpl.class)
@EntityScan(basePackageClasses = PlatformRepoPgApplication.class)
public class PlatformRepoPgApplication {
}
