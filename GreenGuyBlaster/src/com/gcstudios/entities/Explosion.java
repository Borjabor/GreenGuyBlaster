package com.gcstudios.entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.gcstudios.main.Game;

public class Explosion extends Entity{
	
	private int frames = 0;
	private int targetFrames = 6;
	private int maxAnimation = 2;
	private int curAnimation = 0;
	
	public BufferedImage[] explosionSprite = new BufferedImage[3];

	public Explosion(double x, double y, int width, int height, double speed, BufferedImage sprite) {
		super(x, y, width, height, speed, sprite);
		
		explosionSprite[0] = Game.spritesheet.getSprite(32, 0, 16, 16);
		explosionSprite[1] = Game.spritesheet.getSprite(48, 0, 16, 16);
		explosionSprite[2] = Game.spritesheet.getSprite(64, 0, 16, 16);
		
	}
	
	public void tick() {
		frames++;
		if(frames == targetFrames) {
			frames = 0;
			curAnimation++;
			if(curAnimation > maxAnimation) {
				Game.entities.remove(this);
				return;
			}
		}
	}
	
	public void render(Graphics g) {
		g.drawImage(explosionSprite[curAnimation], this.getX(), this.getY(), null);
	}

}
