package ru.sber.demo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import ru.sber.demo.pockemons.Bulbazavr;
import ru.sber.demo.pockemons.Pockemon;

import java.util.Arrays;
import java.util.stream.IntStream;

public class BulbazavrBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("Factory bean in context 👇");
        IntStream.range(1, 40).forEach(value -> System.out.print("="));
        System.out.println();
        Arrays.stream(beanFactory.getBeanNamesForType(Bulbazavr.class)).forEach(System.out::println);
        IntStream.range(1, 40).forEach(value -> System.out.print("="));
        System.out.println();
    }
    
}
