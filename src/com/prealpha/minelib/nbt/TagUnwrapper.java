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

import java.util.List;
import java.util.Map;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public final class TagUnwrapper implements Function<Tag, Object> {
	public TagUnwrapper() {
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object apply(Tag tag) {
		if (tag instanceof RootTag) {
			RootTag root = (RootTag) tag;
			String key = root.getName().getValue();
			Map<String, Tag> value = (Map<String, Tag>) apply(root.getValue());
			return ImmutableMap.of(key, value);
		} else {
			Object value = tag.getValue();
			if (value instanceof Map) {
				return Maps.transformValues((Map<String, Tag>) value, this);
			} else if (value instanceof List) {
				return Lists.transform((List<Tag>) value, this);
			} else {
				return value;
			}
		}
	}
}
