package ru.sber.demo.factory_bean_with_interface;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import ru.sber.demo.BulbazavrBeanFactoryPostProcessor;
import ru.sber.demo.PockemonConfigurationProperties;
import ru.sber.demo.pockemons.Pockemon;

@SpringBootApplication
@EnableConfigurationProperties(PockemonConfigurationProperties.class)
public class GenericFactoryBeanApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(GenericFactoryBeanApplication.class, args);
	}
	
	/*
	   Factory bean заданный таким образом не приводит к ранней инициализации бина bpfpp.
	 */
	@Bean
	FactoryBean<Pockemon> bulbazavrFactoryBean(PockemonConfigurationProperties bulbazavrConfigurationProperties) {
		return new BulbazarvFactoryBeanWithParentInterface(bulbazavrConfigurationProperties);
	}
	
	@Bean
	BulbazavrBeanFactoryPostProcessor bulbazavrPostProcessor() {
		return new BulbazavrBeanFactoryPostProcessor();
	}
	
}
