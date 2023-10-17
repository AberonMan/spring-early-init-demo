package ru.sber.demo.app.dsl.right.attribute;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import ru.sber.demo.PockemonConfigurationProperties;
import ru.sber.demo.dsl.keeper.WithZookeeper;
import ru.sber.demo.dsl.pockemon.PockemonDsl;
import ru.sber.demo.dsl.pockemon.right.attribute.EnableRightAttributePockemonDsl;
import ru.sber.demo.model.Pockemon;
import ru.sber.demo.model.PockemonMaster;
import ru.sber.demo.model.PockemonType;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties(PockemonConfigurationProperties.class)
@EnableRightAttributePockemonDsl
@WithZookeeper
public class DslRightAttributePokemonApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(DslRightAttributePokemonApplication.class, args);
    }
    
    @Bean
    public PockemonDsl mishaDsl() {
        return Pockemon.catchPokemon(PockemonType.PICKACHU)
            .byMaster("Egor");
    }
    
    @Bean
    public PockemonDsl zhenyaDsl() {
        return Pockemon.catchPokemon(PockemonType.BULBAZAVR)
            .byMaster("Arsen");
    }
    
    @Bean
    public PockemonDsl maximDsl() {
        return Pockemon.catchPokemon(PockemonType.PICKACHU)
            .byMaster("Veronika");
    }
    
    @Bean
    public List<PockemonMaster> masters(List<PockemonMaster> masters) {
        return masters;
    }
}
