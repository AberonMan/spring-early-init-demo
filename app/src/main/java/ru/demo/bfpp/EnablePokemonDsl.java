package ru.demo.bfpp;

import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import({
    PokemonDslImportBeanDefinitionRegistrar.class,
    WorkerConfigurationImportSelector.class
})
public @interface EnablePokemonDsl {
    boolean loadWorkers() default false;
}
