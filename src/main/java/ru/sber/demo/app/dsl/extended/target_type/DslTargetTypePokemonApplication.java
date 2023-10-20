package ru.sber.demo.app.dsl.extended.target_type;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import ru.sber.demo.PokemonConfigurationProperties;
import ru.sber.demo.dsl.keeper.WithZookeeper;
import ru.sber.demo.dsl.pockemon.PokemonDsl;
import ru.sber.demo.dsl.pockemon.extended.target_type.EnableTargetTypePokemonDsl;
import ru.sber.demo.model.api.Pokemon;
import ru.sber.demo.model.PokemonMaster;
import ru.sber.demo.model.PokemonType;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties(PokemonConfigurationProperties.class)
@EnableTargetTypePokemonDsl
@WithZookeeper
public class DslTargetTypePokemonApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(DslTargetTypePokemonApplication.class, args);
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
