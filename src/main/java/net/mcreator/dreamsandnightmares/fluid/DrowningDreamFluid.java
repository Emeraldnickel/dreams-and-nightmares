
package net.mcreator.dreamsandnightmares.fluid;

import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fluids.FluidAttributes;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.dreamsandnightmares.init.DreamsAndNightmaresModItems;
import net.mcreator.dreamsandnightmares.init.DreamsAndNightmaresModFluids;
import net.mcreator.dreamsandnightmares.init.DreamsAndNightmaresModBlocks;

public abstract class DrowningDreamFluid extends ForgeFlowingFluid {
	public static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(DreamsAndNightmaresModFluids.DROWNING_DREAM,
			DreamsAndNightmaresModFluids.FLOWING_DROWNING_DREAM,
			FluidAttributes.builder(new ResourceLocation("dreams_and_nightmares:blocks/nightmare_material"),
					new ResourceLocation("dreams_and_nightmares:blocks/nightmare_material"))

	).explosionResistance(100f)

			.tickRate(2)

			.bucket(DreamsAndNightmaresModItems.DROWNING_DREAM_BUCKET).block(() -> (LiquidBlock) DreamsAndNightmaresModBlocks.DROWNING_DREAM.get());

	private DrowningDreamFluid() {
		super(PROPERTIES);
	}

	public static class Source extends DrowningDreamFluid {
		public Source() {
			super();
		}

		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends DrowningDreamFluid {
		public Flowing() {
			super();
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
