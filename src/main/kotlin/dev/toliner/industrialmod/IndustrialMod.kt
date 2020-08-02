package dev.toliner.industrialmod

import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import net.toliner.korgelin.api.KotlinMod
import net.toliner.korgelin.container.KotlinModLoadingContext
import org.apache.logging.log4j.LogManager

@KotlinMod(IndustrialMod.modId)
object IndustrialMod {

    val logger = LogManager.getLogger("Industrial Mod")
    const val modId = "industrialmod"

    init {
        KotlinModLoadingContext.get().eventBus.apply {

        }
    }

    val itemGroup: ItemGroup = object : ItemGroup(modId) {
        override fun createIcon(): ItemStack { return ItemStack(Items.DIAMOND) }
    }
}