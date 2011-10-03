package de.bananaco.bananasahara.populator;

import java.util.Random;

import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;

public class MotherPopulator extends BlockPopulator {

	// A lot of codenamecode here, I know, but I wanted to get this fecking
	// commit out ^_^

	@Override
	public void populate(World world, Random random, Chunk chunk) {
		for (BlockPopulator pop : list) {
			pop.populate(world, random, chunk);
		}
	}

	private final BlockPopulator[] list;

	public MotherPopulator() {
		list = new BlockPopulator[] {
                    new ShrubPopulator()
                    new CactusPopulator()
                    new OrePopulator()
		};
	}
}
