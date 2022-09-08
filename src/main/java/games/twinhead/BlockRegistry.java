package games.twinhead;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BlockRegistry {

    public void register(){
        registerBlock("oak_ladder");
        registerBlock("spruce_ladder");
        registerBlock("birch_ladder");
        registerBlock("jungle_ladder");
        registerBlock("acacia_ladder");
        registerBlock("dark_oak_ladder");
        registerBlock("mangrove_ladder");
        registerBlock("crimson_ladder");
        registerBlock("warped_ladder");
    }


    public static void registerBlock(String name){
        Block block = new MoreLadderBlock(FabricBlockSettings.copyOf(Blocks.LADDER));
        Registry.register(Registry.BLOCK, new Identifier(MoreLadders.mod_id, name), block);
        Registry.register(Registry.ITEM, new Identifier(MoreLadders.mod_id, name), new BlockItem(block, new FabricItemSettings().group(ItemGroup.DECORATIONS)));
    }
}
