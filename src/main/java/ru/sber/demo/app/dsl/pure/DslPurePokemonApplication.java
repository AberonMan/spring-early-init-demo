package ru.sber.demo.app.dsl.pure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import ru.sber.demo.dsl.keeper.WithZookeeper;
import ru.sber.demo.dsl.pokemon.PokemonDsl;
import ru.sber.demo.dsl.pokemon.simple.pure.EnablePurePokemonDsl;
import ru.sber.demo.model.api.Pokemon;
import ru.sber.demo.PokemonConfigurationProperties;
import ru.sber.demo.model.PokemonMaster;
import ru.sber.demo.model.PokemonType;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties(PokemonConfigurationProperties.class)
@EnablePurePokemonDsl
@WithZookeeper
public class DslPurePokemonApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(DslPurePokemonApplication.class, args);
    }
    
    @Bean
    public PokemonDsl mishaDsl() {
        return Pokemon.catchPokemon(PokemonType.PICKACHU)
            .byMaster("Egor");
    }
    
    @Bean
    public PokemonDsl zhenyaDsl() {
        return Pokemon.catchPokemon(PokemonType.BULBAZAVR)
            .byMaster("Arsen");
    }
    
    @Bean
    public PokemonDsl maximDsl() {
        return Pokemon.catchPokemon(PokemonType.PICKACHU)
            .byMaster("Veronika");
    }
    
    @Bean
    public List<PokemonMaster> masters(List<PokemonMaster> masters) {
        return masters;
    }
}
