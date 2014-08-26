package com.robbell.connectedworlds.gameobjects;

public class Tile
{
	private String string;
	private boolean isEmpty;

	public Tile(String string)
	{
		this.string = string;
		if(string.equals("0")) isEmpty = true;
	}
	
	public boolean isEmpty()
	{
		return isEmpty;
	}
}
