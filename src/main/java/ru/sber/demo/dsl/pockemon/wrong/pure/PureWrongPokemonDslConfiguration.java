package ru.sber.demo.dsl.pockemon.wrong.pure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PureWrongPokemonDslConfiguration {
    @Bean
    public PureWrongPokemonDslBeanFactoryPostProcessor pureWrongPokemonDslBeanFactoryPostProcessor() {
        return new PureWrongPokemonDslBeanFactoryPostProcessor();
    }
}
