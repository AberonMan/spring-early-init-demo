package ru.sber.demo.model;

public abstract class AbstractPockemon implements Pockemon {
    private final String pockemonImage;
    private final boolean shiny;
    
    protected AbstractPockemon(String pockemonImage, boolean shiny) {
        this.pockemonImage = pockemonImage;
        this.shiny = shiny;
    }
    
    @Override
    public String pockemonImage() {
        return pockemonImage;
    }
    
    @Override
    public boolean isShiny() {
        return shiny;
    }
}
