package ru.sber.demo.model;

public class PockemonMaster {
    private final String name;
    private final Pockemon pockemon;
    
    public PockemonMaster(String name, Pockemon pockemon) {
        System.out.println("Я покемон-мастер " + name + "!");
        System.out.println("Я тренирую его!");
        System.out.println(pockemon.pockemonImage());
        System.out.println("=======================");
        this.pockemon = pockemon;
        this.name = name;
    }
}
