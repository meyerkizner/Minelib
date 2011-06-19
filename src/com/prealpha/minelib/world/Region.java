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

import java.util.Map;
import com.prealpha.minelib.math.Coordinate2D;

public interface Region extends Map<Coordinate2D, Chunk> {
	Coordinate2D getGlobalPosition();
	
	public Chunk getChunk(Coordinate2D location);
	public Chunk getChunk(int x, int z);
	
	public boolean chunkExists(Coordinate2D location);
	public boolean chunkExists(int x, int z);
	
	
	public Block getRegionalBlock(Coordinate2D location);
	public Block getRegionalBlock(int x, int y, int z);
	
	public boolean regionalBlockExists(Coordinate2D location);
	public boolean regionalBlockExists(int x, int z);
}
