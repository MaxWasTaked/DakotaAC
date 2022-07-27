package mccore.mccore;

import mccore.mccore.checks.AntiBot.AntiBot_A;
import mccore.mccore.checks.AutoClicker.AutoClicker_A;
import mccore.mccore.checks.Blink.Blink_A;
import mccore.mccore.checks.Crasher.Crasher_A;
import mccore.mccore.checks.Critical.Critical_A;
import mccore.mccore.checks.Critical.Critical_B;
import mccore.mccore.checks.Derp.Derp_A;
import mccore.mccore.checks.ESP.ESP_A;
import mccore.mccore.checks.FastBow.FastBow_A;
import mccore.mccore.checks.FastBreak.FastBreak_A;
import mccore.mccore.checks.FastClimb.FastClimb_A;
import mccore.mccore.checks.FastEat.FastEat_A;
import mccore.mccore.checks.FastPlace.FastPlace_A;
import mccore.mccore.checks.Flight.Flight_A;
import mccore.mccore.checks.Flight.Flight_B;
import mccore.mccore.checks.Freecam.Freecam_A;
import mccore.mccore.checks.InventoryCleaner.InventoryCleaner_A;
import mccore.mccore.checks.InventoryMovement.InventoryMovement_A;
import mccore.mccore.checks.Jesus.Jesus_A;
import mccore.mccore.checks.KillAura.KillAura_A;
import mccore.mccore.checks.KillAura.KillAura_B;
import mccore.mccore.checks.KillAura.KillAura_C;
import mccore.mccore.checks.Knockback.Knockback_A;
import mccore.mccore.checks.NoFall.NoFall_A;
import mccore.mccore.checks.NoRotateSet.NoRotateSet_A;
import mccore.mccore.checks.NoSlowDown.NoSlowDown_A;
import mccore.mccore.checks.NoSlowDown.NoSlowDown_B;
import mccore.mccore.checks.NoSlowDown.NoSlowDown_C;
import mccore.mccore.checks.Nuke.Nuke_A;
import mccore.mccore.checks.Phase.Phase_A;
import mccore.mccore.checks.Reach.Reach_A;
import mccore.mccore.checks.Scaffold.Scaffold_A;
import mccore.mccore.checks.Scaffold.Scaffold_B;
import mccore.mccore.checks.Speed.Speed_A;
import mccore.mccore.checks.Speed.Speed_B;
import mccore.mccore.checks.Speed.Speed_C;
import mccore.mccore.checks.Step.Step_A;
import mccore.mccore.checks.Teleport.Teleport_A;
import mccore.mccore.checks.Timer.Timer_A;
import mccore.mccore.command.Information;
import mccore.mccore.player.PingSpoofer_A;
import mccore.mccore.utils.command.Report;
import mccore.mccore.utils.command.Settings;
import mccore.mccore.utils.events.Aggression;
import mccore.mccore.utils.events.BanWaves;
import mccore.mccore.utils.events.SetBacks;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class mccore extends JavaPlugin {
    @Override
    public void onEnable() {

        // Start the check method
        getServer().getPluginManager().registerEvents(new AntiBot_A(), this);
        getServer().getPluginManager().registerEvents(new AutoClicker_A(), this);
        getServer().getPluginManager().registerEvents(new Blink_A(), this);
        getServer().getPluginManager().registerEvents(new Crasher_A(), this);
        getServer().getPluginManager().registerEvents(new Critical_A(), this);
        getServer().getPluginManager().registerEvents(new Critical_B(), this);
        getServer().getPluginManager().registerEvents(new Derp_A(), this);
        getServer().getPluginManager().registerEvents(new ESP_A(), this);
        getServer().getPluginManager().registerEvents(new FastBow_A(), this);
        getServer().getPluginManager().registerEvents(new FastBreak_A(), this);
        getServer().getPluginManager().registerEvents(new FastClimb_A(), this);
        getServer().getPluginManager().registerEvents(new FastEat_A(), this);
        getServer().getPluginManager().registerEvents(new FastPlace_A(), this);
        getServer().getPluginManager().registerEvents(new Flight_A(), this);
        getServer().getPluginManager().registerEvents(new Flight_B(), this);
        getServer().getPluginManager().registerEvents(new Freecam_A(), this);
        getServer().getPluginManager().registerEvents(new InventoryCleaner_A(), this);
        getServer().getPluginManager().registerEvents(new InventoryMovement_A(), this);
        getServer().getPluginManager().registerEvents(new Jesus_A(), this);
        getServer().getPluginManager().registerEvents(new KillAura_A(), this);
        getServer().getPluginManager().registerEvents(new KillAura_B(), this);
        getServer().getPluginManager().registerEvents(new KillAura_C(), this);
        getServer().getPluginManager().registerEvents(new Knockback_A(), this);
        getServer().getPluginManager().registerEvents(new NoFall_A(), this);
        getServer().getPluginManager().registerEvents(new NoRotateSet_A(), this);
        getServer().getPluginManager().registerEvents(new NoSlowDown_A(), this);
        getServer().getPluginManager().registerEvents(new NoSlowDown_B(), this);
        getServer().getPluginManager().registerEvents(new NoSlowDown_C(), this);
        getServer().getPluginManager().registerEvents(new Nuke_A(), this);
        getServer().getPluginManager().registerEvents(new Phase_A(), this);
        getServer().getPluginManager().registerEvents(new PingSpoofer_A(), this);
        getServer().getPluginManager().registerEvents(new Reach_A(), this);
        getServer().getPluginManager().registerEvents(new Scaffold_A(), this);
        getServer().getPluginManager().registerEvents(new Scaffold_B(), this);
        getServer().getPluginManager().registerEvents(new Speed_A(), this);
        getServer().getPluginManager().registerEvents(new Speed_B(), this);
        getServer().getPluginManager().registerEvents(new Speed_C(), this);
        getServer().getPluginManager().registerEvents(new Step_A(), this);
        getServer().getPluginManager().registerEvents(new Teleport_A(), this);
        getServer().getPluginManager().registerEvents(new Timer_A(), this);

        // Checker action taker
        getServer().getPluginManager().registerEvents(new Aggression(), this);
        getServer().getPluginManager().registerEvents(new BanWaves(), this);
        getServer().getPluginManager().registerEvents(new SetBacks(), this);


        // Plugin main commands
        Objects.requireNonNull(this.getCommand("report")).setExecutor(new Report());
        Objects.requireNonNull(this.getCommand("dks_settings")).setExecutor(new Settings());
        Objects.requireNonNull(this.getCommand("dks_info")).setExecutor(new Information());
    }
}