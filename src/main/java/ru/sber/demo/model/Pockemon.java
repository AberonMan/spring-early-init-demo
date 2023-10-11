package ru.sber.demo.model;

import ru.sber.demo.dsl.pockemon.PockemonDsl;

public interface Pockemon {
    String pockemonImage();
    PockemonType pockemonType();
    boolean isShiny();
    
    static PockemonDsl catchPokemon(PockemonType type) {
        return new PockemonDsl(type);
    }
}
