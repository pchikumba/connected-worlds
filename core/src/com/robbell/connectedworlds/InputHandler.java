package com.robbell.connectedworlds;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;

public class InputHandler implements InputProcessor
{
	private Direction direction;
	
	public enum Direction
	{
		None,
		Up,
		Down,
		Left,
		Right
	}
	
	public Direction getDirection()
	{
		return direction;
	}
	
	@Override
	public boolean keyDown(int keycode)
	{
		if (keycode == Keys.UP) direction = Direction.Up;
		else if (keycode == Keys.DOWN) direction = Direction.Down;
		else if (keycode == Keys.LEFT) direction = Direction.Left;
		else if (keycode == Keys.RIGHT) direction = Direction.Right;
		
		return false;
	}

	@Override
	public boolean keyUp(int keycode)
	{
		direction = Direction.None;
		
		return false;
	}

	@Override
	public boolean keyTyped(char character)
	{
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button)
	{
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button)
	{
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer)
	{
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY)
	{
		return false;
	}

	@Override
	public boolean scrolled(int amount)
	{
		return false;
	}
}
