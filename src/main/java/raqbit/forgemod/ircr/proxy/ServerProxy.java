package raqbit.forgemod.ircr.proxy;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.*;
import net.minecraftforge.common.MinecraftForge;
import raqbit.forgemod.ircr.config.ServerConfig;
import raqbit.forgemod.ircr.irc.Bot;
import raqbit.forgemod.ircr.mc.bot.ForgeBotEvents;

/**
 * Created by Raqbit on 30-10-16.
 */
public class ServerProxy implements IModProxy {
    @Override
    public void preInit(FMLPreInitializationEvent event) {
        ServerConfig.loadConfig(event.getSuggestedConfigurationFile());

        FMLCommonHandler.instance().bus().register(new ForgeBotEvents());
        MinecraftForge.EVENT_BUS.register(new ForgeBotEvents());
    }

    @Override
    public void init(FMLInitializationEvent event) {

    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {

    }

    @Override
    public void serverLoaded(FMLServerStartedEvent event) {
        Bot.createBot();
    }

    @Override
    public void serverStopping(FMLServerStoppingEvent event) {
        Bot.getClient().shutdown("Server stopping.");
    }
}
