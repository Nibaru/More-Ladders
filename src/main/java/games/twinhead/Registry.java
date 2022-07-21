package games.twinhead;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Registry {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MoreLadders.mod_id);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MoreLadders.mod_id);

    public static final RegistryObject<Block> SPRUCE_LADDER = BLOCKS.register( "spruce_ladder", () -> new MoreLadderBlock(BlockBehaviour.Properties.of(Material.DECORATION).noOcclusion().strength(0.4F).sound(SoundType.LADDER)));
    public static final RegistryObject<Block> OAK_LADDER = BLOCKS.register( "oak_ladder", () -> new MoreLadderBlock(BlockBehaviour.Properties.of(Material.DECORATION).noOcclusion().strength(0.4F).sound(SoundType.LADDER)));
    public static final RegistryObject<Block> BIRCH_LADDER = BLOCKS.register( "birch_ladder", () -> new MoreLadderBlock(BlockBehaviour.Properties.of(Material.DECORATION).noOcclusion().strength(0.4F).sound(SoundType.LADDER)));
    public static final RegistryObject<Block> JUNGLE_LADDER = BLOCKS.register( "jungle_ladder", () -> new MoreLadderBlock(BlockBehaviour.Properties.of(Material.DECORATION).noOcclusion().strength(0.4F).sound(SoundType.LADDER)));
    public static final RegistryObject<Block> ACACIA_LADDER = BLOCKS.register( "acacia_ladder", () -> new MoreLadderBlock(BlockBehaviour.Properties.of(Material.DECORATION).noOcclusion().strength(0.4F).sound(SoundType.LADDER)));
    public static final RegistryObject<Block> DARK_OAK_LADDER = BLOCKS.register( "dark_oak_ladder", () -> new MoreLadderBlock(BlockBehaviour.Properties.of(Material.DECORATION).noOcclusion().strength(0.4F).sound(SoundType.LADDER)));
    public static final RegistryObject<Block> MANGROVE_LADDER = BLOCKS.register( "mangrove_ladder", () -> new MoreLadderBlock(BlockBehaviour.Properties.of(Material.DECORATION).noOcclusion().strength(0.4F).sound(SoundType.LADDER)));
    public static final RegistryObject<Block> CRIMSON_LADDER = BLOCKS.register( "crimson_ladder", () -> new MoreLadderBlock(BlockBehaviour.Properties.of(Material.DECORATION).noOcclusion().strength(0.4F).sound(SoundType.LADDER)));
    public static final RegistryObject<Block> WARPED_LADDER = BLOCKS.register( "warped_ladder", () -> new MoreLadderBlock(BlockBehaviour.Properties.of(Material.DECORATION).noOcclusion().strength(0.4F).sound(SoundType.LADDER)));

    public static final  RegistryObject<Item> SPRUCE_LADDER_ITEM = ITEMS.register("spruce_ladder",() -> new BlockItem(SPRUCE_LADDER.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
    public static final  RegistryObject<Item> OAK_LADDER_ITEM = ITEMS.register("oak_ladder",() -> new BlockItem(OAK_LADDER.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
    public static final  RegistryObject<Item> BIRCH_LADDER_ITEM = ITEMS.register("birch_ladder",() -> new BlockItem(BIRCH_LADDER.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
    public static final  RegistryObject<Item> JUNGLE_LADDER_ITEM = ITEMS.register("jungle_ladder",() -> new BlockItem(JUNGLE_LADDER.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
    public static final  RegistryObject<Item> ACACIA_LADDER_ITEM = ITEMS.register("acacia_ladder",() -> new BlockItem(ACACIA_LADDER.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
    public static final  RegistryObject<Item> DARK_OAK_LADDER_ITEM = ITEMS.register("dark_oak_ladder",() -> new BlockItem(DARK_OAK_LADDER.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
    public static final  RegistryObject<Item> MANGROVE_LADDER_ITEM = ITEMS.register("mangrove_ladder",() -> new BlockItem(MANGROVE_LADDER.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
    public static final  RegistryObject<Item> CRIMSON_LADDER_ITEM = ITEMS.register("crimson_ladder",() -> new BlockItem(CRIMSON_LADDER.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));
    public static final  RegistryObject<Item> WARPED_LADDER_ITEM = ITEMS.register("warped_ladder",() -> new BlockItem(WARPED_LADDER.get(), new Item.Properties().tab(CreativeModeTab.TAB_DECORATIONS)));

}
