package com.robbell.connectedworlds.renderers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.robbell.connectedworlds.AssetManager;
import com.robbell.connectedworlds.gameobjects.Map;
import com.robbell.connectedworlds.gameobjects.Player;
import com.robbell.connectedworlds.gameobjects.Tile;
import com.robbell.connectedworlds.gameobjects.World;

public class WorldRenderer
{
	private OrthographicCamera camera;
	private World world;
	private SpriteBatch batcher;
	private TextureRegion cloudRegion;
	private TextureRegion stoneRegion;
	private TextureRegion playerRegion;
	private final int tileWidth = 50;
	private final int tileHeight = 24;
	private int halfTileWidth = tileWidth / 2;
	private int halfTileHeight = tileHeight / 2;

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
		drawMap(world.getHeavenMap(), 200, 20, true);
		drawMap(world.getHellMap(), 400, 200, false);
	}

	private void drawMap(Map map, int xOffset, int yOffset, boolean isHeaven)
	{
		Tile[][] tiles = map.getTiles();
		Player player = map.getPlayer();
		
		for(int xCoord = 0; xCoord < tiles.length; xCoord++)
		{
			for(int yCoord = 0; yCoord < tiles[xCoord].length; yCoord++)
			{
				int xPos = halfTileWidth * (xCoord - yCoord);
				int yPos = halfTileHeight * (xCoord + yCoord);				
				
				drawTile(xPos + xOffset, yPos + yOffset, isHeaven);
				
				if(player.getXCoord() == xCoord && player.getYCoord() == yCoord)
				{
					drawPlayer(xPos + xOffset, yPos + yOffset);
				}
			}
		}
	}

	private void drawPlayer(int xPos, int yPos)
	{
		xPos = xPos + halfTileWidth - (playerRegion.getRegionWidth() / 2);
		yPos = yPos + halfTileHeight - playerRegion.getRegionHeight();
		
		batcher.draw(playerRegion, xPos, yPos);
	}

	private void drawTile(int xPos, int yPos, boolean isHeaven)
	{
		batcher.draw(isHeaven ? cloudRegion : stoneRegion, xPos, yPos);
	}

	private void initialiseAssets()
	{
		cloudRegion = AssetManager.cloudTile;
		stoneRegion = AssetManager.stoneTile;
		playerRegion = AssetManager.player;
	}
	
	private void clearScreen()
	{
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	}
}
