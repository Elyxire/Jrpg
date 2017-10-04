package Game;

import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class BattlePlayer {
	  private int pv = 700;
	  private Image player;

	  // méthode init() vu précédement
	  public void init() throws SlickException {
		    player =  new Image("res/11.png");
		    if(Play.persoId==0){
		    	player = new Image("res/11.png");
		    }else if(Play.persoId==1){
		    	player = new Image("res/22.png");
		    }else if(Play.persoId==2){
		    	player = new Image("res/33.png");
		    }else if(Play.persoId==3){
		    	player = new Image("res/44.png");
		    }
		  }
	  public void render(GameContainer gc) {
		    player.drawCentered(gc.getWidth() * 3 / 4, gc.getHeight() / 2);
		  }
	  // pour cette méthode nous ajoutons l'attribut g
	  public void render(GameContainer gc, Graphics g) {
		  try {if(Play.persoId==0){
		    	player = new Image("res/11.png");
		    }else if(Play.persoId==1){
		    	
					player = new Image("res/22.png");
				}else if(Play.persoId==2){
		    	player = new Image("res/33.png");
		    }else if(Play.persoId==3){
		    	player = new Image("res/44.png");
		    }}catch (SlickException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
		    }
	    player.drawCentered(gc.getWidth() * 3 / 4, gc.getHeight() / 2);
	    Font font = g.getFont();
	    String text = "pv Player :"+Integer.toString(pv);
	    font.drawString(gc.getWidth() * 3 / 4 - font.getWidth(text) / 2, gc.getHeight() / 2 - player.getHeight() / 2 - font.getLineHeight(), text, Color.white);
	  }
	  public void setPv(int pv) { this.pv = pv; }
	  public int getPv() { return pv; }
	}

