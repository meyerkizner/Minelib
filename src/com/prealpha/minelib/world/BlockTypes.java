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
 * MineLib. If not, see <http:// www.gnu.org/licenses/>.
 */

package com.prealpha.minelib.world;

public final class BlockTypes {
	public static final BlockType AIR = new BlockType((byte)0);
	public static final BlockType STONE = new BlockType((byte)1);
	public static final BlockType GRASS = new BlockType((byte)2);
	public static final BlockType DIRT = new BlockType((byte)3);
	public static final BlockType COBBLESTONE = new BlockType((byte)4);
	public static final BlockType WOODEN_PLANK = new BlockType((byte)5);
	public static final BlockType PLANK = new BlockType((byte)5);
	public static final BlockType SAPPLING_NORMAL = new BlockType((byte)6,(byte)0);
	public static final BlockType SAPPLING_REDWOOD = new BlockType((byte)6,(byte)1);
	public static final BlockType SAPPLING_BIRCH = new BlockType((byte)6,(byte)2);
	public static final BlockType BEDROCK = new BlockType((byte)7);
	public static final BlockType WATER = new BlockType((byte)8);
	public static final BlockType WATER_STATIONARY = new BlockType((byte)9);
	public static final BlockType LAVA = new BlockType((byte)10);
	public static final BlockType LAVA_STATIONARY = new BlockType((byte)11);
	public static final BlockType SAND = new BlockType((byte)12);
	public static final BlockType GRAVEL = new BlockType((byte)13);
	public static final BlockType GOLD_ORE = new BlockType((byte)14);
	public static final BlockType IRON_ORE = new BlockType((byte)15);
	public static final BlockType COAL_ORE = new BlockType((byte)16);
	public static final BlockType WOOD_NORMAL = new BlockType((byte)17,(byte)0);
	public static final BlockType WOOD_REDWOOD = new BlockType((byte)17,(byte)1);
	public static final BlockType WOOD_BIRCH = new BlockType((byte)17,(byte)2);
	public static final BlockType LEAF_NORMAL = new BlockType((byte)18,(byte)0);
	public static final BlockType LEAF_REDWOOD = new BlockType((byte)18,(byte)1);
	public static final BlockType LEAF_BIRCH = new BlockType((byte)18,(byte)2);
	public static final BlockType SPONGE = new BlockType((byte)19);
	public static final BlockType GLASS = new BlockType((byte)20);
	public static final BlockType LAPIS_LAZULI_ORE = new BlockType((byte)21);
	public static final BlockType LAPIS_LAZULI_BLOCK = new BlockType((byte)22);
	public static final BlockType DISPENSER = new BlockType((byte)23);
	public static final BlockType SANDSTONE = new BlockType((byte)24);
	public static final BlockType NOTE_BLOCK = new BlockType((byte)25);
	public static final BlockType BED = new BlockType((byte)26);
	public static final BlockType POWERED_RAIL = new BlockType((byte)27);
	public static final BlockType DETECTOR_RAIL = new BlockType((byte)28);
	public static final BlockType COBWEB = new BlockType((byte)30);
	public static final BlockType TALL_GRASS = new BlockType((byte)31);
	public static final BlockType DEAD_SHRUB = new BlockType((byte)32);
	
	// start wool
	public static final BlockType WOOL_WHITE = new BlockType((byte)33,(byte)0);
	public static final BlockType WOOL_ORANGE = new BlockType((byte)33,(byte)1);
	public static final BlockType WOOL_MAGENTA = new BlockType((byte)33,(byte)2);
	public static final BlockType WOOL_LIGHT_BLUE = new BlockType((byte)3,(byte)3);
	public static final BlockType WOOL_YELLOW = new BlockType((byte)33,(byte)4);
	public static final BlockType WOOL_LIGHT_GREEN = new BlockType((byte)33,(byte)5);
	public static final BlockType WOOL_PINK = new BlockType((byte)33,(byte)6);
	public static final BlockType WOOL_GRAY = new BlockType((byte)33,(byte)7);
	public static final BlockType WOOL_LIGHT_GRAY = new BlockType((byte)33,(byte)8);
	public static final BlockType WOOL_CYAN = new BlockType((byte)33,(byte)9);
	public static final BlockType WOOL_PURPLE = new BlockType((byte)33,(byte)10);
	public static final BlockType WOOL_BLUE = new BlockType((byte)33,(byte)11);
	public static final BlockType WOOL_BROWN = new BlockType((byte)33,(byte)12);
	public static final BlockType WOOL_DARK_GREEN  = new BlockType((byte)33,(byte)13);
	public static final BlockType WOOL_RED = new BlockType((byte)33,(byte)14);
	public static final BlockType WOOL_BLACK = new BlockType((byte)33,(byte)15);
	// end wool
	
