package test.testerer.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import test.testerer.util.Utils;

public class weapon_knife extends Item {
	public weapon_knife(Properties properties) {
		super(properties);
	}


	@Override
	public void hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		Level level = attacker.level();

		var damageSource = Utils.createSimpleDamageSource(level, DamageTypes.GENERIC);

		target.hurt(damageSource, 1000);

		stack.consume(1, attacker);

	}

	@Override
	public boolean canDestroyBlock(ItemStack stack, BlockState state, Level level, BlockPos pos, LivingEntity entity) {
		return false;
	}
}
