package net.protabs.heliocraft.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.protabs.heliocraft.Heliocraft;
import net.protabs.heliocraft.block.ModBlocks;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Heliocraft.MODID);

    public static final RegistryObject<CreativeModeTab> HELIOCRAFT_TAB = CREATIVE_MODE_TABS.register("heliocraft_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.MIRROR.get()))
                    .title(Component.translatable("creativetab.heliocraft_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.MIRROR.get());
                        pOutput.accept(ModItems.BASIC_PRISM.get());
                        pOutput.accept(ModItems.PANDA_DEBUG.get());
                        pOutput.accept(ModItems.METAL_DETECTOR.get());

                        pOutput.accept(ModBlocks.MIRROR_BLOCK.get());
                        pOutput.accept(ModBlocks.PRISM_BLOCK.get());
                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
