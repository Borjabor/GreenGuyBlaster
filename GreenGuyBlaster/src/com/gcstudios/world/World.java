package com.gcstudios.world;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.gcstudios.entities.Enemy;
import com.gcstudios.entities.Entity;

import com.gcstudios.entities.Player;
import com.gcstudios.graficos.UI;
import com.gcstudios.main.Game;

public class World {

	public static Tile[] tiles;
	public static int WIDTH,HEIGHT;
	public static final int TILE_SIZE = 16;
	
	
	
	
	public World(){
		/*String[] tileTypes = {"grass", "dirt", "sand", "snow"};
		WIDTH = 200;
		HEIGHT = 80;
		//Map division
		int division = WIDTH/tileTypes.length;
		tiles = new Tile[WIDTH * HEIGHT];
		for(int xx = 0; xx < WIDTH; xx++) {
			int initialHeight = Entity.rand.nextInt(4) + 8;
			for(int yy = 0; yy < HEIGHT; yy++) {
				if(yy == HEIGHT - 1 || xx == WIDTH -1 || yy == 0 || xx == 0) {
					tiles[xx + yy * WIDTH] = new GroundTile(xx*16, yy*16, Tile.TILE_STONE);
					tiles[xx + yy * WIDTH].solid = true;
				}else {
					if(yy >= initialHeight) {
						int indexBiome = xx / division;
						if(tileTypes[indexBiome] == "grass") {
							tiles[xx + yy * WIDTH] = new GroundTile(xx*16, yy*16, Tile.TILE_GRASS);
						}else if(tileTypes[indexBiome] == "dirt"){
							tiles[xx + yy * WIDTH] = new GroundTile(xx*16, yy*16, Tile.TILE_DIRT);
						}else if(tileTypes[indexBiome] == "sand"){
							tiles[xx + yy * WIDTH] = new GroundTile(xx*16, yy*16, Tile.TILE_SAND);
						}else if(tileTypes[indexBiome] == "snow"){
							tiles[xx + yy * WIDTH] = new GroundTile(xx*16, yy*16, Tile.TILE_SNOW);
						}
					}else {
						tiles[xx + yy * WIDTH] = new SkyTile(xx*16, yy*16, Tile.TILE_SKY);
					}
				}
			}
		}*/
	}
	
	public static boolean isFree(int xnext,int ynext){
		
		int x1 = xnext / TILE_SIZE;
		int y1 = ynext / TILE_SIZE;
		
		int x2 = (xnext+TILE_SIZE-1) / TILE_SIZE;
		int y2 = ynext / TILE_SIZE;
		
		int x3 = xnext / TILE_SIZE;
		int y3 = (ynext+TILE_SIZE-1) / TILE_SIZE;
		
		int x4 = (xnext+TILE_SIZE-1) / TILE_SIZE;
		int y4 = (ynext+TILE_SIZE-1) / TILE_SIZE;
		
		return !((tiles[x1 + (y1*World.WIDTH)] instanceof GroundTile) ||
				(tiles[x2 + (y2*World.WIDTH)] instanceof GroundTile) ||
				(tiles[x3 + (y3*World.WIDTH)] instanceof GroundTile) ||
				(tiles[x4 + (y4*World.WIDTH)] instanceof GroundTile));
	}
	
	public void tick() {
		
	}
	
	public static void restartGame(){
		//Apply a method to restart game (TODO is "to do")
		return;
	}
	
	public void render(Graphics g){
		int xstart = Camera.x >> 4;
		int ystart = Camera.y >> 4;
		
		int xfinal = xstart + (Game.WIDTH >> 4);
		int yfinal = ystart + (Game.HEIGHT >> 4);
		
		for(int xx = xstart; xx <= xfinal; xx++) {
			for(int yy = ystart; yy <= yfinal; yy++) {
				if(xx < 0 || yy < 0 || xx >= WIDTH || yy >= HEIGHT)
					continue;
				Tile tile = tiles[xx + (yy*WIDTH)];
				tile.render(g);
			}
		}
	}
	
}
