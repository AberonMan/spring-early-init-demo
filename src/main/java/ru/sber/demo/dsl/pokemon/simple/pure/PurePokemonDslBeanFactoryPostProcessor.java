package ru.sber.demo.dsl.pokemon.simple.pure;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import ru.sber.demo.dsl.pokemon.AbstractPokemonDslBeanFactoryPostProcessor;
import ru.sber.demo.dsl.pokemon.PokemonFactoryBean;
import ru.sber.demo.dsl.pokemon.PokemonMasterFactoryBean;

public class PurePokemonDslBeanFactoryPostProcessor extends AbstractPokemonDslBeanFactoryPostProcessor {
    
    @Override
    protected void registerMaster(BeanDefinitionRegistry beanFactory, String dslBeanName, String masterName,
                                  String pokemonName) {
        RootBeanDefinition master = (RootBeanDefinition) BeanDefinitionBuilder.rootBeanDefinition(
                PokemonMasterFactoryBean.class)
            .addConstructorArgReference(dslBeanName)
            .addConstructorArgReference(pokemonName)
            .setScope(BeanDefinition.SCOPE_SINGLETON)
            .getBeanDefinition();
        beanFactory.registerBeanDefinition(masterName, master);
    }
    
    @Override
    protected void registerPokemon(BeanDefinitionRegistry beanFactory, String dslBeanName, String pokemonName) {
        RootBeanDefinition pokemon = (RootBeanDefinition) BeanDefinitionBuilder.rootBeanDefinition(PokemonFactoryBean.class)
            .addConstructorArgReference("demo-ru.sber.demo.PokemonConfigurationProperties")
            .addConstructorArgReference(dslBeanName)
            .setScope(BeanDefinition.SCOPE_SINGLETON)
            .getBeanDefinition();
        beanFactory.registerBeanDefinition(pokemonName, pokemon);
    }
}
