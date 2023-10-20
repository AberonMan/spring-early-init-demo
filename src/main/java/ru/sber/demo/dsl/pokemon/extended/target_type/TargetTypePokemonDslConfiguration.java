package ru.sber.demo.dsl.pokemon.extended.target_type;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TargetTypePokemonDslConfiguration {
    @Bean
    public TargetTypePokemonDslBeanFactoryPostProcessor pureWrongPokemonDslBeanFactoryPostProcessor() {
        return new TargetTypePokemonDslBeanFactoryPostProcessor();
    }
}
