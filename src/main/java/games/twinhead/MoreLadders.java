package games.twinhead;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(MoreLadders.mod_id)
public class MoreLadders {
    public static final String mod_id="more_ladders";


    public MoreLadders() {
        // Register ourselves for server and other game events we are interested in
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        Registry.BLOCKS.register(eventBus);
        Registry.ITEMS.register(eventBus);

        eventBus.addListener(this::clientSetup);

        MinecraftForge.EVENT_BUS.register(this);
    }

    public void clientSetup(final FMLClientSetupEvent event){
        event.enqueueWork(()->{
            ItemBlockRenderTypes.setRenderLayer(Registry.OAK_LADDER.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(Registry.SPRUCE_LADDER.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(Registry.BIRCH_LADDER.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(Registry.JUNGLE_LADDER.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(Registry.ACACIA_LADDER.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(Registry.DARK_OAK_LADDER.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(Registry.CRIMSON_LADDER.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(Registry.WARPED_LADDER.get(), RenderType.translucent());

        });
    }

    @SubscribeEvent
    public void onPlayerTick(LivingEvent.LivingUpdateEvent e) {
        if (e.getEntityLiving() instanceof Player) {
            Player player = (Player) e.getEntityLiving();
            Block block = player.level.getBlockState(new BlockPos(player.position().x, player.position().y,
                    player.position().z)).getBlock();
            if (block instanceof MoreLadderBlock) {
                if (!player.isCrouching()) {
                    if (player.horizontalCollision) {
                        player.move(MoverType.SELF, new Vec3(0, 0.15, 0));
                    } else player.move(MoverType.SELF, new Vec3(0, -0.15, 0));
                }
            }
        }
    }


}
