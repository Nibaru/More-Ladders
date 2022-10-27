package games.twinhead.moreladders.block;

import games.twinhead.moreladders.MoreLadders;
import games.twinhead.moreladders.registry.BlockRegistry;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Oxidizable;
import net.minecraft.tag.BlockTags;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;

public enum Ladder {
    ACACIA(Blocks.ACACIA_PLANKS, BlockTags.AXE_MINEABLE, "acacia_planks"),
    BIRCH(Blocks.BIRCH_PLANKS, BlockTags.AXE_MINEABLE, "birch_planks"),
    CRIMSON(Blocks.CRIMSON_PLANKS, BlockTags.AXE_MINEABLE, "crimson_planks"),
    DARK_OAK(Blocks.DARK_OAK_PLANKS, BlockTags.AXE_MINEABLE, "dark_oak_planks"),
    JUNGLE(Blocks.JUNGLE_PLANKS, BlockTags.AXE_MINEABLE, "jungle_planks"),
    MANGROVE(Blocks.MANGROVE_PLANKS, BlockTags.AXE_MINEABLE, "mangrove_planks"),
    OAK(Blocks.OAK_PLANKS, BlockTags.AXE_MINEABLE, "oak_planks"),
    SPRUCE(Blocks.SPRUCE_PLANKS, BlockTags.AXE_MINEABLE, "spruce_planks"),
    WARPED(Blocks.WARPED_PLANKS, BlockTags.AXE_MINEABLE, "warped_planks"),

    ACACIA_LOG(Blocks.ACACIA_LOG, BlockTags.AXE_MINEABLE, "acacia_log", "acacia_planks"),
    BIRCH_LOG(Blocks.BIRCH_LOG, BlockTags.AXE_MINEABLE, "birch_log", "birch_planks"),
    CRIMSON_STEM(Blocks.CRIMSON_STEM, BlockTags.AXE_MINEABLE, "crimson_stem", "crimson_planks"),
    DARK_OAK_LOG(Blocks.DARK_OAK_LOG, BlockTags.AXE_MINEABLE, "dark_oak_log", "dark_oak_planks"),
    JUNGLE_LOG(Blocks.JUNGLE_LOG, BlockTags.AXE_MINEABLE, "jungle_log", "jungle_planks"),
    MANGROVE_LOG(Blocks.MANGROVE_LOG, BlockTags.AXE_MINEABLE, "mangrove_log", "mangrove_planks"),
    OAK_LOG(Blocks.OAK_LOG, BlockTags.AXE_MINEABLE, "oak_log", "oak_planks"),
    SPRUCE_LOG(Blocks.SPRUCE_LOG, BlockTags.AXE_MINEABLE, "spruce_log", "spruce_planks"),
    WARPED_LOG(Blocks.WARPED_STEM, BlockTags.AXE_MINEABLE, "warped_stem", "warped_planks"),

    RED_MUSHROOM(Blocks.RED_MUSHROOM_BLOCK, BlockTags.AXE_MINEABLE, "red_mushroom_block", "mushroom_stem"),
    BROWN_MUSHROOM(Blocks.BROWN_MUSHROOM_BLOCK, BlockTags.AXE_MINEABLE, "brown_mushroom_block", "mushroom_stem"),

    COBBLESTONE(Blocks.COBBLESTONE, BlockTags.PICKAXE_MINEABLE),
    MOSSY_COBBLESTONE(Blocks.MOSSY_COBBLESTONE, BlockTags.PICKAXE_MINEABLE),
    STONE(Blocks.STONE, BlockTags.PICKAXE_MINEABLE),
    STONE_BRICK(Blocks.STONE_BRICKS, BlockTags.PICKAXE_MINEABLE, "stone_bricks"),
    DEEPSLATE(Blocks.DEEPSLATE, BlockTags.PICKAXE_MINEABLE),
    DEEPSLATE_BRICK(Blocks.DEEPSLATE_BRICKS, BlockTags.PICKAXE_MINEABLE, "deepslate_bricks"),

    BRICK(Blocks.BRICKS, BlockTags.PICKAXE_MINEABLE,"bricks"),

