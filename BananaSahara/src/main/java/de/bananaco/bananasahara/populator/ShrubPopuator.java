/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package de.bananaco.bananasahara.populator;

import java.util.Random;
import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.generator.BlockPopulator;

/**
 * 
 * @author Ryan
 */
class ShrubPopulator extends BlockPopulator {

	@Override
	public void populate(World world, Random random, Chunk source) {
		
		for (int x = 0; x < 16; x++) {
			for (int z = 0; z < 16; z++) {

				int cx = (source.getX() << 4) + x;
				int cz = (source.getZ() << 4) + z;
				int y = world.getHighestBlockYAt(cx, cz);
				Block block = source.getBlock(x, y, z);

				int n = random.nextInt(128);
				if (n < 1) {
					if (block.getType() == Material.AIR && block.getRelative(BlockFace.DOWN).getType() == Material.SAND)
						block.setType(Material.DEAD_BUSH);
					
				}
			}
		}
	}
}