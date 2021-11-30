package com.gcstudios.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.gcstudios.main.Game;
import com.gcstudios.world.Camera;
import com.gcstudios.world.GroundTile;
import com.gcstudios.world.SkyTile;
import com.gcstudios.world.Tile;
import com.gcstudios.world.World;

public class Enemy extends Entity{
	
	public int life = 3;

	public Enemy(double x, double y, int width, int height, double speed, BufferedImage sprite) {
		super(x, y, width, height, speed, sprite);
		
	}
	
	public void tick() {
		y += speed;
		if(y >= Game.HEIGHT) {
			Game.entities.remove(this);
			Game.life -= 1;
			return;
			
		}
		
		for(int i = 0; i < Game.entities.size(); i++) {
			Entity e = Game.entities.get(i);
			if (e instanceof Bullet) {
				if(Entity.isColidding(this,  e)) {
					//Posso colocar uma vida > 0, caso queira aumentar dificuldade
					Game.entities.remove(e);
					life--;
					if(life == 0) {
						Explosion explosion = new Explosion(x, y, 16, 16, 0, null);
						Game.entities.add(explosion);
						Game.entities.remove(this);
						Game.score++;	
						return;
					}
					break;
				}
			}
		}
				
	}
	
	
	
	

}
