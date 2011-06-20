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
	Region getRegion(Coordinate2D location);

	Region getRegion(int x, int z);

	boolean regionExists(Coordinate2D location);

	boolean regionExists(int x, int z);

	Chunk getGlobalChunk(Coordinate2D location);

	Chunk getGlobalChunk(int x, int z);

	boolean globalChunkExists(Coordinate2D location);

	boolean globalChunkExists(int x, int z);

	Block getGlobalBlock(Coordinate3D location);

	Block getGlobalBlock(int x, int y, int z);

	boolean globalBlockExists(Coordinate3D location);

	boolean globalBlockExists(int x, int y, int z);
}
