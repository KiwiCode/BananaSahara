package de.bananaco.bananasahara.populator;

import java.util.Random;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.generator.BlockPopulator;

/**
 * 
 * @author King Rat
 */

public class OrePopulator extends BlockPopulator {

	public void populate(World world, Random random, Chunk source) {

		int[] chance = { 90, 50, 30, 30, 25, 25, 10 };
		int[] maxSize = { 32, 10, 16, 12, 8, 8, 8 };
		int[] maxHeight = { 56, 48, 30, 30, 25, 20, 16 };
		Material[] oreType = { Material.COAL_ORE, Material.IRON_ORE, Material.SOUL_SAND, Material.GOLD_ORE, Material.REDSTONE_ORE, Material.LAPIS_ORE, Material.DIAMOND_ORE };

		for (int i = 0; i < oreType.length; i++) {
			if (random.nextInt(100) < chance[i]) {
				int x = random.nextInt(16);
				int z = random.nextInt(16);
				int y = random.nextInt(maxHeight[i] - 6) + 6;
				Block block = world.getBlockAt(x, y, z);
				block.setType(oreType[i]);
				for (int j = 0; j < maxSize[i]; i++) {
					block = world.getBlockAt(x + j, y, z);
					block.setType(oreType[i]);
				}
			}
		}
	}
}