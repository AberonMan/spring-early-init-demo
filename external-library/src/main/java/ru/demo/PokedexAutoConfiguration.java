package ru.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PokedexAutoConfiguration {
    
    @Bean
    static PokedexBeanFactoryPostProcessor pokedexBeanFactoryPostProcessor() {
        return new PokedexBeanFactoryPostProcessor();
    }
}
