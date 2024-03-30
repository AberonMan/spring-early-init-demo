package ru.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

import java.util.Collection;

@RequiredArgsConstructor
public class PokemonWelcomeBoard {
    
    private final Collection<String> pockemonsNames;
    private final Collection<String> workersNames;
    
    @EventListener(ContextRefreshedEvent.class)
    public void printAllPokemonInContext() {
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
