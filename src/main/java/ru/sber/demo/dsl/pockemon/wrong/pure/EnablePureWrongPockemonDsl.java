package ru.sber.demo.dsl.pockemon.wrong.pure;

import org.springframework.context.annotation.Import;
import ru.sber.demo.dsl.keeper.WithZookeeperConfiguration;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(PureWrongPockemonDslConfiguration.class)
public @interface EnablePureWrongPockemonDsl {
}
