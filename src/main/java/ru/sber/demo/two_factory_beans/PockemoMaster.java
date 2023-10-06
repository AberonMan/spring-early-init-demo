package ru.sber.demo.two_factory_beans;

import ru.sber.demo.pockemons.Pickachu;

public class PockemoMaster {
    public PockemoMaster(Pickachu pickachu) {
        System.out.println(pickachu.pockemonImage());
    }
}
