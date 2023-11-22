package ru.sber.demo.app.factory_bean.morebeans;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import ru.sber.demo.PokemonConfigurationProperties;
import ru.sber.demo.dsl.keeper.WithZookeeper;
import ru.sber.demo.dsl.pokemon.PokemonFactoryBean;
import ru.sber.demo.model.PokemonMaster;
import ru.sber.demo.model.PokemonType;
import ru.sber.demo.model.api.Pokemon;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties(PokemonConfigurationProperties.class)
@WithZookeeper
public class MoreBeansWithoutDslPokemonApplication {
    public static final String MISHA = "misha";
    public static final String MISHA_MASTER = "Egor";
    public static final String ZHENYA = "zhenya";
    public static final String ZHENYA_MASTER = "Arsen";
    public static final String MAKSIM = "maksim";
    public static final String MAKSIM_MASTER = "Veronika";
    public static final String VALENTIN = "Valentin";
    public static final String VALENTIN_MASTER = "Galina";
    
    public static void main(String[] args) {
        SpringApplication.run(MoreBeansWithoutDslPokemonApplication.class, args);
    }
    
    @Bean(MISHA)
    public PokemonFactoryBean misha(PokemonConfigurationProperties properties) {
        return new PokemonFactoryBean(properties).withType(PokemonType.PICKACHU);
    }
    
    @Bean(name = MISHA_MASTER)
    public PokemonMaster mishaMaster(@Qualifier(MISHA) Pokemon pokemon) {
        return new PokemonMaster(MISHA_MASTER, pokemon);
    }
    
    @Bean(ZHENYA)
    public PokemonFactoryBean zhenya(PokemonConfigurationProperties properties) {
        return new PokemonFactoryBean(properties).withType(PokemonType.BULBAZAVR);
    }
    
    @Bean(name = ZHENYA_MASTER)
    public PokemonMaster zhenyaMaster(@Qualifier(ZHENYA) Pokemon pokemon) {
        return new PokemonMaster(ZHENYA_MASTER, pokemon);
    }
    
    @Bean(MAKSIM)
    public PokemonFactoryBean maksim(PokemonConfigurationProperties properties) {
        return new PokemonFactoryBean(properties).withType(PokemonType.PICKACHU);
    }
    
    @Bean(name = MAKSIM_MASTER)
    public PokemonMaster maksimMaster(@Qualifier(MAKSIM) Pokemon pokemon) {
        return new PokemonMaster(MAKSIM_MASTER, pokemon);
    }
    
    @Bean(VALENTIN)
    public PokemonFactoryBean valentin(PokemonConfigurationProperties properties) {
        return new PokemonFactoryBean(properties).withType(PokemonType.PICKACHU);
    }
    
    @Bean(name = VALENTIN_MASTER)
    public PokemonMaster valentinMaster(@Qualifier(VALENTIN) Pokemon pokemon) {
        return new PokemonMaster(VALENTIN_MASTER, pokemon);
    }
    
    @Bean
    public List<PokemonMaster> masters(List<PokemonMaster> masters) {
        return masters;
    }
}
