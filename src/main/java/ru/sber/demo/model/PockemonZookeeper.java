package ru.sber.demo.model;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

public class PockemonZookeeper {
    private final PockemonKeeperBook book;
    
    public PockemonZookeeper(PockemonKeeperBook book) {
        this.book = book;
    }
    
    @EventListener(ContextRefreshedEvent.class)
    public void welcome() {
        System.out.println("Добро пожаловать в зоопарк покемонов!");
        System.out.println("У нас живут покемоны со следующими именами: ");
        book.getNames().forEach(
            name -> System.out.println(" - " + name)
        );
        
    }
}
