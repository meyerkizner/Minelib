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

import org.junit.Test;

import com.google.common.io.ByteStreams;

public final class GZipTest {
	private final ByteBuffer data;

	public GZipTest() throws IOException {
		InputStream stream = getClass().getResourceAsStream("test.nbt");
		GZIPInputStream gis = new GZIPInputStream(stream);
		data = ByteBuffer.wrap(ByteStreams.toByteArray(gis));
		gis.close();
		stream.close();
	}

	@Test
	public void testGzip() {
		assertEquals(0x0a, data.get(0));
		assertEquals(0x00, data.get(1));
		assertEquals(0x0b, data.get(2));
	}
}
