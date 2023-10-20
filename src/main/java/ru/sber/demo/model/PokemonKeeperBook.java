package ru.sber.demo.model;

import java.util.Collection;

public class PokemonKeeperBook {
    private final Collection<String> names;
    
    public PokemonKeeperBook(Collection<String> names) {
        this.names = names;
    }
    
    public Collection<String> getNames() {
        return names;
    }
}
