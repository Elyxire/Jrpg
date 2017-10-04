package Game;

import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class BattleEnnemy {
	private Image ennemy;
	
	private int pv=50;
	

	  public void init() throws SlickException {
		  ennemy = new Image("res/Minotaur.png");
	    if(!Play.m2){
	    	this.ennemy = new Image("res/Minotaur.png");
	    	this.pv=50;
		}else{
			this.ennemy = new Image("res/66.png");
			this.pv=1300;
		}
	  }

	  public void render(GameContainer gc,  Graphics g) {
		  if(pv<650 && Play.m2){
			  try {
				ennemy=new Image("res/SF_Seiryu.png");
			} catch (SlickException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }
	    this.ennemy.drawCentered(gc.getWidth() * 1 / 4, gc.getHeight() / 2);
	    Font font = g.getFont();
	    String text = "pv ennemy: "+Integer.toString(pv);
	    font.drawString(gc.getWidth() * 1 / 4 - font.getWidth(text) / 2, gc.getHeight() / 2 - ennemy.getHeight() / 2 - font.getLineHeight(), text, Color.white);
	  }

	  
		  
	
	  public void setPv(int pv) { this.pv = pv; }
	  public int getPv() { return pv; }
	  public void setImage(){try {
		ennemy=new Image("res/66.png");
	} catch (SlickException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}}
}


