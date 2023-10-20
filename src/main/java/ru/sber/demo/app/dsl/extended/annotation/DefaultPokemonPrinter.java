package ru.sber.demo.app.dsl.extended.annotation;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import ru.sber.demo.model.api.Pokemon;

import java.util.List;

public class DefaultPokemonPrinter {

    private final List<Pokemon> pokemons;

    public DefaultPokemonPrinter(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    @EventListener(ContextRefreshedEvent.class)
    public void print() {
        if (pokemons.isEmpty()) {
            System.out.println("В наборе по умолчанию нет покемонов!");
        } else {
            System.out.println("Набор по умолчанию: ");
            pokemons.forEach(pokemon -> System.out.println(" - " + pokemon));
        }
    }
}
