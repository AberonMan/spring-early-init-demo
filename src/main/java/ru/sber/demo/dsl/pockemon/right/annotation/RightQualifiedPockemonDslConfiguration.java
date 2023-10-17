package ru.sber.demo.dsl.pockemon.right.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RightQualifiedPockemonDslConfiguration {
    @Bean
    public RightQualifiedPockemonDslBeanFactoryPostProcessor rightQualifiedPockemonDslBeanFactoryPostProcessor() {
        return new RightQualifiedPockemonDslBeanFactoryPostProcessor();
    }
}
