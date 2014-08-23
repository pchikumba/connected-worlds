package com.robbell.connectedworlds.renderers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.robbell.connectedworlds.AssetManager;
import com.robbell.connectedworlds.gameobjects.Map;
import com.robbell.connectedworlds.gameobjects.Tile;
import com.robbell.connectedworlds.gameobjects.World;

public class WorldRenderer
{
	private TextureRegion tileRegion;
	private World world;
	private OrthographicCamera camera;
	private SpriteBatch batcher;
	private final int tileWidth = 50;
	private final int tileHeight = 24;

	public WorldRenderer(World world)
	{
		this.world = world;
		
		camera = new OrthographicCamera();
		camera.setToOrtho(true);

		batcher = new SpriteBatch();
		batcher.setProjectionMatrix(camera.combined);
		
		initialiseAssets();
	}
	
	public void render()
	{
		clearScreen();

		batcher.begin();

		drawMaps();
		
		batcher.end();
	}
	
	private void drawMaps()
	{
		drawMap(world.getHeavenMap(), 0, 20);
		drawMap(world.getHellMap(), 200, 200);
	}

	private void drawMap(Map map, int xOffset, int yOffset)
	{
		Tile[][] tiles = map.getTiles();
		
		for(int i = 0; i < tiles.length; i++)
		{
			for(int j = 0; j < tiles[i].length; j++)
			{
				int xPos = (tileWidth / 2) * (i - j);
				int yPos = (tileHeight / 2) * (i + j);
				drawTile(tiles[i][j], xPos + xOffset, yPos + yOffset, tiles);
			}
		}
	}

	private void drawTile(Tile tile, int xPos, int yPos, Tile[][] tiles)
	{
		xPos += tiles.length * tileWidth / 2; 
		
		batcher.draw(tileRegion, xPos, yPos);
	}

	private void initialiseAssets()
	{
		tileRegion = AssetManager.tile;
	}
	
	private void clearScreen()
	{
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	}
}
