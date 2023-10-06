package ru.sber.demo.pockemons;

public class Bulbazavr implements Pockemon {
    
    private final String bulbazavrImage;
    
    public Bulbazavr(String bulbazavrImage) {
        this.bulbazavrImage = bulbazavrImage;
    }
    
    @Override
    public String pockemonImage() {
        return bulbazavrImage;
    }
}
