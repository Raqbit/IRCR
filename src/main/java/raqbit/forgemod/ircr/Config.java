package raqbit.forgemod.ircr;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

/**
 * Created by Ramon on 26-10-2016.
 */
public class Config {

    private static String network;
    private static int port;
    private static String channel;
    private static String nick;
    private static String realname;
    private static boolean announceDeaths;

    public static void loadConfig(File configFile)
    {
        Configuration config = new Configuration(configFile);
        config.load();

        network = config.getString("network", Configuration.CATEGORY_GENERAL, "irc.esper.net", "The network for the relay to connect to.");
        port = config.getInt("port", Configuration.CATEGORY_GENERAL, 6667, 1024, 65535, "The port for the relay to use.");
        channel = config.getString("channel", Configuration.CATEGORY_GENERAL, "#mancave", "The channel for the relay to join.");
        nick = config.getString("nick", Configuration.CATEGORY_GENERAL, "MancaveRelay", "The Relay's nick.");
        realname = config.getString("realname", Configuration.CATEGORY_GENERAL, "A Relay bot for the Mancave Modded MC Server.", "The Relay's realname.");
        announceDeaths = config.getBoolean("announceDeaths", Configuration.CATEGORY_GENERAL, true, "Announce deaths or not.");

        config.save();
    }

    public static String getNetwork() {
        return network;
    }

    public static int getPort() {
        return port;
    }

    public static String getChannel() {
        return channel;
    }

    public static String getNick() {
        return nick;
    }

    public static String getRealname() {
        return realname;
    }

    public static boolean doAnnounceDeaths() {
        return announceDeaths;
    }
}
