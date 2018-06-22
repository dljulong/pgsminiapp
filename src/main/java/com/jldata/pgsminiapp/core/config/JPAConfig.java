package com.jldata.pgsminiapp.core.config;


import com.jldata.pgsminiapp.core.jpa.BaseRepositoryFactoryBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.jldata.pgsminiapp",repositoryFactoryBeanClass = BaseRepositoryFactoryBean.class)
public class JPAConfig {

}
