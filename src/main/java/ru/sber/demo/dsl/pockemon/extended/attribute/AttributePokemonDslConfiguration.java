package ru.sber.demo.dsl.pockemon.extended.attribute;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AttributePokemonDslConfiguration {
    @Bean
    public AttributePokemonDslBeanFactoryPostProcessor pureWrongPokemonDslBeanFactoryPostProcessor() {
        return new AttributePokemonDslBeanFactoryPostProcessor();
    }
}
