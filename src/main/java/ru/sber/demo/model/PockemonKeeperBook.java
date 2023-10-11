package ru.sber.demo.model;

import java.util.Collection;

public class PockemonKeeperBook {
    private final Collection<String> names;
    
    public PockemonKeeperBook(Collection<String> names) {
        this.names = names;
    }
    
    public Collection<String> getNames() {
        return names;
    }
}
