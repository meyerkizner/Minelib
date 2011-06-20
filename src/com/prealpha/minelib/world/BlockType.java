/*
 * Minelib, a Minecraft library
 * Copyright (C) 2011 Ty Overby
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

package com.prealpha.minelib.world;

public final class BlockType {
	private final byte id;

	private final byte data;

	/**
	 * Providing only the id, the data value will be set to 0
	 * @param id The ID number for the block
	 */
	public BlockType(byte id) {
		this.id = id;
		this.data = 0;
	}
	/**
	 * @param id The ID number for the block
	 * @param data The extra data pertaining to the block
	 */
	public BlockType(byte id, byte data) {
		this.id = id;
		this.data = data;
	}
	
	/**
	 * @return The Identification number for the block
	 */
	public byte getID() {
		return this.id;
	}
	/**
	 * @return The Data pertaining to the block.  If there is no data, it will default to 0.
	 */
	public byte getData() {
		return this.data;
	}

	/**
	 * Similarity checks if the ID's are the same.  
	 * This way, you could say that the different types of trees are similar.
	 * @param other Another BlockType
	 * @return
	 */
	public boolean isSimilar(BlockType other) {
		if (other == null) {
			return false;
		}
		if (this.getID() != other.getID()) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + data;
		result = prime * result + id;
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
		if (!(obj instanceof BlockType)) {
			return false;
		}
		BlockType other = (BlockType) obj;
		if (data != other.data) {
			return false;
		}
		if (id != other.id) {
			return false;
		}
		return true;
	}
}
