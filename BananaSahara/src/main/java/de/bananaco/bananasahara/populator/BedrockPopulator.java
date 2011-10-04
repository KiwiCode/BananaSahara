package de.bananaco.bananasahara.populator;

import java.util.Random;

import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;

/**
 * A bedrock populator!
 * 
 * @author iffa
 */

public class BedrockPopulator extends BlockPopulator {

	@Override
	public void populate(World world, Random random, Chunk chunk) {
		
		for (int x = 0; x < 16; x++) {
			for (int z = 0; z < 16; z++) {

				if (random.nextInt(2) == 1) {
					if (random.nextInt(2) == 1)
						chunk.getBlock(x, 1, z).setType(Material.BEDROCK);
					else {
						chunk.getBlock(x, 2, z).setType(Material.BEDROCK);
						chunk.getBlock(x, 3, z).setType(Material.BEDROCK);
					}
				} else
					chunk.getBlock(x, 2, z).setType(Material.BEDROCK);
				
			}
		}
	}
}