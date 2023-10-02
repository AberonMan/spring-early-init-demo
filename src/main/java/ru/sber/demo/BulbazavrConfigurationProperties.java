package ru.sber.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "demo")
public class BulbazavrConfigurationProperties {
    
    private String pathToFile;
    
    public String pathToFile() {
        return pathToFile;
    }
    
    public void setPathToFile(String pathToFile) {
        this.pathToFile = pathToFile;
    }
}
