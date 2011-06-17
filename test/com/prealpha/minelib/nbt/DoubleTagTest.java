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

public final class DoubleTagTest {
	private DoubleTag positiveZero;

	private DoubleTag negativeZero;

	private DoubleTag positiveInfinity;

	private DoubleTag negativeInfinity;

	private DoubleTag nan;

	private DoubleTag large;

	private DoubleTag small;

	private DoubleTag negative;

	@Before
	public void setUp() {
		positiveZero = new DoubleTag(0.);
		negativeZero = new DoubleTag(-0.);
		positiveInfinity = new DoubleTag(Double.POSITIVE_INFINITY);
		negativeInfinity = new DoubleTag(Double.NEGATIVE_INFINITY);
		nan = new DoubleTag(Double.NaN);
		large = new DoubleTag(Double.MAX_VALUE);
		small = new DoubleTag(Double.MIN_VALUE);
		negative = new DoubleTag(-1.5);
	}

	@Test
	public void testGetTagType() {
		assertEquals(Type.DOUBLE, positiveZero.getTagType());
		assertEquals(Type.DOUBLE, negativeZero.getTagType());
		assertEquals(Type.DOUBLE, positiveInfinity.getTagType());
		assertEquals(Type.DOUBLE, negativeInfinity.getTagType());
		assertEquals(Type.DOUBLE, nan.getTagType());
		assertEquals(Type.DOUBLE, large.getTagType());
		assertEquals(Type.DOUBLE, small.getTagType());
		assertEquals(Type.DOUBLE, negative.getTagType());
	}

	@Test
	public void testGetValue() {
		assertEquals(0., positiveZero.getValue(), 0);
		assertEquals(-0., negativeZero.getValue(), 0);
		assertEquals(Double.POSITIVE_INFINITY, positiveInfinity.getValue(), 0);
		assertEquals(Double.NEGATIVE_INFINITY, negativeInfinity.getValue(), 0);
		assertEquals(Double.NaN, nan.getValue(), 0);
		assertEquals(Double.MAX_VALUE, large.getValue(), 0);
		assertEquals(Double.MIN_VALUE, small.getValue(), 0);
		assertEquals(-1.5, negative.getValue(), 0);
	}

	@Test
	public void testToBytes() {
		assertArrayEquals(new byte[] { 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
				0x00, 0x00 }, positiveZero.toBytes().array());
		assertArrayEquals(new byte[] { (byte) 0x80, 0x00, 0x00, 0x00, 0x00,
				0x00, 0x00, 0x00 }, negativeZero.toBytes().array());
		assertArrayEquals(new byte[] { 0x7f, (byte) 0xf0, 0x00, 0x00, 0x00,
				0x00, 0x00, 0x00 }, positiveInfinity.toBytes().array());
		assertArrayEquals(new byte[] { (byte) 0xff, (byte) 0xf0, 0x00, 0x00,
				0x00, 0x00, 0x00, 0x00 }, negativeInfinity.toBytes().array());
		assertArrayEquals(new byte[] { 0x7f, (byte) 0xf8, 0x00, 0x00, 0x00,
				0x00, 0x00, 0x00 }, nan.toBytes().array());
		assertArrayEquals(
				new byte[] { 0x7f, (byte) 0xef, (byte) 0xff, (byte) 0xff,
						(byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff },
				large.toBytes().array());
		assertArrayEquals(new byte[] { 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
				0x00, 0x01 }, small.toBytes().array());
		assertArrayEquals(new byte[] { (byte) 0xbf, (byte) 0xf8, 0x00, 0x00,
				0x00, 0x00, 0x00, 0x00 }, negative.toBytes().array());
	}
}
