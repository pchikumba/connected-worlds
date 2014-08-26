package com.robbell.connectedworlds.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.robbell.connectedworlds.gameobjects.World.Direction;

public class Map
{
	private Tile[][] tiles;
	private Player player;
	private final int headerLength = 2;

	public Map()
	{
		player = new Player();
	}

	public void load(String mapPath)
	{
		FileHandle handle = Gdx.files.internal("maps/" + mapPath);
		
		String contents = handle.readString();
		String[] lines = contents.split(System.getProperty("line.separator"));
		
		String[] dimensions = lines[0].split(",");
		String[] playerLocation = lines[1].split(",");
		
		tiles = new Tile[Integer.parseInt(dimensions[0])][Integer.parseInt(dimensions[1])];

		for (int xCount = 0; xCount < tiles.length; xCount++)
		{
			String[] tileInfo = lines[xCount + headerLength].split(",");
			
			for (int yCount = 0; yCount < tiles[xCount].length; yCount++)
			{
				tiles[xCount][yCount] = new Tile(tileInfo[yCount]);
			}
		}

		player.setXCoord(Integer.parseInt(playerLocation[0]));
		player.setYCoord(Integer.parseInt(playerLocation[1]));
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
		if (direction != player.getDirection())
		{
			player.setDirection(direction);
			return;
		}

		if (direction == Direction.Up)
			player.setXCoord(player.getXCoord() - 1);
		else if (direction == Direction.Down)
			player.setXCoord(player.getXCoord() + 1);
		else if (direction == Direction.Left)
			player.setYCoord(player.getYCoord() + 1);
		else if (direction == Direction.Right)
			player.setYCoord(player.getYCoord() - 1);
	}
}
