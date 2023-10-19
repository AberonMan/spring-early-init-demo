package ru.sber.demo.app.dsl.right.annotation;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import ru.sber.demo.model.api.Pockemon;

import java.util.List;

public class DefaultPockemonPrinter {

    private final List<Pockemon> pockemons;

    public DefaultPockemonPrinter(List<Pockemon> pokemons) {
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
