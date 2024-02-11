package ru.sber.demo.bfpp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.core.ResolvableType;
import ru.sber.demo.model.Pokemon;
import ru.sber.demo.model.PokemonDsl;
import ru.sber.demo.model.PokemonMaster;
import ru.sber.demo.utils.PokemonFactoryBean;

public class PokemonDslBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        final String[] pokemonDslBeanNames = beanFactory.getBeanNamesForType(PokemonDsl.class);
        final BeanDefinitionRegistry beanDefinitionRegistry = (BeanDefinitionRegistry) beanFactory;
        
        for (String pokemonBeanName : pokemonDslBeanNames) {
            
            final String newPokemonDslBeanName = pokemonBeanName + "#dsl";
            RootBeanDefinition pokemonFactoryBean =
                (RootBeanDefinition) BeanDefinitionBuilder.rootBeanDefinition(PokemonFactoryBean.class)
                    .addConstructorArgReference(newPokemonDslBeanName)
                    .addConstructorArgReference("demo-ru.sber.demo.PokemonConfigurationPropertiesClass")
                    .setScope(BeanDefinition.SCOPE_SINGLETON)
                    .getBeanDefinition();
            
            final BeanDefinition dslBeanDefinition = beanDefinitionRegistry.getBeanDefinition(pokemonBeanName);
            pokemonFactoryBean.setOriginatingBeanDefinition(dslBeanDefinition);
            
            beanDefinitionRegistry.removeBeanDefinition(pokemonBeanName);
            beanDefinitionRegistry.registerBeanDefinition(pokemonBeanName, pokemonFactoryBean);
            beanDefinitionRegistry.registerBeanDefinition(newPokemonDslBeanName, dslBeanDefinition);
            
            RootBeanDefinition pokemonMaster =
                (RootBeanDefinition) BeanDefinitionBuilder.rootBeanDefinition(PokemonMaster.class)
                    .addConstructorArgReference(newPokemonDslBeanName)
                    .addConstructorArgReference(pokemonBeanName)
                    .setScope(BeanDefinition.SCOPE_SINGLETON).getBeanDefinition();
            beanDefinitionRegistry.registerBeanDefinition("masterFor" + pokemonBeanName, pokemonMaster);
            
        }
    }
}
