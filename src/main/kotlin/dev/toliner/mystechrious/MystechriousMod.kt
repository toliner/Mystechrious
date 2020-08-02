package dev.toliner.mystechrious

import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import net.toliner.korgelin.api.KotlinMod
import net.toliner.korgelin.container.KotlinModLoadingContext
import org.apache.logging.log4j.LogManager

@KotlinMod(MystechriousMod.modId)
object MystechriousMod {

    val logger = LogManager.getLogger("Mystechrious")
    const val modId = "mystechrious"
    const val modName = "Mystechrious"

    init {
        KotlinModLoadingContext.get().eventBus.apply {

        }
    }

    val itemGroup: ItemGroup = object : ItemGroup(modId) {
        override fun createIcon() = ItemStack(Items.DIAMOND)
    }
}