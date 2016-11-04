package raqbit.forgemod.ircr.irc;

import org.kitteh.irc.client.library.Client;
import org.kitteh.irc.client.library.feature.auth.SaslPlain;
import raqbit.forgemod.ircr.config.ServerConfig;

/**
 * Created by Ramon on 26-10-2016.
 */
public class Bot {
    private static Client client;

    public static Client getClient() {
        return client;
    }

    public static String getChannel() {
        return ServerConfig.getChannel();
    }

    public static void createBot()
    {
        System.out.println("Creating bot...");
        boolean isSecure = ServerConfig.isSsl();

        client = Client.builder()
                .nick(ServerConfig.getNick())
                .serverHost(ServerConfig.getNetwork())
                .serverPort(ServerConfig.getPort())
                .secure(isSecure)
                .realName(ServerConfig.getRealname())
                .build();

        if(isSecure)
        {
            System.out.println("Using a secure ssl connection to connect to irc. Sasl is now possible.");

            if(ServerConfig.useSasl())
            {
                client.getAuthManager().addProtocol(new SaslPlain(client, ServerConfig.getSaslname(), String.copyValueOf(ServerConfig.getSaslpass())));
                System.out.println("Using sasl to authenticate with irc services.");
            }
        }
        client.getEventManager().registerEventListener(new IRCEvents());
        client.addChannel(ServerConfig.getChannel());
        System.out.println("Joined " + ServerConfig.getChannel() + ".");
        client.sendMessage(ServerConfig.getChannel(), "Server has initialized.");
    }
}
