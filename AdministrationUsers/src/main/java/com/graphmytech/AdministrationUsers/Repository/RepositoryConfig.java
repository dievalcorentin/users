package com.graphmytech.AdministrationUsers.Repository;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.graphmytech.AdministrationUsers.Repository")
public class RepositoryConfig {
    // You might not need any additional code here if only enabling repositories.
}
