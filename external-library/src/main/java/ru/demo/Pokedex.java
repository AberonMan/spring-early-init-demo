package ru.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import ru.demo.model.ZooWorker;

import java.util.Collection;

@RequiredArgsConstructor
public class Pokedex {
    private final ZooWorker owner;
    private final Collection<String> pokemonNames;
    
    @EventListener(ContextRefreshedEvent.class)
    public void init() {
        System.out.println("Я покедекс для " + owner.getName());
        System.out.println("У меня зарегистрированы покемоны: " + pokemonNames);
    }
}
