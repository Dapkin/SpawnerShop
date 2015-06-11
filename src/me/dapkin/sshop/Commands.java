package me.dapkin.sshop;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.ChatColor;

public class Commands implements CommandExecutor {
	
	public ShopPlugin plugin;
	
	public Commands(ShopPlugin plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(args.length == 0) {
				if(p.hasPermission("spawnershop.use")) {
					if(plugin.cooldown.containsKey(p.getName())) {
						int cooldown_time = plugin.config.getInt("options.cooldown");
						long diff = (System.currentTimeMillis() - ((Long)plugin.cooldown.get(p.getName())).longValue()) / 1000L;
						if(diff < cooldown_time) {
							p.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.config.getString("options.prefix")) + " " + ChatColor.translateAlternateColorCodes('&', plugin.config.getString("options.cooldownmessage")));
						}else {
							p.openInventory(plugin.spawnerInv);
							p.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.config.getString("options.prefix")) + " " + ChatColor.translateAlternateColorCodes('&', plugin.config.getString("options.openmessage")));
							plugin.cooldown.remove(p.getName());
						}
					}else {
						p.openInventory(plugin.spawnerInv);
			            p.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.config.getString("options.prefix")) + " " + ChatColor.translateAlternateColorCodes('&', plugin.config.getString("options.openmessage")));
					}
				}else {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.config.getString("options.prefix")) + " " + ChatColor.translateAlternateColorCodes('&', plugin.config.getString("options.nopermission")));
				}
			}else if(args.length == 1 && args[0].equalsIgnoreCase("reload")) {
				if(p.hasPermission("spawnershop.reload") || p.isOp()) {
					plugin.spawnerInv.clear();
					plugin.setupInv();
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.config.getString("options.prefix")) + " " + ChatColor.translateAlternateColorCodes('&', plugin.config.getString("options.reloadsuccess")));
				}else {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.config.getString("options.prefix")) + " " + ChatColor.translateAlternateColorCodes('&', plugin.config.getString("options.nopermission")));
				}
			}
		}
		return true;
	}
}
