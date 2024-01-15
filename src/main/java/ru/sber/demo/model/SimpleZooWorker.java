package ru.sber.demo.model;

import ru.sber.demo.model.api.ZooWorker;

import jakarta.annotation.PostConstruct;

import java.util.Set;

public class SimpleZooWorker implements ZooWorker {
    
    private final Set<String> pokemonNames;
    
    public SimpleZooWorker(Set<String> pokemonNames) {
        this.pokemonNames = pokemonNames;
    }
    
    @PostConstruct
    public void init() {
        work();
    }
    
    @Override
    public void work() {
        System.out.println("==================");
        System.out.println("Опять работать((");
        System.out.println("Покемоны, мои покемоны...");
        System.out.println("Вот они, слева направо: " + String.join(", ", pokemonNames));
        System.out.println("==================");
    }
}
