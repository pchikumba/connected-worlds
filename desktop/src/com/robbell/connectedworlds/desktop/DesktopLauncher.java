package com.robbell.connectedworlds.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.robbell.connectedworlds.ConnectedWorldsGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 1000;
		config.height = 700;
		config.title = "Connected Worlds";
		new LwjglApplication(new ConnectedWorldsGame(), config);
	}
}
