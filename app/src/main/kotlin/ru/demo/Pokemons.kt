package ru.demo

import ru.demo.model.PokemonType
import ru.demo.utils.pokemons

fun pokemonInitializer() = pokemons {

    pokemon(pokemonName = "Max", pokemonType = PokemonType.PICKACHU, masterName = "Veronika")
    pokemon(pokemonName = "Serg", pokemonType = PokemonType.PICKACHU, masterName = "Veronika")
    pokemon(pokemonName = "Zhenya", pokemonType = PokemonType.BULBAZAVR, masterName = "Egore")
    pokemon(pokemonName = "Vania", pokemonType = PokemonType.PICKACHU, masterName = "Veronika")

}