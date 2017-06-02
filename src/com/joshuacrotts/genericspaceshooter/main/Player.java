package com.joshuacrotts.genericspaceshooter.main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

import com.joshuacrotts.standards.StandardDraw;
import com.joshuacrotts.standards.StandardGameObject;
import com.joshuacrotts.standards.StandardID;
import com.joshuacrotts.standards.StdOps;

public class Player extends StandardGameObject implements KeyListener{
	
	private GenericSpaceShooter gss;
	
	private short interval = 100;
	
	public Player(double x, double y, GenericSpaceShooter gss){
		super(x, y, StandardID.Player);
		
		this.gss = gss;
		
		this.currentSprite = StdOps.loadImage("Resources/player.png");
		
		this.width = this.currentSprite.getWidth();
		this.height = this.currentSprite.getHeight();
		
		this.health = 50;
		
	}
	
	public void tick(){
		
		if(this.health <= 0){
			GenericSpaceShooter.gssh.removeEntity(this);
			JOptionPane.showMessageDialog(null, "You died, your score was: "+GenericSpaceShooter.score);
			System.exit(0);
		}
		
		
		this.x += this.velX;
		
		this.checkCoordinates();
		
		this.fireBulletCheck();

		
	}
	
	public void render(Graphics2D g2){
		
		g2.drawImage(this.currentSprite, (int) x, (int) y, null);
		
		StandardDraw.text("Life: "+this.health, 20, 50, "", 40f, Color.YELLOW);
		StandardDraw.text("Score: "+GenericSpaceShooter.score, 20, 90, "", 40f, Color.YELLOW);
	}
	
	public void keyPressed(KeyEvent e){
		switch(e.getKeyCode()){
		case KeyEvent.VK_A: this.velX = -5.0; break;
		case KeyEvent.VK_D: this.velX = 5.0; break;
		case KeyEvent.VK_SPACE: this.fireBullet(); break;
		}
	}
	
	public void keyReleased(KeyEvent e){
		switch(e.getKeyCode()){
		case KeyEvent.VK_A: this.velX = 0; break;
		case KeyEvent.VK_D: this.velX = 0; break;
		}
	}
	
	public void keyTyped(KeyEvent e){
		
		
	}
	
	public void checkCoordinates(){
		if(this.x <= 0){
			this.x = 0;
		}
		
		if(this.x >= this.gss.width() - this.width){
			this.x = this.gss.width() - this.width;
			
		}
	}
	
	private void fireBullet(){
		if(this.interval < 20){
			return;
		}else{
			this.interval = 0;
			GenericSpaceShooter.gssh.addEntity(new Bullet((this.x + this.width / 2), this.y, -20, this.getId()));
		}
	}
	
	private void fireBulletCheck(){
		this.interval++;
		
		if(this.interval > 20){
			this.interval = 20;
		}
	}
}
