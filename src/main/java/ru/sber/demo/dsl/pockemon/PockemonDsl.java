package ru.sber.demo.dsl.pockemon;

import ru.sber.demo.model.PockemonType;

public class PockemonDsl {
    private final PockemonType type;
    private String masterName;
    
    public PockemonDsl(PockemonType type) {
        
        this.type = type;
    }
    
    public PockemonDsl byMaster(String masterName) {
        this.masterName = masterName;
        return this;
    }
    
    public PockemonType getType() {
        return type;
    }
    
    public String getMasterName() {
        return masterName;
    }
}
