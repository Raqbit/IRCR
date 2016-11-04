package raqbit.forgemod.ircr.config;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

/**
 * Created by Ramon on 26-10-2016.
 */
public class ServerConfig {

    // Variables used for configuring the irc Bot, dedi server only
    private static boolean ssl;
    private static String network;
    private static int port;
    private static boolean useSasl;
    private static String saslname;
    private static char[] saslpass;
    private static String nick;
    private static String realname;
    private static String channel;
    private static boolean announceDeaths;

    // Setting up the dedi server config
    public static void loadConfig(File configFile) {
        Configuration config = new Configuration(configFile);
        config.load();

        ssl = config.getBoolean("enableSSL", Configuration.CATEGORY_GENERAL, true, "Use ssl or not");
        network = config.getString("network", Configuration.CATEGORY_GENERAL, "irc.esper.net", "The network for the relay to connect to.");
        port = config.getInt("port", Configuration.CATEGORY_GENERAL, 6697, 1024, 65535, "The port for the relay to use.");
        useSasl = config.getBoolean("useSasl", Configuration.CATEGORY_GENERAL, false, "Use Sasl or not");
        saslname = config.getString("saslName", Configuration.CATEGORY_GENERAL, "saslname", "The name used for sasl authentication.");
        saslpass = config.getString("saslPass", Configuration.CATEGORY_GENERAL, "saslpass", "The password used for sasl authentication.").toCharArray();
        nick = config.getString("nick", Configuration.CATEGORY_GENERAL, "MancaveRelay", "The Relay's nick.");
        realname = config.getString("realname", Configuration.CATEGORY_GENERAL, "A Relay bot for the Mancave Modded mc Server.", "The Relay's realname.");
        channel = config.getString("channel", Configuration.CATEGORY_GENERAL, "#mancave", "The channel for the relay to join.");
        announceDeaths = config.getBoolean("announceDeaths", Configuration.CATEGORY_GENERAL, true, "Announce deaths or not.");

        config.save();
    }

    // Getters for dedi server variables
    public static boolean isSsl() {
        return ssl;
    }

    public static String getNetwork() {
        return network;
    }

    public static int getPort() {
        return port;
    }

    public static boolean useSasl() {
        return useSasl;
    }

    public static char[] getSaslpass() {
        return saslpass;
    }

    public static String getSaslname() {
        return saslname;
    }

    public static String getNick() {
        return nick;
    }

    public static String getRealname() {
        return realname;
    }

    public static String getChannel() {
        return channel;
    }

    public static boolean doAnnounceDeaths() {
        return announceDeaths;
    }
}
