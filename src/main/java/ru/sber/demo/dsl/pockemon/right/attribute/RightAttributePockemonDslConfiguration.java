package ru.sber.demo.dsl.pockemon.right.attribute;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RightAttributePockemonDslConfiguration {
    @Bean
    public RightAttributePockemonDslBeanFactoryPostProcessor pureWrongPockemonDslBeanFactoryPostProcessor() {
        return new RightAttributePockemonDslBeanFactoryPostProcessor();
    }
}
