package client.monika.fuck;


import java.util.ArrayList;

public enum Category {
    COMBAT,
    RENDER,
    MOVEMENT,
    PLAYER,
    OTHER;
    private final ArrayList<Module> moduleList=new ArrayList<>();
    public Category registry(Module e){
        moduleList.add(e);
        return this;
    }

    public ArrayList<Module> getModuleList() {
        return moduleList;
    }
}
