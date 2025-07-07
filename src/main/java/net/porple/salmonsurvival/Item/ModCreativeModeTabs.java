package net.porple.salmonsurvival.Item;
import net.porple.salmonsurvival.SalmonSurvival;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.porple.salmonsurvival.block.ModBlocks;


public class ModCreativeModeTabs {
    public  static  final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, SalmonSurvival.MOD_ID);

    public static final RegistryObject<CreativeModeTab> ALEXANDRITE_ITEMS_TAB =
            CREATIVE_MODE_TABS.register(
                    "alexandrite_items_tab",
                    () -> CreativeModeTab
                            .builder().icon(() -> new ItemStack(ModItems.ALEXANDRITE.get()))
                            .title(Component.translatable("creativetab.salmonsurvival.alexandrite_items"))
                            .displayItems((itemDisplayParameters, output) -> {
                                output.accept(ModItems.ALEXANDRITE.get());
                                output.accept(ModItems.TOPAZ.get());
                                output.accept(ModItems.SALMONITE_INGOT.get());

                                output.accept(ModItems.SALMONITE_CHISEL.get());
                                output.accept(ModItems.SALMON_SLAMMER.get());

                                output.accept(ModBlocks.FISHING_NET.get());
                                output.accept(ModBlocks.ALEXANDRITE_BLOCK.get());
                            }).build()
            );

    public  static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
