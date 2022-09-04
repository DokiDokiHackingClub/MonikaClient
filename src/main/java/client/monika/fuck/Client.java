package client.monika.fuck;

import client.monika.fuck.event.EventManager;
import cn.enaium.cf4m.CF4M;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.async.AsyncLogger;

public enum Client {
    INSTANCE;
    public static final String NAME="MonikaClient";
    public static final Logger LOGGER=new AsyncLogger(new LoggerContext(NAME),NAME,null);
    public static final EventManager EVENT_MANAGER = new EventManager();
    public static final ModuleManager MODULE_MANAGER = new ModuleManager();
    public static final SettingManager SETTING_MANAGER = new SettingManager();

    public void run(){
        CF4M.run(this);
        LOGGER.debug(Category.PLAYER.getModuleList());
        MODULE_MANAGER.loadMods();

    }
}
