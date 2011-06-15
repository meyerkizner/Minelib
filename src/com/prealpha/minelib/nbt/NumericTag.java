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

/*
 * TODO: maybe this should be an abstract class with six subclasses?
 */
public final class NumericTag extends Tag {
	private final Type tagType;

	private final Number value;

	public NumericTag(byte value) {
		tagType = Type.BYTE;
		this.value = value;
	}

	public NumericTag(short value) {
		tagType = Type.SHORT;
		this.value = value;
	}

	public NumericTag(int value) {
		tagType = Type.INT;
		this.value = value;
	}

	public NumericTag(long value) {
		tagType = Type.LONG;
		this.value = value;
	}

	public NumericTag(float value) {
		tagType = Type.FLOAT;
		this.value = value;
	}

	public NumericTag(double value) {
		tagType = Type.DOUBLE;
		this.value = value;
	}

	@Override
	public Type getTagType() {
		return tagType;
	}

	@Override
	public Number getValue() {
		return value;
	}

	@Override
	public ByteBuffer toBytes() {
		int length;
		switch (tagType) {
		case BYTE: length = 1; break;
		case SHORT: length = 2; break;
		case INT: case FLOAT: length = 4; break;
		case LONG: case DOUBLE: length = 8; break;
		default: throw new IllegalStateException();
		}

		ByteBuffer payload = ByteBuffer.allocate(length);
		switch (tagType) {
		case BYTE: payload.put(value.byteValue()); break;
		case SHORT: payload.putShort(value.shortValue()); break;
		case INT: payload.putInt(value.intValue()); break;
		case LONG: payload.putLong(value.longValue()); break;
		case FLOAT: payload.putFloat(value.floatValue()); break;
		case DOUBLE: payload.putDouble(value.doubleValue()); break;
		default: throw new IllegalStateException();
		}
		payload.position(0);
		return payload;
	}
}
