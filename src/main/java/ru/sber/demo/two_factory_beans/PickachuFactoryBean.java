package ru.sber.demo.two_factory_beans;

import org.springframework.beans.factory.FactoryBean;
import ru.sber.demo.PockemonConfigurationProperties;
import ru.sber.demo.pockemons.Pickachu;
import ru.sber.demo.pockemons.Pockemon;

import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Важно, что тут {@link FactoryBean}!!
 */
public class PickachuFactoryBean implements FactoryBean<Pockemon> {
    
    private final PockemonConfigurationProperties properties;
    
    public PickachuFactoryBean(PockemonConfigurationProperties configurationProperties) {
        properties = configurationProperties;
    }
    
    @Override
    public boolean isSingleton() {
        return true;
    }
    
    @Override
    public Pockemon getObject() throws Exception {
        final String pickachuImage =
            Files.readString(Paths.get(Thread.currentThread().getContextClassLoader().getResource(properties.pathToPickachu()).toURI()));
        System.out.println(pickachuImage);
        return new Pickachu(properties.pathToPickachu());
    }
    
    @Override
    public Class<?> getObjectType() {
        return Pickachu.class;
    }
    
}
