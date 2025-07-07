package net.porple.salmonsurvival.datagen;

import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableMap;
import com.jcraft.jorbis.Block;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelOutput;
import net.minecraft.client.data.models.blockstates.BlockStateGenerator;
import net.minecraft.client.data.models.model.ModelInstance;
import net.minecraft.client.data.models.model.TexturedModel;
import net.minecraft.data.BlockFamily;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ModBlockModelGenerators extends BlockModelGenerators {
    final Map<Block, TexturedModel> texturedModels = ImmutableMap.<Block, TexturedModel>builder()
            .build();

    static final ImmutableMap<BlockFamily.Variant, BiConsumer<ModBlockFamilyProvider, Block>> SHAPE_CONSUMERS = ImmutableMap.<BlockFamily.Variant, BiConsumer<ModBlockFamilyProvider, Block>>builder()
            .put(BlockFamily.Variant.BUTTON, ModBlockFamilyProvider::button)
            .put(BlockFamily.Variant.DOOR, ModBlockFamilyProvider::door)
            .put(BlockFamily.Variant.CHISELED, ModBlockFamilyProvider::fullBlockVariant)
            .put(BlockFamily.Variant.CRACKED, ModBlockFamilyProvider::fullBlockVariant)
            .put(BlockFamily.Variant.CUSTOM_FENCE, ModBlockFamilyProvider::customFence)
            .put(BlockFamily.Variant.FENCE, ModBlockFamilyProvider::fence)
            .put(BlockFamily.Variant.CUSTOM_FENCE_GATE, ModBlockFamilyProvider::customFenceGate)
            .put(BlockFamily.Variant.FENCE_GATE, ModBlockFamilyProvider::fenceGate)
            .put(BlockFamily.Variant.SIGN, ModBlockFamilyProvider::sign)
            .put(BlockFamily.Variant.SLAB, ModBlockFamilyProvider::slab)
            .put(BlockFamily.Variant.STAIRS, ModBlockFamilyProvider::stairs)
            .put(BlockFamily.Variant.PRESSURE_PLATE, ModBlockFamilyProvider::pressurePlate)
            .put(BlockFamily.Variant.TRAPDOOR, ModBlockFamilyProvider::trapdoor)
            .put(BlockFamily.Variant.WALL, ModBlockFamilyProvider::wall)
            .build();

    public ModBlockModelGenerators(Consumer<BlockStateGenerator> pBlockStateOutput, ItemModelOutput pItemModelOutput, BiConsumer<ResourceLocation, ModelInstance> pModelOutput) {
        super(pBlockStateOutput, pItemModelOutput, pModelOutput);
    }
}
