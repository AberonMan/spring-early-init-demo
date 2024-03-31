package ru.demo.model

class PokemonMaster(masterName: String, pokemon: Pokemon) {
    init {
        println("Я покемон-мастер $masterName!")
        println("Я тренирую его!")
        println(pokemon.pokemonImage)
        println("=======================")
    }
}
