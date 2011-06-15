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
import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.collect.Maps.EntryTransformer;

public final class CompoundTag extends Tag {
	private final Map<String, Tag> value;

	public CompoundTag() {
		value = Maps.newHashMap();
	}

	public CompoundTag(Map<? extends String, ? extends Tag> map) {
		value = Maps.newHashMap(map);
	}

	@Override
	public Type getTagType() {
		return Type.COMPOUND;
	}

	@Override
	public Map<String, Tag> getValue() {
		return value;
	}

	@Override
	public ByteBuffer toBytes() {
		// make copies to avoid encoding twice
		Map<String, ByteBuffer> nameBytes = ImmutableMap.copyOf(Maps
				.transformEntries(value,
						new EntryTransformer<String, Tag, ByteBuffer>() {
							@Override
							public ByteBuffer transformEntry(String key,
									Tag value) {
								return new StringTag(key).toBytes();
							}
						}));
		Map<String, ByteBuffer> payloadBytes = ImmutableMap.copyOf(Maps
				.transformValues(value, Tag.ENCODER));

		int length = 1; // for the null terminating byte
		for (ByteBuffer buffer : nameBytes.values()) {
			length += buffer.capacity() + 1; // add one for the tagType
		}
		for (ByteBuffer buffer : payloadBytes.values()) {
			length += buffer.capacity();
		}

		ByteBuffer payload = ByteBuffer.allocate(length);
		for (String name : value.keySet()) {
			payload.put(value.get(name).getTagType().getBinaryType());
			payload.put(nameBytes.get(name));
			payload.put(payloadBytes.get(name));
		}
		payload.put((byte) 0x00);
		payload.position(0);
		return payload;
	}
}
