package raqbit.forgemod.ircr.proxy;

import cpw.mods.fml.common.event.*;

/**
 * Created by Raqbit on 30-10-16.
 */
public interface IModProxy {

    public void preInit(FMLPreInitializationEvent event);

    public void init(FMLInitializationEvent event);

    public void postInit(FMLPostInitializationEvent event);

    public void serverLoaded(FMLServerStartedEvent event);

    public void serverStopping(FMLServerStoppingEvent event);
}
