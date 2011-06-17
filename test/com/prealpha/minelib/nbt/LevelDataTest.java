/*
 * MineLib, a Minecraft library
 * Copyright (C) 2011 Ty Overby
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

package com.prealpha.minelib.nbt;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.zip.GZIPInputStream;

import org.junit.Before;
import org.junit.Test;

import com.google.common.io.ByteStreams;

public final class LevelDataTest {
	private NbtDecoder decoder;
	
	private final ByteBuffer data;
	
	public LevelDataTest() throws IOException {
		InputStream stream = getClass().getResourceAsStream("level.dat");
		GZIPInputStream gis = new GZIPInputStream(stream);
		data = ByteBuffer.wrap(ByteStreams.toByteArray(gis));
		gis.close();
		stream.close();
	}

	@Before
	public void setUp() {
		decoder = new NbtDecoder();
	}

	@Test
	public void testLevelData() {
		RootTag root = decoder.apply(data);
		//get the compound tag representing the player
		CompoundTag playerCompoundTag = (CompoundTag)((CompoundTag)root.getValue().getValue().get("Data")).getValue().get("Player");
		//makes sure that it is 20 (the value in the file)
		assertEquals((short)20,playerCompoundTag.getValue().get("Health").getValue());
		//set it equal to 10 now
		playerCompoundTag.getValue().put("Health",new ShortTag((short) 10));
		//check to see if the object now contains 10
		assertEquals((short)10,playerCompoundTag.getValue().get("Health").getValue());
		
		//make a new root tag out of the old bytes to see if the values transfer over
		RootTag newRoot = decoder.apply(root.toBytes());
		//reassign the player compound tag to the new one
		playerCompoundTag = (CompoundTag)((CompoundTag)newRoot.getValue().getValue().get("Data")).getValue().get("Player");
		//see if the value carried over
		assertEquals((short)10,playerCompoundTag.getValue().get("Health").getValue());
	}
}
