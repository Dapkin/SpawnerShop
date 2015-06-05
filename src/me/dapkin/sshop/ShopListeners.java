package me.dapkin.sshop;

import java.text.NumberFormat;
import java.util.Locale;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ShopListeners implements Listener {
  public final ShopPlugin ref;
  public ShopListeners(ShopPlugin inst) {
    ref = inst;
  }
  
  @EventHandler
  public void onInventoryClick(InventoryClickEvent event) {
    Player player = (Player)event.getWhoClicked();
    ItemStack clicked = event.getCurrentItem();
    Inventory inventory = event.getInventory();
    String error = ChatColor.RED + "Error:" + ChatColor.DARK_RED + " You do not have sufficient funds.";
    if (inventory.getName().equals(ref.spawnerInv.getName())) {
      event.setCancelled(true);
      if ((clicked == null) || (clicked.getType() == Material.AIR)) {
        return;
      }
      ChatColor white = ChatColor.WHITE;
      if (clicked.getItemMeta().getDisplayName().equalsIgnoreCase(white + "Enderman Spawner")) {
        if (ShopPlugin.economy.getBalance(player) >= ref.getConfig().getInt("prices.enderman")) {
          ShopPlugin.economy.withdrawPlayer(player, ref.getConfig().getInt("prices.enderman"));
          Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "give " + player.getName() + " 52 1 0 {BlockEntityTag:{EntityId:Enderman}}");
          player.sendMessage(ChatColor.GREEN + ref.config.getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(ref.getConfig().getInt("prices.enderman")) + " has been taken from your account.");
          player.closeInventory();
          ref.cooldown.put(player.getName(), System.currentTimeMillis());
        }
        else {
          player.closeInventory();
          player.sendMessage(error);
        }
      }else if (clicked.getItemMeta().getDisplayName().equalsIgnoreCase(white + "Blaze Spawner")) {
        if (ShopPlugin.economy.getBalance(player) >= ref.getConfig().getInt("prices.blaze")) {
          ShopPlugin.economy.withdrawPlayer(player, ref.getConfig().getInt("prices.blaze"));
          Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "give " + player.getName() + " 52 1 0 {BlockEntityTag:{EntityId:Blaze}}");
          player.sendMessage(ChatColor.GREEN + ref.config.getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(ref.getConfig().getInt("prices.blaze")) + " has been taken from your account.");
          player.closeInventory();
          ref.cooldown.put(player.getName(), System.currentTimeMillis());
        }else {
          player.sendMessage(error);
          player.closeInventory();
        }
      }else if (clicked.getItemMeta().getDisplayName().equalsIgnoreCase(white + "Skeleton Spawner")) {
        if (ShopPlugin.economy.getBalance(player) >= ref.getConfig().getInt("prices.skeleton")) {
          ShopPlugin.economy.withdrawPlayer(player, ref.getConfig().getInt("prices.skeleton"));
          Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "give " + player.getName() + " 52 1 0 {BlockEntityTag:{EntityId:Skeleton}}");
          player.sendMessage(ChatColor.GREEN + ref.config.getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(ref.getConfig().getInt("prices.skeleton")) + " has been taken from your account.");
          player.closeInventory();
          ref.cooldown.put(player.getName(), System.currentTimeMillis());
        }else {
          player.sendMessage(error);
          player.closeInventory();
        }
      }else if (clicked.getItemMeta().getDisplayName().equalsIgnoreCase(white + "Zombie Spawner")) {
        if (ShopPlugin.economy.getBalance(player) >= ref.getConfig().getInt("prices.zombie")) {
          ShopPlugin.economy.withdrawPlayer(player, ref.getConfig().getInt("prices.zombie"));
          Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "give " + player.getName() + " 52 1 0 {BlockEntityTag:{EntityId:Zombie}}");
          player.sendMessage(ChatColor.GREEN + ref.config.getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(ref.getConfig().getInt("prices.zombie")) + " has been taken from your account.");
          player.closeInventory();
          ref.cooldown.put(player.getName(), System.currentTimeMillis());
        }else {
          player.sendMessage(error);
          player.closeInventory();
        }
      }else if (clicked.getItemMeta().getDisplayName().equalsIgnoreCase(white + "Creeper Spawner")) {
        if (ShopPlugin.economy.getBalance(player) >= ref.getConfig().getInt("prices.creeper")) {
          ShopPlugin.economy.withdrawPlayer(player, ref.getConfig().getInt("prices.creeper"));
          Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "give " + player.getName() + " 52 1 0 {BlockEntityTag:{EntityId:Creeper}}");
          player.sendMessage(ChatColor.GREEN + ref.config.getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(ref.getConfig().getInt("prices.creeper")) + " has been taken from your account.");
          player.closeInventory();
          ref.cooldown.put(player.getName(), System.currentTimeMillis());
        }else {
          player.sendMessage(error);
          player.closeInventory();
        }
      }else if (clicked.getItemMeta().getDisplayName().equalsIgnoreCase(white + "Cave Spider Spawner")) {
        if (ShopPlugin.economy.getBalance(player) >= ref.getConfig().getInt("prices.cavespider")) {
          ShopPlugin.economy.withdrawPlayer(player, ref.getConfig().getInt("prices.cavespider"));
          Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "give " + player.getName() + " 52 1 0 {BlockEntityTag:{EntityId:CaveSpider}}");
          player.sendMessage(ChatColor.GREEN + ref.config.getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(ref.getConfig().getInt("prices.cavespider")) + " has been taken from your account.");
          player.closeInventory();
          ref.cooldown.put(player.getName(), System.currentTimeMillis());
        }else {
          player.sendMessage(error);
          player.closeInventory();
        }
      }else if (clicked.getItemMeta().getDisplayName().equalsIgnoreCase(white + "Spider Spawner")) {
        if (ShopPlugin.economy.getBalance(player) >= ref.getConfig().getInt("prices.spider")) {
          ShopPlugin.economy.withdrawPlayer(player, ref.getConfig().getInt("prices.spider"));
          Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "give " + player.getName() + " 52 1 0 {BlockEntityTag:{EntityId:Spider}}");
          player.sendMessage(ChatColor.GREEN + ref.config.getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(ref.getConfig().getInt("prices.spider")) + " has been taken from your account.");
          player.closeInventory();
          ref.cooldown.put(player.getName(), System.currentTimeMillis());
        }
        else{
          player.sendMessage(error);
          player.closeInventory();
        }
      }else if (clicked.getItemMeta().getDisplayName().contains("Wolf Spawner")) {
        if (ShopPlugin.economy.getBalance(player) >= ref.getConfig().getInt("prices.wolf")) {
          ShopPlugin.economy.withdrawPlayer(player, ref.getConfig().getInt("prices.wolf"));
          Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "give " + player.getName() + " 52 1 0 {BlockEntityTag:{EntityId:Wolf}}");
          player.sendMessage(ChatColor.GREEN + ref.config.getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(ref.getConfig().getInt("prices.wolf")) + " has been taken from your account.");
          player.closeInventory();
          ref.cooldown.put(player.getName(), System.currentTimeMillis());
        }else {
          player.sendMessage(error);
          player.closeInventory();
        }
      }else if (clicked.getItemMeta().getDisplayName().equalsIgnoreCase(white + "Chicken Spawner")) {
        if (ShopPlugin.economy.getBalance(player) >= ref.getConfig().getInt("prices.chicken")) {
          ShopPlugin.economy.withdrawPlayer(player, ref.getConfig().getInt("prices.chicken"));
          Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "give " + player.getName() + " 52 1 0 {BlockEntityTag:{EntityId:Chicken}}");
          player.sendMessage(ChatColor.GREEN + ref.config.getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(ref.getConfig().getInt("prices.chicken")) + " has been taken from your account.");
          player.closeInventory();
          ref.cooldown.put(player.getName(), System.currentTimeMillis());
        }else {
          player.sendMessage(error);
          player.closeInventory();
        }
      }else if (clicked.getItemMeta().getDisplayName().equalsIgnoreCase(white + "Cow Spawner")) {
        if (ShopPlugin.economy.getBalance(player) >= ref.getConfig().getInt("prices.cow")) {
          ShopPlugin.economy.withdrawPlayer(player, ref.getConfig().getInt("prices.cow"));
          Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "give " + player.getName() + " 52 1 0 {BlockEntityTag:{EntityId:Cow}}");
          player.sendMessage(ChatColor.GREEN + ref.config.getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(ref.getConfig().getInt("prices.cow")) + " has been taken from your account.");
          player.closeInventory();
          ref.cooldown.put(player.getName(), System.currentTimeMillis());
        }else {
          player.sendMessage(error);
          player.closeInventory();
        }
      }else if (clicked.getItemMeta().getDisplayName().equalsIgnoreCase(white + "Pig Spawner")) {
        if (ShopPlugin.economy.getBalance(player) >= ref.getConfig().getInt("prices.pig")) {
          ShopPlugin.economy.withdrawPlayer(player, ref.getConfig().getInt("prices.pig"));
          Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "give " + player.getName() + " 52 1 0 {BlockEntityTag:{EntityId:Pig}}");
          player.sendMessage(ChatColor.GREEN + ref.config.getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(ref.getConfig().getInt("prices.pig")) + " has been taken from your account.");
          player.closeInventory();
          ref.cooldown.put(player.getName(), System.currentTimeMillis());
        }else {
          player.sendMessage(error);
          player.closeInventory();
        }
      }else if (clicked.getItemMeta().getDisplayName().equalsIgnoreCase(white + "Ocelot Spawner")) {
        if (ShopPlugin.economy.getBalance(player) >= ref.getConfig().getInt("prices.ocelot")) {
          ShopPlugin.economy.withdrawPlayer(player, ref.getConfig().getInt("prices.ocelot"));
          Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "give " + player.getName() + " 52 1 0 {BlockEntityTag:{EntityId:Ozelot}}");
          player.sendMessage(ChatColor.GREEN + ref.config.getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(ref.getConfig().getInt("prices.ocelot")) + " has been taken from your account.");
          player.closeInventory();
          ref.cooldown.put(player.getName(), System.currentTimeMillis());
        }else {
          player.sendMessage(error);
          player.closeInventory();
        }
      }else if (clicked.getItemMeta().getDisplayName().equalsIgnoreCase(white + "Mushroom Cow Spawner")) {
        if (ShopPlugin.economy.getBalance(player) >= ref.getConfig().getInt("prices.mushroom")) {
          ShopPlugin.economy.withdrawPlayer(player, ref.getConfig().getInt("prices.mushroom"));
          Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "give " + player.getName() + " 52 1 0 {BlockEntityTag:{EntityId:MushroomCow}}");
          player.sendMessage(ChatColor.GREEN + ref.config.getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(ref.getConfig().getInt("prices.mushroom")) + " has been taken from your account.");
          player.closeInventory();
          ref.cooldown.put(player.getName(), System.currentTimeMillis());
        }else {
          player.sendMessage(error);
          player.closeInventory();
        }
      }else if (clicked.getItemMeta().getDisplayName().equalsIgnoreCase(white + "Sheep Spawner")) {
        if (ShopPlugin.economy.getBalance(player) >= ref.getConfig().getInt("prices.sheep")) {
          ShopPlugin.economy.withdrawPlayer(player, ref.getConfig().getInt("prices.sheep"));
          Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "give " + player.getName() + " 52 1 0 {BlockEntityTag:{EntityId:Sheep}}");
          player.sendMessage(ChatColor.GREEN + ref.config.getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(ref.getConfig().getInt("prices.sheep")) + " has been taken from your account.");
          player.closeInventory();
          ref.cooldown.put(player.getName(), System.currentTimeMillis());
        }else {
          player.sendMessage(error);
          player.closeInventory();
        }
      }else if (clicked.getItemMeta().getDisplayName().equalsIgnoreCase(white + "Bat Spawner")) {
        if (ShopPlugin.economy.getBalance(player) >= ref.getConfig().getInt("prices.bat")) {
          ShopPlugin.economy.withdrawPlayer(player, ref.getConfig().getInt("prices.bat"));
          Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "give " + player.getName() + " 52 1 0 {BlockEntityTag:{EntityId:Bat}}");
          player.sendMessage(ChatColor.GREEN + ref.config.getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(ref.getConfig().getInt("prices.bat")) + " has been taken from your account.");
          player.closeInventory();
          ref.cooldown.put(player.getName(), System.currentTimeMillis());
        }else {
          player.sendMessage(error);
          player.closeInventory();
        }
      }else if (clicked.getItemMeta().getDisplayName().equalsIgnoreCase(white + "Rabbit Spawner")) {
        if (ShopPlugin.economy.getBalance(player) >= ref.getConfig().getInt("prices.rabbit")) {
          ShopPlugin.economy.withdrawPlayer(player, ref.getConfig().getInt("prices.rabbit"));
          Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "give " + player.getName() + " 52 1 0 {BlockEntityTag:{EntityId:Rabbit}}");
          player.sendMessage(ChatColor.GREEN + ref.config.getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(ref.getConfig().getInt("prices.rabbit")) + " has been taken from your account.");
          player.closeInventory();
          ref.cooldown.put(player.getName(), System.currentTimeMillis());
        }
        else {
          player.sendMessage(error);
          player.closeInventory();
        }
      }else if (clicked.getItemMeta().getDisplayName().equalsIgnoreCase(white + "Squid Spawner")) {
        if (ShopPlugin.economy.getBalance(player) >= ref.getConfig().getInt("prices.squid")) {
          ShopPlugin.economy.withdrawPlayer(player, ref.getConfig().getInt("prices.squid"));
          Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "give " + player.getName() + " 52 1 0 {BlockEntityTag:{EntityId:Squid}}");
          player.sendMessage(ChatColor.GREEN + ref.config.getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(ref.getConfig().getInt("prices.squid")) + " has been taken from your account.");
          player.closeInventory();
          ref.cooldown.put(player.getName(), System.currentTimeMillis());
        }else {
          player.sendMessage(error);
          player.closeInventory();
        }
      }else if (clicked.getItemMeta().getDisplayName().equalsIgnoreCase(white + "Villager Spawner")) {
        if (ShopPlugin.economy.getBalance(player) >= ref.getConfig().getInt("prices.villager")) {
          ShopPlugin.economy.withdrawPlayer(player, ref.getConfig().getInt("prices.villager"));
          Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "give " + player.getName() + " 52 1 0 {BlockEntityTag:{EntityId:Villager}}");
          player.sendMessage(ChatColor.GREEN + ref.config.getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(ref.getConfig().getInt("prices.villager")) + " has been taken from your account.");
          player.closeInventory();
          ref.cooldown.put(player.getName(), System.currentTimeMillis());
        }else {
          player.sendMessage(error);
          player.closeInventory();
        }
      }else if (clicked.getItemMeta().getDisplayName().equalsIgnoreCase(white + "Zombie Pigman Spawner")) {
        if (ShopPlugin.economy.getBalance(player) >= ref.getConfig().getInt("prices.zombiepig")) {
          ShopPlugin.economy.withdrawPlayer(player, ref.getConfig().getInt("prices.zombiepig"));
          Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "give " + player.getName() + " 52 1 0 {BlockEntityTag:{EntityId:PigZombie}}");
          player.sendMessage(ChatColor.GREEN + ref.config.getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(ref.getConfig().getInt("prices.zombiepig")) + " has been taken from your account.");
          player.closeInventory();
          ref.cooldown.put(player.getName(), System.currentTimeMillis());
        }else {
          player.sendMessage(error);
          player.closeInventory();
        }
      }else if (clicked.getItemMeta().getDisplayName().equalsIgnoreCase(white + "Silverfish Spawner")) {
        if (ShopPlugin.economy.getBalance(player) >= ref.getConfig().getInt("prices.silverfish")) {
          ShopPlugin.economy.withdrawPlayer(player, ref.getConfig().getInt("prices.silverfish"));
          Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "give " + player.getName() + " 52 1 0 {BlockEntityTag:{EntityId:Silverfish}}");
          player.sendMessage(ChatColor.GREEN + ref.config.getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(ref.getConfig().getInt("prices.silverfish")) + " has been taken from your account.");
          player.closeInventory();
          ref.cooldown.put(player.getName(), System.currentTimeMillis());
        }else {
          player.sendMessage(error);
          player.closeInventory();
        }
      }else if (clicked.getItemMeta().getDisplayName().equalsIgnoreCase(white + "Iron Golem Spawner")) {
        if (ShopPlugin.economy.getBalance(player) >= ref.getConfig().getInt("prices.irongolem")) {
          ShopPlugin.economy.withdrawPlayer(player, ref.getConfig().getInt("prices.irongolem"));
          Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "give " + player.getName() + " 52 1 0 {BlockEntityTag:{EntityId:VillagerGolem}}");
          player.sendMessage(ChatColor.GREEN + ref.config.getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(ref.getConfig().getInt("prices.irongolem")) + " has been taken from your account.");
          player.closeInventory();
          ref.cooldown.put(player.getName(), System.currentTimeMillis());
        }else {
          player.sendMessage(error);
          player.closeInventory();
        }
      }else if (clicked.getItemMeta().getDisplayName().equalsIgnoreCase(white + "Slime Spawner")) {
          if (ShopPlugin.economy.getBalance(player) >= ref.getConfig().getInt("prices.slime")) {
              ShopPlugin.economy.withdrawPlayer(player, ref.getConfig().getInt("prices.slime"));
              Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "give " + player.getName() + " 52 1 0 {BlockEntityTag:{EntityId:Slime}}");
              player.sendMessage(ChatColor.GREEN + ref.config.getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(ref.getConfig().getInt("prices.slime")) + " has been taken from your account.");
              player.closeInventory();
              ref.cooldown.put(player.getName(), System.currentTimeMillis());
            }else {
              player.sendMessage(error);
              player.closeInventory();
            }
      }else if (clicked.getItemMeta().getDisplayName().equalsIgnoreCase(white + "Horse Spawner")) {
          if (ShopPlugin.economy.getBalance(player) >= ref.getConfig().getInt("prices.horse")) {
              ShopPlugin.economy.withdrawPlayer(player, ref.getConfig().getInt("prices.horse"));
              Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "give " + player.getName() + " 52 1 0 {BlockEntityTag:{EntityId:EntityHorse}}");
              player.sendMessage(ChatColor.GREEN + ref.config.getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(ref.getConfig().getInt("prices.horse")) + " has been taken from your account.");
              player.closeInventory();
              ref.cooldown.put(player.getName(), System.currentTimeMillis());
            }else {
              player.sendMessage(error);
              player.closeInventory();
            }
      }else if (clicked.getItemMeta().getDisplayName().equalsIgnoreCase(white + "Witch Spawner")) {
          if (ShopPlugin.economy.getBalance(player) >= ref.getConfig().getInt("prices.witch")) {
              ShopPlugin.economy.withdrawPlayer(player, ref.getConfig().getInt("prices.witch"));
              Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), "give " + player.getName() + " 52 1 0 {BlockEntityTag:{EntityId:Witch}}");
              player.sendMessage(ChatColor.GREEN + ref.config.getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(ref.getConfig().getInt("prices.witch")) + " has been taken from your account.");
              player.closeInventory();
              ref.cooldown.put(player.getName(), System.currentTimeMillis());
            }else {
              player.sendMessage(error);
              player.closeInventory();
            }
      }
    }
  }
}