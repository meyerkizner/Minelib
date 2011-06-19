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

import java.util.Map;

import com.prealpha.minelib.math.Coordinate2D;
import com.prealpha.minelib.math.Coordinate3D;

public interface World extends Map<Coordinate2D, Chunk> {
	// region access and metadata, however they will work
	public Region getRegion(Coordinate2D location);
	public Region getRegion(int x, int z);
	
	public boolean regionExists(Coordinate2D location);
	public boolean regionExists(int x, int z);
	
	
	public Chunk getGlobalChunk(Coordinate2D location);
	public Chunk getGlobalChunk(int x, int z);
	
	public boolean globalChunkExists(Coordinate2D location);
	public boolean globalChunkExists(int x, int z);
	
	
	public Block getGlobalBlock(Coordinate3D location);
	public Block getGlobalBlock(int x, int y, int z);
	
	public boolean globalBlockExists(Coordinate3D location);
	public boolean globalBlockExists(int x, int y, int z);
}
