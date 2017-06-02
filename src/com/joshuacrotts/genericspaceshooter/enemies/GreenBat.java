package com.joshuacrotts.genericspaceshooter.enemies;

import java.awt.Graphics2D;

import com.joshuacrotts.genericspaceshooter.main.Bullet;
import com.joshuacrotts.genericspaceshooter.main.GenericSpaceShooter;
import com.joshuacrotts.standards.StdOps;

public class GreenBat extends Enemy{

	
	
	public GreenBat(double x, double y){
		super(x, y);
		
		this.currentSprite = StdOps.loadImage("Resources/greenbat.png");
		
		this.width = this.currentSprite.getWidth();
		this.height = this.currentSprite.getHeight();
		
		this.health = 40;
		
		this.velY = StdOps.rand(0, 5);
		
		
	}
	
	public void tick(){
		
		if(this.health <= 0 || this.y >= 900){
			GenericSpaceShooter.gssh.removeEntity(this);
			return;
		}
		
		this.x += this.velX;
		this.y += this.velY;
		
		this.fireBulletCheck();
		this.fireBullet();
		
	}
	
	public void render(Graphics2D g2){
		g2.drawImage(this.currentSprite, (int) x, (int) y, null);
	}
	
	public void fireBullet(){
		if(this.interval < 150){
			return;
		}else{
			this.interval = 0;
			GenericSpaceShooter.gssh.addEntity(new Bullet((this.x + this.width / 2), this.y, 20, this.getId()));
		}
	}
	
	private void fireBulletCheck(){
		this.interval += StdOps.rand(0, 2);
		
		if(this.interval > 150){
			this.interval = 150;
		}
	}
}
