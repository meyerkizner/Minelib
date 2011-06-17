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
import java.util.Map;
import java.util.zip.GZIPInputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.common.io.ByteStreams;

public final class NbtDecoderTestBasic {
	private NbtDecoder decoder;

	private final ByteBuffer data;

	public NbtDecoderTestBasic() throws IOException {
		InputStream stream = getClass().getResourceAsStream("test.nbt");
		GZIPInputStream gis = new GZIPInputStream(stream);
		data = ByteBuffer.wrap(ByteStreams.toByteArray(gis));
		gis.close();
		stream.close();
	}

	@Before
	public void setUp() {
		decoder = new NbtDecoder();
	}

	@After
	public void tearDown() {
		decoder = null;
	}

	@Test
	public void testApply() {
		RootTag root = decoder.apply(data);
		assertNotNull(root);

		StringTag nameTag = root.getName();
		String name = nameTag.getValue();
		assertEquals("hello world", name);

		CompoundTag value = root.getValue();
		Map<String, Tag> valueMap = value.getValue();
		assertEquals(1, valueMap.size());
		assertTrue(valueMap.containsKey("name"));
		Tag contents = valueMap.get("name");
		assertTrue(contents instanceof StringTag);
		String contentsStr = ((StringTag) contents).getValue();
		assertEquals("Bananrama", contentsStr);
	}
}
