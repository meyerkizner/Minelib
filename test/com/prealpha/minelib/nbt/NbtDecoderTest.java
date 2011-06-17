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

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.common.io.ByteStreams;
import com.prealpha.minelib.nbt.Tag.Type;

public final class NbtDecoderTest {
	/*
	 * bigtest.nbt compressed bytes
	 */
	private static final byte[] DATA = new byte[] { 0x1f, (byte) 0x8b, 0x08,
			0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, (byte) 0xed, 0x54,
			(byte) 0xcf, 0x4f, 0x1a, 0x41, 0x14, 0x7e, (byte) 0xc2, 0x02,
			(byte) 0xcb, (byte) 0x96, (byte) 0x82, (byte) 0xb1, (byte) 0xc4,
			0x10, 0x63, (byte) 0xcc, (byte) 0xab, (byte) 0xb5, (byte) 0x84,
			(byte) 0xa5, (byte) 0xdb, (byte) 0xcd, 0x42, 0x11, (byte) 0x89,
			(byte) 0xb1, (byte) 0x88, 0x16, 0x2c, (byte) 0x9a, 0x0d, 0x1a,
			(byte) 0xd8, (byte) 0xa8, 0x31, (byte) 0x86, (byte) 0xb8, 0x2b,
			(byte) 0xc3, (byte) 0x82, 0x2e, (byte) 0xbb, 0x66, 0x77,
			(byte) 0xb0, (byte) 0xf1, (byte) 0xd4, 0x4b, 0x7b, 0x6c, 0x7a,
			(byte) 0xeb, 0x3f, (byte) 0xd3, 0x23, 0x7f, 0x43, (byte) 0xcf,
			(byte) 0xbd, (byte) 0xf6, (byte) 0xbf, (byte) 0xa0, (byte) 0xc3,
			0x2f, 0x7b, 0x69, (byte) 0xcf, (byte) 0xbd, (byte) 0xf0, 0x32,
			(byte) 0xc9, (byte) 0xf7, (byte) 0xe6, (byte) 0xbd, 0x6f,
			(byte) 0xe6, 0x7b, 0x6f, 0x26, 0x79, 0x02, 0x04, 0x54, 0x72, 0x4f,
			0x2c, 0x0e, 0x78, (byte) 0xcb, (byte) 0xb1, 0x4d, (byte) 0x8d,
			0x78, (byte) 0xf4, (byte) 0xe3, 0x70, 0x62, 0x3e, 0x08, 0x7b, 0x1d,
			(byte) 0xc7, (byte) 0xa5, (byte) 0x93, 0x18, 0x0f, (byte) 0x82,
			0x47, (byte) 0xdd, (byte) 0xee, (byte) 0x84, 0x02, 0x62,
			(byte) 0xb5, (byte) 0xa2, (byte) 0xaa, (byte) 0xc7, 0x78, 0x76,
			0x5c, 0x57, (byte) 0xcb, (byte) 0xa8, 0x55, 0x0f, 0x1b,
			(byte) 0xc8, (byte) 0xd6, 0x1e, 0x6a, (byte) 0x95, (byte) 0x86,
			(byte) 0x86, 0x0d, (byte) 0xad, 0x7e, 0x58, 0x7b, (byte) 0x8f,
			(byte) 0x83, (byte) 0xcf, (byte) 0x83, 0x4f, (byte) 0x83, 0x6f,
			(byte) 0xcf, 0x03, 0x10, 0x6e, 0x5b, (byte) 0x8e, 0x3e,
			(byte) 0xbe, (byte) 0xa5, 0x38, 0x4c, 0x64, (byte) 0xfd, 0x10,
			(byte) 0xea, (byte) 0xda, 0x74, (byte) 0xa6, 0x23, 0x40,
			(byte) 0xdc, 0x66, 0x2e, 0x69, (byte) 0xe1, (byte) 0xb5,
			(byte) 0xd3, (byte) 0xbb, 0x73, (byte) 0xfa, 0x76, 0x0b, 0x29,
			(byte) 0xdb, 0x0b, (byte) 0xe0, (byte) 0xef, (byte) 0xe8, 0x3d,
			0x1e, 0x38, 0x5b, (byte) 0xef, 0x11, 0x08, 0x56, (byte) 0xf5,
			(byte) 0xde, 0x5d, (byte) 0xdf, 0x0b, 0x40, (byte) 0xe0, 0x5e,
			(byte) 0xb7, (byte) 0xfa, 0x64, (byte) 0xb7, 0x04, 0x00,
			(byte) 0x8c, 0x41, 0x4c, 0x73, (byte) 0xc6, 0x08, 0x55, 0x4c,
			(byte) 0xd3, 0x20, 0x2e, 0x7d, (byte) 0xa4, (byte) 0xc0,
			(byte) 0xc8, (byte) 0xc2, 0x10, (byte) 0xb3, (byte) 0xba,
			(byte) 0xde, 0x58, 0x0b, 0x53, (byte) 0xa3, (byte) 0xee, 0x44,
			(byte) 0x8e, 0x45, 0x03, 0x30, (byte) 0xb1, 0x27, 0x53,
			(byte) 0x8c, 0x4c, (byte) 0xf1, (byte) 0xe9, 0x14, (byte) 0xa3,
			0x53, (byte) 0x8c, (byte) 0x85, (byte) 0xe1, (byte) 0xd9,
			(byte) 0x9f, (byte) 0xe3, (byte) 0xb3, (byte) 0xf2, 0x44,
			(byte) 0x81, (byte) 0xa5, 0x7c, 0x33, (byte) 0xdd, (byte) 0xd8,
			(byte) 0xbb, (byte) 0xc7, (byte) 0xaa, 0x75, 0x13, 0x5f, 0x28,
			0x1c, 0x08, (byte) 0xd7, 0x2e, (byte) 0xd1, 0x59, 0x3f,
			(byte) 0xaf, 0x1d, 0x1b, 0x60, 0x21, 0x59, (byte) 0xdf,
			(byte) 0xfa, (byte) 0xf1, 0x05, (byte) 0xfe, (byte) 0xc1,
			(byte) 0xce, (byte) 0xfc, (byte) 0x9d, (byte) 0xbd, 0x00,
			(byte) 0xbc, (byte) 0xf1, 0x40, (byte) 0xc9, (byte) 0xf8,
			(byte) 0x85, 0x42, 0x40, 0x46, (byte) 0xfe, (byte) 0x9e,
			(byte) 0xeb, (byte) 0xea, 0x0f, (byte) 0x93, 0x3a, 0x68,
			(byte) 0x87, 0x60, (byte) 0xbb, (byte) 0xeb, 0x32, 0x37,
			(byte) 0xa3, 0x28, 0x0a, (byte) 0x8e, (byte) 0xbb, (byte) 0xf5,
			(byte) 0xd0, 0x69, 0x63, (byte) 0xca, 0x4e, (byte) 0xdb,
			(byte) 0xe9, (byte) 0xec, (byte) 0xe6, (byte) 0xe6, 0x2b, 0x3b,
			(byte) 0xbd, 0x25, (byte) 0xbe, 0x64, 0x49, 0x09, 0x3d,
			(byte) 0xaa, (byte) 0xbb, (byte) 0x94, (byte) 0xfd, 0x18, 0x7e,
			(byte) 0xe8, (byte) 0xd2, 0x0e, (byte) 0xda, 0x6f, 0x15, 0x4c,
			(byte) 0xb1, 0x68, 0x3e, 0x2b, (byte) 0xe1, (byte) 0x9b,
			(byte) 0x9c, (byte) 0x84, (byte) 0x99, (byte) 0xbc, (byte) 0x84,
			0x05, 0x09, 0x65, 0x59, 0x16, 0x45, 0x00, (byte) 0xff, 0x2f, 0x28,
			(byte) 0xae, 0x2f, (byte) 0xf2, (byte) 0xc2, (byte) 0xb2,
			(byte) 0xa4, 0x2e, 0x1d, 0x20, 0x77, 0x5a, 0x3b, (byte) 0xb9,
			(byte) 0x8c, (byte) 0xca, (byte) 0xe7, 0x29, (byte) 0xdf, 0x51,
			0x41, (byte) 0xc9, 0x16, (byte) 0xb5, (byte) 0xc5, 0x6d,
			(byte) 0xa1, 0x2a, (byte) 0xad, 0x2c, (byte) 0xc5, 0x31, 0x7f,
			(byte) 0xba, 0x7a, (byte) 0x92, (byte) 0x8e, 0x5e, (byte) 0x9d,
			0x5f, (byte) 0xf8, 0x12, 0x05, 0x23, 0x1b, (byte) 0xd1,
			(byte) 0xf6, (byte) 0xb7, 0x77, (byte) 0xaa, (byte) 0xcd,
			(byte) 0x95, 0x72, (byte) 0xbc, (byte) 0x9e, (byte) 0xdf, 0x58,
			0x5d, 0x4b, (byte) 0x97, (byte) 0xae, (byte) 0x92, 0x17,
			(byte) 0xb9, 0x44, (byte) 0xd0, (byte) 0x80, (byte) 0xc8,
			(byte) 0xfa, 0x3e, (byte) 0xbf, (byte) 0xb3, (byte) 0xdc, 0x54,
			(byte) 0xcb, 0x07, 0x75, 0x6e, (byte) 0xa3, (byte) 0xb6, 0x76,
			0x59, (byte) 0x92, (byte) 0x93, (byte) 0xa9, (byte) 0xdc, 0x51,
			0x50, (byte) 0x99, 0x6b, (byte) 0xcc, 0x35, (byte) 0xe6, 0x1a,
			(byte) 0xff, 0x57, 0x23, 0x08, 0x42, (byte) 0xcb, (byte) 0xe9,
			0x1b, (byte) 0xd6, 0x78, (byte) 0xc2, (byte) 0xec, (byte) 0xfe,
			(byte) 0xfc, 0x7a, (byte) 0xfb, 0x7d, 0x78, (byte) 0xd3,
			(byte) 0x84, (byte) 0xdf, (byte) 0xd4, (byte) 0xf2, (byte) 0xa4,
			(byte) 0xfb, 0x08, 0x06, 0x00, 0x00 };

