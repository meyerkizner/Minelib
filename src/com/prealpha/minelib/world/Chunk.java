/*
 * MineLib, a Minecraft library
 * Copyright (C) 2011 Meyer Kizner
 * 
 * This file is part of MineLib.
 * 
 * MineLib is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * MineLib is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * MineLib. If not, see <http://www.gnu.org/licenses/>.
 */

package com.prealpha.minelib.world;

import com.prealpha.minelib.math.*;

/*
 * When this is implemented, it can probably be a class. Can't think of a
 * reason to have multiple implementations.
 */
public interface Chunk extends Iterable<Byte> {
	Coordinate2D getRegionalPosition();
	Coordinate2D getGlobalPosition();

	byte getBlock(Coordinate3D coordinate);
	byte getBlock(int x, int y, int z);

	byte getData(Coordinate3D coordinate);
	byte getData(int x, int y, int z);

	// entities, etc...
}