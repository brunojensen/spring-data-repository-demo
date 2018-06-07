package org.extension.spring.data.repository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import spring.data.repository.internal.RepositorySpecificationExecutorImpl;

@ComponentScan(basePackages = {"com.bea.spring.boot"})
@EnableJpaRepositories(
        value = "org.extension.spring.data.repository",
        repositoryBaseClass = RepositorySpecificationExecutorImpl.class)
@SpringBootApplication
public class SpringDataRepositoryDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataRepositoryDemoApplication.class, args);
    }
}
