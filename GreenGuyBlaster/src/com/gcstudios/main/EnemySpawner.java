package com.gcstudios.main;

import com.gcstudios.entities.Enemy;
import com.gcstudios.entities.Entity;

public class EnemySpawner {
	
	public int targetTime = 120;
	public int curTime = 0;
	
	public void tick() {
		curTime++;
		if(curTime == targetTime) {
			curTime = 0;
			int yy = 0;
			int xx = Entity.rand.nextInt(Game.WIDTH - 16);
			Enemy enemy = new Enemy(xx, yy, 16, 16, 1, Game.spritesheet.getSprite(16,  0,  16,  16));
			Game.entities.add(enemy);
		}
	}

}
