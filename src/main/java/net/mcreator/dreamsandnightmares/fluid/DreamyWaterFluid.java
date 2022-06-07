
package net.mcreator.dreamsandnightmares.fluid;

import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fluids.FluidAttributes;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.ParticleOptions;

import net.mcreator.dreamsandnightmares.init.DreamsAndNightmaresModItems;
import net.mcreator.dreamsandnightmares.init.DreamsAndNightmaresModFluids;
import net.mcreator.dreamsandnightmares.init.DreamsAndNightmaresModBlocks;

public abstract class DreamyWaterFluid extends ForgeFlowingFluid {
	public static final ForgeFlowingFluid.Properties PROPERTIES = new ForgeFlowingFluid.Properties(DreamsAndNightmaresModFluids.DREAMY_WATER,
			DreamsAndNightmaresModFluids.FLOWING_DREAMY_WATER,
			FluidAttributes.builder(new ResourceLocation("dreams_and_nightmares:blocks/dream_colour"),
					new ResourceLocation("dreams_and_nightmares:blocks/dream_colour"))

	).explosionResistance(100f).canMultiply()

			.bucket(DreamsAndNightmaresModItems.DREAMY_WATER_BUCKET).block(() -> (LiquidBlock) DreamsAndNightmaresModBlocks.DREAMY_WATER.get());

	private DreamyWaterFluid() {
		super(PROPERTIES);
	}

	@Override
	public ParticleOptions getDripParticle() {
		return ParticleTypes.EXPLOSION;
	}

	public static class Source extends DreamyWaterFluid {
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

	public static class Flowing extends DreamyWaterFluid {
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
