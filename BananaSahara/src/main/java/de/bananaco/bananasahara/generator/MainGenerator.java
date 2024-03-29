package de.bananaco.bananasahara.generator;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.util.noise.SimplexOctaveGenerator;

import de.bananaco.bananasahara.populator.MotherPopulator;

public class MainGenerator extends ChunkGenerator {

	@Override
	public byte[] generate(World world, Random random, int chunkX, int chunkZ) {

		byte[] b = new byte[32768];
		Random seed = new Random(world.getSeed());
		SimplexOctaveGenerator g = new SimplexOctaveGenerator(seed, 8);
		g.setScale(1 / 128.0);

		// Main chunk loop
		for (int x = 0; x < 16; x++) {
			for (int z = 0; z < 16; z++) {

				double noise = g.noise(x + chunkX * 16, z + chunkZ * 16, 0.75, 0.85) * 15;
				
				// Flat layers
				for (int y = 0; y < 1; y++)
					b[xyzToByte(x, y, z)] = bedrock;
				for (int y = 1; y < 54; y++)
					b[xyzToByte(x, y, z)] = stone;


				// Noisey layers
				for (int y = 54; y < 60 + noise; y++)
					b[xyzToByte(x, y, z)] = sand;
				for (int y = 50; y < (57 + (noise / 2)); y++)
					b[xyzToByte(x, y, z)] = sandstone;
				for (int y = 50; y < (56 + (noise / 4)); y++)
					b[xyzToByte(x, y, z)] = stone;

				// "Sea" layer
				for (int y = 50; y < 62; y++) {
					if (b[xyzToByte(x, y, z)] == 0)
						b[xyzToByte(x, y, z)] = lava;
				}

			}
		}
		return b;
	}

	@Override
	public List<BlockPopulator> getDefaultPopulators(World world) {
		return Arrays.<BlockPopulator> asList(new MotherPopulator());
	}

	@Override
	public boolean canSpawn(World world, int x, int z) {
		double xX = Math.random() * x;
		double zZ = Math.random() * z;
		if (xX > zZ)
			return true;
		else
			return false;
	}

	public int xyzToByte(int x, int y, int z) {
		return (x * 16 + z) * 128 + y;
	}

	byte bedrock = (byte) Material.BEDROCK.getId();
	byte stone = (byte) Material.STONE.getId();
	byte sand = (byte) Material.SAND.getId();
	byte sandstone = (byte) Material.SANDSTONE.getId();
	byte water = (byte) Material.STATIONARY_WATER.getId();
	byte lava = (byte) Material.STATIONARY_LAVA.getId();
	byte soulsand = (byte) Material.SOUL_SAND.getId();

}
