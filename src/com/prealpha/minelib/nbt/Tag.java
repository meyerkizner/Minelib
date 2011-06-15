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

import com.google.common.base.Function;

public abstract class Tag {
	public static final Function<Tag, ByteBuffer> ENCODER = new Function<Tag, ByteBuffer>() {
		@Override
		public ByteBuffer apply(Tag input) {
			return input.toBytes();
		}
	};

	public static enum Type {
		BYTE,

		SHORT,

		INT,

		LONG,

		FLOAT,

		DOUBLE,

		BYTE_ARRAY,

		STRING,

		LIST,

		COMPOUND;

		byte getBinaryType() {
			return (byte) (ordinal() + 1);
		}

		static Type fromBinaryType(byte binaryType) {
			return values()[binaryType - 1];
		}
	}

	Tag() {
	}

	public abstract Type getTagType();

	public abstract Object getValue();

	public abstract ByteBuffer toBytes();

	@Override
	public String toString() {
		return getValue().toString();
	}
}
