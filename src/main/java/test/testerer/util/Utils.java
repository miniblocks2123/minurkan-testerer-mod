package test.testerer.util;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class Utils {
	public static DamageSource createDamageSource(Level level, ResourceKey<@NotNull DamageType> damageTypeResourceKey) {
		var damageType = level.registryAccess().lookupOrThrow(Registries.DAMAGE_TYPE).get(damageTypeResourceKey.identifier()).orElseThrow();

		return new DamageSource(damageType);
	}
}
