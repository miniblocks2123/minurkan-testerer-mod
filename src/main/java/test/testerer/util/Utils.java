package test.testerer.util;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class Utils {
	public static Holder<@NotNull DamageType> getDamageTypeHolder(Level level, ResourceKey<@NotNull DamageType> damageTypeResourceKey) {
		return level.registryAccess().lookupOrThrow(Registries.DAMAGE_TYPE).get(damageTypeResourceKey.identifier()).orElseThrow();
	}

	public static DamageSource createSimpleDamageSource(Level level, ResourceKey<@NotNull DamageType> damageTypeResourceKey) {
		var damageTypeHolder = getDamageTypeHolder(level, damageTypeResourceKey);

		return new DamageSource(damageTypeHolder);
	}
}
