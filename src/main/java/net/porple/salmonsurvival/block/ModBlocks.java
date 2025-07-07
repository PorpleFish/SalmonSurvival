package net.porple.salmonsurvival.block;

import net.minecraft.world.level.block.Block;
import net.porple.salmonsurvival.Item.ModItems;
import net.porple.salmonsurvival.SalmonSurvival;

import net.minecraft.core.registries.Registries;

import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


import java.util.function.Supplier;

public class    ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, SalmonSurvival.MOD_ID);

    public static final RegistryObject<Block> ALEXANDRITE_BLOCK = registerBlock("alexandrite_block",
           () -> new Block(BlockBehaviour.Properties.of()
                   .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(SalmonSurvival.MOD_ID, "alexandrite_block")))
                   .strength(4f)
                   .requiresCorrectToolForDrops()
                   .sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> FISHING_NET = registerBlock("fishing_net",
            () -> new Block(BlockBehaviour.Properties.of()
                    .setId(ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(SalmonSurvival.MOD_ID, "fishing_net")))
                    .strength(1f)
                    .noOcclusion()
                    .noCollission()
                    .sound(SoundType.SCAFFOLDING)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()
                .setId(ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(SalmonSurvival.MOD_ID, name)))));
    }
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
