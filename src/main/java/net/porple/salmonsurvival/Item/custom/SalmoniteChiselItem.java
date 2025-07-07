package net.porple.salmonsurvival.Item.custom;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;

import java.util.Map;

// Select item then press ctrl h to see all special item classes from minecraft B)
public class SalmoniteChiselItem extends Item {
    private static final Map<Block, Block> CHISEL_MAP =
            Map.of(
              Blocks.STONE, Blocks.STONE_BRICKS,
              Blocks.END_STONE, Blocks.END_STONE_BRICKS,
              Blocks.DEEPSLATE, Blocks.DEEPSLATE_BRICKS,
              Blocks.GOLD_BLOCK, Blocks.NETHERITE_BLOCK
            );

    public SalmoniteChiselItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Minecraft.getInstance().player.displayClientMessage(Component.literal("Message"),false);
        Level level = pContext.getLevel();
        Block clickedBlock = level.getBlockState(pContext.getClickedPos()).getBlock();

        if (CHISEL_MAP.containsKey(clickedBlock)) {
            if (!level.isClientSide()) {
                level.setBlockAndUpdate(pContext.getClickedPos(), CHISEL_MAP.get(clickedBlock).defaultBlockState());
                pContext.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), ((ServerPlayer)pContext.getPlayer()),
                        item -> pContext.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));
            }
            level.playSound(null, pContext.getClickedPos(), SoundEvents.GRINDSTONE_USE, SoundSource.BLOCKS);
        }

        return super.useOn(pContext);
    }
}
