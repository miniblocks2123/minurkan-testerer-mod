package test.testerer.item;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import test.testerer.ModLogger;
import test.testerer.Testerer;
import test.testerer.item.custom.weapon_knife;

import java.util.function.Function;

public class ModItems {

	public static final weapon_knife WEAPON_KNIFE = register("knife", weapon_knife::new, new Item.Properties().durability(1).stacksTo(1));


	public static <GenericItem extends Item> GenericItem register(String name, Function<Item.Properties, GenericItem> itemFactory, Item.Properties settings) {
		// Create the item key.
		ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, Testerer.id(name));

		// Create the item instance.
		GenericItem item = itemFactory.apply(settings.setId(itemKey));

		// Register the item.
		Registry.register(BuiltInRegistries.ITEM, itemKey, item);

		return item;
	}

	public static void initialise() {
		ModLogger.devLogger("loading mod items");
	}

}