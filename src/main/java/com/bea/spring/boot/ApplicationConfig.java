package com.bea.spring.boot;

import com.bea.spring.repository.internal.RepositorySpecificationExecutorImpl;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = {"com.bea.spring.boot"})
@Configuration
@EnableJpaRepositories(
    value = "com.bea.spring.boot.repository",
    repositoryBaseClass = RepositorySpecificationExecutorImpl.class)
public class ApplicationConfig {
}
