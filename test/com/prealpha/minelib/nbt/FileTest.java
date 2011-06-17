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
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.junit.Before;
import org.junit.Test;

import com.google.common.io.ByteStreams;

/*
 * Verifies the integrity of the test files. When a test fails, we'll know if
 * this is the problem immediately.
 */
public final class FileTest {
	private MessageDigest digest;

	@Before
	public void setUp() throws NoSuchAlgorithmException {
		digest = MessageDigest.getInstance("SHA-256");
	}

	@Test
	public void checkTestNbt() throws IOException {
		InputStream stream = getClass().getResourceAsStream("test.nbt");
		byte[] data = ByteStreams.toByteArray(stream);
		assertEquals(
				"8ce8cd785334bf9736d7e69b00c69238eff88ab6bd471c8e0a743e382223606d",
				digest(data));
		stream.close();
	}

	@Test
	public void checkBigtestNbt() throws IOException {
		InputStream stream = getClass().getResourceAsStream("bigtest.nbt");
		byte[] data = ByteStreams.toByteArray(stream);
		assertEquals(
				"43629bb139ff0ed46e8dd24f7abbcacf0bc9deededb055d8105b3056ca3fc8df",
				digest(data));
		stream.close();
	}

	@Test
	public void checkLevelDat() throws IOException {
		InputStream stream = getClass().getResourceAsStream("level.dat");
		byte[] data = ByteStreams.toByteArray(stream);
		assertEquals(
				"a7ada83978ce522c17e8e21f405759b9eda1399540858fdbae5bc03e2717e2fa",
				digest(data));
		stream.close();
	}

	private String digest(byte[] data) {
		byte[] digest = this.digest.digest(data);
		String str = "";
		for (byte b : digest) {
			if (b >= 0 && b < 16) {
				str += '0';
			}
			str += Integer.toHexString(b & 0xff);
		}
		return str;
	}
}
