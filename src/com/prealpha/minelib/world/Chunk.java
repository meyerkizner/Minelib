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

import java.util.Iterator;

import com.prealpha.minelib.math.Coordinate2D;
import com.prealpha.minelib.math.Coordinate3D;

/*
 * TODO: entities and tile entities
 */
public interface Chunk extends Iterable<Block> {
	/**
	 * Returns the global, two-dimensional position of this chunk. The global
	 * position ranges from (-infinity, -infinity) to (+infinity, +infinity).
	 * 
	 * @return the position of the chunk relative to the world
	 */
	Coordinate2D getGlobalPosition();

	/**
	 * Returns the regional, two-dimensional position of this chunk. The
	 * regional position ranges from (0, 0) to (31, 31).
	 * 
	 * @return the position of the chunk relative to the region
	 */
	Coordinate2D getRegionalPosition();

	/**
	 * Returns the block at the given coordinate. Valid coordinates range from
	 * (0, 0, 0) to (15, 127, 15).
	 * 
	 * @param coordinate
	 *            a chunk-relative coordinate
	 * @return the block at the given coordinate
	 * @throws IllegalArgumentException
	 *             if the coordinate is outside the chunk
	 */
	Block getBlock(Coordinate3D coordinate);

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
	 * @throws IllegalArgumentException
	 *             if the coordinate is outside the chunk
	 */
	void setBlock(Coordinate3D coordinate, BlockType blockType);

	/**
	 * Returns the lowest y-coordinate at which light from the sky is at full
	 * strength, in the given coordinate. Essentially, this is the height of the
	 * (non-air) blocks in that coordinate. Valid coordinates range from (0, 0)
	 * to (15, 15).
	 * 
	 * @param coordinate
	 *            a chunk-relative coordinate
	 * @return the height at the given coordinate
	 * @throws IllegalArgumentException
	 *             if the coordinate is outside the chunk
	 */
	byte getHeight(Coordinate2D coordinate);

	/**
	 * Returns {@code true} if this chunk was populated with resources other
	 * than the standard blocks (stone, dirt, etc.). This flag is automatically
	 * set when the chunk is manually modified using the
	 * {@link #setBlock(Coordinate3D, Block)} method.
	 * 
	 * @return {@code true} if this chunk is populated or was modified
	 */
	boolean isPopulated();

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
	Iterator<Block> iterator();
}