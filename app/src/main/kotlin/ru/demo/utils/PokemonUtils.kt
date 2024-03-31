package ru.demo.utils

import ru.demo.PokemonConfigurationProperties
import ru.demo.model.Pokemon
import ru.demo.model.PokemonType
import java.nio.file.Files
import java.nio.file.Paths
import java.util.Objects
import java.util.concurrent.ThreadLocalRandom

fun createPokemon(
    pokemonType: PokemonType,
    pokemonConfigurationProperties: PokemonConfigurationProperties
): Pokemon {
    // у нас самый демократичный зоопарк, половина покемонов shiny, а половина нет.

    val shiny = ThreadLocalRandom.current().nextBoolean()

    return when (pokemonType) {
        PokemonType.PICKACHU -> Pokemon(
            loadImage(pokemonConfigurationProperties.pikachuImage),
            pokemonType,
             shiny,
        )

        PokemonType.BULBAZAVR -> Pokemon(
            loadImage(pokemonConfigurationProperties.bulbazavrImage),
            pokemonType,
            shiny,
        )
    }
}

private fun loadImage(pokemonImagePath: String): String {
    val resource = Thread.currentThread().contextClassLoader.getResource(pokemonImagePath)
    val image = Files.readString(
        Paths.get(
            Objects.requireNonNull(resource, "Can't find pokemon imager: $pokemonImagePath").toURI()
        )
    )
    println(image)
    return image;
}
