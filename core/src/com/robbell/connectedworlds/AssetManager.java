package com.robbell.connectedworlds;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetManager
{
	public static TextureRegion tile;

	public static void load()
	{
		Texture tileTexture = new Texture(Gdx.files.internal("stone.png"));
		tileTexture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

		tile = new TextureRegion(tileTexture, 0, 0, 50, 24);
		tile.flip(false, true);
	}
}
