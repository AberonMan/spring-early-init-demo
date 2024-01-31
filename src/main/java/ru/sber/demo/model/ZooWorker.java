package ru.sber.demo.model;

import javax.annotation.PostConstruct;

import java.util.Set;

public class ZooWorker {
    
    private final Set<String> pokemonNames;
    
    public ZooWorker(Set<String> pokemonNames) {
        this.pokemonNames = pokemonNames;
    }
    
    @PostConstruct
    public void init() {
        work();
    }
    
    public void work() {
        System.out.println("==================");
        System.out.println("Опять работать((");
        System.out.println("Покемоны, мои покемоны...");
        System.out.println("Вот они, слева направо: " + String.join(", ", pokemonNames));
        System.out.println("==================");
    }
}
