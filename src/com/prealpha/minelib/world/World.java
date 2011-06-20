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

import com.prealpha.minelib.math.Coordinate2D;
import com.prealpha.minelib.math.Coordinate3D;

public interface World {
	/**
	 * Valid values range from (-infinity,-infinity) to (+infinity,+infinity). (x,z)
	 * @param location
	 * @return The region at the coordinates provided.
	 */
	Region getRegion(Coordinate2D location);
	Region getRegion(int x, int z);

	/**
	 * Valid values range from (-infinity,-infinity) to (+infinity,+infinity). (x,z)
	 * @param location
	 * @return If the region at the given coordinates exists.
	 */
	boolean regionExists(Coordinate2D location);
	boolean regionExists(int x, int z);

	/**
	 * Valid values range from (-infinity,-infinity) to (+infinity,+infinity). (x,z)
	 * @param location
	 * @return The chunk at the given location
	 */
	Chunk getGlobalChunk(Coordinate2D location);
	Chunk getGlobalChunk(int x, int z);

	/**
	 * Valid values range from (-infinity,-infinity) to (+infinity,+infinity). (x,z)
	 * @param location
	 * @return If the chunk at the given location exists
	 */
	boolean globalChunkExists(Coordinate2D location);
	boolean globalChunkExists(int x, int z);

	/**
	 * Valid values range from (-infinity,0,-infinity) to (+infinity,128,+infinity). (x,y,z)
	 * @param location
	 * @return The block at the given position
	 */
	Block getGlobalBlock(Coordinate3D location);
	Block getGlobalBlock(int x, int y, int z);

	/**
	 * Valid values range from (-infinity,0,-infinity) to (+infinity,128,+infinity). (x,y,z)
	 * @param location
	 * @return If the block at the given position exists
	 */
	boolean globalBlockExists(Coordinate3D location);
	boolean globalBlockExists(int x, int y, int z);
}
