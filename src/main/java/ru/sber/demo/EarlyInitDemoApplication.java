package ru.sber.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableConfigurationProperties(BulbazavrConfigurationProperties.class)
public class EarlyInitDemoApplication {
	
	public static final String BULBAZRV = "bulbazrv";
	
	public static void main(String[] args) {
		SpringApplication.run(EarlyInitDemoApplication.class, args);
	}
	
	@Bean(BULBAZRV)
	BulbazavrFactoryBean bulbazavrFactoryBean(BulbazavrConfigurationProperties bulbazavrConfigurationProperties) {
		return new BulbazavrFactoryBean(bulbazavrConfigurationProperties);
	}
	
	@Bean
	BulbazavrPostProcessor bulbazavrPostProcessor() {
		return new BulbazavrPostProcessor();
	}
	
}
