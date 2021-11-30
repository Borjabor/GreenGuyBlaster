package com.gcstudios.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.gcstudios.main.Game;
import com.gcstudios.world.Camera;
import com.gcstudios.world.World;


public class Player extends Entity{
		
	public boolean right, left;
	public boolean isShooting = false;
	
	public Player(int x, int y, int width, int height,double speed,BufferedImage sprite) {
		super(x, y, width, height,speed,sprite);
		
	}
	
	public void tick(){
		if(right) {
			x += speed;
		}else if(left) {
			x -= speed;
		}
		
		if(x >= Game.WIDTH) {
			x = -16;
		}else if(x + 16 < 0) {
			x = Game.WIDTH;
		}
		
		//Shooting
		if(isShooting) {
			isShooting = false;
			int xx = this.getX() + 8;
			int yy = this.getY();
			Bullet bullet = new Bullet(xx, yy, 1, 2, 1, null);
			Game.entities.add(bullet);
		}
		
		
	}
	
	
	
	

}