	public static final BlockType DANDELION = new BlockType((byte)37);
	public static final BlockType FLOWER_YELLOW = DANDELION;
	public static final BlockType ROSE = new BlockType((byte)38);
	public static final BlockType FLOWER_RED = ROSE;
	public static final BlockType MUSHROOM_BROWN = new BlockType((byte)39);
	public static final BlockType MUSHROOM_RED = new BlockType((byte)40);
	public static final BlockType GOLD_BLOCK = new BlockType((byte)41);
	public static final BlockType IRON_BLOCK = new BlockType((byte)42);
	
	// Start slabs
	public static final BlockType SLAB_STONE = new BlockType((byte)44,(byte)0);
	public static final BlockType SLAB_SANDSTONE = new BlockType((byte)44,(byte)1);
	public static final BlockType SLAB_WOOD = new BlockType((byte)44,(byte)2);
	public static final BlockType SLAB_COBBLESTONE = new BlockType((byte)44,(byte)3);
	// End slabs
	
	public static final BlockType BRICK = new BlockType((byte)45);
	public static final BlockType TNT = new BlockType((byte)46);
	public static final BlockType BOOKSHELF = new BlockType((byte)47);
	public static final BlockType MOSS_STONE = new BlockType((byte)48);
	public static final BlockType OBSIDIAN = new BlockType((byte)49);
	
	// Start torches
	public static final BlockType TORCH_SOUTH = new BlockType((byte)50,(byte)1);
	public static final BlockType TORCH_NORTH = new BlockType((byte)50,(byte)2);
	public static final BlockType TORCH_WEST = new BlockType((byte)50,(byte)3);
	public static final BlockType TORCH_EAST = new BlockType((byte)50,(byte)4);
	public static final BlockType TORCH_FLOOR = new BlockType((byte)50,(byte)5);
	// End torches
	
	public static final BlockType FIRE = new BlockType((byte)51);
	
	// Start stairs
	public static final BlockType STAIR_COBBLESTONE_SOUTH = new BlockType((byte)52,(byte)0);
	public static final BlockType STAIR_COBBLESTONE_NORTH = new BlockType((byte)52,(byte)1);
	public static final BlockType STAIR_COBBLESTONE_WEST = new BlockType((byte)52,(byte)2);
	public static final BlockType STAIR_COBBLESTONE_EAST = new BlockType((byte)52,(byte)3);
	// End stairs
	
	public static final BlockType CHEST = new BlockType((byte)54);
	public static final BlockType REDSTONE_WIRE = new BlockType((byte)55);
	public static final BlockType DIAMOND_ORE = new BlockType((byte)56);
	public static final BlockType DIAMOND_BLOCK = new BlockType((byte)57);
	public static final BlockType CRAFTING_TABLE = new BlockType((byte)58);
	
	// start crops
	public static final BlockType CROP_0 = new BlockType((byte)59,(byte)0);
	public static final BlockType CROP_1 = new BlockType((byte)59,(byte)1);
	public static final BlockType CROP_2 = new BlockType((byte)59,(byte)2);
	public static final BlockType CROP_3 = new BlockType((byte)59,(byte)3);
	public static final BlockType CROP_4 = new BlockType((byte)59,(byte)4);
	public static final BlockType CROP_5 = new BlockType((byte)59,(byte)5);
	public static final BlockType CROP_6 = new BlockType((byte)59,(byte)6);
	public static final BlockType CROP_7 = new BlockType((byte)59,(byte)7);
	// end crops
	// start farmland
	public static final BlockType FARMLAND_0 = new BlockType((byte)60,(byte)0);
	public static final BlockType FARMLAND_1 = new BlockType((byte)60,(byte)1);
	public static final BlockType FARMLAND_2 = new BlockType((byte)60,(byte)2);
	public static final BlockType FARMLAND_3 = new BlockType((byte)60,(byte)3);
	public static final BlockType FARMLAND_4 = new BlockType((byte)60,(byte)4);
	public static final BlockType FARMLAND_5 = new BlockType((byte)60,(byte)5);
	public static final BlockType FARMLAND_6 = new BlockType((byte)60,(byte)6);
	public static final BlockType FARMLAND_7 = new BlockType((byte)60,(byte)7);
	// end farmland
	
