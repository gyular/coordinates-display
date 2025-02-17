package me.boxadactle.coordinatesdisplay.event;

import me.boxadactle.coordinatesdisplay.CoordinatesDisplay;
import me.boxadactle.coordinatesdisplay.init.Keybinds;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ClientEvents {

    @Mod.EventBusSubscriber(modid = CoordinatesDisplay.MOD_ID, value = Dist.CLIENT)
    public static class ClientForgeEvents {
        @SubscribeEvent
        public static void keyInput(InputEvent.Key e) {
            LocalPlayer p = Minecraft.getInstance().player;
            if (p != null) {
                Keybinds.checkBindings(p.getX(), p.getY(), p.getBlockZ());
            }
        }
    }

    @Mod.EventBusSubscriber(modid = CoordinatesDisplay.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModBusEvents {
        @SubscribeEvent
        public static void keyRegister(RegisterKeyMappingsEvent e) {
            CoordinatesDisplay.LOGGER.info("Registering key binds");
            Keybinds.register(e);
        }
    }
}
