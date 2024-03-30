package ru.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import ru.demo.bfpp.EnablePokemonDsl;
import ru.demo.model.Pokemon;
import ru.demo.model.PokemonDsl;
import ru.demo.model.PokemonType;
import ru.demo.model.ZooWorker;

import java.util.Map;

@SpringBootApplication
@EnablePokemonDsl(loadWorkers = true)
@EnableConfigurationProperties(PokemonConfigurationProperties.class)
public class PocketZooSpringBootApplication {
    
    private static final String MISHA_PIKACHU = "mishaPikachu";
    private static final String ZHENYA_BULBAZAVR = "zhenyaBulbazavr";
    private static final String MAX_PIKACHU = "maxPikachu";
    private static final String EVA_BULBAZAVR = "evaBulbazavr";
    
    public static void main(String[] args) {
        SpringApplication.run(PocketZooSpringBootApplication.class, args);
    }
    
    @Bean(MAX_PIKACHU)
    PokemonDsl maxPikachu() {
        return new PokemonDsl(PokemonType.PICKACHU).byMaster("Veronika");
    }
    
    @Bean(ZHENYA_BULBAZAVR)
    PokemonDsl zhenyaBulbazavr() {
        return new PokemonDsl(PokemonType.BULBAZAVR).byMaster("Egor");
    }
    
    @Bean(MISHA_PIKACHU)
    PokemonDsl mishaPikachu() {
        return new PokemonDsl(PokemonType.BULBAZAVR).byMaster("Arsen");
    }
    
    @Bean(EVA_BULBAZAVR)
    PokemonDsl evaBulbazavr() {
        return new PokemonDsl(PokemonType.BULBAZAVR).byMaster("Arina");
    }
    
    @Bean
    PokemonWelcomeBoard zookeeper(Map<String, Pokemon> pokemons, Map<String, ZooWorker> workers) {
        return new PokemonWelcomeBoard(pokemons.keySet(), workers.keySet());
    }
}
