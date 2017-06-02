package com.joshuacrotts.genericspaceshooter.main;

import java.awt.image.BufferedImage;

import com.joshuacrotts.genericspaceshooter.enemies.GreenBat;
import com.joshuacrotts.standards.StandardDraw;
import com.joshuacrotts.standards.StandardGame;
import com.joshuacrotts.standards.StandardHandler;
import com.joshuacrotts.standards.StdOps;

public class GenericSpaceShooter extends StandardGame{
	
	//Image reference:
	//http://wallpapercave.com/wp/jnmJ9pp.jpg
		
	private static final long serialVersionUID = -7923114031576573406L;

	//Inits the new handler to handle collisions
	public static StandardHandler gssh;
	
	//Inits the objects in the game
	private Player player;
	
	//Background init
	private static BufferedImage bg = null;
	
	//Etc instance variables
	public static int score = 0;
	
	public GenericSpaceShooter(int w, int h){
		super(w, h, "Generic Space Shooter in Under 30 Minutes!");
		this.consoleFPS = false;
		
		GenericSpaceShooter.bg = StdOps.loadImage("Resources/bg.png");
		
		
		GenericSpaceShooter.gssh = new GenericSpaceShooterHandler();
		
		this.player = new Player(300, 720, this);
		
		
		GenericSpaceShooter.gssh.addEntity(this.player);
		
		this.addListener(player);
		
		this.StartGame();
	}
	
	public void tick(){
		if(GenericSpaceShooter.gssh.size() < 20)
			GenericSpaceShooter.gssh.addEntity(new GreenBat(StdOps.rand(0, 760), StdOps.rand(-200, -50)));
		
		StandardHandler.Handler(gssh);
		
		GenericSpaceShooter.score++;
	}
	
	public void render(){
		StandardDraw.image(GenericSpaceShooter.bg, 0, 0); 
		StandardDraw.Handler(gssh);
		
	}
	
	public static void main(String[] args) {
		new GenericSpaceShooter(800,800);
	}
}
