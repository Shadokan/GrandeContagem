package com.grandemc.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static com.grandemc.GrandeContagem.*;

public class MainCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player)) { return false; }
        Player p = (Player) sender;


        if (cmd.getName().equalsIgnoreCase("Blocos")){
            if (args.length == 0){

                p.sendMessage("");
                p.sendMessage("§fBlocos quebrados: " + getPlayerManager().getPlayer(p.getName()).getQuantidade());
                p.sendMessage("");
                return true;
            }
        }

        return false;
    }
}
