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
import static org.junit.Assert.*;

public class BlockTypeTest {
	@Test 
	public void testEquals(){
		BlockType wood = new BlockType((byte)17);
		//check to see if wood is equal to itself
		assertEquals(wood,wood);
		
		BlockType whiteWool = new BlockType((byte)35,(byte)0);
		BlockType orangeWool = new BlockType((byte)35,(byte)1);
		//make sure that white wool is not the same as orange wool
		assertFalse(whiteWool.equals(orangeWool));
	}
	
	@Test
	public void testSimilar(){
		BlockType whiteWool = new BlockType((byte)35,(byte)0);
		BlockType orangeWool = new BlockType((byte)35,(byte)1);
		//make sure that they are similar
		assertTrue(whiteWool.isSimilar(orangeWool));
	}
}
