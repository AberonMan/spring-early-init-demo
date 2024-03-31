package ru.demo.initializer;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.support.GenericApplicationContext;
import ru.demo.PokemonConfigurationProperties;
import ru.demo.model.Pokemon;
import ru.demo.model.PokemonMaster;
import ru.demo.model.PokemonType;
import ru.demo.utils.PokemonFactory;

public abstract class PokemonDslBeanInitializer implements ApplicationContextInitializer<GenericApplicationContext> {
    private static final ThreadLocal<GenericApplicationContext> CONTEXT_THREAD_LOCAL = new ThreadLocal<>();
    
    @Override
    public void initialize(GenericApplicationContext applicationContext) {
        CONTEXT_THREAD_LOCAL.set(applicationContext);
        initialize();
        CONTEXT_THREAD_LOCAL.remove();
    }
    
    protected abstract void initialize();
    
    protected void pokemon(String name, PokemonType type, String masterName) {
        GenericApplicationContext context = CONTEXT_THREAD_LOCAL.get();
        context.registerBean(
            name,
            Pokemon.class,
            () -> PokemonFactory.createPokemon(type, context.getBean(PokemonConfigurationProperties.class))
        );
        
        context.registerBean(
            "masterFor" + name,
            PokemonMaster.class,
            () -> new PokemonMaster(masterName, context.getBean(name, Pokemon.class)),
            bd -> bd.setDependsOn(name)
        );
    }
    
}