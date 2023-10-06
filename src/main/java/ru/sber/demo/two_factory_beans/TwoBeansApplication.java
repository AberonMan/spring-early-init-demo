package ru.sber.demo.two_factory_beans;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Import;
import ru.sber.demo.BulbazavrBeanFactoryPostProcessor;
import ru.sber.demo.PockemonConfigurationProperties;
import ru.sber.demo.pockemons.Bulbazavr;
import ru.sber.demo.pockemons.Pickachu;

@SpringBootApplication
@EnableConfigurationProperties(PockemonConfigurationProperties.class)
public class TwoBeansApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(TwoBeansApplication.class, args);
    }
    
    @Bean
    Bulbazavr bulbazavr() {
        return new Bulbazavr("");
    }
    
    @Bean
    public PockemoMaster pockemoMaster(Pickachu pickachu) {
        return new PockemoMaster(pickachu);
    }
    
    @Bean
    static BulbazavrBeanFactoryPostProcessor bulbazavrPostProcessor() {
        return new BulbazavrBeanFactoryPostProcessor();
    }
    
    @Bean
    static PickachuFactoryRegisterBeanPostProcessor pickachuFactoryRegisterBeanPostProcessor() {
        return new PickachuFactoryRegisterBeanPostProcessor();
    }
}
