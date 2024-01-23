package ru.sber.demo.dsl.keeper;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.sber.demo.model.SimpleZooWorker;
import ru.sber.demo.model.api.Pokemon;
import ru.sber.demo.model.api.ZooWorker;

import java.util.Map;

@Configuration
public class WithZookeeperConfiguration {
    @Bean
    public PokemonZookeeperBeanFactoryPostProcessor pokemonZookeeperBeanFactoryPostProcessor() {
        return new PokemonZookeeperBeanFactoryPostProcessor();
    }

    // this Map is injected by Spring. It will search for all Pokemons,
    // the String key is each of those names.
    @Bean
    public ZooWorker worker(Map<String, Pokemon> pokemons) {
        return new SimpleZooWorker(pokemons.keySet());
    }
}
