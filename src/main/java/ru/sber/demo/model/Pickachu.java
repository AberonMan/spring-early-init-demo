package ru.sber.demo.model;

public class Pickachu extends AbstractPockemon {
    public Pickachu(String pockemonImage, boolean shiny) {
        super(pockemonImage, shiny);
    }
    
    @Override
    public PockemonType pockemonType() {
        return PockemonType.PICKACHU;
    }
}
