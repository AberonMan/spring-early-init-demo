package ru.sber.demo.dsl.pockemon;

import org.springframework.beans.factory.FactoryBean;
import ru.sber.demo.model.api.Pokemon;
import ru.sber.demo.model.PokemonMaster;

public class PokemonMasterFactoryBean implements FactoryBean<PokemonMaster> {
    private final PokemonDsl dsl;
    private final Pokemon pockemon;
    
    public PokemonMasterFactoryBean(PokemonDsl dsl, Pokemon pockemon) {
        this.dsl = dsl;
        this.pockemon = pockemon;
    }
    
    @Override
    public PokemonMaster getObject() throws Exception {
        return new PokemonMaster(dsl.getMasterName(), pockemon);
    }
    
    @Override
    public Class<?> getObjectType() {
        return PokemonMaster.class;
    }
}
