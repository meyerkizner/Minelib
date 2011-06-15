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

import java.nio.ByteBuffer;
import java.util.Arrays;

public final class ByteArrayTag extends Tag {
	private final byte[] value;

	public ByteArrayTag(byte[] value) {
		this.value = Arrays.copyOf(value, value.length);
	}

	@Override
	public Type getTagType() {
		return Type.BYTE_ARRAY;
	}

	@Override
	public byte[] getValue() {
		return value;
	}

	@Override
	public ByteBuffer toBytes() {
		ByteBuffer payload = ByteBuffer.allocate(value.length + 4);
		payload.putInt(value.length);
		payload.put(value);
		payload.position(0);
		return payload;
	}

	@Override
	public String toString() {
		return Arrays.toString(value);
	}
}
