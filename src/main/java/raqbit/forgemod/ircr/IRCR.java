package raqbit.forgemod.ircr;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartedEvent;
import cpw.mods.fml.common.event.FMLServerStoppingEvent;
import net.minecraftforge.common.MinecraftForge;
import raqbit.forgemod.ircr.IRC.Bot;
import raqbit.forgemod.ircr.MC.ForgeEvents;

/**
 * Created by Ramon on 26-10-2016.
 */
@Mod(modid = IRCR.MODID, version = IRCR.VERSION, name = "IRC Relay", acceptableRemoteVersions = "*")
public class IRCR {
    public static final String MODID = "ircr";
    public static final String VERSION = "0.5";

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        FMLCommonHandler.instance().bus().register(new ForgeEvents());
        MinecraftForge.EVENT_BUS.register(new ForgeEvents());

        Config.loadConfig(event.getSuggestedConfigurationFile());
    }

    @EventHandler
    public void serverLoaded(FMLServerStartedEvent event) {
        Bot.createBot();
    }

    @EventHandler
    public void serverStopping(FMLServerStoppingEvent event) {
        Bot.getClient().shutdown("Server stopping.");
    }
}
