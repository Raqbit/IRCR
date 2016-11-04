package raqbit.forgemod.ircr.irc;

/**
 * Created by Ramon on 26-10-2016.
 */
public class IRCUtil {

    public static String getNonPingableName(String name)
    {
        return name.substring(0,1) + "\u200B" + name.substring(1);
    }
}
