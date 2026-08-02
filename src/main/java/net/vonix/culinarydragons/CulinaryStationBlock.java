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
    public CulinaryStationBlock(StationKind kind) { super(BlockBehaviour.Properties.of(Material.WOOD).strength(2.0f).sound(SoundType.WOOD)); this.kind = kind; }
    @Override public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (level.isClientSide) return InteractionResult.SUCCESS;
        ItemStack held = player.getItemInHand(hand); ItemStack result = kind.process(held);
        if (result.isEmpty()) { player.displayClientMessage(new TextComponent("Insert a suitable ingredient into the " + kind.label + "."), true); return InteractionResult.CONSUME; }
        if (!player.getAbilities().instabuild) held.shrink(1);
        if (!player.getInventory().add(result)) player.drop(result, false);
        player.displayClientMessage(new TextComponent(kind.label + " produced " + result.getHoverName().getString() + "."), true); return InteractionResult.CONSUME;
    }
    public enum StationKind {
        JUICER("Juicer") { ItemStack process(ItemStack s) {
            if (s.is(CulinaryDragonsMod.GRAPES.get())) return out(CulinaryDragonsMod.GRAPE_JUICE);
            if (s.is(CulinaryDragonsMod.BERRIES.get())) return out(CulinaryDragonsMod.BERRY_JUICE);
            if (s.is(CulinaryDragonsMod.STRAWBERRIES.get())) return out(CulinaryDragonsMod.BERRY_JUICE);
            if (s.is(CulinaryDragonsMod.CHERRIES.get())) return out(CulinaryDragonsMod.CHERRY_JUICE);
            if (s.is(CulinaryDragonsMod.PINEAPPLE.get()) || s.is(CulinaryDragonsMod.MANGO.get()) || s.is(CulinaryDragonsMod.PAPAYA.get())) return out(CulinaryDragonsMod.TROPICAL_JUICE);
            if (s.is(net.minecraft.world.item.Items.APPLE)) return out(CulinaryDragonsMod.APPLE_JUICE); return ItemStack.EMPTY; } },
        BLENDER("Blender") { ItemStack process(ItemStack s) {
            if (s.is(net.minecraft.world.item.Items.APPLE)) return out(CulinaryDragonsMod.SMOOTHIE);
            if (s.is(CulinaryDragonsMod.BERRIES.get()) || s.is(CulinaryDragonsMod.STRAWBERRIES.get())) return out(CulinaryDragonsMod.STRAWBERRY_SMOOTHIE);
            if (s.is(CulinaryDragonsMod.MANGO.get())) return out(CulinaryDragonsMod.MANGO_SMOOTHIE);
            if (s.is(CulinaryDragonsMod.PINEAPPLE.get()) || s.is(CulinaryDragonsMod.BANANA.get()) || s.is(CulinaryDragonsMod.PAPAYA.get())) return out(CulinaryDragonsMod.TROPICAL_SMOOTHIE);
            if (s.is(net.minecraft.world.item.Items.MELON_SLICE)) return out(CulinaryDragonsMod.MELON_SMOOTHIE); return ItemStack.EMPTY; } },
        FERMENTER("Fermentation Barrel") { ItemStack process(ItemStack s) {
            if (s.is(CulinaryDragonsMod.GRAPE_JUICE.get())) return out(CulinaryDragonsMod.WINE_BOTTLE);
            if (s.is(CulinaryDragonsMod.CHERRY_JUICE.get())) return out(CulinaryDragonsMod.CHERRY_WINE);
            if (s.is(CulinaryDragonsMod.TROPICAL_JUICE.get())) return out(CulinaryDragonsMod.TROPICAL_WINE);
            if (s.is(CulinaryDragonsMod.APPLE_JUICE.get())) return out(CulinaryDragonsMod.APPLE_CIDER);
            if (s.is(CulinaryDragonsMod.BERRY_JUICE.get())) return out(CulinaryDragonsMod.BERRY_MEAD);
            if (s.is(CulinaryDragonsMod.PEACH.get())) return out(CulinaryDragonsMod.PEACH_CIDER);
            if (s.is(CulinaryDragonsMod.DRAGONFRUIT.get())) return out(CulinaryDragonsMod.DRAGONFRUIT_WINE); return ItemStack.EMPTY; } },
        COOKING_POT("Cooking Pot") { ItemStack process(ItemStack s) {
            if (s.is(net.minecraft.world.item.Items.POTATO)) return out(CulinaryDragonsMod.BAKED_POTATO_PLATTER);
            if (s.is(net.minecraft.world.item.Items.BEEF)) return out(CulinaryDragonsMod.COOKED_MEAT_PLATTER);
            if (s.is(net.minecraft.world.item.Items.CARROT)) return out(CulinaryDragonsMod.VEGETABLE_STEW); return ItemStack.EMPTY; } };
        final String label; StationKind(String label) { this.label = label; }
        abstract ItemStack process(ItemStack stack);
        static ItemStack out(net.minecraftforge.registries.RegistryObject<net.minecraft.world.item.Item> item) { return new ItemStack(item.get()); }
    }
}