	// start furnace
	public static final BlockType FURNACE_EAST = new BlockType((byte)61,(byte)2);
	public static final BlockType FURNACE_WEST = new BlockType((byte)61,(byte)3);
	public static final BlockType FURNACE_NORTH = new BlockType((byte)61,(byte)4);
	public static final BlockType FURNACE_SOUTH = new BlockType((byte)61,(byte)5);
	
	public static final BlockType FURNACE_EAST_BURNING = new BlockType((byte)62,(byte)2);
	public static final BlockType FURNACE_WEST_BURNING = new BlockType((byte)62,(byte)3);
	public static final BlockType FURNACE_NORTH_BURNING = new BlockType((byte)62,(byte)4);
	public static final BlockType FURNACE_SOUTH_BURNING = new BlockType((byte)62,(byte)5);
	// end furnace
	
	// begin sign posts
	public static final BlockType SIGN_POST_WEST = new BlockType((byte)63,(byte)0);
	public static final BlockType SIGN_POST_WEST_NORTHWEST = new BlockType((byte)63,(byte)1);
	public static final BlockType SIGN_POST_NORTHWEST = new BlockType((byte)63,(byte)2);
	public static final BlockType SIGN_POST_NORTH_NORTHWEST = new BlockType((byte)63,(byte)3);
	public static final BlockType SIGN_POST_NORTH = new BlockType((byte)63,(byte)4);
	public static final BlockType SIGN_POST_NORTH_NORTHEAST = new BlockType((byte)63,(byte)5);
	public static final BlockType SIGN_POST_NORTHEAST = new BlockType((byte)63,(byte)6);
	public static final BlockType SIGN_POST_EAST_NORTHEAST = new BlockType((byte)63,(byte)7);
	public static final BlockType SIGN_POST_EAST = new BlockType((byte)63,(byte)8);
	public static final BlockType SIGN_POST_EAST_SOUTHEAST = new BlockType((byte)63,(byte)9);
	public static final BlockType SIGN_POST_SOUTHEAST = new BlockType((byte)63,(byte)10);
	public static final BlockType SIGN_POST_SOUTH_SOUTHEAST = new BlockType((byte)63,(byte)11);
	public static final BlockType SIGN_POST_SOUTH = new BlockType((byte)63,(byte)12);
	public static final BlockType SIGN_POST_SOUTH_SOUTHWEST = new BlockType((byte)63,(byte)13);
	public static final BlockType SIGN_POST_SOUTHWEST = new BlockType((byte)63,(byte)14);
	public static final BlockType SIGN_POST_WEST_SOUTHWEST = new BlockType((byte)63,(byte)15);
	// end Sign posts

	// TODO:doors
	
	// Begin ladders
	public static final BlockType LADDER_EAST = new BlockType((byte)65,(byte)2);
	public static final BlockType LADDER_WEST = new BlockType((byte)65,(byte)3);
	public static final BlockType LADDER_NORTH = new BlockType((byte)65,(byte)4);
	public static final BlockType LADDER_SOUTH = new BlockType((byte)65,(byte)5);
	// Exit ladders
	
	// TODO: ladders
	
	// begin stone stairs
	public static final BlockType STAIR_WOOD_SOUTH = new BlockType((byte)52,(byte)0);
	public static final BlockType STAIR_WOOD_NORTH = new BlockType((byte)52,(byte)1);
	public static final BlockType STAIR_WOOD_WEST = new BlockType((byte)52,(byte)2);
	public static final BlockType STAIR_WOOD_EAST = new BlockType((byte)52,(byte)3);
	// end stairs
	
	// Begin wall signs
	public static final BlockType WALL_SIGN_EAST = new BlockType((byte)68,(byte)2);
	public static final BlockType WALL_SIGN_WEST = new BlockType((byte)68,(byte)3);
	public static final BlockType WALL_SIGN_NORTH = new BlockType((byte)68,(byte)4);
	public static final BlockType WALL_SIGN_SOUTH = new BlockType((byte)68,(byte)5);
	// End wall signs
	
