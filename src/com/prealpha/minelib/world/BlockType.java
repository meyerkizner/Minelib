/*
 * MineLib, a Minecraft library
 * Copyright (C) 2011 Ty Overby
 * 
 * This file is part of MineLib.
 * 
 * MineLib is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * MineLib is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * MineLib. If not, see <http://www.gnu.org/licenses/>.
 */

package com.prealpha.minelib.world;

public final class BlockType {
	private final byte id;
	private final byte data;
	
	public BlockType(byte id, byte data){
		this.id = id;
		this.data = data;
	}
	
	public byte getID(){
		return this.id;
	}
	public byte getData(){
		return this.data;
	}
	
	public boolean equals(BlockType other){
		if(other == null){
			return false;
		}
		if(this.getID()!=other.getID()){
			return false;
		}
		if(this.getData()!=other.getData()){
			return false;
		}
		return true;
	}
	
	public boolean isSimilar(BlockType other){
		if(other == null){
			return false;
		}
		if(this.getID()!=other.getID()){
			return false;
		}
		return true;
	}
}
