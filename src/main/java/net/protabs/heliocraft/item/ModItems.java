package net.protabs.heliocraft.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.protabs.heliocraft.Heliocraft;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Heliocraft.MODID);
    public static final RegistryObject<Item> MIRROR = ITEMS.register("mirror",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BASIC_PRISM = ITEMS.register("baseprism",
            () -> new Item(new Item.Properties()));
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
