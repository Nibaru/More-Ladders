package games.twinhead.moreladders;

import games.twinhead.moreladders.registry.BlockRegistry;
import net.fabricmc.api.ModInitializer;

public class MoreLadders implements ModInitializer {

    public static final String mod_id="more_ladders";

    @Override
    public void onInitialize() {
        new BlockRegistry().register();
    }
}
