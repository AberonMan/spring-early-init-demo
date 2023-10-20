package ru.sber.demo.model;

import ru.sber.demo.model.api.Pokemon;

public class PokemonMaster {
    private final String name;
    private final Pokemon pockemon;
    
    public PokemonMaster(String name, Pokemon pockemon) {
        System.out.println("Я покемон-мастер " + name + "!");
        System.out.println("Я тренирую его!");
        System.out.println(pockemon.pockemonImage());
        System.out.println("=======================");
        this.pockemon = pockemon;
        this.name = name;
    }
}
