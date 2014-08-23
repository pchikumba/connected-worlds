package com.robbell.connectedworlds.gameobjects;

public class Map
{
	private Tile[][] tiles;
	
	public Map()
	{
		
	}
	
	public void load(String mapPath)
	{
		tiles = new Tile[8][8];
		
		for(int i = 0; i < 8; i++)
		{
			for(int j = 0; j < 8; j++)
			{
				tiles[i][j] = new Tile();
			}
		}
	}
	
	public Tile[][] getTiles()
	{
		return tiles;
	}
}

