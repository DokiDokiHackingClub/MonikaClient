package client.monika.fuck.clickgui;

import client.monika.fuck.Category;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;

import java.io.IOException;
import java.util.ArrayList;

public class ClickGUI extends GuiScreen {

    public ArrayList<CategoryPanel> categoryPanels;

    public ClickGUI() {
        //添加Category
        categoryPanels = new ArrayList<>();
        int categoryPanelsY = 5;
        for (Category c : Category.values()) {
            categoryPanels.add(new CategoryPanel(c, 5, categoryPanelsY, 100, 20));
            categoryPanelsY += 30;
        }
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        for (CategoryPanel c : categoryPanels) {
            c.drawScreen(mouseX, mouseY);//绘制所有Category
        }
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    public void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
        for (CategoryPanel c : categoryPanels) {
            c.mouseClicked(mouseX, mouseY,mouseButton);//调用所有CategoryPanel的mouseClicked方法
        }
        super.mouseClicked(mouseX, mouseY, mouseButton);
    }

    @Override
    public void mouseReleased(int mouseX, int mouseY, int state) {
        for (CategoryPanel c : categoryPanels) {
            c.mouseReleased(mouseX, mouseY,state);//调用所有CategoryPanel的mouseReleased方法
        }
        super.mouseReleased(mouseX, mouseY, state);
    }

    public static boolean isHovered(int mouseX, int mouseY, int x, int y, int width, int height) {
        return mouseX >= x && mouseX - width <= x && mouseY >= y && mouseY - height <= y;//获取鼠标位置是否在指定位置
    }


    public static void drawRect(int x, int y, int width, int height, int color) {
        Gui.drawRect(x, y, x + width, y + height, color);//绘制Rect
    }
}
