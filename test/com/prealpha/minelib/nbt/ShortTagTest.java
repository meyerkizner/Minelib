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

public final class ShortTagTest {
	private ShortTag zero;

	private ShortTag positive;

	private ShortTag negative;

	@Before
	public void setUp() {
		zero = new ShortTag((short) 0);
		positive = new ShortTag(Short.MAX_VALUE);
		negative = new ShortTag(Short.MIN_VALUE);
	}

	@Test
	public void testGetTagType() {
		assertEquals(Type.SHORT, zero.getTagType());
		assertEquals(Type.SHORT, positive.getTagType());
		assertEquals(Type.SHORT, negative.getTagType());
	}

	@Test
	public void testGetValue() {
		assertEquals(0, (short) zero.getValue());
		assertEquals(Short.MAX_VALUE, (short) positive.getValue());
		assertEquals(Short.MIN_VALUE, (short) negative.getValue());
	}

	@Test
	public void testToBytes() {
		assertArrayEquals(new byte[] { 0x00, 0x00 }, zero.toBytes().array());
		assertArrayEquals(new byte[] { 0x7f, (byte) 0xff }, positive.toBytes()
				.array());
		assertArrayEquals(new byte[] { (byte) 0x80, 0x00 }, negative.toBytes()
				.array());
	}
}
