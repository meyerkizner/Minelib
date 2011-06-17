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

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

import org.junit.Before;
import org.junit.Test;

import com.google.common.io.ByteStreams;
import com.prealpha.minelib.nbt.Tag.Type;

public final class NbtDecoderTest {
	private NbtDecoder decoder;

	private final ByteBuffer data;

	private RootTag root;

	private Map<String, Tag> valueMap;

	public NbtDecoderTest() throws IOException {
		InputStream stream = getClass().getResourceAsStream("bigtest.nbt");
		GZIPInputStream gis = new GZIPInputStream(stream);
		data = ByteBuffer.wrap(ByteStreams.toByteArray(gis));
		gis.close();
		stream.close();
	}

	@Before
	public void setUp() {
		decoder = new NbtDecoder();
		root = decoder.apply(data);
		valueMap = root.getValue().getValue();
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
