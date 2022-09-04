package client.monika.fuck.modules;

import client.monika.fuck.Category;
import client.monika.fuck.Module;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;

public class ClickGUI extends Module {
    public ClickGUI() {
        super("ClickGUI","点击式GUI",Keyboard.KEY_RSHIFT, Category.RENDER);
    }

    @Override
    public void onEnable() {
        super.onEnable();
        Minecraft.getMinecraft().displayGuiScreen(new client.monika.fuck.clickgui.ClickGUI());
        toggle();
    }
}
