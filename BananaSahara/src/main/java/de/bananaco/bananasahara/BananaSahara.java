package de.bananaco.bananasahara;

import org.bukkit.World.Environment;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.java.JavaPlugin;

import de.bananaco.bananasahara.generator.MainGenerator;

public class BananaSahara extends JavaPlugin {

	public void onDisable() {
		System.out.println(this + " is now disabled!");
	}

	public void onEnable() {
		System.out.println("Hold on to your knickers, " + this
				+ " is now enabled!");
		
		// Just for testing
		if (getServer().getWorld("testworld") == null)
			getServer().createWorld("testworld", Environment.NORMAL, new MainGenerator());
	}

	@Override
	public ChunkGenerator getDefaultWorldGenerator(String worldName, String id) {
		return new MainGenerator();
	}

}
