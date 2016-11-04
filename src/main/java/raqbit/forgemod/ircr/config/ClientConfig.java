package raqbit.forgemod.ircr.config;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

/**
 * Created by Raqbit on 30-10-16.
 */
public class ClientConfig {

    // Variables used for configuring the irc Bot, client only


    // Setting up the dedi server config
    public static void loadConfig(File configFile) {
        Configuration config = new Configuration(configFile);
        config.load();



        config.save();
    }

    // Getters for dedi server variables

}
