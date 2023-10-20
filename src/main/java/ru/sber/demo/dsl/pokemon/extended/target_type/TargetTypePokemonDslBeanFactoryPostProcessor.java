package ru.sber.demo.dsl.pokemon.extended.target_type;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.core.ResolvableType;
import ru.sber.demo.dsl.pokemon.AbstractPokemonDslBeanFactoryPostProcessor;
import ru.sber.demo.dsl.pokemon.PokemonFactoryBean;
import ru.sber.demo.dsl.pokemon.PokemonMasterFactoryBean;
import ru.sber.demo.model.api.Pokemon;
import ru.sber.demo.model.PokemonMaster;

public class TargetTypePokemonDslBeanFactoryPostProcessor extends AbstractPokemonDslBeanFactoryPostProcessor {
    
    @Override
    protected void registerMaster(BeanDefinitionRegistry beanFactory, String dslBeanName, String masterName,
                                  String pokemonName) {
        RootBeanDefinition master = (RootBeanDefinition) BeanDefinitionBuilder.rootBeanDefinition(
                PokemonMasterFactoryBean.class)
            .addConstructorArgReference(dslBeanName)
            .addConstructorArgReference(pokemonName)
            .setScope(BeanDefinition.SCOPE_SINGLETON)
            .getBeanDefinition();
        
        master.setTargetType(ResolvableType.forClass(PokemonMaster.class));
        beanFactory.registerBeanDefinition(masterName, master);
    }
    
    @Override
    protected void registerPokemon(BeanDefinitionRegistry beanFactory, String dslBeanName, String pokemonName) {
        RootBeanDefinition pokemon = (RootBeanDefinition) BeanDefinitionBuilder.rootBeanDefinition(PokemonFactoryBean.class)
            .addConstructorArgReference("demo-ru.sber.demo.PokemonConfigurationProperties")
            .addConstructorArgReference(dslBeanName)
            .setScope(BeanDefinition.SCOPE_SINGLETON)
            .getBeanDefinition();
        pokemon.setTargetType(ResolvableType.forClass(Pokemon.class));
        beanFactory.registerBeanDefinition(pokemonName, pokemon);
    }
}
