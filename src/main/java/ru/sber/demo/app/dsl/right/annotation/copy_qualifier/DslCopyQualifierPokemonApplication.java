package ru.sber.demo.app.dsl.right.annotation.copy_qualifier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import ru.sber.demo.PokemonConfigurationProperties;
import ru.sber.demo.app.dsl.right.annotation.DefaultPokemon;
import ru.sber.demo.app.dsl.right.annotation.DefaultPokemonPrinter;
import ru.sber.demo.dsl.keeper.WithZookeeper;
import ru.sber.demo.dsl.pockemon.PokemonDsl;
import ru.sber.demo.dsl.pockemon.right.annotation.EnableCopyQualifiedPokemonDsl;
import ru.sber.demo.model.api.Pokemon;
import ru.sber.demo.model.PokemonMaster;
import ru.sber.demo.model.PokemonType;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties(PokemonConfigurationProperties.class)
@EnableCopyQualifiedPokemonDsl
@WithZookeeper
public class DslCopyQualifierPokemonApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(DslCopyQualifierPokemonApplication.class, args);
    }
    
    @Bean
    @DefaultPokemon
    public PokemonDsl mishaDsl() {
        return Pokemon.catchPokemon(PokemonType.PICKACHU)
            .byMaster("Egor");
    }
    
    @Bean
    @DefaultPokemon
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

    @Bean
    public DefaultPokemonPrinter defaultPokemonPrinter(
        @DefaultPokemon List<Pokemon> pokemons) {
        return new DefaultPokemonPrinter(pokemons);
    }

}
