package net.vonix.culinarydragons;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod(CulinaryDragonsMod.MOD_ID)
public final class CulinaryDragonsMod {
    public static final String MOD_ID = "culinarydragons";
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);
    public static final CreativeModeTab TAB = new CreativeModeTab(MOD_ID) {
        @Override public ItemStack makeIcon() { return new ItemStack(WINE_BOTTLE.get()); }
    };
    public static final RegistryObject<Block> JUICER = BLOCKS.register("juicer", () -> new CulinaryStationBlock(CulinaryStationBlock.StationKind.JUICER));
    public static final RegistryObject<Block> BLENDER = BLOCKS.register("blender", () -> new CulinaryStationBlock(CulinaryStationBlock.StationKind.BLENDER));
    public static final RegistryObject<Block> FERMENTER = BLOCKS.register("fermenter", () -> new CulinaryStationBlock(CulinaryStationBlock.StationKind.FERMENTER));
    public static final RegistryObject<Block> COOKING_POT = BLOCKS.register("cooking_pot", () -> new CulinaryStationBlock(CulinaryStationBlock.StationKind.COOKING_POT));
    public static final RegistryObject<Item> JUICER_ITEM = ITEMS.register("juicer", () -> new BlockItem(JUICER.get(), new Item.Properties().tab(TAB)));
    public static final RegistryObject<Item> BLENDER_ITEM = ITEMS.register("blender", () -> new BlockItem(BLENDER.get(), new Item.Properties().tab(TAB)));
    public static final RegistryObject<Item> FERMENTER_ITEM = ITEMS.register("fermenter", () -> new BlockItem(FERMENTER.get(), new Item.Properties().tab(TAB)));
    public static final RegistryObject<Item> COOKING_POT_ITEM = ITEMS.register("cooking_pot", () -> new BlockItem(COOKING_POT.get(), new Item.Properties().tab(TAB)));
    private static Item.Properties edible(int nutrition, float saturation) { return new Item.Properties().tab(TAB).food(new FoodProperties.Builder().nutrition(nutrition).saturationMod(saturation).build()); }
    public static final RegistryObject<Item> GRAPES = ITEMS.register("grapes", () -> new Item(edible(3, .3f)));
    public static final RegistryObject<Item> BERRIES = ITEMS.register("mixed_berries", () -> new Item(edible(4, .4f)));
    public static final RegistryObject<Item> STRAWBERRIES = ITEMS.register("strawberries", () -> new Item(edible(3, .35f)));
    public static final RegistryObject<Item> PINEAPPLE = ITEMS.register("pineapple", () -> new Item(edible(4, .4f)));
    public static final RegistryObject<Item> MANGO = ITEMS.register("mango", () -> new Item(edible(4, .4f)));
    public static final RegistryObject<Item> PEACH = ITEMS.register("peach", () -> new Item(edible(3, .35f)));
    public static final RegistryObject<Item> CHERRIES = ITEMS.register("cherries", () -> new Item(edible(3, .3f)));
    public static final RegistryObject<Item> BANANA = ITEMS.register("banana", () -> new Item(edible(4, .45f)));
    public static final RegistryObject<Item> KIWI = ITEMS.register("kiwi", () -> new Item(edible(3, .35f)));
    public static final RegistryObject<Item> PAPAYA = ITEMS.register("papaya", () -> new Item(edible(4, .4f)));
    public static final RegistryObject<Item> DRAGONFRUIT = ITEMS.register("dragonfruit", () -> new Item(edible(5, .45f)));
    public static final RegistryObject<Item> FRUIT_SALAD = ITEMS.register("fruit_salad", () -> new Item(edible(8, .8f)));
    public static final RegistryObject<Item> SMOOTHIE = ITEMS.register("smoothie", () -> new Item(edible(6, .7f)));
    public static final RegistryObject<Item> BERRY_SMOOTHIE = ITEMS.register("berry_smoothie", () -> new Item(edible(7, .8f)));
    public static final RegistryObject<Item> GRAPE_JUICE = ITEMS.register("grape_juice", () -> new Item(edible(4, .4f)));
    public static final RegistryObject<Item> BERRY_JUICE = ITEMS.register("berry_juice", () -> new Item(edible(4, .45f)));
    public static final RegistryObject<Item> APPLE_JUICE = ITEMS.register("apple_juice", () -> new Item(edible(4, .4f)));
    public static final RegistryObject<Item> TROPICAL_JUICE = ITEMS.register("tropical_juice", () -> new Item(edible(5, .5f)));
    public static final RegistryObject<Item> CHERRY_JUICE = ITEMS.register("cherry_juice", () -> new Item(edible(4, .4f)));
    public static final RegistryObject<Item> TROPICAL_SMOOTHIE = ITEMS.register("tropical_smoothie", () -> new Item(edible(7, .8f)));
    public static final RegistryObject<Item> STRAWBERRY_SMOOTHIE = ITEMS.register("strawberry_smoothie", () -> new Item(edible(7, .8f)));
    public static final RegistryObject<Item> MANGO_SMOOTHIE = ITEMS.register("mango_smoothie", () -> new Item(edible(7, .8f)));
    public static final RegistryObject<Item> CHERRY_WINE = ITEMS.register("cherry_wine", () -> new Item(edible(4, .3f)));
    public static final RegistryObject<Item> TROPICAL_WINE = ITEMS.register("tropical_wine", () -> new Item(edible(4, .3f)));
    public static final RegistryObject<Item> PEACH_CIDER = ITEMS.register("peach_cider", () -> new Item(edible(5, .5f)));
    public static final RegistryObject<Item> DRAGONFRUIT_WINE = ITEMS.register("dragonfruit_wine", () -> new Item(edible(5, .35f)));
    public static final RegistryObject<Item> WINE_BOTTLE = ITEMS.register("wine_bottle", () -> new Item(edible(3, .2f)));
    public static final RegistryObject<Item> APPLE_CIDER = ITEMS.register("apple_cider", () -> new Item(edible(5, .5f)));
    public static final RegistryObject<Item> BERRY_MEAD = ITEMS.register("berry_mead", () -> new Item(edible(5, .5f)));
    public static final RegistryObject<Item> MELON_SMOOTHIE = ITEMS.register("melon_smoothie", () -> new Item(edible(6, .65f)));
    public static final RegistryObject<Item> MINT_TEA = ITEMS.register("mint_tea", () -> new Item(edible(3, .35f)));
    public static final RegistryObject<Item> HOT_CHOCOLATE = ITEMS.register("hot_chocolate", () -> new Item(edible(6, .7f)));
    public static final RegistryObject<Item> DRAGONFIRE_PUNCH = ITEMS.register("dragonfire_punch", () -> new Item(edible(8, .8f)));
    public static final RegistryObject<Item> VEGETABLE_STEW = ITEMS.register("vegetable_stew", () -> new Item(edible(10, .9f)));
    public static final RegistryObject<Item> DRAGONFRUIT_CIDER = ITEMS.register("dragonfruit_cider", () -> new Item(edible(5, .5f)));
    public static final RegistryObject<Item> COOKED_MEAT_PLATTER = ITEMS.register("cooked_meat_platter", () -> new Item(edible(14, 1f)));
    public static final RegistryObject<Item> BAKED_POTATO_PLATTER = ITEMS.register("baked_potato_platter", () -> new Item(edible(10, .9f)));
    public CulinaryDragonsMod() { IEventBus bus = net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext.get().getModEventBus(); BLOCKS.register(bus); ITEMS.register(bus); }
}
