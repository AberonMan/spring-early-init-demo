# Описалово

Мы устали все конфигурировать, поэтому мы создавали BeanFactory-у post processor-ы
1. Для покемонов PokemonDslBeanFactoryPostProcessor
2. И для зоопарка ZookeperDslBeanFactoryPostProcessor

И мы словили NullPointerException

Интересный эффект заключается в том, что ConfigurationProperties созданный через value object-ы не боятся ранней инициализации и все их поля становятся заполненными.

Причина этому кроется в классе `org.springframework.boot.context.properties.ConfigurationPropertiesBeanRegistrar`, который отвечает за регистрацию BeanDefinition-ов для ConfigurationProperties.
Он обрабатывает java record-ы следующим образом:
``` java
private BeanDefinition createBeanDefinition(String beanName, Class<?> type) {  
    BindMethod bindMethod = ConfigurationPropertiesBean.deduceBindMethod(type);  
    RootBeanDefinition definition = new RootBeanDefinition(type);  
    BindMethodAttribute.set(definition, bindMethod);  
    if (bindMethod == BindMethod.VALUE_OBJECT) {  // java record
       definition.setInstanceSupplier(() -> ConstructorBound.from(this.beanFactory, beanName, type));  
    }  
    return definition;  
}

```
При создании RootBeanDefinition для value object он проставляет ему setInstanceSupplier, который сработает при ранней инициализации и позволит корректно создать этот бин.