    BASALT(Blocks.BASALT, BlockTags.PICKAXE_MINEABLE, "basalt_side", "basalt_top"),
    COPPER(Blocks.COPPER_BLOCK, BlockTags.PICKAXE_MINEABLE, "copper_block"),
    EXPOSED_COPPER(Blocks.EXPOSED_COPPER, BlockTags.PICKAXE_MINEABLE),
    WEATHERED_COPPER(Blocks.WEATHERED_COPPER, BlockTags.PICKAXE_MINEABLE),
    OXIDIZED_COPPER(Blocks.OXIDIZED_COPPER, BlockTags.PICKAXE_MINEABLE),
    WAXED_COPPER(Blocks.WAXED_COPPER_BLOCK, BlockTags.PICKAXE_MINEABLE, "copper_block"),
    WAXED_EXPOSED_COPPER(Blocks.WAXED_EXPOSED_COPPER, BlockTags.PICKAXE_MINEABLE, "exposed_copper"),
    WAXED_WEATHERED_COPPER(Blocks.WAXED_WEATHERED_COPPER, BlockTags.PICKAXE_MINEABLE, "weathered_copper"),
    WAXED_OXIDIZED_COPPER(Blocks.WAXED_OXIDIZED_COPPER, BlockTags.PICKAXE_MINEABLE, "oxidized_copper"),


    ;


    final String railTexture;
    final String rungTexture;
    final Block copyBlock;
    final TagKey<Block> toolTag;

    Ladder(Block copyBlock, TagKey<Block> toolTag){
        this.copyBlock = copyBlock;
        this.toolTag = toolTag;
        this.rungTexture = this.name().toLowerCase();
        this.railTexture = this.name().toLowerCase();
    };

    Ladder(Block copyBlock, TagKey<Block> toolTag, String bothTexture){
        this.copyBlock = copyBlock;
        this.toolTag = toolTag;
        this.rungTexture = bothTexture;
        this.railTexture = bothTexture;
    };

    Ladder(Block copyBlock, TagKey<Block> toolTag, String railTexture, String rungTexture){
        this.copyBlock = copyBlock;
        this.toolTag = toolTag;
        this.railTexture = railTexture;
        this.rungTexture= rungTexture;
    };

    public Block getCopyBlock(){
        return this.copyBlock;
    }


    public Block getBlock(){
        if(!BlockRegistry.LADDERS.containsKey(this)){
            Block block = switch (this){
                case COPPER -> new OxidizableLadderBlock(Oxidizable.OxidationLevel.UNAFFECTED, FabricBlockSettings.copyOf(Blocks.COPPER_BLOCK).nonOpaque());
                case EXPOSED_COPPER -> new OxidizableLadderBlock(Oxidizable.OxidationLevel.EXPOSED,FabricBlockSettings.copyOf(Blocks.EXPOSED_COPPER).nonOpaque());
                case WEATHERED_COPPER -> new OxidizableLadderBlock(Oxidizable.OxidationLevel.WEATHERED,FabricBlockSettings.copyOf(Blocks.WEATHERED_COPPER).nonOpaque());
                case OXIDIZED_COPPER -> new OxidizableLadderBlock(Oxidizable.OxidationLevel.OXIDIZED,FabricBlockSettings.copyOf(Blocks.OXIDIZED_COPPER).nonOpaque());
                default -> new MoreLadderBlock(FabricBlockSettings.copyOf(this.getToolTag()  == BlockTags.PICKAXE_MINEABLE ? this.getCopyBlock() : Blocks.LADDER).nonOpaque());
            };

            BlockRegistry.LADDERS.put(this, block);
            return block;
        } else {
            return BlockRegistry.LADDERS.get(this);
        }
    };

    public String toString(){
        return this.name().toLowerCase() + "_ladder";
    }

    public String displayName(){
        String[] parts = this.toString().split("_");
        StringBuilder builder = new StringBuilder();
        for (String part: parts) {
            builder.append(part.substring(0,1).toUpperCase()).append(part.substring(1).toLowerCase()).append(" ");
        }

        return builder.toString().substring(0, builder.length()-1);
    }

    public Identifier getIdentifier(){
        return new Identifier(MoreLadders.mod_id, this.toString());
    }

    public Identifier getRungTexture(){
        return new Identifier("minecraft", "block/" + this.rungTexture);
    }

    public Identifier getRailTexture(){
        return new Identifier("minecraft", "block/" + this.railTexture);
    }

    public TagKey<Block> getToolTag(){
        return this.toolTag;
    }


}
