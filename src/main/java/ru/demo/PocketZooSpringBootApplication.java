package ru.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import ru.demo.model.ZooWorker;
import ru.demo.utils.PockemonFactory;
import ru.demo.model.Pokemon;
import ru.demo.model.PokemonMaster;
import ru.demo.model.PokemonType;

import java.util.Map;

@SpringBootApplication
@EnableConfigurationProperties(PokemonConfigurationProperties.class)
public class PocketZooSpringBootApplication {
    
    private static final String MISHA_PIKACHU = "mishaPikachu";
    private static final String ZHENYA_BULBAZAVR = "zhenyaBulbazavr";
    private static final String MAX_PIKACHU = "maxPikachu";
    private static final String EVA_BULBAZAVR = "evaBulbazavr";
    
    public static void main(String[] args) {
        SpringApplication.run(PocketZooSpringBootApplication.class, args);
    }
    
    @Bean
    PokemonMaster maxMaster(@Qualifier(ZHENYA_BULBAZAVR)
                            Pokemon pokemon) {
        return new PokemonMaster("Veronika", pokemon);
    }
    
    @Bean(MAX_PIKACHU)
    Pokemon maxPikachu(PokemonConfigurationProperties configurationProperties) {
        return PockemonFactory.createPokemon(PokemonType.PICKACHU, configurationProperties);
    }
    
    @Bean
    PokemonMaster zhenyaMaster(@Qualifier(ZHENYA_BULBAZAVR)
                               Pokemon pokemon) {
        return new PokemonMaster("Egor", pokemon);
    }
    
    @Bean(ZHENYA_BULBAZAVR)
    Pokemon zhenyaBulbazavr(PokemonConfigurationProperties configurationProperties) {
        return PockemonFactory.createPokemon(PokemonType.BULBAZAVR, configurationProperties);
    }
    
    @Bean
    PokemonMaster mishaMaster(@Qualifier(MISHA_PIKACHU)
                              Pokemon pokemon) {
        
        return new PokemonMaster("Kirill", pokemon);
    }
    
    @Bean(MISHA_PIKACHU)
    Pokemon mishaPikachu(PokemonConfigurationProperties configurationProperties) {
        return PockemonFactory.createPokemon(PokemonType.PICKACHU, configurationProperties);
    }
    
    @Bean
    PokemonMaster evaMaster(@Qualifier(EVA_BULBAZAVR)
                            Pokemon pokemon) {
        
        return new PokemonMaster("Arina", pokemon);
    }
    
    @Bean(EVA_BULBAZAVR)
    Pokemon evaBulbazavr(PokemonConfigurationProperties configurationProperties) {
        return PockemonFactory.createPokemon(PokemonType.BULBAZAVR, configurationProperties);
    }
    
    @Bean
    ZooWorker zooWorker(Map<String, Pokemon> pokemons) {
        return new ZooWorker(pokemons.keySet());
    }
    
    @Bean
    PokemonWelcomeBoard zookeeper(Map<String, Pokemon> pokemons, Map<String, ZooWorker> workers) {
        return new PokemonWelcomeBoard(pokemons.keySet(), workers.keySet());
    }
}
