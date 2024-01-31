package ru.sber.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import ru.sber.demo.model.Pokemon;
import ru.sber.demo.model.PokemonType;
import ru.sber.demo.model.PokemonZookeeper;
import ru.sber.demo.model.ZooWorker;
import ru.sber.demo.utils.PockemonFactory;

import java.util.Map;

@SpringBootApplication
@EnableConfigurationProperties(PokemonConfigurationProperties.class)
public class PocketZooSpringBootAppplication {
    
    public static void main(String[] args) {
        SpringApplication.run(PocketZooSpringBootAppplication.class, args);
    }
    
    @Bean
    Pokemon maxPikachu(PokemonConfigurationProperties configurationProperties) {
        return PockemonFactory.createPokemon(PokemonType.PICKACHU, configurationProperties);
    }
    
    @Bean
    Pokemon zhenyaBulbazavr(PokemonConfigurationProperties configurationProperties) {
        return PockemonFactory.createPokemon(PokemonType.PICKACHU, configurationProperties);
    }
    
    @Bean
    ZooWorker zooWorker(Map<String, Pokemon> pockemons) {
        return new ZooWorker(pockemons.keySet());
    }
    
    @Bean
    PokemonZookeeper zookeeper(Map<String, Pokemon> pokemons, Map<String, ZooWorker> workers) {
        return new PokemonZookeeper(
            pokemons.keySet(),
            workers.keySet()
        );
    }
}
