package com.robbell.connectedworlds.renderers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.robbell.connectedworlds.AssetManager;
import com.robbell.connectedworlds.gameobjects.Map;
import com.robbell.connectedworlds.gameobjects.Player;
import com.robbell.connectedworlds.gameobjects.Tile;
import com.robbell.connectedworlds.gameobjects.World;
import com.robbell.connectedworlds.gameobjects.World.Direction;

public class WorldRenderer
{
	private OrthographicCamera camera;
	private World world;
	private SpriteBatch batcher;
	private ShapeRenderer shapeRenderer;
	private TextureRegion cloudRegion;
	private TextureRegion stoneRegion;
	private TextureRegion heavenPlayerDown;
	private TextureRegion hellPlayerDown;
	private TextureRegion backgroundRegion;
	private final int tileWidth = 50;
	private final int tileHeight = 24;
	private int halfTileWidth = tileWidth / 2;
	private int halfTileHeight = tileHeight / 2;
	
	
	private enum MapPosition
	{
		Top,
		Bottom
	}

	public WorldRenderer(World world)
	{
		this.world = world;
		
		camera = new OrthographicCamera();
		camera.setToOrtho(true);
		
		shapeRenderer = new ShapeRenderer();
		shapeRenderer.setProjectionMatrix(camera.combined);

		batcher = new SpriteBatch();
		batcher.setProjectionMatrix(camera.combined);
		
		initialiseAssets();
	}
	
	public void render()
	{
		clearScreen();

		batcher.begin();
		
		drawBackground();
		drawMaps();
		
		batcher.end();
	}
	
	private void drawBackground()
	{
		float midpoint = Gdx.graphics.getHeight() / 2;
		batcher.draw(backgroundRegion, 0, midpoint - backgroundRegion.getRegionHeight() + 25); 
	}

	private void drawMaps()
	{
		drawMap(world.getHeavenMap(), MapPosition.Top);
		drawMap(world.getHellMap(), MapPosition.Bottom);
	}

	private void drawMap(Map map, MapPosition position)
	{
		Tile[][] tiles = map.getTiles();
		Player player = map.getPlayer();
		
		int mapWidth = (tiles.length + tiles[0].length) * halfTileWidth;
		
		int xOffset = ((Gdx.graphics.getWidth() - mapWidth) / 2) + (tiles[0].length * halfTileWidth) - halfTileWidth;
		
		int mapHeight = (tiles.length + tiles[0].length) * halfTileHeight;
		
		int yOffset = ((Gdx.graphics.getHeight() / 2) - mapHeight) / 2 + (position == MapPosition.Bottom ? Gdx.graphics.getHeight() / 2 : 0); 
		
		for(int xCoord = 0; xCoord < tiles.length; xCoord++)
		{
			for(int yCoord = 0; yCoord < tiles[xCoord].length; yCoord++)
			{
				Tile tile = tiles[xCoord][yCoord];
				int xPos = halfTileWidth * (xCoord - yCoord);
				int yPos = halfTileHeight * (xCoord + yCoord);				
				
				if(!tile.isEmpty()) drawTile(xPos + xOffset, yPos + yOffset, position);
				
				if(player.getXCoord() == xCoord && player.getYCoord() == yCoord)
				{
					drawPlayer(xPos + xOffset, yPos + yOffset, player, position);
				}
			}
		}
	}

	private void drawPlayer(int xPos, int yPos, Player player, MapPosition position)
	{
		xPos = xPos + halfTileWidth - (heavenPlayerDown.getRegionWidth() / 2);
		yPos = yPos + halfTileHeight - heavenPlayerDown.getRegionHeight() + 3;
		
		TextureRegion playerRegion; 
		
		playerRegion = getPlayerRegion(player, position);
		
		batcher.draw(playerRegion, xPos, yPos);
	}

	private TextureRegion getPlayerRegion(Player player, MapPosition position)
	{
		if(position == MapPosition.Top)
		{
			if(player.getDirection() == Direction.Up) return AssetManager.heavenPlayerUp;
			else if(player.getDirection() == Direction.Down) return AssetManager.heavenPlayerDown;
			else if(player.getDirection() == Direction.Left) return AssetManager.heavenPlayerLeft;
			else return AssetManager.heavenPlayerRight;
		}
		else
		{
			if(player.getDirection() == Direction.Up) return AssetManager.hellPlayerUp;
			else if(player.getDirection() == Direction.Down) return AssetManager.hellPlayerDown;
			else if(player.getDirection() == Direction.Left) return AssetManager.hellPlayerLeft;
			else return AssetManager.hellPlayerRight;
		}
	}

	private void drawTile(int xPos, int yPos, MapPosition position)
	{
		batcher.draw(position == MapPosition.Top ? cloudRegion : stoneRegion, xPos, yPos);
	}

	private void initialiseAssets()
	{
		cloudRegion = AssetManager.cloudTile;
		stoneRegion = AssetManager.stoneTile;
		heavenPlayerDown = AssetManager.heavenPlayerDown;
		hellPlayerDown = AssetManager.hellPlayerDown;
		backgroundRegion = AssetManager.background;
	}
	
	private void clearScreen()
	{
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	}
}
