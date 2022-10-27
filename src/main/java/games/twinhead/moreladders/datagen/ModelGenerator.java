package games.twinhead.moreladders.datagen;

import games.twinhead.moreladders.MoreLadders;
import games.twinhead.moreladders.block.Ladder;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class ModelGenerator extends FabricModelProvider {

    public ModelGenerator(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        for (Ladder ladder: Ladder.values()) {
            blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ladder.getBlock());
            registerLadder(blockStateModelGenerator, ladder);
        }

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

    }


    public void registerLadder(BlockStateModelGenerator blockStateModelGenerator, Ladder ladder) {
        TextureMap textureMap = new TextureMap();

        TextureKey RUNG = TextureKey.of("rung");
        TextureKey RAIL = TextureKey.of("rail");

        textureMap.put(RUNG, ladder.getRungTexture());
        textureMap.put(RAIL, ladder.getRailTexture());

        Identifier ladderModel = new Model(Optional.of(new Identifier(MoreLadders.mod_id, "block/ladder")), Optional.empty(), RUNG, RAIL)
                .upload(new Identifier(MoreLadders.mod_id, "block/" + ladder), textureMap, blockStateModelGenerator.modelCollector);

    }
}
