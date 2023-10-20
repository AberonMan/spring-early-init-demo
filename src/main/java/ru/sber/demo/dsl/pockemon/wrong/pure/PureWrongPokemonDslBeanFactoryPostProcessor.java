package ru.sber.demo.dsl.pockemon.wrong.pure;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import ru.sber.demo.dsl.pockemon.AbstractPokemonDslBeanFactoryPostProcessor;
import ru.sber.demo.dsl.pockemon.PokemonFactoryBean;
import ru.sber.demo.dsl.pockemon.PokemonMasterFactoryBean;

public class PureWrongPokemonDslBeanFactoryPostProcessor extends AbstractPokemonDslBeanFactoryPostProcessor {
    
    @Override
    protected void registerMaster(BeanDefinitionRegistry beanFactory, String dslBeanName, String masterName,
                                  String pockemonName) {
        RootBeanDefinition master = (RootBeanDefinition) BeanDefinitionBuilder.rootBeanDefinition(
                PokemonMasterFactoryBean.class)
            .addConstructorArgReference(dslBeanName)
            .addConstructorArgReference(pockemonName)
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
