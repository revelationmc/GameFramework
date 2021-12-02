package managers;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.plugin.Plugin;
import utils.Colours;

public abstract class GameManager {

    Colours colours = new Colours();

    public void start(int gameTime, Plugin plugin){
        Bukkit.getScheduler().runTaskLaterAsynchronously(plugin, () ->{

        }, gameTime);
    }

    public void end(String gameName, Sound sound, int time1, int time2, int time3){
        Bukkit.getOnlinePlayers().forEach(player -> {
            player.sendTitle(colours.colour(gameName), "", time1, time2, time3);
            player.playSound(player.getLocation(), sound, 10, 1);
        });
    }

}
