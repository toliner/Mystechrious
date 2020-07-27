package dev.toliner.industrialmod

import net.toliner.korgelin.api.KotlinMod
import net.toliner.korgelin.container.KotlinModLoadingContext
import java.util.logging.LogManager

@KotlinMod("industrialmod")
object IndustrialMod {
    private val logger = LogManager.getLogManager()!!

    init {
        KotlinModLoadingContext.get().eventBus.apply {

        }
    }
}