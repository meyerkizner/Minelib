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

import org.junit.Test;

import com.prealpha.minelib.math.Coordinate3D;

import static org.junit.Assert.*;

public class BasicBlockTest {
	@Test
	public void testEquals(){
		//same position, same blockType
		Block woodenBlock = new BasicBlock(new BlockType((byte)17), new Coordinate3D(5,5,5));
		Block woodenBlock2 = new BasicBlock(new BlockType((byte)17), new Coordinate3D(5,5,5));
		//check to see if they are equivilant
		assertTrue(woodenBlock.equals(woodenBlock2));
		
		//different position, same blocktype
		Block stoneBlock = new BasicBlock(new BlockType((byte)1), new Coordinate3D(5,5,5));
		Block stoneBlock2 = new BasicBlock(new BlockType((byte)1), new Coordinate3D(5,4,5));
		//see if they aren't equal because the position is different
		assertFalse(stoneBlock.equals(stoneBlock2));
		
		//same position, different blocktype
		assertFalse(woodenBlock.equals(stoneBlock));
	}
	
	@Test
	public void testSimilar(){
		Block woodenBlock = new BasicBlock(new BlockType((byte)17), new Coordinate3D(5,5,5));
		Block woodenBlock2 = new BasicBlock(new BlockType((byte)17), new Coordinate3D(1,25,76));
		//check to see if they are similar dispite different coordinates
		assertTrue(woodenBlock.isSimilar(woodenBlock2));
		
		Block standardwood = new BasicBlock(new BlockType((byte)17), new Coordinate3D(5,5,5));
		Block birtchwood = new BasicBlock(new BlockType((byte)17,(byte)2), new Coordinate3D(1,25,76));
		assertTrue(standardwood.isSimilar(birtchwood));
	}
	
	@Test
	public void testIsA(){
		Block standardwood = new BasicBlock(new BlockType((byte)17), new Coordinate3D(5,5,5));
		BlockType wood = new BlockType((byte)17);
		
		assertTrue(standardwood.isA(wood));
	}
}
