package ru.sber.demo.dsl.pockemon.right.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CopyQualifiedPokemonDslConfiguration {
    @Bean
    public CopyQualifiedPokemonDslBeanFactoryPostProcessor copyQualifiedPokemonDslBeanFactoryPostProcessor() {
        return new CopyQualifiedPokemonDslBeanFactoryPostProcessor();
    }
}
