package games.twinhead.moreladders.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.LadderBlock;
import net.minecraft.block.Oxidizable;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;

public class OxidizableLadderBlock extends LadderBlock implements Oxidizable {
    private final Oxidizable.OxidationLevel oxidationLevel;

    public OxidizableLadderBlock(Oxidizable.OxidationLevel oxidationLevel, Settings settings) {
        super(settings);
        this.oxidationLevel = oxidationLevel;
    }

    @SuppressWarnings("deprecation")
    public void randomTick(BlockState blockState, ServerWorld serverWorld, BlockPos blockPos, Random random) {
        this.tickDegradation(blockState, serverWorld, blockPos, random);
    }

    public boolean hasRandomTicks(BlockState blockState) {
        return Oxidizable.getIncreasedOxidationBlock(blockState.getBlock()).isPresent();
    }

    public Oxidizable.OxidationLevel getDegradationLevel() {
        return this.oxidationLevel;
    }
}
