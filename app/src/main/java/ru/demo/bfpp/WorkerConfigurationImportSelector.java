package ru.demo.bfpp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;
import ru.demo.model.Pokemon;
import ru.demo.model.ZooWorker;

import java.util.Map;

public class WorkerConfigurationImportSelector implements ImportSelector {
    
    @Override
    public String[] selectImports(AnnotationMetadata metadata) {
        AnnotationAttributes attributes =
            AnnotationAttributes.fromMap(metadata.getAnnotationAttributes(EnablePokemonDsl.class.getName(), true));
        
        if (attributes != null && Boolean.TRUE.equals(attributes.getBoolean("loadWorkers"))) {
            return new String[] { WorkerConfiguration.class.getName() };
        }
        
        return new String[0];
    }
    
    static class WorkerConfiguration {
        
        @Bean
        ZooWorker zooWorker(Map<String, Pokemon> pokemons) {
            return new ZooWorker(pokemons.keySet(), "Вася");
        }
    }
}
