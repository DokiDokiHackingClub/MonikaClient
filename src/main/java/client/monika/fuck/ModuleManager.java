package client.monika.fuck;

import client.monika.fuck.event.EventTarget;
import client.monika.fuck.event.events.EventKeyboard;
import client.monika.fuck.modules.Sprint;

import java.util.ArrayList;

public class ModuleManager {
    private ArrayList<Module> modules;

    public ModuleManager() {
        this.modules = new ArrayList();
        Client.INSTANCE.EVENT_MANAGER.register(this);
    }

    public void loadMods() {

    }


    private void addModule(Module m) {
        modules.add(m);
    }

    @EventTarget
    public void onKey(EventKeyboard eventKeyBoard) {
        for (Module mod : modules) {
            if (mod.getKeyCode() == eventKeyBoard.getKey())
                mod.toggle();
        }
    }

    public ArrayList<Module> getModules() {
        return modules;
    }
}
