package me.zeus.MoarLore;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    
    @SuppressWarnings("unused")
    private Main plugin;
    
    public Main(Main plugin){
        this.plugin = plugin;
    }
    
    public void onEnable(){
        
        getCommand("rename").setExecutor(new CommandListener());
        
    }
    
    
    
    
    
    
    
    
    
}
