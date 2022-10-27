package games.twinhead.moreladders.registry;

import games.twinhead.moreladders.MoreLadders;
import games.twinhead.moreladders.block.Ladder;
import games.twinhead.moreladders.block.OxidizableLadderBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.OxidizableBlocksRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Oxidizable;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.HashMap;

public class BlockRegistry {

    public static HashMap<Ladder, Block> LADDERS = new HashMap<>();

    public void register(){
        for (Ladder ladder :Ladder.values()) {
            registerBlock(ladder);
        }
        registerOxidizable();
    }

    public void registerOxidizable(){
        OxidizableBlocksRegistry.registerOxidizableBlockPair(Ladder.COPPER.getBlock(), Ladder.EXPOSED_COPPER.getBlock());
        OxidizableBlocksRegistry.registerOxidizableBlockPair(Ladder.EXPOSED_COPPER.getBlock(), Ladder.WEATHERED_COPPER.getBlock());
        OxidizableBlocksRegistry.registerOxidizableBlockPair(Ladder.WEATHERED_COPPER.getBlock(), Ladder.OXIDIZED_COPPER.getBlock());

        OxidizableBlocksRegistry.registerWaxableBlockPair(Ladder.COPPER.getBlock(), Ladder.WAXED_COPPER.getBlock());
        OxidizableBlocksRegistry.registerWaxableBlockPair(Ladder.EXPOSED_COPPER.getBlock(), Ladder.EXPOSED_COPPER.getBlock());
        OxidizableBlocksRegistry.registerWaxableBlockPair(Ladder.WEATHERED_COPPER.getBlock(), Ladder.WEATHERED_COPPER.getBlock());
        OxidizableBlocksRegistry.registerWaxableBlockPair(Ladder.OXIDIZED_COPPER.getBlock(), Ladder.OXIDIZED_COPPER.getBlock());
        
    }

    public static void registerBlock(Ladder ladder){
        Registry.register(Registry.ITEM, new Identifier(MoreLadders.mod_id, ladder.toString()), new BlockItem(ladder.getBlock(), new FabricItemSettings().group(ItemGroup.DECORATIONS)));
        Registry.register(Registry.BLOCK, new Identifier(MoreLadders.mod_id, ladder.toString()), ladder.getBlock());
    }
}