	private final NbtDecoder decoder;

	private ByteBuffer data;
	
	private RootTag root;
	
	private Map<String, Tag> valueMap;

	public NbtDecoderTest() {
		decoder = new NbtDecoder();
	}

	@Before
	public void setUp() throws IOException {
		ByteArrayInputStream bis = new ByteArrayInputStream(DATA);
		GZIPInputStream gis = new GZIPInputStream(bis);
		data = ByteBuffer.wrap(ByteStreams.toByteArray(gis));
		gis.close();
		bis.close();
		
		root = decoder.apply(data);
		valueMap = root.getValue().getValue();
	}

	@After
	public void tearDown() {
		data = null;
		root = null;
		valueMap = null;
	}

	@Test
	public void testRoot() {
		assertNotNull(root);

		StringTag nameTag = root.getName();
		String name = nameTag.getValue();
		assertEquals("Level", name);

		assertEquals(11, valueMap.size());
	}
	
	@Test
	public void testByte() {
		assertTrue(valueMap.containsKey("byteTest"));
		Tag byteTag = valueMap.get("byteTest");
		assertTrue(byteTag instanceof ByteTag);
		byte byteValue = ((ByteTag) byteTag).getValue();
		assertEquals(127, byteValue);
	}
	
	@Test
	public void testShort() {
		assertTrue(valueMap.containsKey("shortTest"));
		Tag shortTag = valueMap.get("shortTest");
		assertTrue(shortTag instanceof ShortTag);
		short shortValue = ((ShortTag) shortTag).getValue();
		assertEquals(32767, shortValue);
	}
	
