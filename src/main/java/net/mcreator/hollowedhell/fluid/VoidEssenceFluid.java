
package net.mcreator.hollowedhell.fluid;

import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fluids.FluidAttributes;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.hollowedhell.init.HollowedhellModItems;
import net.mcreator.hollowedhell.init.HollowedhellModFluids;
import net.mcreator.hollowedhell.init.HollowedhellModBlocks;

public abstract class VoidEssenceFluid extends ForgeFlowingFluid {
	public static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(() -> HollowedhellModFluids.VOID_ESSENCE,
			() -> HollowedhellModFluids.FLOWING_VOID_ESSENCE,
			FluidAttributes.builder(new ResourceLocation("hollowedhell:blocks/void"), new ResourceLocation("hollowedhell:blocks/void"))

	).explosionResistance(100f)

			.bucket(() -> HollowedhellModItems.VOID_ESSENCE_BUCKET).block(() -> (LiquidBlock) HollowedhellModBlocks.VOID_ESSENCE);

	private VoidEssenceFluid() {
		super(PROPERTIES);
	}

	public static class Source extends VoidEssenceFluid {
		public Source() {
			super();
			setRegistryName("void_essence");
		}

		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends VoidEssenceFluid {
		public Flowing() {
			super();
			setRegistryName("flowing_void_essence");
		}

		protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
			super.createFluidStateDefinition(builder);
			builder.add(LEVEL);
		}

		public int getAmount(FluidState state) {
			return state.getValue(LEVEL);
		}

		public boolean isSource(FluidState state) {
			return false;
		}
	}
}
