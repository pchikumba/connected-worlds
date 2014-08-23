package com.robbell.connectedworlds.gameobjects;

import com.robbell.connectedworlds.gameobjects.World.Direction;

public class Player
{
	private int x;
	private int y;
	private Direction direction;
	
	public Player()
	{
		direction = Direction.Down;
	}
	
	public Direction getDirection()
	{
		return direction;
	}
	
	public void setDirection(Direction direction)
	{
		this.direction = direction;  
	}

	public int getXCoord()
	{
		return x;
	}
	
	public int getYCoord()
	{
		return y;
	}
	
	public void setXCoord(int x)
	{
		this.x = x;
	}
	
	public void setYCoord(int y)
	{
		this.y = y;
	}
}