	@Test
	public void testInt() {
		assertTrue(valueMap.containsKey("intTest"));
		Tag intTag = valueMap.get("intTest");
		assertTrue(intTag instanceof IntTag);
		int intValue = ((IntTag) intTag).getValue();
		assertEquals(2147483647, intValue);
	}
	
	@Test
	public void testLong() {
		assertTrue(valueMap.containsKey("longTest"));
		Tag longTag = valueMap.get("longTest");
		assertTrue(longTag instanceof LongTag);
		long longValue = ((LongTag) longTag).getValue();
		assertEquals(9223372036854775807L, longValue);
	}
	
	@Test
	public void testFloat() {
		assertTrue(valueMap.containsKey("floatTest"));
		Tag floatTag = valueMap.get("floatTest");
		assertTrue(floatTag instanceof FloatTag);
		float floatValue = ((FloatTag) floatTag).getValue();
		assertEquals(0.49823147f, floatValue, 0);
	}
	
	@Test
	public void testDouble() {
		assertTrue(valueMap.containsKey("doubleTest"));
		Tag doubleTag = valueMap.get("doubleTest");
		assertTrue(doubleTag instanceof DoubleTag);
		double doubleValue = ((DoubleTag) doubleTag).getValue();
		assertEquals(0.4931287132182315, doubleValue, 0);
	}

