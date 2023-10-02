package ru.sber.demo;

import org.springframework.beans.factory.config.AbstractFactoryBean;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

public class BulbazavrFactoryBean extends AbstractFactoryBean<Bulbazavr> {
    
    private final BulbazavrConfigurationProperties testConfigurationProperties;
    
    public BulbazavrFactoryBean(BulbazavrConfigurationProperties testConfigurationProperties) {
        this.testConfigurationProperties = testConfigurationProperties;
    }
    
    @Override
    public Class<?> getObjectType() {
        return Bulbazavr.class;
    }
    
    @Override
    protected Bulbazavr createInstance() throws Exception {
        final String pathToFile = testConfigurationProperties.pathToFile();
        Objects.requireNonNull(pathToFile, "Path to file with bulbazavr can't be null!");
        final String bulbazavrImage =
            Files.readString(Paths.get(Thread.currentThread().getContextClassLoader().getResource(pathToFile).toURI()));
        System.out.println(bulbazavrImage);
        return new Bulbazavr(bulbazavrImage);
    }
    
}
