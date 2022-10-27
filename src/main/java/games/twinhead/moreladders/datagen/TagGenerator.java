package games.twinhead.moreladders.datagen;


import games.twinhead.moreladders.block.Ladder;
import games.twinhead.moreladders.tag.MoreLaddersTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.registry.Registry;

public class TagGenerator extends FabricTagProvider<Block> {

    public TagGenerator(FabricDataGenerator dataGenerator) {
        super(dataGenerator, Registry.BLOCK);
    }



    @Override
    protected void generateTags() {
        for (Ladder ladder: Ladder.values()) {
            getOrCreateTagBuilder(BlockTags.CLIMBABLE).add(ladder.getBlock());
            getOrCreateTagBuilder(BlockTags.FALL_DAMAGE_RESETTING).add(ladder.getBlock());

            if(ladder.getToolTag() == BlockTags.AXE_MINEABLE){
                getOrCreateTagBuilder(MoreLaddersTags.WOODEN_LADDERS).add(ladder.getBlock());
            }

            if(ladder.getToolTag() == BlockTags.PICKAXE_MINEABLE){
                getOrCreateTagBuilder(MoreLaddersTags.STONE_LADDERS).add(ladder.getBlock());
            }
        }
        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE).addTag(MoreLaddersTags.WOODEN_LADDERS);
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE).addTag(MoreLaddersTags.STONE_LADDERS);


    }
}
