package de.bananaco.bananasahara;

public class XYZ {
	// Variables
	public int x;
	public int y;
	public int z;

	public XYZ(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public XYZ() {
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		result = prime * result + z;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof XYZ)) {
			return false;
		}
		XYZ other = (XYZ) obj;
		if (x != other.x) {
			return false;
		}
		if (y != other.y) {
			return false;
		}
		if (z != other.z) {
			return false;
		}
		return true;
	}
}
