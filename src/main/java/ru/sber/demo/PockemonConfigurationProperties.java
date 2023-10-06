package ru.sber.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "demo")
public class PockemonConfigurationProperties {
    
    private String pathToBulbazvr;
    
    private String pathToPickachu;
    
    public String pathToPickachu() {
        return pathToPickachu;
    }
    
    public void setPathToPickachu(String pathToPickachu) {
        this.pathToPickachu = pathToPickachu;
    }
    
    public String pathToBulbazvr() {
        return pathToBulbazvr;
    }
    
    public void setPathToBulbazvr(String pathToBulbazvr) {
        this.pathToBulbazvr = pathToBulbazvr;
    }
}
