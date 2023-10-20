package ru.sber.demo.dsl.pockemon.right.attribute;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import ru.sber.demo.dsl.pockemon.AbstractPokemonDslBeanFactoryPostProcessor;
import ru.sber.demo.dsl.pockemon.PokemonFactoryBean;
import ru.sber.demo.dsl.pockemon.PokemonMasterFactoryBean;
import ru.sber.demo.model.api.Pokemon;
import ru.sber.demo.model.PokemonMaster;

public class RightAttributePokemonDslBeanFactoryPostProcessor extends AbstractPokemonDslBeanFactoryPostProcessor {
    
    @Override
    protected void registerMaster(BeanDefinitionRegistry beanFactory, String dslBeanName, String masterName,
                                  String pockemonName) {
        RootBeanDefinition master = (RootBeanDefinition) BeanDefinitionBuilder.rootBeanDefinition(
                PokemonMasterFactoryBean.class)
            .addConstructorArgReference(dslBeanName)
            .addConstructorArgReference(pockemonName)
            .setScope(BeanDefinition.SCOPE_SINGLETON)
            .getBeanDefinition();
        master.setAttribute(FactoryBean.OBJECT_TYPE_ATTRIBUTE, PokemonMaster.class);
        beanFactory.registerBeanDefinition(masterName, master);
    }
    
    @Override
    protected void registerPokemon(BeanDefinitionRegistry beanFactory, String dslBeanName, String pokemonName) {
        RootBeanDefinition pokemon = (RootBeanDefinition) BeanDefinitionBuilder.rootBeanDefinition(PokemonFactoryBean.class)
            .addConstructorArgReference("demo-ru.sber.demo.PokemonConfigurationProperties")
            .addConstructorArgReference(dslBeanName)
            .setScope(BeanDefinition.SCOPE_SINGLETON)
            .getBeanDefinition();
        pokemon.setAttribute(FactoryBean.OBJECT_TYPE_ATTRIBUTE, Pokemon.class);
        beanFactory.registerBeanDefinition(pokemonName, pokemon);
    }
}
