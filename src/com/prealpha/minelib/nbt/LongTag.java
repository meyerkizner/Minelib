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

import com.google.common.primitives.Longs;

public final class LongTag extends NumericTag {
	private final long value;

	public LongTag(long value) {
		this.value = value;
	}

	@Override
	public Type getTagType() {
		return Type.LONG;
	}

	@Override
	public Long getValue() {
		return value;
	}

	@Override
	public ByteBuffer toBytes() {
		return ByteBuffer.wrap(Longs.toByteArray(value));
	}
}
