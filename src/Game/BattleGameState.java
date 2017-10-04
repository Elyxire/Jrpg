package Game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.command.InputProvider;
import org.newdawn.slick.command.KeyControl;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import Game.BattleController.BattleCommand;

public class BattleGameState extends BasicGameState {
	  // déclaration des autres variables (leçon précédente)
	  private BattleEnnemy ennemy = new BattleEnnemy();
	  private BattlePlayer player = new BattlePlayer();
	  private Image start;

	  public BattleGameState(int State) {
	}

	@Override
	  public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
	    // initialisation du fond (leçon précédente)
		if(!Play.m2){
			start = new Image("res/Plain.png");
			
		}else{
			start = new Image("res/Hexagram.png");
			
		}
		this.ennemy.init();
		
	    
	    this.player.init();
	    InputProvider provider = new InputProvider(gc.getInput());
	    provider.bindCommand(new KeyControl(Input.KEY_W), BattleCommand.ATTACK);
	    provider.bindCommand(new KeyControl(Input.KEY_X), BattleCommand.DEFEND);
	    provider.bindCommand(new KeyControl(Input.KEY_C), BattleCommand.FLEE);
	    provider.addListener(new BattleController(player, ennemy, sbg));
		
	    
	  }

	  @Override
	  public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
	    // affichage du fond (leçon précédente)
		start.draw();
	    this.player.render(gc,g);
	    this.ennemy.render(gc, g);
	    
	  }
	  @Override
	  public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException { }

	  @Override
	  public int getID() {
	    return 2;
	  }
	}

