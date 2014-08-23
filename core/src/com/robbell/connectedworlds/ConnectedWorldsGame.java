package com.robbell.connectedworlds;

import com.badlogic.gdx.Game;
import com.robbell.connectedworlds.screens.GameScreen;

public class ConnectedWorldsGame extends Game
{
	@Override
	public void create()
	{
		AssetManager.load();
		setScreen(new GameScreen());
	}
}
