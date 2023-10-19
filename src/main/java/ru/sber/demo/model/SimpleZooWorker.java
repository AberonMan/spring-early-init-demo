package ru.sber.demo.model;

import ru.sber.demo.model.api.ZooWorker;

import javax.annotation.PostConstruct;

public class SimpleZooWorker implements ZooWorker {
    
    @PostConstruct
    public void init() {
        work();
    }
    
    @Override
    public void work() {
        System.out.println("Опять работать((");
    }
}
