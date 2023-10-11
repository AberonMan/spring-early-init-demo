package ru.sber.demo.model;

public class Bulbazavr extends AbstractPockemon {
    
    public Bulbazavr(String bulbazavrImage, boolean shiny) {
        super(bulbazavrImage, shiny);
    }
    
    @Override
    public PockemonType pockemonType() {
        return PockemonType.BULBAZAVR;
    }
}
