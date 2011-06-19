/*
 * Minelib, a Minecraft library
 * Copyright (C) 2011 Meyer Kizner
 * 
 * This file is part of Minelib.
 * 
 * Minelib is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * Minelib is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * Minelib. If not, see <http://www.gnu.org/licenses/>.
 */

package com.prealpha.minelib.math;

public final class Coordinate3D {
	public final int x;
	public final int y;
	public final int z;

	public Coordinate3D(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getZ() {
		return z;
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
		if (!(obj instanceof Coordinate3D)) {
			return false;
		}
		Coordinate3D other = (Coordinate3D) obj;
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

	@Override
	public String toString() {
		return "(" + x + ", " + y + ", " + z + ")";
	}
	
	public Coordinate3D plus(int x, int y, int z){
		return new Coordinate3D(this.getX()+x, this.getY()+y, this.getZ()+z);
	}
	public Coordinate3D plus(Coordinate3D other){
		return plus(other.getX(),other.getY(),other.getZ());
	}
	
	public Coordinate3D minus(int x, int y, int z){
		return new Coordinate3D(this.getX()-x,this.getY()-y,this.getZ()-z);
	}
	public Coordinate3D minus(Coordinate3D other){
		return minus(other.getX(),other.getY(),other.getZ());
	}
}