	@Test
	public void testByteArray() {
		final String KEY = "byteArrayTest (the first 1000 values of (n*n*255+n*7)%100, starting with n=0 (0, 62, 34, 16, 8, ...))";
		assertTrue(valueMap.containsKey(KEY));
		Tag byteArrayTag = valueMap.get(KEY);
		assertTrue(byteArrayTag instanceof ByteArrayTag);
		byte[] byteArray = ((ByteArrayTag) byteArrayTag).getValue();
		assertEquals(1000, byteArray.length);
		for (int n = 0; n < byteArray.length; n++) {
			assertEquals((n * n * 255 + n * 7) % 100, byteArray[n]);
		}
	}

	@Test
	public void testString() {
		assertTrue(valueMap.containsKey("stringTest"));
		Tag stringTag = valueMap.get("stringTest");
		assertTrue(stringTag instanceof StringTag);
		String str = ((StringTag) stringTag).getValue();
		assertEquals("HELLO WORLD THIS IS A TEST STRING ÅÄÖ!", str);
	}

	@Test
	public void testLongList() {
		assertTrue(valueMap.containsKey("listTest (long)"));
		Tag longListTag = valueMap.get("listTest (long)");
		assertTrue(longListTag instanceof ListTag);
		assertEquals(Type.LONG, ((ListTag) longListTag).getElementType());
		List<Tag> longList = ((ListTag) longListTag).getValue();
		assertEquals(5, longList.size());
		for (int i = 0; i < longList.size(); i++) {
			assertEquals(i + 11L, longList.get(i).getValue());
		}
	}

	@Test
	public void testCompoundList() {
		assertTrue(valueMap.containsKey("listTest (compound)"));
		Tag compoundListTag = valueMap.get("listTest (compound)");
		assertTrue(compoundListTag instanceof ListTag);
		assertEquals(Type.COMPOUND,
				((ListTag) compoundListTag).getElementType());
		List<Tag> compoundList = ((ListTag) compoundListTag).getValue();
		assertEquals(2, compoundList.size());

		Map<String, Tag> entry0 = ((CompoundTag) compoundList.get(0))
				.getValue();
		assertTrue(entry0.containsKey("name"));
		assertEquals("Compound tag #0", entry0.get("name").getValue());
		assertTrue(entry0.containsKey("created-on"));
		assertEquals(1264099775885L, entry0.get("created-on").getValue());

		Map<String, Tag> entry1 = ((CompoundTag) compoundList.get(1))
				.getValue();
		assertTrue(entry1.containsKey("name"));
		assertEquals("Compound tag #1", entry1.get("name").getValue());
		assertTrue(entry1.containsKey("created-on"));
		assertEquals(1264099775885L, entry1.get("created-on").getValue());
	}

	@Test
	public void testCompound() {
		assertTrue(valueMap.containsKey("nested compound test"));
		Tag compoundTag = valueMap.get("nested compound test");
		assertTrue(compoundTag instanceof CompoundTag);
		Map<String, Tag> compound = ((CompoundTag) compoundTag).getValue();
		assertEquals(2, compound.size());

		assertTrue(compound.containsKey("ham"));
		Map<String, Tag> entryHam = ((CompoundTag) compound.get("ham"))
				.getValue();
		assertTrue(entryHam.containsKey("name"));
		assertEquals("Hampus", entryHam.get("name").getValue());
		assertTrue(entryHam.containsKey("value"));
		assertEquals(0.75f, entryHam.get("value").getValue());

		assertTrue(compound.containsKey("egg"));
		Map<String, Tag> entryEgg = ((CompoundTag) compound.get("egg"))
				.getValue();
		assertTrue(entryEgg.containsKey("name"));
		assertEquals("Eggbert", entryEgg.get("name").getValue());
		assertTrue(entryEgg.containsKey("value"));
		assertEquals(0.5f, entryEgg.get("value").getValue());
	}
}
