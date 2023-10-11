package ru.sber.demo.dsl.keeper;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WithZookeeperConfiguration {
    @Bean
    public PockemonZookeeperBeanFactoryPostProcessor pockemonZookeeperBeanFactoryPostProcessor() {
        return new PockemonZookeeperBeanFactoryPostProcessor();
    }
}
