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
import java.util.zip.GZIPInputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.common.io.ByteStreams;

public final class GZipTest {
	private InputStream fileStream;

	@Before
	public void setUp() throws IOException {
		// new random access file in read-only mode
		fileStream = getClass().getResourceAsStream("test.nbt");
	}

	@After
	public void tearDown() throws IOException {
		if (fileStream != null) {
			fileStream.close();
		}
	}

	@Test
	public void testGzip() throws IOException {
		byte[] data = ByteStreams.toByteArray(new GZIPInputStream(fileStream));
		assertEquals(data[0], 0x0a); // first byte is 10
		assertEquals(data[1], 0x00); // second byte is 0
		assertEquals(data[2], 0x0b); // third byte is 11
	}
}
