package ru.sber.demo.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import ru.sber.demo.PokemonConfigurationPropertiesClass;
import ru.sber.demo.bfpp.PokemonDslBeanFactoryPostProcessor;
import ru.sber.demo.bfpp.ZookeperDslBeanFactoryPostProcessor;
import ru.sber.demo.model.Pokemon;
import ru.sber.demo.model.PokemonDsl;
import ru.sber.demo.model.PokemonType;
import ru.sber.demo.model.ZooWorker;

import java.util.Map;

@SpringBootApplication
@EnableConfigurationProperties(PokemonConfigurationPropertiesClass.class)
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
        return new PokemonDsl(PokemonType.PICKACHU)
            .byMaster("Veronika");
    }
    
    @Bean(ZHENYA_BULBAZAVR)
    PokemonDsl zhenyaBulbazavr() {
        return new PokemonDsl(PokemonType.BULBAZAVR)
            .byMaster("Egor");
    }
    
    @Bean(MISHA_PIKACHU)
    PokemonDsl mishaPikachu() {
        return new PokemonDsl(PokemonType.BULBAZAVR)
            .byMaster("Arsen");
    }
    
    @Bean(EVA_BULBAZAVR)
    PokemonDsl evaBulbazavr() {
        return new PokemonDsl(PokemonType.BULBAZAVR)
            .byMaster("Arina");
    }
    
    @Bean
    ZooWorker zooWorker(Map<String, Pokemon> pokemons) {
        return new ZooWorker(pokemons.keySet());
    }
    
    @Bean
    static PokemonDslBeanFactoryPostProcessor pokemonDslBeanFactoryPostProcessor() {
        return new PokemonDslBeanFactoryPostProcessor();
    }

    @Bean
    static ZookeperDslBeanFactoryPostProcessor pokemonZookeeperBeanFactoryPostProcessor() {
        return new ZookeperDslBeanFactoryPostProcessor();
    }
}
