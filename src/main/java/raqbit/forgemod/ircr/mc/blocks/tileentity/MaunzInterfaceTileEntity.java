package raqbit.forgemod.ircr.mc.blocks.tileentity;


import dan200.computercraft.api.lua.ILuaContext;
import dan200.computercraft.api.lua.LuaException;
import dan200.computercraft.api.peripheral.IComputerAccess;
import dan200.computercraft.api.peripheral.IPeripheral;
import net.minecraft.tileentity.TileEntity;
import raqbit.forgemod.ircr.irc.Bot;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by Raqbit on 30-10-16.
 */
public class MaunzInterfaceTileEntity extends TileEntity implements IPeripheral {

    private static boolean isWorking;

    public static void setIsWorking(boolean isWorking) {
        MaunzInterfaceTileEntity.isWorking = isWorking;
    }

    @Override
    public String getType() {
        return "maunzinterface";
    }

    @Override
    public String[] getMethodNames() {
        return new String[]{"think", "isWorking", "reset"};
    }

    @Override
    public Object[] callMethod(IComputerAccess computer, ILuaContext context, int method, Object[] arguments) throws LuaException, InterruptedException {
        if (method == 2) {
            Bot.getClient().sendCTCPMessage("Maunz", "*ping");
            Thread.sleep(5000);
            if (isWorking) {
                setIsWorking(false);
                return new Object[]{true};
            } else {
                return new Object[]{false};
            }
        }
        return new Object[]{null};
    }

    @Override
    public void attach(IComputerAccess computer) {
        System.out.println("Attaching...");
    }

    @Override
    public void detach(IComputerAccess computer) {
        Bot.getClient().sendCTCPMessage("Maunz", "*reset");
    }

    @Override
    public boolean equals(IPeripheral other) {
        return false;
    }
}
