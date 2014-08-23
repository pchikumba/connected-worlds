package com.robbell.connectedworlds.gameobjects;

import com.badlogic.gdx.Gdx;
import com.robbell.connectedworlds.InputHandler;
import com.robbell.connectedworlds.InputHandler.Direction;

public class World
{
	private Map hellMap;
	private Map heavenMap;
	private InputHandler inputHandler;
	private boolean isPlayerMoving;
	
	public World()
	{
		inputHandler = new InputHandler();
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
		if(isPlayerMoving || inputHandler.getDirection() == Direction.None) return;
		
		hellMap.movePlayer(inputHandler.getDirection());
		heavenMap.movePlayer(inputHandler.getDirection());
	}
}
