package com.robbell.connectedworlds.gameobjects;

import com.badlogic.gdx.Gdx;
import com.robbell.connectedworlds.InputHandler;

public class World
{
	public enum Direction
	{
		None,
		Up,
		Down,
		Left,
		Right
	}
	
	private Map hellMap;
	private Map heavenMap;
	private InputHandler inputHandler;
	private boolean isPlayerMoving;
	
	public World()
	{
		inputHandler = new InputHandler(this);
		Gdx.input.setInputProcessor(inputHandler);
		
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

	public void update(float delta)
	{

	}

	public void upPressed()
	{
		movePlayers(Direction.Up);
	}

	public void downPressed()
	{
		movePlayers(Direction.Down);
	}

	public void leftPressed()
	{
		movePlayers(Direction.Left);
	}

	public void rightPressed()
	{
		movePlayers(Direction.Right);
	}
	
	private void movePlayers(Direction direction)
	{
		hellMap.movePlayer(direction);
		heavenMap.movePlayer(direction);
	}
}
