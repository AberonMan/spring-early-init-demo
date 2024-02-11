# Описалово

В этот момент мы подебажили spring и поняли, что виной всему метод с одним аргументами у `ConfigurableListableBeanFactory`.
```java
	String[] getBeanNamesForType(@Nullable Class<?> type);
```
Он неявно для нас приводил к вызову метода:
``` java
	String[] getBeanNamesForType(@Nullable Class<?> type, boolean includeNonSingletons, boolean allowEagerInit);

```
и в `includeNonSingletons` и `allowEagerInit` передавались значения true.

`NPE` у нас пропал, но по неизвестной пока причине у нас пропали все бины покемонов в нашем зукипере.


