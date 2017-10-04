package Game;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Menu extends BasicGameState{
	
	private Image start;
	
	public Menu(int State){
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		
		start = new Image("res/Book.png");
		
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		start.draw();
		g.drawString("PRESS START", 380, 500);
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta ) throws SlickException {
		Input input = gc.getInput();
		if(input.isKeyDown(Input.KEY_ENTER)){
			sbg.enterState(1);
		}else if(input.isKeyPressed(Input.KEY_ESCAPE)){
			gc.exit();
		}
		
	}
	
	public int getID(){
		return 0;
	}
	
}
