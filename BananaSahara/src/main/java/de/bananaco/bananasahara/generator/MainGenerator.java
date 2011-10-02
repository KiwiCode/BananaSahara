package de.bananaco.bananasahara.generator;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.util.noise.SimplexOctaveGenerator;

public class MainGenerator extends ChunkGenerator {

	byte[] b = new byte[32768];
	byte bedrock = (byte) Material.BEDROCK.getId();
	byte stone = (byte) Material.STONE.getId();
	byte sand = (byte) Material.SAND.getId();
	byte water = (byte) Material.STATIONARY_WATER.getId();

	@Override
	public byte[] generate(World world, Random random, int chunkX, int chunkZ) {

		Random seed = new Random(world.getSeed());
		SimplexOctaveGenerator g = new SimplexOctaveGenerator(seed, 8);
		g.setScale(1 / 64.0);

		for (int x = 0; x < 16; x++) {
			for (int z = 0; z < 16; z++) {

				for (int y = 0; y < 1; y++)
					b[xyzToByte(x, y, z)] = bedrock;

				for (int y = 1; y < 8; y++)
					b[xyzToByte(x, y, z)] = stone;

				double noise = g.noise(x + chunkX * 16, z + chunkZ * 16, 0.5, 0.5) * 16;
				for (int y = 8; y < 16 + noise; y++) 
					b[xyzToByte(x, y, z)] = sand;

				for (int y = 8; y < 24; y++) {
					if (b[xyzToByte(x, y, z)] == 0)
						b[xyzToByte(x, y, z)] = water;
				}
			}
		}
		return b;
	}

	@Override
	public boolean canSpawn(World world, int x, int z) {
		double xX = Math.random() * x;
		double zZ = Math.random() * z;
		if (xX > zZ) {
			return true;
		} else {
			return false;
		}
	}

	public int xyzToByte(int x, int y, int z) {
		return (x * 16 + z) * 128 + y;
	}
}
