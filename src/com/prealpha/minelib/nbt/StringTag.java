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

import static com.google.common.base.Preconditions.*;

import java.nio.ByteBuffer;

import com.google.common.base.Charsets;

public final class StringTag extends Tag {
	private final String value;

	/*
	 * TODO: decoding and then encoding again will hurt performance
	 */
	public StringTag(String value) {
		int byteLength = value.getBytes(Charsets.UTF_8).length;
		checkArgument(byteLength <= Short.MAX_VALUE);
		this.value = value;
	}

	@Override
	public Type getTagType() {
		return Type.STRING;
	}

	@Override
	public String getValue() {
		return value;
	}

	@Override
	public ByteBuffer toBytes() {
		byte[] bytes = value.getBytes(Charsets.UTF_8);
		ByteBuffer payload = ByteBuffer.allocate(bytes.length + 2);
		payload.putShort((short) bytes.length);
		payload.put(bytes);
		payload.position(0);
		return payload;
	}
}
