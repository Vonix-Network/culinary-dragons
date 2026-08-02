package net.vonix.culinarydragons;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;

public final class CulinaryStationBlock extends Block {
    private final StationKind kind;
    public CulinaryStationBlock(StationKind kind) {
        super(BlockBehaviour.Properties.of(Material.WOOD).strength(2.0f).sound(SoundType.WOOD));
        this.kind = kind;
    }
    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (level.isClientSide) return InteractionResult.SUCCESS;
        ItemStack held = player.getItemInHand(hand);
        ItemStack result = kind.process(held);
        if (result.isEmpty()) {
            player.displayClientMessage(new TextComponent("Insert a suitable ingredient into the " + kind.label + "."), true);
            return InteractionResult.CONSUME;
        }
        if (!player.getAbilities().instabuild) held.shrink(1);
        if (!player.getInventory().add(result)) player.drop(result, false);
        player.displayClientMessage(new TextComponent(kind.label + " produced " + result.getHoverName().getString() + "."), true);
        return InteractionResult.CONSUME;
    }
    public enum StationKind {
        JUICER("Juicer") {
            ItemStack process(ItemStack s) { if (s.is(CulinaryDragonsMod.GRAPES.get())) return new ItemStack(CulinaryDragonsMod.GRAPE_JUICE.get()); if (s.is(CulinaryDragonsMod.BERRIES.get())) return new ItemStack(CulinaryDragonsMod.BERRY_JUICE.get()); if (s.is(net.minecraft.world.item.Items.APPLE)) return new ItemStack(CulinaryDragonsMod.APPLE_JUICE.get()); return ItemStack.EMPTY; }
        },
        BLENDER("Blender") {
            ItemStack process(ItemStack s) { if (s.is(net.minecraft.world.item.Items.APPLE)) return new ItemStack(CulinaryDragonsMod.SMOOTHIE.get()); if (s.is(CulinaryDragonsMod.BERRIES.get())) return new ItemStack(CulinaryDragonsMod.BERRY_SMOOTHIE.get()); if (s.is(net.minecraft.world.item.Items.MELON_SLICE)) return new ItemStack(CulinaryDragonsMod.MELON_SMOOTHIE.get()); return ItemStack.EMPTY; }
        },
        FERMENTER("Fermentation Barrel") {
            ItemStack process(ItemStack s) { if (s.is(CulinaryDragonsMod.GRAPE_JUICE.get())) return new ItemStack(CulinaryDragonsMod.WINE_BOTTLE.get()); if (s.is(CulinaryDragonsMod.APPLE_JUICE.get())) return new ItemStack(CulinaryDragonsMod.APPLE_CIDER.get()); if (s.is(CulinaryDragonsMod.BERRY_JUICE.get())) return new ItemStack(CulinaryDragonsMod.BERRY_MEAD.get()); return ItemStack.EMPTY; }
        },
        COOKING_POT("Cooking Pot") {
            ItemStack process(ItemStack s) { if (s.is(net.minecraft.world.item.Items.POTATO)) return new ItemStack(CulinaryDragonsMod.BAKED_POTATO_PLATTER.get()); if (s.is(net.minecraft.world.item.Items.BEEF)) return new ItemStack(CulinaryDragonsMod.COOKED_MEAT_PLATTER.get()); if (s.is(net.minecraft.world.item.Items.CARROT)) return new ItemStack(CulinaryDragonsMod.VEGETABLE_STEW.get()); return ItemStack.EMPTY; }
        };
        final String label; StationKind(String label) { this.label = label; }
        abstract ItemStack process(ItemStack stack);
    }
}
