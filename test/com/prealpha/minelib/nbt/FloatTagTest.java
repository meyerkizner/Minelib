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

public final class FloatTagTest {
	private FloatTag positiveZero;

	private FloatTag negativeZero;

	private FloatTag positiveInfinity;

	private FloatTag negativeInfinity;

	private FloatTag nan;

	private FloatTag large;

	private FloatTag small;

	private FloatTag negative;

	@Before
	public void setUp() {
		positiveZero = new FloatTag(0.f);
		negativeZero = new FloatTag(-0.f);
		positiveInfinity = new FloatTag(Float.POSITIVE_INFINITY);
		negativeInfinity = new FloatTag(Float.NEGATIVE_INFINITY);
		nan = new FloatTag(Float.NaN);
		large = new FloatTag(Float.MAX_VALUE);
		small = new FloatTag(Float.MIN_VALUE);
		negative = new FloatTag(-1.5f);
	}

	@Test
	public void testGetTagType() {
		assertEquals(Type.FLOAT, positiveZero.getTagType());
		assertEquals(Type.FLOAT, negativeZero.getTagType());
		assertEquals(Type.FLOAT, positiveInfinity.getTagType());
		assertEquals(Type.FLOAT, negativeInfinity.getTagType());
		assertEquals(Type.FLOAT, nan.getTagType());
		assertEquals(Type.FLOAT, large.getTagType());
		assertEquals(Type.FLOAT, small.getTagType());
		assertEquals(Type.FLOAT, negative.getTagType());
	}

	@Test
	public void testGetValue() {
		assertEquals(0.f, positiveZero.getValue(), 0);
		assertEquals(-0.f, negativeZero.getValue(), 0);
		assertEquals(Float.POSITIVE_INFINITY, positiveInfinity.getValue(), 0);
		assertEquals(Float.NEGATIVE_INFINITY, negativeInfinity.getValue(), 0);
		assertEquals(Float.NaN, nan.getValue(), 0);
		assertEquals(Float.MAX_VALUE, large.getValue(), 0);
		assertEquals(Float.MIN_VALUE, small.getValue(), 0);
		assertEquals(-1.5f, negative.getValue(), 0);
	}

	@Test
	public void testToBytes() {
		assertArrayEquals(new byte[] { 0x00, 0x00, 0x00, 0x00 }, positiveZero
				.toBytes().array());
		assertArrayEquals(new byte[] { (byte) 0x80, 0x00, 0x00, 0x00 },
				negativeZero.toBytes().array());
		assertArrayEquals(new byte[] { 0x7f, (byte) 0x80, 0x00, 0x00 },
				positiveInfinity.toBytes().array());
		assertArrayEquals(new byte[] { (byte) 0xff, (byte) 0x80, 0x00, 0x00 },
				negativeInfinity.toBytes().array());
		assertArrayEquals(new byte[] { 0x7f, (byte) 0xc0, 0x00, 0x00 }, nan
				.toBytes().array());
		assertArrayEquals(new byte[] { 0x7f, 0x7f, (byte) 0xff, (byte) 0xff },
				large.toBytes().array());
		assertArrayEquals(new byte[] { 0x00, 0x00, 0x00, 0x01 }, small
				.toBytes().array());
		assertArrayEquals(new byte[] { (byte) 0xbf, (byte) 0xc0, 0x00, 0x00 },
				negative.toBytes().array());
	}
}
