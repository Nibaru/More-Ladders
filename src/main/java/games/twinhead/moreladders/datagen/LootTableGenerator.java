package games.twinhead.moreladders.datagen;

import games.twinhead.moreladders.MoreLadders;
import games.twinhead.moreladders.block.Ladder;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider;
import net.minecraft.data.server.BlockLootTableGenerator;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.util.Identifier;

import java.util.function.BiConsumer;

public class LootTableGenerator extends SimpleFabricLootTableProvider {


    public LootTableGenerator(FabricDataGenerator dataGenerator) {
        super(dataGenerator, LootContextTypes.BLOCK);
    }

    @Override
    public void accept(BiConsumer<Identifier, LootTable.Builder> identifierBuilderBiConsumer) {
        for (Ladder ladder :Ladder.values()) {
            identifierBuilderBiConsumer.accept(new Identifier(MoreLadders.mod_id, "blocks/" + ladder.toString()), BlockLootTableGenerator.drops(ladder.getBlock(), ladder.getBlock().asItem(), ConstantLootNumberProvider.create(1.0F)));
        }
    }
}
