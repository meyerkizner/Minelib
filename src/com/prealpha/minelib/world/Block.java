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

import com.prealpha.minelib.math.Coordinate3D;

public interface Block {
	/**
	 * The value of the chunk-wise position ranges from (0,0,0) to (16,128,15). (x,y,z)
	 * @return The position of the block relative to the chunk.
	 */
	Coordinate3D getChunkwisePosition();

	/**
	 * The value of the regional position ranges from (0,0,0) to (512,128,512). (x,y,z)
	 * @return The position of the block relative to the region.
	 */
	Coordinate3D getRegionalPosition();

	/**
	 * The value of the global position ranges from (-infinity,0,-infinity) to (+infinity,128,+infinity). (x,y,z)
	 * @return The position of the block relative to the world.
	 */
	Coordinate3D getGlobalPosition();

	/**
	 * @return A BlockType object that contains the block ID and block data
	 */
	BlockType getBlockType();

	/**
	 * @param other
	 * @return A boolean value that represents if the BlockType of each block is identical
	 */
	boolean isA(Block other);
	/**
	 * @param blockType A BlockType object to compair against the current Block
	 * @return A boolean value that represents if the BlockType of the block is identical to the given Blocktype
	 */
	boolean isA(BlockType blockType);

	/**
	 * Blocks are similar to another block if their blocktype has matching IDs.
	 * This means that orange wool IS similar to blue wool.
	 * @param other Another Block object
	 * @return A boolean value that states if the current block's is similar to another block's blocktype
	 */
	boolean isSimilar(Block other);
	/**
	 * A block can be similar to a blocktype if its blocktype has matching IDs to the given BlockType
	 * @param blocktype The BlockType to compair it to.
	 * @return A boolean value that states if the current block's blocktype is similar to another block
	 */
	boolean isSimilar(BlockType blocktype);
}