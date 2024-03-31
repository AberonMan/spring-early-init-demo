package ru.demo.utils

import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.support.GenericApplicationContext
import org.springframework.context.support.beans
import ru.demo.PokemonConfigurationProperties
import ru.demo.model.Pokemon
import ru.demo.model.PokemonMaster
import ru.demo.model.PokemonType

fun pokemons(initFunction: UtilityPokemonDslInitializer.(GenericApplicationContext) -> Unit):
    ApplicationContextInitializer<GenericApplicationContext> = UtilityPokemonDslInitializer(initFunction)

/**
 * Initializer used in DSL based on [pokemons] method.
 */
class UtilityPokemonDslInitializer(private val init: UtilityPokemonDslInitializer.(GenericApplicationContext) -> Unit) :
    ApplicationContextInitializer<GenericApplicationContext> {

    private val context: ThreadLocal<GenericApplicationContext> = ThreadLocal<GenericApplicationContext>()

    override fun initialize(applicationContext: GenericApplicationContext) {
        try {
            context.set(applicationContext)
            init(applicationContext)
        } finally {
            context.remove()
        }
    }

    fun pokemon(
        pokemonName: String,
        pokemonType: PokemonType,
        masterName: String,
    ) {
        beans {
            bean<Pokemon>(pokemonName) {
                createPokemon(pokemonType, ref<PokemonConfigurationProperties>())
            }
            bean<PokemonMaster>() {
                PokemonMaster(masterName, ref(pokemonName))
            }
        }.initialize(context.get())
    }


}

