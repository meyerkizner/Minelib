/*
 * MineLib, a Minecraft library
 * Copyright (C) 2011 Meyer Kizner
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

import com.prealpha.minelib.math.Coordinate3D;

public class BasicBlock implements Block {
	private final Coordinate3D globalPosition;
	public final byte blockType;
	public final byte data;
	
	
	public BasicBlock(byte blockType){
		this.globalPosition = new Coordinate3D(0,0,0);
		this.blockType=blockType;
		this.data=0;
	}
	public BasicBlock(byte blockType, byte data){
		this.globalPosition = new Coordinate3D(0, 0, 0);
		this.blockType=blockType;
		this.data=data;
	}
	public BasicBlock(Coordinate3D globalPosition,byte blockType, byte data){
		this.globalPosition=globalPosition;
		this.blockType=blockType;
		this.data=data;
	}
	public BasicBlock(int globalX, int globalY, int globalZ, byte blockType, byte data){
		this.globalPosition = new Coordinate3D(globalX, globalY, globalZ);
		this.blockType = blockType;
		this.data = data;
	}
	
	@Override
	public Coordinate3D getGlobalPosition() {
		return this.globalPosition;
	}
	@Override
	public Coordinate3D getRegionalPosition() {
		return this.globalPosition.mod(512);
	}
	@Override
	public Coordinate3D getChunkwisePosition() {
		return this.globalPosition.mod(16);
	}


	@Override
	public byte getType() {
		return this.blockType;
	}
	@Override
	public byte getData() {
		return this.data;
	}

	@Override
	public boolean equals(Block other) {
		if(!this.getGlobalPosition().equals(other.getGlobalPosition())){
			return false;
		}
		if(this.getType()!=other.getType()){
			return false;
		}
		if(this.getData()!=other.getData()){
			return false;
		}
		return true;
	}
	@Override
	public boolean isA(Block other) {
		if(this.getType()!=other.getType()){
			return false;
		}
		if(this.getData()!=other.getData()){
			return false;
		}
		return true;
	}
	@Override
	public boolean sharesData(Block other) {
		return this.getData()==other.getData();
	}
	@Override
	public boolean sharesType(Block other) {
		return this.getType()==other.getType();
	}

}
