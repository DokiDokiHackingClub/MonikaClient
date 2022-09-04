package client.monika.fuck.clickgui;

import client.monika.fuck.Category;
import client.monika.fuck.Client;
import client.monika.fuck.Module;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;

public class CategoryPanel {


    private Category category;
    private boolean hovered;
    //单独Category的位置
    private int x;
    private int y;
    //单独Category的长高
    private int width;
    private int height;

    public boolean dragging;//是否为移动状态
    //临时单独Category的位置（上一个位置）
    private int tempX;
    private int tempY;
    //是否显示ModulePanel
    private boolean displayModulePanel;
    //ModulePanel列表
    private ArrayList<ModulePanel> modulePanels;

    public CategoryPanel(Category category, int x, int y, int width, int height) {
        this.category = category;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        FontUtils.setupFontUtils();//设置Font
        modulePanels = new ArrayList<>();

        ArrayList<Module> modules = new ArrayList<>();
        modules.addAll(this.category.getModuleList());//获取该分类所以Module
        for (Module m : modules) {
            modulePanels.add(new ModulePanel(m));//添加ModulePanel
        }
    }


    public void drawScreen(int mouseX, int mouseY) {
        this.hovered = ClickGUI.isHovered(mouseX, mouseY, this.x, this.y, this.width, this.height);//获取鼠标是否在指定位置
        if (this.dragging) {
            //移动CategoryPanel
            this.x = this.tempX + mouseX;
            this.y = this.tempY + mouseY;
        }
        //改变Category颜色
        int color = new Color(0, 190, 255).getRGB();
        if (this.hovered) color = new Color(0, 88, 120).getRGB();
        ClickGUI.drawRect(x, y, this.width, this.height, color);//绘制Category背景
        FontUtils.drawCenteredString(this.category.name(), x + this.width / 2, y + this.height / 2, Color.WHITE.getRGB());//绘制Category的标题
        int modulePanelsY = this.y + this.height;
        //绘制该Category下的所有Module
        if(this.displayModulePanel) {
            for (ModulePanel module : modulePanels) {
                module.drawScreen(mouseX,mouseY,this.x + 10, modulePanelsY, 80, 20);
                modulePanelsY += 20;
            }
        }
    }

    public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
        //如果鼠标在指定位置
        //如果鼠标左键按下
        if (this.hovered && mouseButton == 0) {
            //移动状态为true
            dragging = true;
            //给临时坐标赋值
            this.tempX = this.x - mouseX;
            this.tempY = this.y - mouseY;
        } else if (this.hovered && mouseButton == 1) {//如果鼠标右键被按下
            this.displayModulePanel = !this.displayModulePanel;//是否显示Module
        }
        for (ModulePanel modulePanel : modulePanels) {//调用所有ModulePanel的mouseClicked方法
            modulePanel.mouseClicked(mouseX,mouseY,mouseButton);
        }
    }

    public void mouseReleased(int mouseX, int mouseY, int state) {
        //如果鼠标左键被释放退出移动Category模式
        if (state == 0) {
            this.dragging = false;
        }
    }


}
