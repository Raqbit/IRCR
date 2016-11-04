package raqbit.forgemod.ircr.mc.bot;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.CommandEvent;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import org.kitteh.irc.client.library.util.Format;
import raqbit.forgemod.ircr.config.ServerConfig;
import raqbit.forgemod.ircr.irc.Bot;
import raqbit.forgemod.ircr.irc.IRCUtil;
import raqbit.forgemod.ircr.mc.MCUtil;

/**
 * Created by Ramon on 26-10-2016.
 */
public class ForgeBotEvents {

    @SubscribeEvent
    public void onServerChat(ServerChatEvent event) {
            if (event.message.startsWith("\\")) {
                event.setCanceled(true);
                MCUtil.sayToAll("<" + event.username + "> " + event.message.substring(1), false);
                Bot.getClient().sendMessage(ServerConfig.getChannel(), Format.BOLD + IRCUtil.getNonPingableName(event.username) + " sent a bot command:");
                Bot.getClient().sendMessage(ServerConfig.getChannel(), event.message.substring(1));

            } else {
                Bot.getClient().sendMessage(ServerConfig.getChannel(), "<" + IRCUtil.getNonPingableName(event.username) + "> " + event.message);
            }
    }

    @SubscribeEvent
    public void onServerAction(CommandEvent event) {
        if (event.command.getCommandName().equals("me") && event.sender instanceof EntityPlayer) {
            Bot.getClient().sendMessage(ServerConfig.getChannel(), "* " +
                    IRCUtil.getNonPingableName(((EntityPlayer) event.sender).getDisplayName()) + " " +
                    MCUtil.arrayToString(event.parameters));
        }
    }

    @SubscribeEvent
    public void onServerJoin(PlayerEvent.PlayerLoggedInEvent event) {
        Bot.getClient().sendMessage(ServerConfig.getChannel(), Format.BOLD +
                IRCUtil.getNonPingableName(event.player.getDisplayName()) + " has joined the game.");
    }

    @SubscribeEvent
    public void onServerLeave(PlayerEvent.PlayerLoggedOutEvent event) {
        Bot.getClient().sendMessage(ServerConfig.getChannel(), Format.BOLD +
                IRCUtil.getNonPingableName(event.player.getDisplayName()) + " has left the game.");
    }

    @SubscribeEvent
    public void onPlayerDies(LivingDeathEvent event) {
        if (ServerConfig.doAnnounceDeaths() && event.entity instanceof EntityPlayer) {
            Bot.getClient().sendMessage(ServerConfig.getChannel(), Format.BOLD +
                    IRCUtil.getNonPingableName(((EntityPlayer) event.entity).getDisplayName()) + " died.");

        }
    }
}
