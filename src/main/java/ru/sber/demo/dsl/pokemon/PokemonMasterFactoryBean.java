package ru.sber.demo.dsl.pokemon;

import org.springframework.beans.factory.FactoryBean;
import ru.sber.demo.model.api.Pokemon;
import ru.sber.demo.model.PokemonMaster;

public class PokemonMasterFactoryBean implements FactoryBean<PokemonMaster> {
    private final PokemonDsl dsl;
    private final Pokemon pokemon;
    
    public PokemonMasterFactoryBean(PokemonDsl dsl, Pokemon pokemon) {
        this.dsl = dsl;
        this.pokemon = pokemon;
    }
    
    @Override
    public PokemonMaster getObject() {
        return new PokemonMaster(dsl.getMasterName(), pokemon);
    }
    
    @Override
    public Class<?> getObjectType() {
        return PokemonMaster.class;
    }
}
