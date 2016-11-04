package raqbit.forgemod.ircr.mc;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;

import java.util.List;

/**
 * Created by Ramon on 26-10-2016.
 */
public class MCUtil {

    public static void sayToAll(String message, boolean fromIRC) {
        List<EntityPlayer> users = MinecraftServer.getServer().getConfigurationManager().playerEntityList;
        if (fromIRC) {
            for (EntityPlayer player : users) {
                player.addChatMessage(new ChatComponentText(EnumChatFormatting.DARK_PURPLE + "" + EnumChatFormatting.BOLD + "[irc] " + EnumChatFormatting.RESET + message));
            }
        } else {
            for (EntityPlayer player : users) {
                player.addChatMessage(new ChatComponentText(message));
            }
        }
    }

    public static String arrayToString(String[] array) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i != array.length - 1) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }
}
