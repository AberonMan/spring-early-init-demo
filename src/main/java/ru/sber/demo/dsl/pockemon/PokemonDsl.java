package ru.sber.demo.dsl.pockemon;

import ru.sber.demo.model.PokemonType;

public class PokemonDsl {
    private final PokemonType type;
    private String masterName;
    
    public PokemonDsl(PokemonType type) {
        
        this.type = type;
    }
    
    public PokemonDsl byMaster(String masterName) {
        this.masterName = masterName;
        return this;
    }
    
    public PokemonType getType() {
        return type;
    }
    
    public String getMasterName() {
        return masterName;
    }
}
