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

public final class RootTag extends Tag {
	private final StringTag name;

	private final CompoundTag value;

	public RootTag(StringTag name, CompoundTag value) {
		checkNotNull(name);
		checkNotNull(value);
		this.name = name;
		this.value = value;
	}

	@Override
	public Type getTagType() {
		return Type.COMPOUND;
	}

	public StringTag getName() {
		return name;
	}

	@Override
	public CompoundTag getValue() {
		return value;
	}

	@Override
	public ByteBuffer toBytes() {
		ByteBuffer nameBytes = name.toBytes();
		ByteBuffer payload = value.toBytes();
		int length = nameBytes.capacity() + payload.capacity() + 1;
		ByteBuffer result = ByteBuffer.allocate(length);
		result.put(getTagType().getBinaryType());
		result.put(nameBytes);
		result.put(payload);
		result.position(0);
		return result;
	}

	@Override
	public String toString() {
		return name.toString() + '=' + super.toString();
	}
}
