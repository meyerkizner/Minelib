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

public interface Region {
	/**
	 * The global coordinates range from (-infinity,-infinity) to (+infinity,+infinity)
	 * @return The location of the region with respect to the world.
	 */
	Coordinate2D getGlobalPosition();

	/**
	 * The values for the location range from (0,0,0) to (16,128,15). (x,y,z)
	 * @param location
	 * @return The chunk at the given location.
	 */
	Chunk getChunk(Coordinate2D location);
	Chunk getChunk(int x, int z);

	/**
	 * The values for the location range from (0,0,0) to (16,128,15). (x,y,z)
	 * @param location
	 * @return if the chunk exists at the location
	 */
	boolean chunkExists(Coordinate2D location);
	boolean chunkExists(int x, int z);

	/**
	 * The values for the location range from (0,0,0) to (512,128,512). (x,y,z)
	 * @param location
	 * @return A block at the given coordinates with respect to this region.
	 */
	Block getRegionalBlock(Coordinate2D location);
	Block getRegionalBlock(int x, int y, int z);

	/**
	 * The values for the location range from (0,0,0) to (512,128,512). (x,y,z)
	 * @param location
	 * @return If the block at this location exists
	 */
	boolean regionalBlockExists(Coordinate2D location);
	boolean regionalBlockExists(int x, int z);
}
