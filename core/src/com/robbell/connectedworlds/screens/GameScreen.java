package com.robbell.connectedworlds.screens;

import com.badlogic.gdx.Screen;
import com.robbell.connectedworlds.gameobjects.World;
import com.robbell.connectedworlds.renderers.WorldRenderer;

public class GameScreen implements Screen
{
	private WorldRenderer renderer;

	public GameScreen()
	{
		renderer = new WorldRenderer(new World());
	}
	
	@Override
	public void render(float delta)
	{
		renderer.render();
	}

	@Override
	public void resize(int width, int height)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void show()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void hide()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void pause()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void resume()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose()
	{
		// TODO Auto-generated method stub

	}

}
