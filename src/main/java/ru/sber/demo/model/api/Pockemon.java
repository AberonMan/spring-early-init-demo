package ru.sber.demo.model.api;

import ru.sber.demo.dsl.pockemon.PockemonDsl;
import ru.sber.demo.model.PockemonType;

public interface Pockemon {
    String pockemonImage();
    PockemonType pockemonType();
    boolean isShiny();
    
    static PockemonDsl catchPokemon(PockemonType type) {
        return new PockemonDsl(type);
    }
}
