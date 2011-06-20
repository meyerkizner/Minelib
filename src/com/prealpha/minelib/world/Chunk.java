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

/*
 * When this is implemented, it can probably be a class. Can't think of a
 * reason to have multiple implementations.
 */
public interface Chunk {
	/**
	 * The regional position ranges from (0,0) to (32,32). (x,z)
	 * @return The position of the chunk relative to the region.
	 */
	Coordinate2D getRegionalPosition();

	/**
	 * The global position ranges from (-infinity,-infinity) to (+infinity,+infinity). (x,z)
	 * @return The position of the chunk relative to the world.
	 */
	Coordinate2D getGlobalPosition();

	/**
	 * @param coordinate
	 * @return The block at the given coordinate.  
	 */
	Block getBlock(Coordinate3D coordinate);
	Block getBlock(int x, int y, int z);
}