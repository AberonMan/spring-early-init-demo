package ru.sber.demo.dsl.pockemon.simple.pure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PurePokemonDslConfiguration {
    @Bean
    public PurePokemonDslBeanFactoryPostProcessor pureWrongPokemonDslBeanFactoryPostProcessor() {
        return new PurePokemonDslBeanFactoryPostProcessor();
    }
}
