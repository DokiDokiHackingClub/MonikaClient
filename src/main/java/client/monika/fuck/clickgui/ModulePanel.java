package client.monika.fuck.clickgui;

import client.monika.fuck.Module;
import client.monika.fuck.modules.ChineseMode;

import java.awt.*;

public class ModulePanel {

    private Module module;
    private boolean hovered;

    public ModulePanel(Module module) {
        this.module = module;
        FontUtils.setupFontUtils();//设置Font
    }

    public void drawScreen(int mouseX, int mouseY, int x, int y, int width, int height) {
        this.hovered = ClickGUI.isHovered(mouseX, mouseY, x, y, width, height);//鼠标是否在指定位置
        int color = new Color(200, 190, 255).getRGB();//颜色
        if (this.module.isToggle()) color = new Color(200, 0, 120).getRGB();//Module打开的颜色
        if (this.hovered) color = new Color(200, 88, 120).getRGB();//鼠标在指定位置的颜色
        ClickGUI.drawRect(x, y, width, height, color);//绘制Module的背景
        if(ChineseMode.INSTANCE.isToggle())FontUtils.drawCenteredString(this.module.getcName(), x + width / 2, y + height / 2, Color.WHITE.getRGB());
        else FontUtils.drawCenteredString(this.module.getName(), x + width / 2, y + height / 2, Color.WHITE.getRGB());//绘制Module的名字
    }


    public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
        if(this.hovered && mouseButton == 0) {
            this.module.toggle();//当鼠标在指定位置并且鼠标被按下设置Module为关闭或打开
        }
    }
}
