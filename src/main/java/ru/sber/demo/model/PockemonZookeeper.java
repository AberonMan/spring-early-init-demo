package ru.sber.demo.model;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

import java.util.Collection;

public class PockemonZookeeper {
    private final PockemonKeeperBook book;
    
    public PockemonZookeeper(PockemonKeeperBook book) {
        this.book = book;
    }
    
    @EventListener(ContextRefreshedEvent.class)
    public void welcome() {
        System.out.println("Добро пожаловать в зоопарк покемонов!");
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
