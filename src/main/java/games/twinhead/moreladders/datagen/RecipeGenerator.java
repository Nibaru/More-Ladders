package games.twinhead.moreladders.datagen;


import games.twinhead.moreladders.block.Ladder;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import java.util.function.Consumer;

public class RecipeGenerator extends FabricRecipeProvider {
    public RecipeGenerator(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }


    @Override
    protected void generateRecipes(Consumer<RecipeJsonProvider> exporter) {
        for (Ladder ladder :Ladder.values()) {
            ShapedRecipeJsonBuilder.create(ladder.getBlock(), 8).criterion(hasItem(ladder.getBlock()), conditionsFromItem(ladder.getBlock()))
                    .input('#', ladder.getCopyBlock())
                    .pattern("# #")
                    .pattern("###")
                    .pattern("# #")
                    .group("ladders")
                    .offerTo(exporter);
        }
    }
}
