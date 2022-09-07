package games.twinhead;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(MoreLadders.mod_id)
public class MoreLadders {
    public static final String mod_id="more_ladders";


    public MoreLadders() {
        // Register ourselves for server and other game events we are interested in
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        Registry.BLOCKS.register(eventBus);
        Registry.ITEMS.register(eventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent e) {
        if(e.phase.equals(TickEvent.Phase.END)) return;
        Block block = e.player.level.getBlockState(new BlockPos(e.player.position().x, e.player.position().y,
                e.player.position().z)).getBlock();
        if (block instanceof MoreLadderBlock) {
            if (!e.player.isCrouching()) {
                if (e.player.horizontalCollision) {
                    e.player.move(MoverType.SELF, new Vec3(0, 0.15, 0));
                } else e.player.move(MoverType.SELF, new Vec3(0, -0.15, 0));
            }
        }
    }


}
