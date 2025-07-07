package net.porple.salmonsurvival.datagen;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import net.porple.salmonsurvival.Item.ModItems;
import net.porple.salmonsurvival.block.ModBlocks;

import java.util.stream.Stream;

public abstract class ModModelProvider extends ModelProvider {
    public ModModelProvider(PackOutput pOutput) {
        super(pOutput);
        this.blockStatePathProvider = pOutput.createPathProvider(PackOutput.Target.RESOURCE_PACK, "blockstates");
        this.itemInfoPathProvider = pOutput.createPathProvider(PackOutput.Target.RESOURCE_PACK, "items");
        this.modelPathProvider = pOutput.createPathProvider(PackOutput.Target.RESOURCE_PACK, "models");
    }

    private final PackOutput.PathProvider blockStatePathProvider;
    private final PackOutput.PathProvider itemInfoPathProvider;
    private final PackOutput.PathProvider modelPathProvider;

    @Override
    protected Stream<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get);
    }

    @Override
    protected Stream<Item> getKnownItems() {
        return ModItems.ITEMS.getEntries().stream().map(RegistryObject::get);
    }

    @Override
    protected BlockModelGenerators getBlockModelGenerators(BlockStateGeneratorCollector blocks, ItemInfoCollector items, SimpleModelCollector models) {
        return new ModBlockModelGenerators(blocks, items, models);
    }
}
