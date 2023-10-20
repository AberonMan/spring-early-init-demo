package ru.sber.demo.dsl.pokemon.extended.attribute;

import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(AttributePokemonDslConfiguration.class)
public @interface EnableAttributePokemonDsl {
}
