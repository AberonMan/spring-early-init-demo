package ru.sber.demo.dsl.pockemon.right;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RightPockemonDslConfiguration {
    @Bean
    public RightPockemonDslBeanFactoryPostProcessor pureWrongPockemonDslBeanFactoryPostProcessor() {
        return new RightPockemonDslBeanFactoryPostProcessor();
    }
}
