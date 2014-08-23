package com.robbell.connectedworlds;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.robbell.connectedworlds.gameobjects.World;

public class InputHandler implements InputProcessor
{
	private World world;

	public InputHandler(World world)
	{
		this.world = world;
	}

	@Override
	public boolean keyDown(int keycode)
	{
		if (keycode == Keys.UP)
			world.upPressed();
		else if (keycode == Keys.DOWN)
			world.downPressed();
		else if (keycode == Keys.LEFT)
			world.leftPressed();
		else if (keycode == Keys.RIGHT)
			world.rightPressed();

		return false;
	}

	@Override
	public boolean keyUp(int keycode)
	{
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
