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

import static com.google.common.base.Preconditions.*;

import com.prealpha.minelib.math.Coordinate3D;

public final class BasicBlock implements Block {
	private final BlockType blockType;

	private final Coordinate3D globalPosition;

	public BasicBlock(byte blockID, byte data, int globalX, int globalY,
			int globalZ) {
		this(new BlockType(blockID, data), new Coordinate3D(globalX, globalY,
				globalZ));
	}

	public BasicBlock(byte blockID, byte data, Coordinate3D position) {
		this(new BlockType(blockID, data), position);
	}

	public BasicBlock(BlockType blockType, int globalX, int globalY, int globalZ) {
		this(blockType, new Coordinate3D(globalX, globalY, globalZ));
	}

	public BasicBlock(BlockType blockType, Coordinate3D position) {
		checkNotNull(blockType);
		checkNotNull(position);
		this.blockType = blockType;
		this.globalPosition = position;
	}

	@Override
	public Coordinate3D getGlobalPosition() {
		if (this.globalPosition != null) {
			return this.globalPosition;
		} else {
			return null;
		}
	}

	@Override
	public Coordinate3D getRegionalPosition() {
		if (this.globalPosition != null) {
			return this.globalPosition.mod(512);
		} else {
			return null;
		}
	}

	@Override
	public Coordinate3D getChunkwisePosition() {
		if (this.globalPosition != null) {
			return this.globalPosition.mod(16);
		} else {
			return null;
		}
	}

	public byte getBlockID() {
		return this.blockType.getID();
	}

	public byte getBlockData() {
		return this.blockType.getData();
	}

	@Override
	public BlockType getBlockType() {
		return this.blockType;
	}

	@Override
	public boolean isA(BlockType other) {
		return this.getBlockType().equals(other);
	}

	@Override
	public boolean isA(Block other) {
		return this.getBlockType().equals(other.getBlockType());
	}

	@Override
	public boolean isSimilar(BlockType other) {
		return this.getBlockType().isSimilar(other);
	}

	@Override
	public boolean isSimilar(Block other) {
		return this.getBlockType().isSimilar(other.getBlockType());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((blockType == null) ? 0 : blockType.hashCode());
		result = prime * result
				+ ((globalPosition == null) ? 0 : globalPosition.hashCode());
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
		if (!(obj instanceof BasicBlock)) {
			return false;
		}
		BasicBlock other = (BasicBlock) obj;
		if (blockType == null) {
			if (other.blockType != null) {
				return false;
			}
		} else if (!blockType.equals(other.blockType)) {
			return false;
		}
		if (globalPosition == null) {
			if (other.globalPosition != null) {
				return false;
			}
		} else if (!globalPosition.equals(other.globalPosition)) {
			return false;
		}
		return true;
	}
}
