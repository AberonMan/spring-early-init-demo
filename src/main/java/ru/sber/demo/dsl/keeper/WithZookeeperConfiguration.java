package ru.sber.demo.dsl.keeper;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.sber.demo.model.SimpleZooWorker;
import ru.sber.demo.model.api.ZooWorker;

@Configuration
public class WithZookeeperConfiguration {
    @Bean
    public PockemonZookeeperBeanFactoryPostProcessor pockemonZookeeperBeanFactoryPostProcessor() {
        return new PockemonZookeeperBeanFactoryPostProcessor();
    }
    
    @Bean
    public ZooWorker worker() {
        return new SimpleZooWorker();
    }
}
