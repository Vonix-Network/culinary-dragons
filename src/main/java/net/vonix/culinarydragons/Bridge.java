package net.vonix.culinarydragons;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.ForgeRegistries;

/** Optional Farmer's Delight bridge. It resolves partner items by registry ID and never hard-links partner classes. */
public final class Bridge {
    private static final String FARMERS_DELIGHT = "farmersdelight";
    private Bridge() { }

    public static boolean farmersDelight(ItemStack stack, String itemId) {
        if (!ModList.get().isLoaded(FARMERS_DELIGHT) || stack.isEmpty()) return false;
        net.minecraft.world.item.Item item = ForgeRegistries.ITEMS.getValue(new ResourceLocation(FARMERS_DELIGHT, itemId));
        return item != null && stack.is(item);
    }
}
