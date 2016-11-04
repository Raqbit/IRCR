package raqbit.forgemod.ircr.irc;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.EnumChatFormatting;
import org.kitteh.irc.client.library.event.channel.ChannelCTCPEvent;
import org.kitteh.irc.client.library.event.channel.ChannelJoinEvent;
import org.kitteh.irc.client.library.event.channel.ChannelMessageEvent;
import org.kitteh.irc.client.library.event.channel.ChannelPartEvent;
import org.kitteh.irc.client.library.event.helper.MessageEvent;
import org.kitteh.irc.client.library.util.Format;
import org.kitteh.irc.lib.net.engio.mbassy.listener.Handler;
import raqbit.forgemod.ircr.mc.MCUtil;
import raqbit.forgemod.ircr.mc.blocks.tileentity.MaunzInterfaceTileEntity;

import java.util.List;

/**
 * Created by Ramon on 26-10-2016.
 */
public class IRCEvents {

    @Handler
    public void onIRCChannelMessageMessage(ChannelMessageEvent event) {
        if (event.getMessage().toLowerCase().equals("\\list")) {
            List<EntityPlayer> playersOnline = MinecraftServer.getServer().getConfigurationManager().playerEntityList;

            if (!playersOnline.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < playersOnline.size(); i++) {
                    sb.append(IRCUtil.getNonPingableName(playersOnline.get(i).getDisplayName()));
                    if (i != playersOnline.size() - 1) {
                        sb.append(", ");
                    } else {
                        sb.append('.');
                    }
                }

                Bot.getClient().sendMessage(event.getChannel(), "Players online: " + sb.toString());
            }
            else
            {
                Bot.getClient().sendMessage(event.getChannel(), "Currently there are no players playing.");
            }
        }

        MCUtil.sayToAll("<" + event.getActor().getNick() + "> " + Format.stripAll(event.getMessage()), true);
    }

    @Handler
    public void onIRCPrivMessage(MessageEvent event)
    {
        if(event.getClient().getNick().equals("Maunz") && event.getMessage().equals("Pong!"))
        {
            MaunzInterfaceTileEntity.setIsWorking(true);
        }
    }

    @Handler
    public void onIRCAction(ChannelCTCPEvent event) {
        if (event.getMessage().startsWith("ACTION")) {
            String message = event.getMessage().substring(7);
            MCUtil.sayToAll("* " + event.getActor().getNick() + " " + Format.stripAll(message), true);
        }
    }

    @Handler
    public void onJoin(ChannelJoinEvent event) {
        MCUtil.sayToAll(EnumChatFormatting.GRAY + event.getActor().getNick() + " joined " + event.getChannel().getName() + ".", true);
    }

    @Handler
    public void onLeave(ChannelPartEvent event) {
        MCUtil.sayToAll(EnumChatFormatting.GRAY + event.getActor().getNick() + " left " + event.getChannel().getName() + ".", true);
    }
}
