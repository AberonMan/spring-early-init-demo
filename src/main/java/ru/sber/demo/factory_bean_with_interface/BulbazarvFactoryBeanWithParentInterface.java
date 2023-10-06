package ru.sber.demo.factory_bean_with_interface;

import org.springframework.beans.factory.config.AbstractFactoryBean;
import ru.sber.demo.pockemons.Bulbazavr;
import ru.sber.demo.PockemonConfigurationProperties;
import ru.sber.demo.pockemons.Pockemon;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

public class BulbazarvFactoryBeanWithParentInterface extends AbstractFactoryBean<Pockemon> {
    
    private final PockemonConfigurationProperties testConfigurationProperties;
    
    public BulbazarvFactoryBeanWithParentInterface(PockemonConfigurationProperties testConfigurationProperties) {
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
