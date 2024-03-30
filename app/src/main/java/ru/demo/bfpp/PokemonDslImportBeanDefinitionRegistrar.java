package ru.demo.bfpp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.ResolvableType;
import org.springframework.core.type.AnnotationMetadata;
import ru.demo.PokemonConfigurationProperties;
import ru.demo.model.Pokemon;
import ru.demo.model.PokemonDsl;
import ru.demo.model.PokemonMaster;
import ru.demo.utils.PockemonFactoryBean;

import static org.springframework.beans.factory.support.BeanDefinitionBuilder.rootBeanDefinition;

public class PokemonDslImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar, BeanFactoryAware {
    
    private ConfigurableListableBeanFactory beanFactory;
    
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry,
                                        BeanNameGenerator importBeanNameGenerator) {
        
        for (String dslName : beanFactory.getBeanNamesForType(PokemonDsl.class)) {
            final AbstractBeanDefinition pokemonBeanDefinition =
                rootBeanDefinition(PockemonFactoryBean.class).addConstructorArgReference(dslName).getBeanDefinition();
            pokemonBeanDefinition.getConstructorArgumentValues()
                .addGenericArgumentValue(new RuntimeBeanReference(PokemonConfigurationProperties.class));
            ((RootBeanDefinition) pokemonBeanDefinition).setTargetType(ResolvableType.forType(Pokemon.class));
            
            final String pokemonBeanName = dslName + "#generated";
            registry.registerBeanDefinition(pokemonBeanName, pokemonBeanDefinition);
            
            final AbstractBeanDefinition masterBeanDefinition =
                rootBeanDefinition(PokemonMaster.class).addConstructorArgReference(dslName)
                    .addConstructorArgReference(pokemonBeanName).getBeanDefinition();
            
            registry.registerBeanDefinition("master_for_%s".formatted(pokemonBeanName), masterBeanDefinition);
        }
        
    }
    
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = (ConfigurableListableBeanFactory) beanFactory;
    
    }
}
