package ru.sber.demo.app.factory_bean.generic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import ru.sber.demo.PockemonConfigurationProperties;
import ru.sber.demo.dsl.keeper.WithZookeeper;
import ru.sber.demo.dsl.pockemon.PockemonFactoryBean;
import ru.sber.demo.model.PockemonType;

@SpringBootApplication
@EnableConfigurationProperties(PockemonConfigurationProperties.class)
@WithZookeeper
public class GenericFactoryBeanApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(GenericFactoryBeanApplication.class, args);
	}

	@Bean
	public PockemonFactoryBean zhenya(PockemonConfigurationProperties properties) {
		return new PockemonFactoryBean(properties).withType(PockemonType.BULBAZAVR);
	}

	@Bean
	public PockemonFactoryBean maxim(PockemonConfigurationProperties properties) {
		return new PockemonFactoryBean(properties).withType(PockemonType.PICKACHU);
	}
}
