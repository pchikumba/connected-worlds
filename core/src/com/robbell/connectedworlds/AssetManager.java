package com.robbell.connectedworlds;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetManager
{
	public static TextureRegion background;
	public static TextureRegion cloudTile;
	public static TextureRegion stoneTile;
	public static TextureRegion heavenPlayerUp;
	public static TextureRegion heavenPlayerDown;
	public static TextureRegion heavenPlayerLeft;
	public static TextureRegion heavenPlayerRight;
	public static TextureRegion hellPlayerUp;
	public static TextureRegion hellPlayerDown;
	public static TextureRegion hellPlayerLeft;
	public static TextureRegion hellPlayerRight;
	

	public static void load()
	{
		cloudTile = loadTextureRegion("cloud.png", 50, 36);
		stoneTile = loadTextureRegion("stone.png", 50, 38);
		background = loadTextureRegion("background.png", 900, 600);
		
		heavenPlayerUp = loadTextureRegion("heaven-player-up.png", 14, 30);
		heavenPlayerDown = loadTextureRegion("heaven-player-down.png", 14, 30);
		heavenPlayerLeft = loadTextureRegion("heaven-player-left.png", 14, 30);
		heavenPlayerRight = loadTextureRegion("heaven-player-right.png", 14, 30);
		
		hellPlayerUp = loadTextureRegion("hell-player-up.png", 14, 30);
		hellPlayerDown = loadTextureRegion("hell-player-down.png", 14, 30);
		hellPlayerLeft = loadTextureRegion("hell-player-left.png", 14, 30);
		hellPlayerRight = loadTextureRegion("hell-player-right.png", 14, 30);
	}
	
	private static TextureRegion loadTextureRegion(String fileName, int width, int height)
	{
		Texture texture = new Texture(Gdx.files.internal(fileName));
		texture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

		TextureRegion region = new TextureRegion(texture, 0, 0, width, height);
		region.flip(false, true);
		
		return region;
	}
}
