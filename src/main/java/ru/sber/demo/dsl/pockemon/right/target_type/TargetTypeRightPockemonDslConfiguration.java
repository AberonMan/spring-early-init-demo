package ru.sber.demo.dsl.pockemon.right.target_type;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TargetTypeRightPockemonDslConfiguration {
    @Bean
    public TargetTypeRightPockemonDslBeanFactoryPostProcessor pureWrongPockemonDslBeanFactoryPostProcessor() {
        return new TargetTypeRightPockemonDslBeanFactoryPostProcessor();
    }
}
