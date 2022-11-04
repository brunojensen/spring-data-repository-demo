package org.extension.spring.data.repository;

import org.extension.spring.data.repository.internal.RepositorySpecificationExecutorImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = {"org.extension.spring.data.repository.demo"})
@EnableJpaRepositories(
        value = "org.extension.spring.data.repository",
        repositoryBaseClass = RepositorySpecificationExecutorImpl.class)
@SpringBootApplication
public class SpringDataRepositoryDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataRepositoryDemoApplication.class, args);
    }
}