	// begin levers
	// TODO: get these working properly
	// http:// www.minecraftwiki.net/wiki/Data_Values#Levers
	public static final BlockType LEVER_WALL_SOUTH = new BlockType((byte)69,(byte)1);
	public static final BlockType LEVER_WALL_NORTH = new BlockType((byte)69,(byte)2);
	public static final BlockType LEVER_WALL_WEST = new BlockType((byte)69,(byte)3);
	public static final BlockType LEVER_WALL_EAST = new BlockType((byte)69,(byte)4);
	public static final BlockType LEVER_GROUND_WEST = new BlockType((byte)69,(byte)5);
	public static final BlockType LEVER_GROUND_SOUTH = new BlockType((byte)69,(byte)6);
	// end levers
	
	// begin pressure plates
	public static final BlockType PRESSURE_PLATE_STONE_OFF = new BlockType((byte)70,(byte)0);
	public static final BlockType PRESSURE_PLATE_STONE_ON = new BlockType((byte)70,(byte)1);
	// end pressure plates

	public static final BlockType REDSTONE_ORE = new BlockType((byte)73);
	public static final BlockType REDSTONE_ORE_GLOWING = new BlockType((byte)74);
	
	// Start redstone torches off
	public static final BlockType TORCH_REDSTONE_SOUTH_OFF = new BlockType((byte)75,(byte)1);
	public static final BlockType TORCH_REDSTONE_NORTH_OFF = new BlockType((byte)75,(byte)2);
	public static final BlockType TORCH_REDSTONE_WEST_OFF = new BlockType((byte)75,(byte)3);
	public static final BlockType TORCH_REDSTONE_EAST_OFF = new BlockType((byte)75,(byte)4);
	public static final BlockType TORCH_REDSTONE_FLOOR_OFF = new BlockType((byte)75,(byte)5);
	// End redstone torches off
	
	// Start redstone torches on
	public static final BlockType TORCH_REDSTONE_SOUTH_ON = new BlockType((byte)76,(byte)1);
	public static final BlockType TORCH_REDSTONE__NORTH_ON = new BlockType((byte)76,(byte)2);
	public static final BlockType TORCH_REDSTONE__WEST_ON = new BlockType((byte)76,(byte)3);
	public static final BlockType TORCH_REDSTONE__EAST_ON = new BlockType((byte)76,(byte)4);
	public static final BlockType TORCH_REDSTONE__FLOOR_ON = new BlockType((byte)76,(byte)5);
	// End redstone torches on
	
	// begin buttons
	// TODO: get state working correctly
	// http:// www.minecraftwiki.net/wiki/Data_Values#Buttons
	public static final BlockType BUTTON_WEST = new BlockType((byte)77,(byte)1);
	public static final BlockType BUTTON_EAST = new BlockType((byte)77,(byte)2);
	public static final BlockType BUTTON_SOUTH = new BlockType((byte)77,(byte)3);
	public static final BlockType BUTTON_NORTH = new BlockType((byte)77,(byte)4);
	// end buttons
	
	public static final BlockType SNOW = new BlockType((byte)78);
	public static final BlockType ICE = new BlockType((byte)79);
	public static final BlockType SNOW_BLOCK = new BlockType((byte)80);
	
	// begin the fucking cactuses
	public static final BlockType CACTUS_0 = new BlockType((byte)81,(byte)0);
	public static final BlockType CACTUS_1 = new BlockType((byte)81,(byte)1);
	public static final BlockType CACTUS_2 = new BlockType((byte)81,(byte)2);
	public static final BlockType CACTUS_3 = new BlockType((byte)81,(byte)3);
	public static final BlockType CACTUS_4 = new BlockType((byte)81,(byte)4);
	public static final BlockType CACTUS_5 = new BlockType((byte)81,(byte)5);
	public static final BlockType CACTUS_6 = new BlockType((byte)81,(byte)6);
	public static final BlockType CACTUS_7 = new BlockType((byte)81,(byte)7);
	public static final BlockType CACTUS_8 = new BlockType((byte)81,(byte)8);
	public static final BlockType CACTUS_9 = new BlockType((byte)81,(byte)9);
	public static final BlockType CACTUS_10 = new BlockType((byte)81,(byte)10);
	public static final BlockType CACTUS_11 = new BlockType((byte)81,(byte)11);
	public static final BlockType CACTUS_12 = new BlockType((byte)81,(byte)12);
	public static final BlockType CACTUS_13 = new BlockType((byte)81,(byte)13);
	public static final BlockType CACTUS_14 = new BlockType((byte)81,(byte)14);
	public static final BlockType CACTUS_15 = new BlockType((byte)81,(byte)15);
	// thank fucking god
	
	public static final BlockType CLAY_BLOCK = new BlockType((byte)82);
	
