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
import com.google.common.base.Function;
import com.prealpha.minelib.nbt.Tag.Type;

public final class NbtDecoder implements Function<ByteBuffer, RootTag> {
	public NbtDecoder() {
	}

	@Override
	public RootTag apply(ByteBuffer input) {
		byte binaryType = input.get();
		Type tagType = Type.fromBinaryType(binaryType);
		checkArgument(tagType == Type.COMPOUND);
		StringTag name = (StringTag) decodeSimple(Type.STRING, input);
		return new RootTag(name, decodeCompound(input));
	}

	private static Tag decodeSimple(Type tagType, ByteBuffer payload) {
		switch (tagType) {
		case BYTE:
			return new ByteTag(payload.get());
		case SHORT:
			return new ShortTag(payload.getShort());
		case INT:
			return new IntTag(payload.getInt());
		case LONG:
			return new LongTag(payload.getLong());
		case FLOAT:
			return new FloatTag(payload.getFloat());
		case DOUBLE:
			return new DoubleTag(payload.getDouble());
		case BYTE_ARRAY:
			int arrayLength = payload.getInt();
			byte[] arrayBytes = new byte[arrayLength];
			payload.get(arrayBytes);
			return new ByteArrayTag(arrayBytes);
		case STRING:
			short stringLength = payload.getShort();
			byte[] stringBytes = new byte[stringLength];
			payload.get(stringBytes);
			return new StringTag(new String(stringBytes, Charsets.UTF_8));
		case LIST:
			Type elementType = Type.fromBinaryType(payload.get());
			int listLength = payload.getInt();
			ListTag result = new ListTag(elementType);
			for (int i = 0; i < listLength; i++) {
				Tag tag;
				if (elementType == Type.COMPOUND) {
					tag = decodeCompound(payload);
				} else {
					tag = decodeSimple(elementType, payload);
				}
				result.getValue().add(tag);
			}
			return result;
		default:
			throw new IllegalArgumentException();
		}
	}

	private static CompoundTag decodeCompound(ByteBuffer payload) {
		CompoundTag result = new CompoundTag();
		boolean finished = false;
		while (!finished) {
			byte binaryType = payload.get();
			if (binaryType != 0) {
				Type tagType = Type.fromBinaryType(binaryType);
				StringTag name = (StringTag) decodeSimple(Type.STRING, payload);
				Tag tag;
				if (tagType == Type.COMPOUND) {
					tag = decodeCompound(payload);
				} else {
					tag = decodeSimple(tagType, payload);
				}
				result.getValue().put(name.getValue(), tag);
			} else {
				finished = true;
			}
		}
		return result;
	}
}
