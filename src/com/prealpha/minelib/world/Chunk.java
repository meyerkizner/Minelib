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

package com.prealpha.minelib.world;

import static com.google.common.base.Preconditions.*;

import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

import com.prealpha.minelib.math.Coordinate2D;
import com.prealpha.minelib.math.Coordinate3D;
import com.prealpha.minelib.nbt.CompoundTag;
import com.prealpha.minelib.nbt.Tag;

/*
 * TODO: entities and tile entities
 * TODO: some way to serialize this (and blocks), and does it need events?
 *       for serialization, perhaps it should keep and re-return the compound tag
 * TODO: cache Block instances?
 */
public final class Chunk implements Iterable<Block> {
	private final byte[] blocks;

	private final byte[] data;

	private final byte[] heightMap;

	private final Coordinate2D position;

	private boolean populated;

	// to be used by Region/World only
	Chunk(CompoundTag tag) {
		// TODO: will Minecraft break if it doesn't have ALL fields?
		Map<String, Tag> components = tag.getValue();
		blocks = (byte[]) components.get("Blocks").getValue();
		data = (byte[]) components.get("Data").getValue();
		heightMap = (byte[]) components.get("HeightMap").getValue();
		int x = (Integer) components.get("xPos").getValue();
		int z = (Integer) components.get("zPos").getValue();
		position = new Coordinate2D(x, z);
		byte populated = (Byte) components.get("TerrainPopulated").getValue();
		this.populated = (populated != 0);
	}

	/**
	 * Returns the global, two-dimensional position of this chunk. The global
	 * position ranges from (-infinity, -infinity) to (+infinity, +infinity).
	 * 
	 * @return the position of the chunk relative to the world
	 */
	public Coordinate2D getGlobalPosition() {
		return position;
	}

	/**
	 * Returns the regional, two-dimensional position of this chunk. The
	 * regional position ranges from (0, 0) to (31, 31).
	 * 
	 * @return the position of the chunk relative to the region
	 */
	public Coordinate2D getRegionalPosition() {
		return position.mod(32);
	}

	/**
	 * Returns the block at the given coordinate. Valid coordinates range from
	 * (0, 0, 0) to (15, 127, 15).
	 * 
	 * @param coordinate
	 *            a chunk-relative coordinate
	 * @return the block at the given coordinate
	 * @throws IndexOutOfBoundsException
	 *             if the coordinate is outside the chunk
	 */
	public Block getBlock(Coordinate3D coordinate) {
		int index = getIndex(coordinate);
		byte id = blocks[index];
		byte data;
		if (index % 2 == 0) {
			data = (byte) (this.data[index / 2] & 0xf);
		} else {
			data = (byte) (this.data[index / 2] >>> 4);
		}
		return new BasicBlock(id, data, coordinate);
	}

	/**
	 * Sets the block at the given coordinate to the specified type. Valid
	 * coordinates range from (0, 0, 0) to (15, 127, 15). If it was
	 * {@code false} before method execution, the {@link #isPopulated()} flag
	 * will be set to {@code true}.
	 * 
	 * @param coordinate
	 *            a chunk-relative coordinate
	 * @param blockType
	 *            the block type to set
	 * @throws IndexOutOfBoundsException
	 *             if the coordinate is outside the chunk
	 */
	public void setBlock(Coordinate3D coordinate, BlockType blockType) {
		int index = getIndex(coordinate);
		blocks[index] = blockType.getID();
		byte oldData = data[index / 2];
		if (index % 2 == 0) {
			data[index / 2] = (byte) ((oldData & 0xf0) | blockType.getData());
		} else {
			data[index / 2] = (byte) ((blockType.getData() << 4) | (oldData & 0xf));
		}
		populated = true;
	}

	/**
	 * Returns the lowest y-coordinate at which light from the sky is at full
	 * strength, in the given coordinate. Essentially, this is the height of the
	 * (non-air) blocks in that coordinate. Valid coordinates range from (0, 0)
	 * to (15, 15).
	 * 
	 * @param coordinate
	 *            a chunk-relative coordinate
	 * @return the height at the given coordinate
	 * @throws IndexOutOfBoundsException
	 *             if the coordinate is outside the chunk
	 */
	public byte getHeight(Coordinate2D coordinate) {
		int index = coordinate.getX() + (16 * coordinate.getZ());
		return heightMap[index];
	}

	/**
	 * Returns {@code true} if this chunk was populated with resources other
	 * than the standard blocks (stone, dirt, etc.). This flag is automatically
	 * set when the chunk is manually modified using the
	 * {@link #setBlock(Coordinate3D, Block)} method.
	 * 
	 * @return {@code true} if this chunk is populated or was modified
	 */
	public boolean isPopulated() {
		return populated;
	}

	/**
	 * Returns an iterator over the blocks in this chunk. The iterator is
	 * guaranteed to return blocks in a specific order:
	 * <ul>
	 * <li>The iterator advances through blocks in vertical columns, starting at
	 * Y=0 and ending at Y=127.</li>
	 * <li>The first column is in the northeast corner of the chunk, where X=0
	 * and Z=0.</li>
	 * <li>Subsequent columns stay on the north side of the chunk and move from
	 * east to west, with the Z coordinate increasing to Z=15.</li>
	 * <li>Finally, after iterating through all X=0 blocks, the X coordinate is
	 * incremented, and the Z coordinate is reset to Z=0.</li>
	 * <li>This process is repeated for each X coordinate.</li>
	 * </ul>
	 * In all, 32768 (16*128*16) blocks will be returned.
	 * <p>
	 * 
	 * The iterator's {@link Iterator#remove() remove()} method sets the block
	 * in the last iterated position to air.
	 * 
	 * @return an iterator over this chunk's blocks
	 */
	@Override
	public Iterator<Block> iterator() {
		return new ChunkIterator();
	}

	/**
	 * Implementation of {@code Iterator} for {@code Chunk}.
	 * 
	 * @author Meyer Kizner
	 * 
	 */
	private final class ChunkIterator implements Iterator<Block> {
		/**
		 * The next block we are returning is at this index. If
		 * {@link #remove()} is called, it removes the block at
		 * {@code index - 1}.
		 */
		private int index;

		@Override
		public boolean hasNext() {
			return (index < blocks.length);
		}

		@Override
		public Block next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			return getBlock(fromIndex(index++));
		}

		@Override
		public void remove() {
			checkState(index > 0);
			int toRemove = index - 1;
			Coordinate3D coordinate = fromIndex(toRemove);
			setBlock(coordinate, BlockTypes.AIR);
		}
	}

	/**
	 * Returns the index in the {@link #blocks} array for the specified
	 * {@code Coordinate3D}. This may return invalid indices if the coordinate
	 * is out of bounds.
	 * 
	 * @param coordinate
	 *            a chunk-relative coordinate
	 * @return the index of the coordinate's block ID in {@code blocks}
	 */
	private static int getIndex(Coordinate3D coordinate) {
		return coordinate.getY() + (128 * coordinate.getZ())
				+ (2048 * coordinate.getX());
	}

	/**
	 * Returns the {@code Coordinate3D} which corresponds to the specified index
	 * in the {@link #blocks} array. This may return out of bounds coordinates
	 * for invalid indices.
	 * 
	 * @param index
	 *            the index of a block ID in {@code blocks}
	 * @return a chunk-relative coordinate corresponding to the index
	 */
	private static Coordinate3D fromIndex(int index) {
		int y = index % 128;
		int z = (index % 2048) / 128;
		int x = index / 2048;
		return new Coordinate3D(x, y, z);
	}
}
