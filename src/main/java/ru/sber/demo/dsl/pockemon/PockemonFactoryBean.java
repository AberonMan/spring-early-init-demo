package ru.sber.demo.dsl.pockemon;

import org.springframework.beans.factory.FactoryBean;
import ru.sber.demo.PockemonConfigurationProperties;
import ru.sber.demo.model.Bulbazavr;
import ru.sber.demo.model.Pickachu;
import ru.sber.demo.model.api.Pockemon;
import ru.sber.demo.model.PockemonType;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

/**
 * Важно, что тут {@link FactoryBean}!!
 */
public class PockemonFactoryBean implements FactoryBean<Pockemon> {
    
    private static final Random RANDOM = new Random();
    private final PockemonConfigurationProperties properties;
    private PockemonType type;
    
    public PockemonFactoryBean(PockemonConfigurationProperties configurationProperties, PockemonDsl dsl) {
        this.properties = configurationProperties;
        this.type = dsl.getType();
    }
    
    public PockemonFactoryBean(PockemonConfigurationProperties configurationProperties) {
        this.properties = configurationProperties;
    }
    
    @Override
    public boolean isSingleton() {
        return true;
    }
    
    @Override
    public Pockemon getObject() throws Exception {
        boolean shiny = isShiny();
        switch(type) {
            case PICKACHU:
                return new Pickachu(
                    getPockemonImage(properties.pathToPickachu()),
                    shiny
                );
            case BULBAZAVR:
                return new Bulbazavr(
                    getPockemonImage(properties.pathToBulbazvr()),
                    shiny
                );
            default:
                throw new IllegalStateException();
        }
    }
    
    private boolean isShiny() {
        return RANDOM.nextInt() % 4096 == 1345;
    }
    
    private String getPockemonImage(String properties) throws IOException, URISyntaxException {
        return Files.readString(
            Paths.get(
                Thread.currentThread()
                    .getContextClassLoader()
                    .getResource(properties)
                    .toURI()
            )
        );
    }
    
    @Override
    public Class<?> getObjectType() {
        switch(type) {
            case PICKACHU:
                return Pickachu.class;
            case BULBAZAVR:
                return Bulbazavr.class;
            default:
                throw new IllegalStateException();
        }
    }
    
    public PockemonFactoryBean withType(PockemonType type) {
        this.type = type;
        return this;
    }
}
