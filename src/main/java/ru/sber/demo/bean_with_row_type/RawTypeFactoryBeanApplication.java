package ru.sber.demo.bean_with_row_type;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import ru.sber.demo.BulbazavrBeanFactoryPostProcessor;
import ru.sber.demo.PockemonConfigurationProperties;
import ru.sber.demo.factory_bean_with_interface.BulbazarvFactoryBeanWithParentInterface;

@SpringBootApplication
@EnableConfigurationProperties(PockemonConfigurationProperties.class)
public class RawTypeFactoryBeanApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(RawTypeFactoryBeanApplication.class, args);
	}
	
	/*
	   Factory bean заданный таким образом не приводит к ранней инициализации бина bpfpp.
	 */
	@Bean
	FactoryBean bulbazavrFactoryBean(PockemonConfigurationProperties bulbazavrConfigurationProperties) {
		return new BulbazarvFactoryBeanWithParentInterface(bulbazavrConfigurationProperties);
	}
	
	@Bean
	BulbazavrBeanFactoryPostProcessor bulbazavrPostProcessor() {
		return new BulbazavrBeanFactoryPostProcessor();
	}
	
}
