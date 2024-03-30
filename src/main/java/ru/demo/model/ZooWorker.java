package ru.demo.model;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@RequiredArgsConstructor
public class ZooWorker {
    
    private final Set<String> pokemonNames;
    
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
