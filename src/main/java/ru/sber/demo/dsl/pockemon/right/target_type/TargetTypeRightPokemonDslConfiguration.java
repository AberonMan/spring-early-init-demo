package ru.sber.demo.dsl.pockemon.right.target_type;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TargetTypeRightPokemonDslConfiguration {
    @Bean
    public TargetTypeRightPokemonDslBeanFactoryPostProcessor pureWrongPokemonDslBeanFactoryPostProcessor() {
        return new TargetTypeRightPokemonDslBeanFactoryPostProcessor();
    }
}
