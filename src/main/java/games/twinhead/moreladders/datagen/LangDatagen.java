package games.twinhead.moreladders.datagen;

import games.twinhead.moreladders.block.Ladder;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public class LangDatagen extends FabricLanguageProvider {

    protected LangDatagen(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        for (Ladder ladder :Ladder.values()) {
            translationBuilder.add(ladder.getBlock(), ladder.displayName());
        }
    }
}
