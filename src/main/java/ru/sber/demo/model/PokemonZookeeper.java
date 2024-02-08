package ru.sber.demo.model;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

import java.util.Collection;

public class PokemonZookeeper {
    
    private final Collection<String> pockemonsNames;
    private final Collection<String> workersNames;
    
    public PokemonZookeeper(Collection<String> pokemonsNames, Collection<String> workersNames) {
        this.pockemonsNames = pokemonsNames;
        this.workersNames = workersNames;
    }
    
    @EventListener(ContextRefreshedEvent.class)
    public void welcome() {
        System.out.println("Добро пожаловать в зоопарк покемонов, мой юный друг! Я хранитель зоопарка.");
        System.out.println("У нас работают: " + workersNames);
        if (pockemonsNames.isEmpty()) {
            System.out.println("У нас пока нет покемонов :(");
        } else {
            System.out.println("У нас живут покемоны со следующими именами: ");
            pockemonsNames.forEach(
                name -> System.out.println(" - " + name)
            );
        }
        
    }
}
