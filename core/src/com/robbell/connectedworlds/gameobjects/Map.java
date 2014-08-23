package com.robbell.connectedworlds.gameobjects;

import com.robbell.connectedworlds.InputHandler.Direction;

public class Map
{
	private Tile[][] tiles;
	private Player player;
	
	public Map()
	{
		player = new Player();
	}
	
	public void load(String mapPath)
	{
		tiles = new Tile[8][6];
		
		for(int i = 0; i < 8; i++)
		{
			for(int j = 0; j < 6; j++)
			{
				tiles[i][j] = new Tile();
			}
		}
		
		player.setXCoord(3);
		player.setYCoord(4);
	}
	
	public Tile[][] getTiles()
	{
		return tiles;
	}
	
	public Player getPlayer()
	{
		return player;
	}

	public void movePlayer(Direction direction)
	{
		if(direction == Direction.Up) player.setXCoord(player.getXCoord() - 1);
		else if(direction == Direction.Down) player.setXCoord(player.getXCoord() + 1);
		else if(direction == Direction.Left) player.setYCoord(player.getYCoord() + 1);
		else if(direction == Direction.Right) player.setYCoord(player.getYCoord() - 1);
	}
}

