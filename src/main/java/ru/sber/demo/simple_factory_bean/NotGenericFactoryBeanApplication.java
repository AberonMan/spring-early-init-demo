package ru.sber.demo.simple_factory_bean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import ru.sber.demo.PockemonConfigurationProperties;
import ru.sber.demo.BulbazavrBeanFactoryPostProcessor;

@SpringBootApplication
@EnableConfigurationProperties(PockemonConfigurationProperties.class)
public class NotGenericFactoryBeanApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(NotGenericFactoryBeanApplication.class, args);
	}
	
	/*
	   Factory bean заданный таким образом не приводит к ранней инициализации бина bpfpp.
	 */
	@Bean
	BulbazarvNotGenericFactoryBean bulbazavrFactoryBean(PockemonConfigurationProperties bulbazavrConfigurationProperties) {
		return new BulbazarvNotGenericFactoryBean(bulbazavrConfigurationProperties);
	}
	
	@Bean
	BulbazavrBeanFactoryPostProcessor bulbazavrPostProcessor() {
		return new BulbazavrBeanFactoryPostProcessor();
	}
	
}
