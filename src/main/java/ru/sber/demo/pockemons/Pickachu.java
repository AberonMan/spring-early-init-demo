package ru.sber.demo.pockemons;

import java.util.Objects;

public class Pickachu implements Pockemon {
    
    private final String pathToPickachu;
    public Pickachu(String pathToPickachu) {
        this.pathToPickachu = Objects.requireNonNull(pathToPickachu);
    }
    
    @Override
    public String pockemonImage() {
        return pathToPickachu;
    }
}
