package de.bananaco.bananasahara.generator;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.generator.ChunkGenerator;

public class MainGenerator extends ChunkGenerator {

	byte[] b = new byte[32768];
	byte bedrock = (byte) Material.BEDROCK.getId();
	byte stone = (byte) Material.STONE.getId();
	byte sand = (byte) Material.SAND.getId();
	byte water = (byte) Material.STATIONARY_WATER.getId();

	@Override
	public byte[] generate(World world, Random random, int chunkX, int chunkZ) {

		for (int x = 0; x < 16; x++) {
			for (int z = 0; z < 16; z++) {
				for (int y = 0; y < 1; y++)
					b[xyzToByte(x, y, z)] = bedrock;
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
