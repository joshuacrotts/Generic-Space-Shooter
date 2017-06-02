package com.joshuacrotts.genericspaceshooter.main;

import java.awt.Graphics2D;

import com.joshuacrotts.standards.StandardGameObject;
import com.joshuacrotts.standards.StandardID;
import com.joshuacrotts.standards.StdOps;

public class Bullet extends StandardGameObject{
	
	public Bullet(double x, double y, double velY, StandardID id){
		this.x = x;
		this.y = y;
		this.id = (id == StandardID.Player) ? StandardID.Weapon: StandardID.Obstacle;
		
		this.currentSprite = StdOps.loadImage("Resources/bullet.png");
		
		this.width = this.currentSprite.getWidth();
		this.height = this.currentSprite.getHeight();
		
		this.velY = velY;
	}
	
	public void tick(){
		
		
		if(this.y <= -300 || this.y >= 1500){
			GenericSpaceShooter.gssh.removeEntity(this);
			return;
		}
		
		
		this.x += this.velX;
		this.y += this.velY;
	}
	
	public void render(Graphics2D g2){
		if(Math.signum(this.velY) == -1){
			g2.drawImage(this.currentSprite, (int) x - 2, (int) y, null);
		}else{
			g2.drawImage(this.currentSprite, (int) x - 2, (int) y, width, -height, null);
		}
			
	}
	
	
}
