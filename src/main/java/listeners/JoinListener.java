package listeners;


import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import utils.Colours;

public abstract class JoinListener implements Listener {

    Colours colours = new Colours();
    public int amount = 10;
    public int time = 300;
    public Plugin plugin = null;
    public String msg = "&eGame starting in... &e" + time--;


    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        if(amount()){
            this.count(time, plugin, msg);
        }
    }

    public boolean amount(){
        return Bukkit.getOnlinePlayers().size() == this.amount ? true : false;
    }

    public void count(int time, Plugin plugin, String msg){
        Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, () -> {
            Bukkit.getOnlinePlayers().forEach(player -> {
                colours.sendActionMessage(msg, player);
            });
        }, 0L, time);
    }


}
