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
import java.util.Collection;
import java.util.List;

import com.google.common.collect.Constraint;
import com.google.common.collect.Constraints;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

public final class ListTag extends Tag {
	private final List<Tag> value;

	private final Type elementType;

	public ListTag(Type elementType) {
		checkNotNull(elementType);
		this.elementType = elementType;
		List<Tag> baseList = Lists.newArrayList();
		Constraint<Tag> constraint = new TypeConstraint();
		value = Constraints.constrainedList(baseList, constraint);
	}

	public ListTag(Collection<? extends Tag> collection) {
		checkArgument(!collection.isEmpty());
		List<Tag> baseList = Lists.newArrayList(collection);
		elementType = baseList.get(0).getTagType();
		Constraint<Tag> constraint = new TypeConstraint();
		for (Tag tag : baseList) {
			constraint.checkElement(tag);
		}
		value = Constraints.constrainedList(baseList, constraint);
	}

	@Override
	public Type getTagType() {
		return Type.LIST;
	}

	@Override
	public List<Tag> getValue() {
		return value;
	}

	public Type getElementType() {
		return elementType;
	}

	@Override
	public ByteBuffer toBytes() {
		// make a copy to avoid encoding twice
		List<ByteBuffer> payloadBytes = ImmutableList.copyOf(Lists.transform(
				value, Tag.ENCODER));

		int length = 5; // for the element type (1) and count (4)
		for (ByteBuffer buffer : payloadBytes) {
			length += buffer.capacity();
		}

		ByteBuffer payload = ByteBuffer.allocate(length);
		payload.put(elementType.getBinaryType());
		payload.putInt(value.size());
		for (ByteBuffer buffer : payloadBytes) {
			payload.put(buffer);
		}
		payload.position(0);
		return payload;
	}

	private final class TypeConstraint implements Constraint<Tag> {
		@Override
		public Tag checkElement(Tag element) {
			checkArgument(element.getTagType() == elementType);
			return element;
		}
	}
}
