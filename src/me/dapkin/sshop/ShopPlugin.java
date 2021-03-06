package me.dapkin.sshop;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.logging.Level;

import net.milkbowl.vault.economy.Economy;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class ShopPlugin extends JavaPlugin {
  ShopPlugin plugin;
  HashMap<String, Long> cooldown = new HashMap<String, Long>();
  
  public void onEnable() {
    Bukkit.getServer().getPluginManager().registerEvents(new ShopSigns(this), this);
    Bukkit.getServer().getPluginManager().registerEvents(new ShopListeners(this), this);
    initialiseConfig();
    this.getCommand("spawners").setExecutor(new Commands(this));
    setupEconomy();
    setupInv();
    try {
      Metrics metrics = new Metrics(this);
      metrics.start();
    }
    catch (IOException e) {
      Bukkit.getLogger().log(Level.WARNING, "Failed to log stats to Metrics!");
    }
  }
  
  public void initialiseConfig() {
    FileConfiguration config = getConfig();
    config.options().copyDefaults(true);
    saveConfig();
  }
  
  public static Economy economy = null;
  
  public void onDisable() {
	  plugin = null;
  }
  FileConfiguration config = getConfig();
  
  private boolean setupEconomy() {
    RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(Economy.class);
    if (economyProvider != null) {
      economy = (Economy)economyProvider.getProvider();
    }
    return economy != null;
  }
  
  public Inventory spawnerInv = Bukkit.createInventory(null, getConfig().getInt("options.inventorysize"), getConfig().getString("options.shopname"));
  
  public void setupInv() {
    if (getConfig().getBoolean("options.heads")) {
      if (config.getBoolean("spawners.enderman")) {
        ItemStack endermanskull = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
        SkullMeta iendermanskull = (SkullMeta)endermanskull.getItemMeta();
        iendermanskull.setOwner("MHF_Enderman");
        iendermanskull.setDisplayName(ChatColor.WHITE + "Enderman Spawner");
        iendermanskull.setLore(Arrays.asList(new String[] { ChatColor.GREEN + "Price: " + config.getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(getConfig().getInt("prices.enderman")) }));
        endermanskull.setItemMeta(iendermanskull);
        spawnerInv.addItem(endermanskull);
      }
      if (config.getBoolean("spawners.blaze")) {
        ItemStack blazeskull = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
        SkullMeta iblazeskull = (SkullMeta)blazeskull.getItemMeta();
        iblazeskull.setOwner("MHF_Blaze");
        iblazeskull.setDisplayName(ChatColor.WHITE + "Blaze Spawner");
        iblazeskull.setLore(Arrays.asList(new String[] { ChatColor.GREEN + "Price: " + config.getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(getConfig().getInt("prices.blaze")) }));
        blazeskull.setItemMeta(iblazeskull);
        spawnerInv.addItem(blazeskull);
      }
      if (config.getBoolean("spawners.skeleton")) {
        ItemStack skeletonskull = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
        SkullMeta iskeletonskull = (SkullMeta)skeletonskull.getItemMeta();
        iskeletonskull.setOwner("MHF_Skeleton");
        iskeletonskull.setDisplayName(ChatColor.WHITE + "Skeleton Spawner");
        iskeletonskull.setLore(Arrays.asList(new String[] { ChatColor.GREEN + "Price: " + config.getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(getConfig().getInt("prices.skeleton")) }));
        skeletonskull.setItemMeta(iskeletonskull);
        spawnerInv.addItem( skeletonskull);
      }
      if (config.getBoolean("spawners.zombie")){
        ItemStack zombieskull = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
        SkullMeta izombieskull = (SkullMeta)zombieskull.getItemMeta();
        izombieskull.setOwner("MHF_Zombie");
        izombieskull.setDisplayName(ChatColor.WHITE + "Zombie Spawner");
        izombieskull.setLore(Arrays.asList(new String[] { ChatColor.GREEN + "Price: " + config.getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(getConfig().getInt("prices.zombie")) }));
        zombieskull.setItemMeta(izombieskull);
        spawnerInv.addItem(zombieskull);
      }
      if (config.getBoolean("spawners.creeper")) {
        ItemStack creeperskull = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
        SkullMeta icreeperskull = (SkullMeta)creeperskull.getItemMeta();
        icreeperskull.setOwner("MHF_Creeper");
        icreeperskull.setDisplayName(ChatColor.WHITE + "Creeper Spawner");
        icreeperskull.setLore(Arrays.asList(new String[] { ChatColor.GREEN + "Price: " + config.getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(getConfig().getInt("prices.creeper")) }));
        creeperskull.setItemMeta(icreeperskull);
        spawnerInv.addItem(creeperskull);
      }
      if (config.getBoolean("spawners.cavespider")) {
        ItemStack cspiderskull = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
        SkullMeta icspiderskull = (SkullMeta)cspiderskull.getItemMeta();
        icspiderskull.setOwner("MHF_CaveSpider");
        icspiderskull.setDisplayName(ChatColor.WHITE + "Cave Spider Spawner");
        icspiderskull.setLore(Arrays.asList(new String[] { ChatColor.GREEN + "Price: " + config.getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(getConfig().getInt("prices.cavespider")) }));
        cspiderskull.setItemMeta(icspiderskull);
        spawnerInv.addItem(cspiderskull);
      }
      if (config.getBoolean("spawners.spider")) {
        ItemStack spiderskull = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
        SkullMeta ispiderskull = (SkullMeta)spiderskull.getItemMeta();
        ispiderskull.setOwner("MHF_Spider");
        ispiderskull.setDisplayName(ChatColor.WHITE + "Spider Spawner");
        ispiderskull.setLore(Arrays.asList(new String[] { ChatColor.GREEN + "Price: " + config.getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(getConfig().getInt("prices.spider")) }));
        spiderskull.setItemMeta(ispiderskull);
        spawnerInv.addItem(spiderskull);
      }
      if (config.getBoolean("spawners.wolf")) {
        ItemStack wolfskull = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
        SkullMeta iwolfskull = (SkullMeta)wolfskull.getItemMeta();
        iwolfskull.setOwner("MHF_Wolf");
        iwolfskull.setDisplayName(ChatColor.WHITE + "Wolf Spawner");
        iwolfskull.setLore(Arrays.asList(new String[] { ChatColor.GREEN + "Price: " + config.getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(getConfig().getInt("prices.wolf")) }));
        wolfskull.setItemMeta(iwolfskull);
        spawnerInv.addItem(wolfskull);
      }
      if (config.getBoolean("spawners.chicken")) {
        ItemStack chickenskull = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
        SkullMeta ichickenskull = (SkullMeta)chickenskull.getItemMeta();
        ichickenskull.setOwner("MHF_Chicken");
        ichickenskull.setDisplayName(ChatColor.WHITE + "Chicken Spawner");
        ichickenskull.setLore(Arrays.asList(new String[] { ChatColor.GREEN + "Price: " + config.getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(getConfig().getInt("prices.chicken")) }));
        chickenskull.setItemMeta(ichickenskull);
        spawnerInv.addItem(chickenskull);
      }
      if (config.getBoolean("spawners.cow")) {
        ItemStack cowskull = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
        SkullMeta icowskull = (SkullMeta)cowskull.getItemMeta();
        icowskull.setOwner("MHF_Cow");
        icowskull.setDisplayName(ChatColor.WHITE + "Cow Spawner");
        icowskull.setLore(Arrays.asList(new String[] { ChatColor.GREEN + "Price: " + config.getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(getConfig().getInt("prices.cow")) }));
        cowskull.setItemMeta(icowskull);
        spawnerInv.addItem(cowskull);
      }
      if (config.getBoolean("spawners.pig")) {
        ItemStack pigskull = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
        SkullMeta ipigskull = (SkullMeta)pigskull.getItemMeta();
        ipigskull.setOwner("MHF_Pig");
        ipigskull.setDisplayName(ChatColor.WHITE + "Pig Spawner");
        ipigskull.setLore(Arrays.asList(new String[] { ChatColor.GREEN + "Price: " + config.getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(getConfig().getInt("prices.pig")) }));
        pigskull.setItemMeta(ipigskull);
        spawnerInv.addItem(pigskull);
      }
      if (config.getBoolean("spawners.ocelot")) {
        ItemStack ocelotskull = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
        SkullMeta iocelotskull = (SkullMeta)ocelotskull.getItemMeta();
        iocelotskull.setOwner("MHF_Ocelot");
        iocelotskull.setDisplayName(ChatColor.WHITE + "Ocelot Spawner");
        iocelotskull.setLore(Arrays.asList(new String[] { ChatColor.GREEN + "Price: " + config.getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(getConfig().getInt("prices.ocelot")) }));
        ocelotskull.setItemMeta(iocelotskull);
        spawnerInv.addItem(ocelotskull);
      }
      if (config.getBoolean("spawners.mushroom")) {
        ItemStack mushroomskull = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
        SkullMeta imushroomskull = (SkullMeta)mushroomskull.getItemMeta();
        imushroomskull.setOwner("MHF_MushroomCow");
        imushroomskull.setDisplayName(ChatColor.WHITE + "Mushroom Cow Spawner");
        imushroomskull.setLore(Arrays.asList(new String[] { ChatColor.GREEN + "Price: " + config.getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(getConfig().getInt("prices.mushroom")) }));
        mushroomskull.setItemMeta(imushroomskull);
        spawnerInv.addItem(mushroomskull);
      }
      if (config.getBoolean("spawners.sheep")) {
        ItemStack sheepskull = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
        SkullMeta isheepskull = (SkullMeta)sheepskull.getItemMeta();
        isheepskull.setOwner("MHF_Sheep");
        isheepskull.setDisplayName(ChatColor.WHITE + "Sheep Spawner");
        isheepskull.setLore(Arrays.asList(new String[] { ChatColor.GREEN + "Price: " + config.getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(getConfig().getInt("prices.sheep")) }));
        sheepskull.setItemMeta(isheepskull);
        spawnerInv.addItem(sheepskull);
      }
      if (config.getBoolean("spawners.bat")) {
        ItemStack batskull = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
        SkullMeta ibatskull = (SkullMeta)batskull.getItemMeta();
        ibatskull.setOwner("ManBatPlaysMC");
        ibatskull.setDisplayName(ChatColor.WHITE + "Bat Spawner");
        ibatskull.setLore(Arrays.asList(new String[] { ChatColor.GREEN + "Price: " + config.getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(getConfig().getInt("prices.bat")) }));
        batskull.setItemMeta(ibatskull);
        spawnerInv.addItem(batskull);
      }
      if (config.getBoolean("spawners.rabbit")) {
        ItemStack rabbitskull = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
        SkullMeta irabbitskull = (SkullMeta)rabbitskull.getItemMeta();
        irabbitskull.setOwner("Natalieisawesome");
        irabbitskull.setDisplayName(ChatColor.WHITE + "Rabbit Spawner");
        irabbitskull.setLore(Arrays.asList(new String[] { ChatColor.GREEN + "Price: " + config.getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(getConfig().getInt("prices.rabbit")) }));
        rabbitskull.setItemMeta(irabbitskull);
        spawnerInv.addItem(rabbitskull);
      }
      if (config.getBoolean("spawners.squid")) {
        ItemStack squidskull = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
        SkullMeta isquidskull = (SkullMeta)squidskull.getItemMeta();
        isquidskull.setOwner("MHF_Squid");
        isquidskull.setDisplayName(ChatColor.WHITE + "Squid Spawner");
        isquidskull.setLore(Arrays.asList(new String[] { ChatColor.GREEN + "Price: " + config.getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(getConfig().getInt("prices.squid")) }));
        squidskull.setItemMeta(isquidskull);
        spawnerInv.addItem(squidskull);
      }
      if (config.getBoolean("spawners.villager")) {
        ItemStack villagerskull = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
        SkullMeta ivillagerskull = (SkullMeta)villagerskull.getItemMeta();
        ivillagerskull.setOwner("MHF_Villager");
        ivillagerskull.setDisplayName(ChatColor.WHITE + "Villager Spawner");
        ivillagerskull.setLore(Arrays.asList(new String[] { ChatColor.GREEN + "Price: " + config.getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(getConfig().getInt("prices.villager")) }));
        villagerskull.setItemMeta(ivillagerskull);
        spawnerInv.addItem(villagerskull);
      }
      if (config.getBoolean("spawners.zombiepigman")) {
        ItemStack zpigskull = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
        SkullMeta izpigskull = (SkullMeta)zpigskull.getItemMeta();
        izpigskull.setOwner("MHF_PigZombie");
        izpigskull.setDisplayName(ChatColor.WHITE + "Zombie Pigman Spawner");
        izpigskull.setLore(Arrays.asList(new String[] { ChatColor.GREEN + "Price: " + config.getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(getConfig().getInt("prices.zombiepig")) }));
        zpigskull.setItemMeta(izpigskull);
        spawnerInv.addItem(zpigskull);
      }
      if (config.getBoolean("spawners.silverfish")) {
        ItemStack silverskull = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
        SkullMeta isilverskull = (SkullMeta)silverskull.getItemMeta();
        isilverskull.setOwner("AlexVMiner");
        isilverskull.setDisplayName(ChatColor.WHITE + "Silverfish Spawner");
        isilverskull.setLore(Arrays.asList(new String[] { ChatColor.GREEN + "Price: " + config.getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(getConfig().getInt("prices.silverfish")) }));
        silverskull.setItemMeta(isilverskull);
        spawnerInv.addItem(silverskull);
      }
      if (config.getBoolean("spawners.irongolem")) {
        ItemStack golemskull = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
        SkullMeta igolemskull = (SkullMeta)golemskull.getItemMeta();
        igolemskull.setOwner("MHF_Golem");
        igolemskull.setDisplayName(ChatColor.WHITE + "Iron Golem Spawner");
        igolemskull.setLore(Arrays.asList(ChatColor.GREEN + "Price: " + config.getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(getConfig().getInt("prices.irongolem"))));
        golemskull.setItemMeta(igolemskull);
        spawnerInv.addItem(golemskull);
      }
      if(config.getBoolean("spawners.slime")) {
    	  ItemStack slimeskull = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
    	  SkullMeta islimeskull = (SkullMeta) slimeskull.getItemMeta();
    	  islimeskull.setOwner("MHF_Slime");
    	  islimeskull.setDisplayName(ChatColor.WHITE + "Slime Spawner");
    	  islimeskull.setLore(Arrays.asList(ChatColor.GREEN + "Price: " + config.getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(getConfig().getInt("prices.slime"))));
    	  slimeskull.setItemMeta(islimeskull);
    	  spawnerInv.addItem(slimeskull);
      }
      if(config.getBoolean("spawners.horse")) {
    	  ItemStack horseskull = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
    	  SkullMeta ihorseskull = (SkullMeta) horseskull.getItemMeta();
    	  ihorseskull.setOwner("gavertoso");
    	  ihorseskull.setDisplayName(ChatColor.WHITE + "Horse Spawner");
    	  ihorseskull.setLore(Arrays.asList(ChatColor.GREEN + "Price: " + config.getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(getConfig().getInt("prices.horse"))));
    	  horseskull.setItemMeta(ihorseskull);
    	  spawnerInv.addItem(horseskull);
      }
      if(config.getBoolean("spawners.witch")) {
    	  ItemStack witchskull = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
    	  SkullMeta iwitchskull = (SkullMeta) witchskull.getItemMeta();
    	  iwitchskull.setOwner("scrafbrothers4");
    	  iwitchskull.setDisplayName(ChatColor.WHITE + "Witch Spawner");
    	  iwitchskull.setLore(Arrays.asList(ChatColor.GREEN + "Price: " + config.getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(getConfig().getInt("prices.witch"))));
    	  witchskull.setItemMeta(iwitchskull);
    	  spawnerInv.addItem(witchskull);
      }
    }else{
      ItemStack mushroom = new ItemStack(Material.MONSTER_EGG, 1, (short)96);
      ItemStack sheep = new ItemStack(Material.MONSTER_EGG, 1, (short)91);
      ItemStack ocelot = new ItemStack(Material.MONSTER_EGG, 1, (short)98);
      ItemStack pig = new ItemStack(Material.MONSTER_EGG, 1, (short)90);
      ItemStack cow = new ItemStack(Material.MONSTER_EGG, 1, (short)92);
      ItemStack chicken = new ItemStack(Material.MONSTER_EGG, 1, (short)93);
      ItemStack wolf = new ItemStack(Material.MONSTER_EGG, 1, (short)95);
      ItemStack spider = new ItemStack(Material.MONSTER_EGG, 1, (short)52);
      ItemStack cspider = new ItemStack(Material.MONSTER_EGG, 1, (short)59);
      ItemStack creeper = new ItemStack(Material.MONSTER_EGG, 1, (short)50);
      ItemStack zombie = new ItemStack(Material.MONSTER_EGG, 1, (short)54);
      ItemStack skeleton = new ItemStack(Material.MONSTER_EGG, 1, (short)51);
      ItemStack blaze = new ItemStack(Material.MONSTER_EGG, 1, (short)61);
      ItemStack enderman = new ItemStack(Material.MONSTER_EGG, 1, (short)58);
      ItemStack bat = new ItemStack(Material.MONSTER_EGG, 1, (short)65);
      ItemStack rabbit = new ItemStack(Material.MONSTER_EGG, 1, (short)101);
      ItemStack squid = new ItemStack(Material.MONSTER_EGG, 1, (short)94);
      ItemStack villager = new ItemStack(Material.MONSTER_EGG, 1, (short)120);
      ItemStack zpig = new ItemStack(Material.MONSTER_EGG, 1, (short)57);
      ItemStack sfish = new ItemStack(Material.MONSTER_EGG, 1, (short)60);
      ItemStack igolem = new ItemStack(Material.MONSTER_EGG, 1, (short)99);
      ItemStack slime = new ItemStack(Material.MONSTER_EGG, 1, (short)55);
      ItemStack horse = new ItemStack(Material.MONSTER_EGG, 1, (short)100);
      ItemStack witch = new ItemStack(Material.MONSTER_EGG, 1, (short)66);
      
      if (config.getBoolean("spawners.enderman")) {
        ItemMeta ienderman = enderman.getItemMeta();
        ienderman.setDisplayName(ChatColor.WHITE + "Enderman Spawner");
        ienderman.setLore(Arrays.asList(new String[] { ChatColor.GREEN + "Price: " + config.getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(getConfig().getInt("prices.enderman")) }));
        enderman.setItemMeta(ienderman);
        spawnerInv.addItem(enderman);
      }
      if (config.getBoolean("spawners.blaze")) {
        ItemMeta iblaze = blaze.getItemMeta();
        iblaze.setDisplayName(ChatColor.WHITE + "Blaze Spawner");
        iblaze.setLore(Arrays.asList(new String[] { ChatColor.GREEN + "Price: " + config.getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(getConfig().getInt("prices.blaze")) }));
        blaze.setItemMeta(iblaze);
        spawnerInv.addItem(blaze);
      }
      if (config.getBoolean("spawners.skeleton")) {
        ItemMeta iskeleton = skeleton.getItemMeta();
        iskeleton.setDisplayName(ChatColor.WHITE + "Skeleton Spawner");
        iskeleton.setLore(Arrays.asList(new String[] { ChatColor.GREEN + "Price: " + config.getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(getConfig().getInt("prices.skeleton")) }));
        skeleton.setItemMeta(iskeleton);
        spawnerInv.addItem(skeleton);
      }
      if (config.getBoolean("spawners.zombie")) {
        ItemMeta izombie = zombie.getItemMeta();
        izombie.setDisplayName(ChatColor.WHITE + "Zombie Spawner");
        izombie.setLore(Arrays.asList(new String[] { ChatColor.GREEN + "Price: " + config.getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(getConfig().getInt("prices.zombie")) }));
        zombie.setItemMeta(izombie);
        spawnerInv.addItem(zombie);
      }
      if (config.getBoolean("spawners.creeper")) {
        ItemMeta icreeper = creeper.getItemMeta();
        icreeper.setDisplayName(ChatColor.WHITE + "Creeper Spawner");
        icreeper.setLore(Arrays.asList(new String[] { ChatColor.GREEN + "Price: " + config.getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(getConfig().getInt("prices.creeper")) }));
        creeper.setItemMeta(icreeper);
        spawnerInv.addItem(creeper);
      }
      if (config.getBoolean("spawners.cavespider")) {
        ItemMeta icspider = cspider.getItemMeta();
        icspider.setDisplayName(ChatColor.WHITE + "Cave Spider Spawner");
        icspider.setLore(Arrays.asList(new String[] { ChatColor.GREEN + "Price: " + config.getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(getConfig().getInt("prices.cavespider")) }));
        cspider.setItemMeta(icspider);
        spawnerInv.addItem(cspider);
      }
      if (config.getBoolean("spawners.spider")) {
        ItemMeta ispider = spider.getItemMeta();
        ispider.setDisplayName(ChatColor.WHITE + "Spider Spawner");
        ispider.setLore(Arrays.asList(new String[] { ChatColor.GREEN + "Price: " + config.getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(getConfig().getInt("prices.spider")) }));
        spider.setItemMeta(ispider);
        spawnerInv.addItem(spider);
      }
      if (config.getBoolean("spawners.wolf")) {
        ItemMeta iwolf = wolf.getItemMeta();
        iwolf.setDisplayName(ChatColor.WHITE + "Wolf Spawner");
        iwolf.setLore(Arrays.asList(new String[] { ChatColor.GREEN + "Price: " + config.getString("options.currencysing") + NumberFormat.getNumberInstance(Locale.US).format(getConfig().getInt("prices.wolf")) }));
        wolf.setItemMeta(iwolf);
        spawnerInv.addItem(wolf);
      }
      if (config.getBoolean("spawners.chicken")) {
        ItemMeta ichicken = chicken.getItemMeta();
        ichicken.setDisplayName(ChatColor.WHITE + "Chicken Spawner");
        ichicken.setLore(Arrays.asList(new String[] { ChatColor.GREEN + "Price: " + config.getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(getConfig().getInt("prices.chicken")) }));
        chicken.setItemMeta(ichicken);
        spawnerInv.addItem(chicken);
      }
      if (config.getBoolean("spawners.cow")) {
        ItemMeta icow = cow.getItemMeta();
        icow.setDisplayName(ChatColor.WHITE + "Cow Spawner");
        icow.setLore(Arrays.asList(new String[] { ChatColor.GREEN + "Price: " + config.getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(getConfig().getInt("prices.cow")) }));
        cow.setItemMeta(icow);
        spawnerInv.addItem(cow);
      }
      if (config.getBoolean("spawners.pig")) {
        ItemMeta ipig = pig.getItemMeta();
        ipig.setDisplayName(ChatColor.WHITE + "Pig Spawner");
        ipig.setLore(Arrays.asList(new String[] { ChatColor.GREEN + "Price: " + config.getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(getConfig().getInt("prices.pig")) }));
        pig.setItemMeta(ipig);
        spawnerInv.addItem(pig);
      }
      if (config.getBoolean("spawners.ocelot")) {
        ItemMeta iocelot = ocelot.getItemMeta();
        iocelot.setDisplayName(ChatColor.WHITE + "Ocelot Spawner");
        iocelot.setLore(Arrays.asList(new String[] { ChatColor.GREEN + "Price: " + config.getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(getConfig().getInt("prices.ocelot")) }));
        ocelot.setItemMeta(iocelot);
        spawnerInv.addItem(ocelot);
      }
      if (config.getBoolean("spawners.mushroom")) {
        ItemMeta imushroom = mushroom.getItemMeta();
        imushroom.setDisplayName(ChatColor.WHITE + "Mushroom Spawner");
        imushroom.setLore(Arrays.asList(new String[] { ChatColor.GREEN + "Price: " + config.getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(getConfig().getInt("prices.mushroom")) }));
        mushroom.setItemMeta(imushroom);
        spawnerInv.addItem(mushroom);
      }
      if (config.getBoolean("spawners.sheep")) {
        ItemMeta isheep = sheep.getItemMeta();
        isheep.setDisplayName(ChatColor.WHITE + "Sheep Spawner");
        isheep.setLore(Arrays.asList(new String[] { ChatColor.GREEN + "Price: " + config.getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(getConfig().getInt("prices.sheep")) }));
        sheep.setItemMeta(isheep);
        spawnerInv.addItem(sheep);
      }
      if (config.getBoolean("spawners.bat")) {
        ItemMeta ibat = bat.getItemMeta();
        ibat.setDisplayName(ChatColor.WHITE + "Bat Spawner");
        ibat.setLore(Arrays.asList(new String[] { ChatColor.GREEN + "Price: " + config.getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(getConfig().getInt("prices.bat")) }));
        bat.setItemMeta(ibat);
        spawnerInv.addItem(bat);
      }
      if (config.getBoolean("spawners.rabbit")) {
        ItemMeta irabbit = rabbit.getItemMeta();
        irabbit.setDisplayName(ChatColor.WHITE + "Rabbit Spawner");
        irabbit.setLore(Arrays.asList(new String[] { ChatColor.GREEN + "Price: " + config.getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(getConfig().getInt("prices.rabbit")) }));
        rabbit.setItemMeta(irabbit);
        spawnerInv.addItem(rabbit);
      }
      if (config.getBoolean("spawners.squid")) {
        ItemMeta isquid = squid.getItemMeta();
        isquid.setDisplayName(ChatColor.WHITE + "Squid Spawner");
        isquid.setLore(Arrays.asList(new String[] { ChatColor.GREEN + "Price: " + config.getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(getConfig().getInt("prices.squid")) }));
        squid.setItemMeta(isquid);
        spawnerInv.addItem(squid);
      }
      if (config.getBoolean("spawners.villager")) {
        ItemMeta ivillager = villager.getItemMeta();
        ivillager.setDisplayName(ChatColor.WHITE + "Villager Spawner");
        ivillager.setLore(Arrays.asList(new String[] { ChatColor.GREEN + "Price: " + config.getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(getConfig().getInt("prices.villager")) }));
        villager.setItemMeta(ivillager);
        spawnerInv.addItem(villager);
      }
      if (config.getBoolean("spawners.zombiepigman")) {
        ItemMeta izpig = zpig.getItemMeta();
        izpig.setDisplayName(ChatColor.WHITE + "Zombie Pigman Spawner");
        izpig.setLore(Arrays.asList(new String[] { ChatColor.GREEN + "Price: " + config.getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(getConfig().getInt("prices.zombiepig")) }));
        zpig.setItemMeta(izpig);
        spawnerInv.addItem(zpig);
      }
      if (config.getBoolean("spawners.silverfish")) {
        ItemMeta isfish = sfish.getItemMeta();
        isfish.setDisplayName(ChatColor.WHITE + "Silverfish Spawner");
        isfish.setLore(Arrays.asList(new String[] { ChatColor.GREEN + "Price: " + config.getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(getConfig().getInt("prices.silverfish")) }));
        sfish.setItemMeta(isfish);
        spawnerInv.addItem(sfish);
      }
      if (config.getBoolean("spawners.irongolem")){
        ItemMeta iigolem = igolem.getItemMeta();
        iigolem.setDisplayName(ChatColor.WHITE + "Iron Golem Spawner");
        iigolem.setLore(Arrays.asList(new String[] { ChatColor.GREEN + "Price: " + config.getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(getConfig().getInt("prices.irongolem")) }));
        igolem.setItemMeta(iigolem);
        spawnerInv.addItem(igolem);
      }
      if (config.getBoolean("spawners.slime")) {
    	ItemMeta islime = slime.getItemMeta();
    	islime.setDisplayName(ChatColor.WHITE + "Slime Spawner");
    	islime.setLore(Arrays.asList(new String[] { ChatColor.GREEN + "Price: " + config.getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(getConfig().getInt("prices.slime")) }));
        slime.setItemMeta(islime);
        spawnerInv.addItem(slime);
      }
      if (config.getBoolean("spawners.horse")) {
    	ItemMeta ihorse = horse.getItemMeta();
    	ihorse.setDisplayName(ChatColor.WHITE + "Horse Spawner");
    	ihorse.setLore(Arrays.asList(new String[] { ChatColor.GREEN + "Price: " + config.getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(getConfig().getInt("prices.horse")) }));
        horse.setItemMeta(ihorse);
        spawnerInv.addItem(horse);
      }
      if (config.getBoolean("spawners.witch")) {
    	ItemMeta iwitch = witch.getItemMeta();
    	iwitch.setDisplayName(ChatColor.WHITE + "Witch Spawner");
    	iwitch.setLore(Arrays.asList(new String[] { ChatColor.GREEN + "Price: " + config.getString("options.currencysign") + NumberFormat.getNumberInstance(Locale.US).format(getConfig().getInt("prices.witch")) }));
        witch.setItemMeta(iwitch);
        spawnerInv.addItem(witch);
      }
    }
  }
}