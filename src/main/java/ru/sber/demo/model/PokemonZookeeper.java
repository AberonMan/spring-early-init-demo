package ru.sber.demo.model;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

import java.util.Collection;
import java.util.List;

public class PokemonZookeeper {

    private final PokemonKeeperBook book;
    
    private final List<String> workerNames;
    
    public PokemonZookeeper(PokemonKeeperBook book, List<String> workerNames) {
        this.book = book;
        this.workerNames = workerNames;
    }
    
    @EventListener(ContextRefreshedEvent.class)
    public void welcome() {
        System.out.println("Добро пожаловать в зоопарк покемонов, мой юный друг! Я хранитель зоопарка.");
        System.out.println("У нас работают: " + workerNames);
        Collection<String> names = book.getNames();
        if (names.isEmpty()) {
            System.out.println("У нас пока нет покемонов :(");
        } else {
            System.out.println("У нас живут покемоны со следующими именами: ");
            names.forEach(
                name -> System.out.println(" - " + name)
            );
        }
    }
}
