package ru.sber.demo.dsl.pockemon.wrong.target_type;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TargetTypeWrongPockemonDslConfiguration {
    @Bean
    public TargetTypeWrongPockemonDslBeanFactoryPostProcessor pureWrongPockemonDslBeanFactoryPostProcessor() {
        return new TargetTypeWrongPockemonDslBeanFactoryPostProcessor();
    }
}