	// begin sugar cane
	public static final BlockType SUGARCANE_0 = new BlockType((byte)83,(byte)0);
	public static final BlockType SUGARCANE_1 = new BlockType((byte)83,(byte)1);
	public static final BlockType SUGARCANE_2 = new BlockType((byte)83,(byte)2);
	public static final BlockType SUGARCANE_3 = new BlockType((byte)83,(byte)3);
	public static final BlockType SUGARCANE_4 = new BlockType((byte)83,(byte)4);
	public static final BlockType SUGARCANE_5 = new BlockType((byte)83,(byte)5);
	public static final BlockType SUGARCANE_6 = new BlockType((byte)83,(byte)6);
	public static final BlockType SUGARCANE_7 = new BlockType((byte)83,(byte)7);
	public static final BlockType SUGARCANE_8 = new BlockType((byte)83,(byte)8);
	public static final BlockType SUGARCANE_9 = new BlockType((byte)83,(byte)9);
	public static final BlockType SUGARCANE_10 = new BlockType((byte)83,(byte)10);
	public static final BlockType SUGARCANE_11 = new BlockType((byte)83,(byte)11);
	public static final BlockType SUGARCANE_12 = new BlockType((byte)83,(byte)12);
	public static final BlockType SUGARCANE_13 = new BlockType((byte)83,(byte)13);
	public static final BlockType SUGARCANE_14 = new BlockType((byte)83,(byte)14);
	public static final BlockType SUGARCANE_15 = new BlockType((byte)83,(byte)15);
	// end sugar cane
	
	// begin jukebox
	public static final BlockType JUKEBOX_EMPTY = new BlockType((byte)84,(byte)0);
	public static final BlockType JUKEBOX_GOLD = new BlockType((byte)84,(byte)1);
	public static final BlockType JUKEBOX_GREEN = new BlockType((byte)84,(byte)2);
	// end jukebox
	
	public static final BlockType FENCE = new BlockType((byte)85);
	
	// begin pumpkin
	public static final BlockType PUMPKIN_EAST = new BlockType((byte)86,(byte)0);
	public static final BlockType PUMPKIN_SOUTH = new BlockType((byte)86,(byte)1);
	public static final BlockType PUMPKIN_WEST = new BlockType((byte)86,(byte)2);
	public static final BlockType PUMPKIN_NORTH = new BlockType((byte)86,(byte)3);
	// end pumpkin
	
	public static final BlockType NETHERRACK = new BlockType((byte)87);
	public static final BlockType SOUL_SAND = new BlockType((byte)88);
	public static final BlockType GLOWSTONE_BRICK = new BlockType((byte)89);
	public static final BlockType PORTAL = new BlockType((byte)90);
	
	// begin jackolantern
	public static final BlockType JACK_O_LANTERN_EAST = new BlockType((byte)86,(byte)0);
	public static final BlockType JACK_O_LANTERN_SOUTH = new BlockType((byte)86,(byte)1);
	public static final BlockType JACK_O_LANTERN_WEST = new BlockType((byte)86,(byte)2);
	public static final BlockType JACK_O_LANTERN_NORTH = new BlockType((byte)86,(byte)3);
	// end jackolantern
	
	// let them eat cake
	public static final BlockType CAKE_BLOCK_0 = new BlockType((byte)92,(byte)0);
	public static final BlockType CAKE_BLOCK_1 = new BlockType((byte)92,(byte)1);
	public static final BlockType CAKE_BLOCK_2 = new BlockType((byte)92,(byte)2);
	public static final BlockType CAKE_BLOCK_3 = new BlockType((byte)92,(byte)3);
	public static final BlockType CAKE_BLOCK_4 = new BlockType((byte)92,(byte)4);
	public static final BlockType CAKE_BLOCK_5 = new BlockType((byte)92,(byte)5);
	// or not, thats cool too
	
	// TODO: redstone repeater
	// http:// www.minecraftwiki.net/wiki/Data_Values#Redstone_Repeater 
	
	public static final BlockType LOCKED_CHEST = new BlockType((byte)95);
	
	//  begin trapdoor
	public static final BlockType TRAPDOOR_WEST = new BlockType((byte)96,(byte)0);
	public static final BlockType TRAPDOOR_EAST = new BlockType((byte)96,(byte)1);
	public static final BlockType TRAPDOOR_SOUTH = new BlockType((byte)96,(byte)2);
	public static final BlockType TRAPDOOR_NORTH = new BlockType((byte)96,(byte)3);
	// end trapdoor

}
