package ru.sber.demo.app.factory_bean.raw;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import ru.sber.demo.PokemonConfigurationProperties;
import ru.sber.demo.dsl.keeper.WithZookeeper;
import ru.sber.demo.dsl.pockemon.PokemonFactoryBean;
import ru.sber.demo.model.PokemonType;

@SpringBootApplication
@EnableConfigurationProperties(PokemonConfigurationProperties.class)
@WithZookeeper
public class RawTypeFactoryBeanApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(RawTypeFactoryBeanApplication.class, args);
	}
	
	
	@Bean
	public FactoryBean zhenya(PokemonConfigurationProperties properties) {
		return new PokemonFactoryBean(properties).withType(PokemonType.BULBAZAVR);
	}
	
	@Bean
	public FactoryBean maxim(PokemonConfigurationProperties properties) {
		return new PokemonFactoryBean(properties).withType(PokemonType.PICKACHU);
	}
}
