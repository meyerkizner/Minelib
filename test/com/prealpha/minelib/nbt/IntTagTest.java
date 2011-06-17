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

public final class IntTagTest {
	private IntTag zero;

	private IntTag positive;

	private IntTag negative;

	@Before
	public void setUp() {
		zero = new IntTag(0);
		positive = new IntTag(Integer.MAX_VALUE);
		negative = new IntTag(Integer.MIN_VALUE);
	}

	@Test
	public void testGetTagType() {
		assertEquals(Type.INT, zero.getTagType());
		assertEquals(Type.INT, positive.getTagType());
		assertEquals(Type.INT, negative.getTagType());
	}

	@Test
	public void testGetValue() {
		assertEquals(0, (int) zero.getValue());
		assertEquals(Integer.MAX_VALUE, (int) positive.getValue());
		assertEquals(Integer.MIN_VALUE, (int) negative.getValue());
	}

	@Test
	public void testToBytes() {
		assertArrayEquals(new byte[] { 0x00, 0x00, 0x00, 0x00 }, zero.toBytes()
				.array());
		assertArrayEquals(new byte[] { 0x7f, (byte) 0xff, (byte) 0xff,
				(byte) 0xff }, positive.toBytes().array());
		assertArrayEquals(new byte[] { (byte) 0x80, 0x00, 0x00, 0x00 },
				negative.toBytes().array());
	}
}
