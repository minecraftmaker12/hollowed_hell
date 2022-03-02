
package net.mcreator.hollowedhell.block;

import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.BlockPos;

import net.mcreator.hollowedhell.init.HollowedhellModFluids;

public class VoidEssenceBlock extends LiquidBlock {
	public VoidEssenceBlock() {
		super(HollowedhellModFluids.VOID_ESSENCE, BlockBehaviour.Properties.of(Material.WATER).strength(100f)

		);
		setRegistryName("void_essence");
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return true;
	}
}
