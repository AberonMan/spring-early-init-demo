package ru.sber.demo.app.dsl.extended.annotation;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import ru.sber.demo.model.api.Pokemon;

import java.util.List;

public class DefaultPokemonPrinter {

    private final List<Pokemon> pockemons;

    public DefaultPokemonPrinter(List<Pokemon> pokemons) {
        this.pockemons = pokemons;
    }

    @EventListener(ContextRefreshedEvent.class)
    public void print() {
        if (pockemons.isEmpty()) {
            System.out.println("В наборе по умолчанию нет покемонов!");
        } else {
            System.out.println("Набор по умолчанию: ");
            pockemons.forEach(pockemon -> System.out.println(" - " + pockemon));
        }
    }
}
