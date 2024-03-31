package ru.demo

import ru.demo.model.Pokemon
import ru.demo.model.ZooWorker
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean

@SpringBootApplication
@EnableConfigurationProperties(PokemonConfigurationProperties::class)
open class PocketZooSpringBootApplication {

    @Bean
    open fun zooWorker(pokemons: Map<String, Pokemon>): ZooWorker {
        return ZooWorker(pokemons.keys, "Вася")

    }
}

fun main(args: Array<String>) {
    SpringApplicationBuilder()
        .sources(PocketZooSpringBootApplication::class.java)
        .initializers(pokemonInitializer())
        .run(*args)
}
