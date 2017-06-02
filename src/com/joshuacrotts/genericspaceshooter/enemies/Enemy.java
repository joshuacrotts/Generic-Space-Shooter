package com.joshuacrotts.genericspaceshooter.enemies;

import java.awt.Graphics2D;

import com.joshuacrotts.standards.StandardGameObject;
import com.joshuacrotts.standards.StandardID;
import com.joshuacrotts.standards.StdOps;

public abstract class Enemy extends StandardGameObject{
	
	protected int interval = StdOps.rand(0, 120);
	
	public Enemy(double x, double y){
		super(x, y, StandardID.Enemy);
	}


	public abstract void tick();

	public abstract void render(Graphics2D g2);
	
	public abstract void fireBullet();
}
