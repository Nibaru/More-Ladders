package games.twinhead.moreladders.block;

import net.minecraft.block.*;

import java.util.HashMap;
import java.util.Optional;

public interface ModOxidizable extends Degradable<Oxidizable.OxidationLevel> {
    static HashMap<Block, Block> OXIDATION_LEVEL_INCREASES = new HashMap<>() {{
        put(Ladder.COPPER.getBlock(), Ladder.EXPOSED_COPPER.getBlock());
        put(Ladder.EXPOSED_COPPER.getBlock(), Ladder.WEATHERED_COPPER.getBlock());
        put(Ladder.WEATHERED_COPPER.getBlock(), Ladder.OXIDIZED_COPPER.getBlock());
    }};

    static HashMap<Block, Block> OXIDATION_LEVEL_DECREASES = new HashMap<>() {{
        put(Ladder.OXIDIZED_COPPER.getBlock(), Ladder.WEATHERED_COPPER.getBlock());
        put(Ladder.WEATHERED_COPPER.getBlock(), Ladder.EXPOSED_COPPER.getBlock());
        put(Ladder.EXPOSED_COPPER.getBlock(), Ladder.COPPER.getBlock());
    }};

    static Optional<Block> getDecreasedOxidationBlock(Block block) {
        return Optional.ofNullable(OXIDATION_LEVEL_DECREASES.get(block));
    }

    static Block getUnaffectedOxidationBlock(Block block) {
        Block block2 = block;

        for(Block block3 = OXIDATION_LEVEL_DECREASES.get(block); block3 != null; block3 = OXIDATION_LEVEL_DECREASES.get(block3)) {
            block2 = block3;
        }

        return block2;
    }

    static Optional<BlockState> getDecreasedOxidationState(BlockState blockState) {
        return getDecreasedOxidationBlock(blockState.getBlock()).map((block) -> {
            return block.getStateWithProperties(blockState);
        });
    }

    static Optional<Block> getIncreasedOxidationBlock(Block block) {
        return Optional.ofNullable(OXIDATION_LEVEL_INCREASES.get(block));
    }

    static BlockState getUnaffectedOxidationState(BlockState blockState) {
        return getUnaffectedOxidationBlock(blockState.getBlock()).getStateWithProperties(blockState);
    }

    default Optional<BlockState> getDegradationResult(BlockState blockState) {
        return getIncreasedOxidationBlock(blockState.getBlock()).map((block) -> {
            return block.getStateWithProperties(blockState);
        });
    }

    default float getDegradationChanceMultiplier() {
        return this.getDegradationLevel() == Oxidizable.OxidationLevel.UNAFFECTED ? 0.75F : 1.0F;
    }
}
