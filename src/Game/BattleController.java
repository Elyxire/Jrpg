package Game;

import java.awt.Image;
import java.util.Random;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.command.Command;
import org.newdawn.slick.command.InputProviderListener;
import org.newdawn.slick.state.StateBasedGame;

public class BattleController implements InputProviderListener {
	public enum BattleCommand implements Command {
		  ATTACK, DEFEND, FLEE
		}
	 private BattlePlayer player;
	  private BattleEnnemy ennemy;
	  private StateBasedGame sbg;
	  private Random random = new Random();

	  public BattleController(BattlePlayer player, BattleEnnemy ennemy, StateBasedGame sbg) {
	    this.player = player;
	    this.ennemy = ennemy;
	    this.sbg = sbg;
	  }

	  public void controlPressed(Command command) {
	    switch ((BattleCommand) command) {
	      case ATTACK: attack(); break;
	      case DEFEND: defend(); break;
	      case FLEE:   flee();   break;
	      default: break;
	    }
	  }

	  public void controlReleased(Command command) { }

	  private void attack() {
	    // le joueur inflige entre 7 et 10 dégats
	    int playerAttack = 7 ;//+ random.nextInt(4); 
	    //if (random.nextDouble() < .1) { // 10%
	     // playerAttack += playerAttack / 2; // +50% de dégats
	    //}
	    ennemy.setPv(ennemy.getPv() - playerAttack);
	    if (ennemy.getPv() <= 0) { // ennemi mort ?
	        	//ennemy=new Image("re/66.png");
	    		ennemy.setImage();
				ennemy.setPv(1300);
			
	    	sbg.enterState(1);  // retour à la carte
	    } else { 
	      // l'ennemi inflige entre 5 et 9 dégats
	      int ennemyAttack = 5 ;//+ random.nextInt(5);
	      player.setPv(player.getPv() - ennemyAttack);
	      if (player.getPv() <= 0) { // joueur mort ?
	        sbg.enterState(0); // retour titre
	      }
	    }	
	  }

	  private void defend() {
	    // l'ennemi inflige entre 5 et 9 dégâts, la moitié est absorbée
	    int ennemyAttack = (5) ;//+ random.nextInt(5)) / 2;
	    player.setPv(player.getPv() - ennemyAttack);
	    if (player.getPv() <= 0) { // joueur mort ?
	      sbg.enterState(0); // retour titre
	    }
	  }

	  private void flee() {
	    // l'ennemi inflige entre 5 et 9 dégats
	    int ennemyAttack = 5 ;//+ random.nextInt(5);
	    player.setPv(player.getPv() - ennemyAttack);
	    if (player.getPv() <= 0) { // joueur mort ?
	      sbg.enterState(0); // retour titre
	    } else {
	      sbg.enterState(1); // retour à la carte
	    }
	  }



}


		 
