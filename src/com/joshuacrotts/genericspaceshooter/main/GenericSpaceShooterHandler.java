package com.joshuacrotts.genericspaceshooter.main;

import java.awt.Graphics2D;
import java.util.ArrayList;

import com.joshuacrotts.standards.StandardGameObject;
import com.joshuacrotts.standards.StandardHandler;
import com.joshuacrotts.standards.StandardID;

public class GenericSpaceShooterHandler extends StandardHandler{

	public GenericSpaceShooterHandler(){
		this.entities = new ArrayList<StandardGameObject>();
	}
	
	@Override
	public void tick(){
		for(int i = 0; i < this.entities.size(); i++){
			
			//Player to Bullet collision
			if(this.entities.get(i).getId() == StandardID.Player){
				
				for(int j = 0; j < this.entities.size(); j++){
					
					
					if(this.entities.get(j).getId() == StandardID.Obstacle &&
							this.entities.get(j).getBounds().intersects(this.entities.get(i).getBounds())){
						
							this.entities.get(i).health -= 20;
							this.entities.remove(j);
							j--;
						
					}
					
				}
				
			}
			
			//Player bullet to Enemy
			if(this.entities.get(i).getId() == StandardID.Weapon){
				
				for(int j = 0; j < this.entities.size(); j++){
					
					if(this.entities.get(j).getId() == StandardID.Enemy &&
							this.entities.get(j).getBounds().intersects(this.entities.get(i).getBounds())){
						
						this.entities.get(j).health -= 20;
						
						
					}
					
				}
				
			}
			
			this.entities.get(i).tick();
		}
	}
	
	@Override
	public void render(Graphics2D g2){
		for(int i = 0; i < this.entities.size(); i++){
			this.entities.get(i).render(g2);
		}
	}
}
