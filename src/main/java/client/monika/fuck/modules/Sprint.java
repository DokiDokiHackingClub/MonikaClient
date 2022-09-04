package client.monika.fuck.modules;

import client.monika.fuck.Category;
import client.monika.fuck.Module;
import client.monika.fuck.event.EventTarget;
import client.monika.fuck.event.events.EventUpdate;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;

public class Sprint extends Module {
    Category category=Category.PLAYER.registry(this);

    public Sprint() {
        super("Sprint", "强制疾跑", Keyboard.KEY_V, Category.PLAYER);
    }

    @EventTarget
    public void onUpdate(EventUpdate e) {
        Minecraft.getMinecraft().thePlayer.setSprinting(true);
    }
}
