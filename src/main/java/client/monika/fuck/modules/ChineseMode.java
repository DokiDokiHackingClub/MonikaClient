package client.monika.fuck.modules;

import client.monika.fuck.Category;
import client.monika.fuck.Module;
import org.lwjgl.input.Keyboard;

public class ChineseMode extends Module {
    public static final ChineseMode INSTANCE=new ChineseMode();
    public ChineseMode() {
        super("ChineseMode","中文模式", Keyboard.KEY_NONE, Category.OTHER);
    }
}
