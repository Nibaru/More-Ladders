package games.twinhead.moreladders.tag;

import games.twinhead.moreladders.MoreLadders;
import net.minecraft.block.Block;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class MoreLaddersTags {
    public static final TagKey<Block> LADDERS = TagKey.of(Registry.BLOCK_KEY, new Identifier(MoreLadders.mod_id, "ladders"));
    public static final TagKey<Block> WOODEN_LADDERS = TagKey.of(Registry.BLOCK_KEY, new Identifier(MoreLadders.mod_id, "wooden_ladders"));
    public static final TagKey<Block> STONE_LADDERS = TagKey.of(Registry.BLOCK_KEY, new Identifier(MoreLadders.mod_id, "stone_ladders"));

}
