package net.protabs.heliocraft.item.custom;

import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class MetalDetectorItem extends Item {

    public MetalDetectorItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if(!pContext.getLevel().isClientSide()) {
            BlockPos positionclicked = pContext.getClickedPos();
            Player player = pContext.getPlayer();
            boolean foundBlock = false;

            for(int i = 0; i <= positionclicked.getY() + 64; i++) {
                BlockState blockState = pContext.getLevel().getBlockState(positionclicked.below(i));

                if(isValuableBlock(blockState)) {
                    outputValuableCoordinates(positionclicked.below(i), player, blockState.getBlock());
                    foundBlock = true;

                    break;



                    
                }
            }
        if(!foundBlock){
            outputNoValuableFound(player);
        }

        }

        pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(),
                player -> player.broadcastBreakEvent(player.getUsedItemHand()));

        return InteractionResult.SUCCESS;

    }

    private void outputNoValuableFound(Player player) {
        player.sendSystemMessage(Component.translatable("item.heliocraft.metal_detector.no_valuables"));
    }

    private void outputValuableCoordinates(BlockPos below, Player player, Block block) {
        player.sendSystemMessage(Component.literal("Valuable Found: " + I18n.get(block.getDescriptionId())
        + " at " + below.getX() + ", " +below.getY() + ", " + below.getZ()));
    }

    private boolean isValuableBlock(BlockState blockState) {
        return blockState.is((Blocks.IRON_ORE)) || blockState.is(Blocks.DEEPSLATE_IRON_ORE);
    }
}
