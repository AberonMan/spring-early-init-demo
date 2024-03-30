package ru.demo.bfpp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.core.ResolvableType;
import ru.demo.PokemonConfigurationProperties;
import ru.demo.model.Pokemon;
import ru.demo.model.PokemonDsl;
import ru.demo.model.PokemonMaster;
import ru.demo.utils.PockemonFactoryBean;

public class PokemonDslBeanFactoryPostProcessor implements BeanDefinitionRegistryPostProcessor {
    
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        final ConfigurableListableBeanFactory beanFactory = (ConfigurableListableBeanFactory) registry;
        for (String dslName : beanFactory.getBeanNamesForType(PokemonDsl.class)) {
            final AbstractBeanDefinition pokemonBeanDefinition = BeanDefinitionBuilder.rootBeanDefinition(PockemonFactoryBean.class)
                .addConstructorArgReference(dslName).getBeanDefinition();
            pokemonBeanDefinition.getConstructorArgumentValues()
                .addGenericArgumentValue(new RuntimeBeanReference(PokemonConfigurationProperties.class));
            ((RootBeanDefinition) pokemonBeanDefinition).setTargetType(ResolvableType.forType(Pokemon.class));
            
            final String pokemonBeanName = dslName + "#generated";
            registry.registerBeanDefinition(pokemonBeanName, pokemonBeanDefinition);
            
            final AbstractBeanDefinition masterBeanDefinition =
                BeanDefinitionBuilder.rootBeanDefinition(PokemonMaster.class).addConstructorArgReference(dslName)
                    .addConstructorArgReference(pokemonBeanName).getBeanDefinition();
            
            registry.registerBeanDefinition("master_for_%s".formatted(pokemonBeanName), masterBeanDefinition);
        }
    }
    
}
