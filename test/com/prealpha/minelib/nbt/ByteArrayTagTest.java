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

package com.prealpha.minelib.nbt;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.prealpha.minelib.nbt.Tag.Type;

public final class ByteArrayTagTest {
	private ByteArrayTag empty;

	private ByteArrayTag bytes;

	@Before
	public void setUp() {
		empty = new ByteArrayTag(new byte[] {});
		bytes = new ByteArrayTag(new byte[] { (byte) 0xd8, 0x30, 0x43, 0x1e });
	}

	@Test
	public void testGetTagType() {
		assertEquals(Type.BYTE_ARRAY, empty.getTagType());
		assertEquals(Type.BYTE_ARRAY, bytes.getTagType());
	}

	@Test
	public void testToBytes() {
		assertArrayEquals(new byte[] { 0x00, 0x00, 0x00, 0x00 }, empty
				.toBytes().array());
		assertArrayEquals(new byte[] { 0x00, 0x00, 0x00, 0x04, (byte) 0xd8,
				0x30, 0x43, 0x1e }, bytes.toBytes().array());
	}
}
