package client.monika.fuck;

public class Module {
    private boolean toggle;
    private String name;
    private int keyCode;
    private Category category;

    public Module(String name, int keyCode, Category category) {
        this.toggle = false;
        this.name = name;
        this.keyCode = keyCode;
        this.category = category;
    }

    public boolean isToggle() {
        return toggle;
    }

    public void setToggle(boolean toggle) {
        this.toggle = toggle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKeyCode() {
        return keyCode;
    }

    public void setKeyCode(int keyCode) {
        this.keyCode = keyCode;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void toggle()
    {
        this.toggle = !this.toggle;
        if(this.toggle) onEnable(); else onDisable();
    }

    public void onEnable() {
        Client.INSTANCE.EVENT_MANAGER.register(this);
    }

    public void onDisable() {
        Client.INSTANCE.EVENT_MANAGER.unregister(this);
    }
}
