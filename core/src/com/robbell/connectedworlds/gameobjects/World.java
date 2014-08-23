package com.robbell.connectedworlds.gameobjects;

public class World
{
	private Map hellMap;
	private Map heavenMap;
	private Player hellPlayer;
	private Player heavenPlayer;
	
	public World()
	{
		hellMap = new Map();
		heavenMap = new Map();
		
		hellMap.load("");
		heavenMap.load("");
	}
	
	public Map getHeavenMap()
	{
		return heavenMap;
	}

	public Map getHellMap()
	{
		return hellMap;
	}
}
