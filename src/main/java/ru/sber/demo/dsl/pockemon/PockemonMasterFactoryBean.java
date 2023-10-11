package ru.sber.demo.dsl.pockemon;

import org.springframework.beans.factory.FactoryBean;
import ru.sber.demo.model.Pockemon;
import ru.sber.demo.model.PockemonMaster;

public class PockemonMasterFactoryBean implements FactoryBean<PockemonMaster> {
    private final PockemonDsl dsl;
    private final Pockemon pockemon;
    
    public PockemonMasterFactoryBean(PockemonDsl dsl, Pockemon pockemon) {
        this.dsl = dsl;
        this.pockemon = pockemon;
    }
    
    @Override
    public PockemonMaster getObject() throws Exception {
        return new PockemonMaster(dsl.getMasterName(), pockemon);
    }
    
    @Override
    public Class<?> getObjectType() {
        return PockemonMaster.class;
    }
}
