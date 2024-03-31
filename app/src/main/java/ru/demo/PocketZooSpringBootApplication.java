package ru.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import ru.demo.initializer.PokemonDslBeanInitializer;
import ru.demo.model.Pokemon;
import ru.demo.model.PokemonType;
import ru.demo.model.ZooWorker;

import java.util.Map;
import java.util.stream.IntStream;

@SpringBootApplication
@EnableConfigurationProperties(PokemonConfigurationProperties.class)
public class PocketZooSpringBootApplication {
    
    public static void main(String[] args) {
       new SpringApplicationBuilder()
           .initializers()
           .sources(PocketZooSpringBootApplication.class)
           .initializers(new PokemonDslBeanInitializer() {
               @Override
               protected void initialize() {
                   IntStream.range(0, 20).forEach(((index) -> {
                       pokemon("max" + index, PokemonType.BULBAZAVR, "Egor");
                   }));
                   
                   pokemon("Valentin", PokemonType.PICKACHU, "Bubub");
               }}
           ).run(args);
           
    }
    
    @Bean
    ZooWorker zooWorker(Map<String, Pokemon> pokemonMap) {
        return new ZooWorker(pokemonMap.keySet(), "Вася");
    }
    
    @Bean
    PokemonWelcomeBoard zookeeper(Map<String, Pokemon> pokemons, Map<String, ZooWorker> workers) {
        return new PokemonWelcomeBoard(pokemons.keySet(), workers.keySet());
    }
}
