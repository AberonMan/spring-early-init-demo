package ru.sber.demo.app.factory_bean.raw;

import org.springframework.beans.factory.FactoryBean;
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
public class RawTypeFactoryBeanApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(RawTypeFactoryBeanApplication.class, args);
	}
	
	
	@Bean
	public FactoryBean zhenya(PockemonConfigurationProperties properties) {
		return new PockemonFactoryBean(properties).withType(PockemonType.BULBAZAVR);
	}
	
	@Bean
	public FactoryBean maxim(PockemonConfigurationProperties properties) {
		return new PockemonFactoryBean(properties).withType(PockemonType.PICKACHU);
	}
}
