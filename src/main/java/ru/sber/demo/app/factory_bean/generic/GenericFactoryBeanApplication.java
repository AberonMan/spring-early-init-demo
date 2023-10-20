package ru.sber.demo.app.factory_bean.generic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import ru.sber.demo.PokemonConfigurationProperties;
import ru.sber.demo.dsl.keeper.WithZookeeper;
import ru.sber.demo.dsl.pokemon.PokemonFactoryBean;
import ru.sber.demo.model.PokemonType;

@SpringBootApplication
@EnableConfigurationProperties(PokemonConfigurationProperties.class)
@WithZookeeper
public class GenericFactoryBeanApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(GenericFactoryBeanApplication.class, args);
	}

	@Bean
	public PokemonFactoryBean zhenya(PokemonConfigurationProperties properties) {
		return new PokemonFactoryBean(properties).withType(PokemonType.BULBAZAVR);
	}

	@Bean
	public PokemonFactoryBean maxim(PokemonConfigurationProperties properties) {
		return new PokemonFactoryBean(properties).withType(PokemonType.PICKACHU);
	}
}
