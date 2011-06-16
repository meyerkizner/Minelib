/*
 * MineLib, a Minecraft library
 * Copyright (C) 2011 Meyer Kizner
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

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.zip.GZIPInputStream;

import com.google.common.io.ByteStreams;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GZipTest {
	private RandomAccessFile file;
	private DataInputStream dis;

	@Before
	public void setUp() throws Exception {
		//new random access file in read-only mode
		file = new RandomAccessFile( new File("test.nbt"), "r");
	}

	@After
	public void tearDown() throws Exception {
		if(file != null){
			file.close();
		}
		if(dis != null){
			dis.close();
		}
	}

	@Test
	public void TestGzip() throws Exception {
		byte[] data = new byte[(int) file.length()];
		file.read(data);
		dis = new DataInputStream(new GZIPInputStream(new ByteArrayInputStream(data)));

		//reassign data to the decompressed version
		data = ByteStreams.toByteArray(dis);

		assertEquals(data[0],0x0a); //first byte is 10
		assertEquals(data[1],0x00); //seccond byte is 0
		assertEquals(data[2],0x0b); //third byte is 11
	}
}
