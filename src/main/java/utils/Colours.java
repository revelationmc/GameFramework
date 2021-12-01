package utils;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;

public class Colours {

    public String colour(String s){
       return ChatColor.translateAlternateColorCodes('&', s);
    }

    public void sendMessage(String m, Player p){
        p.sendMessage(colour(m));
    }

    public void sendActionMessage(String m, Player p){
        p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(m));
    }


}
