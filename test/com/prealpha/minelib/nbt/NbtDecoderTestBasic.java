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
import java.util.Map;
import java.util.zip.GZIPInputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.common.io.ByteStreams;

public final class NbtDecoderTestBasic {
	/*
	 * test.nbt compressed bytes
	 */
	private static final byte[] DATA = new byte[] { 0x1f, (byte) 0x8b, 0x08,
			0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, (byte) 0xe3, 0x62,
			(byte) 0xe0, (byte) 0xce, 0x48, (byte) 0xcd, (byte) 0xc9,
			(byte) 0xc9, 0x57, 0x28, (byte) 0xcf, 0x2f, (byte) 0xca, 0x49,
			(byte) 0xe1, 0x60, 0x60, (byte) 0xc9, 0x4b, (byte) 0xcc, 0x4d,
			0x65, (byte) 0xe0, 0x74, 0x4a, (byte) 0xcc, 0x4b, (byte) 0xcc,
			0x2b, 0x4a, (byte) 0xcc, 0x4d, 0x64, 0x00, 0x00, 0x77, (byte) 0xda,
			0x5c, 0x3a, 0x21, 0x00, 0x00, 0x00 };

	private final NbtDecoder decoder;

	private ByteBuffer data;

	public NbtDecoderTestBasic() {
		decoder = new NbtDecoder();
	}

	@Before
	public void setUp() throws IOException {
		ByteArrayInputStream bis = new ByteArrayInputStream(DATA);
		GZIPInputStream gis = new GZIPInputStream(bis);
		data = ByteBuffer.wrap(ByteStreams.toByteArray(gis));
		gis.close();
		bis.close();
	}
	
	@After
	public void tearDown() {
		data = null;
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
