package ru.sber.demo.simple_factory_bean;

import org.springframework.beans.factory.config.AbstractFactoryBean;
import ru.sber.demo.pockemons.Bulbazavr;
import ru.sber.demo.PockemonConfigurationProperties;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

public class BulbazarvNotGenericFactoryBean extends AbstractFactoryBean<Bulbazavr> {
    
    private final PockemonConfigurationProperties testConfigurationProperties;
    
    public BulbazarvNotGenericFactoryBean(PockemonConfigurationProperties testConfigurationProperties) {
        this.testConfigurationProperties = testConfigurationProperties;
    }
    
    @Override
    public Class<?> getObjectType() {
        return Bulbazavr.class;
    }
    
    @Override
    protected Bulbazavr createInstance() throws Exception {
        final String pathToFile = testConfigurationProperties.pathToBulbazvr();
        Objects.requireNonNull(pathToFile, "Path to file with bulbazavr can't be null!");
        final String bulbazavrImage =
            Files.readString(Paths.get(Thread.currentThread().getContextClassLoader().getResource(pathToFile).toURI()));
        System.out.println(bulbazavrImage);
        return new Bulbazavr(bulbazavrImage);
    }
    
}
