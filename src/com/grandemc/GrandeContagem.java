package com.grandemc;

import com.grandemc.commands.MainCommand;
import com.grandemc.entity.PlayerManager;
import com.grandemc.listeners.PlayerEvents;
import com.grandemc.utils.MYSQL;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class GrandeContagem extends JavaPlugin {


    private static MYSQL mysql;
    private static PlayerManager playerManager;
    private static GrandeContagem instance;

    @Override
    public void onEnable() {

        instance = this;
        mysql = new MYSQL("root", "", "localhost", 3306, "dbestudo");
        playerManager = new PlayerManager();

        register();
    }


    public static PlayerManager getPlayerManager() {
        return playerManager;
    }

    public static GrandeContagem getInstance() {
        return instance;
    }


    public static MYSQL getMYSQL() {
        return mysql;
    }


    public void register(){
        getCommand("blocos").setExecutor(new MainCommand());
        Bukkit.getPluginManager().registerEvents(new PlayerEvents(), this);
    }

}
