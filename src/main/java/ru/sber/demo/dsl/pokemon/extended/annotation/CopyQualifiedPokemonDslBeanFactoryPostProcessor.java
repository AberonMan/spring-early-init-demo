package ru.sber.demo.dsl.pokemon.extended.annotation;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import ru.sber.demo.dsl.pokemon.AbstractPokemonDslBeanFactoryPostProcessor;
import ru.sber.demo.dsl.pokemon.PokemonFactoryBean;
import ru.sber.demo.dsl.pokemon.PokemonMasterFactoryBean;
import ru.sber.demo.model.api.Pokemon;
import ru.sber.demo.model.PokemonMaster;

// See also ScopedProxyUtils
// See also QualifierAnnotationAutowireCandidateResolver
public class CopyQualifiedPokemonDslBeanFactoryPostProcessor extends AbstractPokemonDslBeanFactoryPostProcessor {
    
    @Override
    protected void registerMaster(BeanDefinitionRegistry beanFactory, String dslBeanName, String masterName,
                                  String pokemonName) {

        RootBeanDefinition master = (RootBeanDefinition) BeanDefinitionBuilder.rootBeanDefinition(
                PokemonMasterFactoryBean.class)
            .addConstructorArgReference(dslBeanName)
            .addConstructorArgReference(pokemonName)
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

        copyQualifierMetadata(beanFactory, dslBeanName, pokemon);

        beanFactory.registerBeanDefinition(pokemonName, pokemon);
    }

    private void copyQualifierMetadata(
        BeanDefinitionRegistry beanFactory, String dslBeanName, RootBeanDefinition targetBeanDefinition) {

        BeanDefinition dslBeanDefinition = beanFactory.getBeanDefinition(dslBeanName);

        // Copy autowire settings from original bean definition.
        targetBeanDefinition.setAutowireCandidate(dslBeanDefinition.isAutowireCandidate());
        targetBeanDefinition.setPrimary(dslBeanDefinition.isPrimary());
        if (dslBeanDefinition instanceof AbstractBeanDefinition) {
            targetBeanDefinition.copyQualifiersFrom((AbstractBeanDefinition) dslBeanDefinition);
        }

        targetBeanDefinition.setDecoratedDefinition(new BeanDefinitionHolder(dslBeanDefinition, dslBeanName));
    }
}
