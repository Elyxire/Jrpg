package Game;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class Perso {
	SpriteSheet img=new SpriteSheet("res/characters/Package1.png",48,48);
	Image [] movementUp = {img.getSubImage(0, 3*48, 48, 48), img.getSubImage(2*48, 3*48, 48, 48)};
    Image [] movementDown = {img.getSubImage(0, 0, 48, 48),img.getSubImage(2*48, 0, 48, 48)};
    //,img.getSubImage(3*64, 0, 64, 64) img.getSubImage(0, 0, 64, 64), 
    Image [] movementLeft = {img.getSubImage(0, 48, 48, 48),img.getSubImage(2*48, 48, 48, 48)};
    Image [] movementRight = {img.getSubImage(0, 2*48, 48, 48),img.getSubImage(2*48, 2*48, 48, 48)};
    Animation up;
    Animation down;
    Animation right;
    Animation left;
    public int id;
    Perso(int id,int[]duration) throws SlickException{
    	if(id==0){
    		img=new SpriteSheet("res/characters/SF_Actor1.png",48,48);
    		movementUp [0] = img.getSubImage(0, 3*48, 48, 48);
    		movementUp [1] = img.getSubImage(2*48, 3*48, 48, 48);
    	    movementDown [0] = img.getSubImage(0, 0, 48, 48);
    	    movementDown [1] = img.getSubImage(2*48, 0, 48, 48);
    	    movementLeft [0] = img.getSubImage(0, 48, 48, 48);
    	    movementLeft [1] = img.getSubImage(2*48, 48, 48, 48);
    	    movementRight [0] = img.getSubImage(0, 2*48, 48, 48);
    	    movementRight [1] = img.getSubImage(2*48, 2*48, 48, 48);
    	}else if(id==1){
    		img=new SpriteSheet("res/characters/Package1.png",48,48);
    		movementUp [0] = img.getSubImage(0, 3*48, 48, 48);
    		movementUp [1] = img.getSubImage(2*48, 3*48, 48, 48);
    	    movementDown [0] = img.getSubImage(0, 0, 48, 48);
    	    movementDown [1] = img.getSubImage(2*48, 0, 48, 48);
    	    movementLeft [0] = img.getSubImage(0, 48, 48, 48);
    	    movementLeft [1] = img.getSubImage(2*48, 48, 48, 48);
    	    movementRight [0] = img.getSubImage(0, 2*48, 48, 48);
    	    movementRight [1] = img.getSubImage(2*48, 2*48, 48, 48);
    	}else if(id==2){
    		img=new SpriteSheet("res/characters/Package1.png",48,48);
    		movementUp [0] = img.getSubImage(3*48 + 0, 3*48, 48, 48);
    		movementUp [1] = img.getSubImage(3*48 + 2*48, 3*48, 48, 48);
    	    movementDown [0] = img.getSubImage(3*48 + 0, 0, 48, 48);
    	    movementDown [1] = img.getSubImage(3*48 + 2*48, 0, 48, 48);
    	    movementLeft [0] = img.getSubImage(3*48 + 0, 48, 48, 48);
    	    movementLeft [1] = img.getSubImage(3*48 + 2*48, 48, 48, 48);
    	    movementRight [0] = img.getSubImage(3*48 + 0, 2*48, 48, 48);
    	    movementRight [1] = img.getSubImage(3*48 + 2*48, 2*48, 48, 48);
    	}else if(id==3){
    		img=new SpriteSheet("res/characters/Package1.png",48,48);
    		movementUp [0] = img.getSubImage(6*48 + 0, 3*48, 48, 48);
    		movementUp [1] = img.getSubImage(6*48 + 2*48, 3*48, 48, 48);
    	    movementDown [0] = img.getSubImage(6*48 + 0, 0, 48, 48);
    	    movementDown [1] = img.getSubImage(6*48 + 2*48, 0, 48, 48);
    	    movementLeft [0] = img.getSubImage(6*48 + 0, 48, 48, 48);
    	    movementLeft [1] = img.getSubImage(6*48 + 2*48, 48, 48, 48);
    	    movementRight [0] = img.getSubImage(6*48 + 0, 2*48, 48, 48);
    	    movementRight [1] = img.getSubImage(6*48 + 2*48, 2*48, 48, 48);
    	}else if(id==4){
    		img=new SpriteSheet("res/characters/Package1.png",48,48);
    		movementUp [0] = img.getSubImage(9*48 + 0, 3*48, 48, 48);
    		movementUp [1] = img.getSubImage(9*48 + 2*48, 3*48, 48, 48);
    	    movementDown [0] = img.getSubImage(9*48 + 0, 0, 48, 48);
    	    movementDown [1] = img.getSubImage(9*48 + 2*48, 0, 48, 48);
    	    movementLeft [0] = img.getSubImage(9*48 + 0, 48, 48, 48);
    	    movementLeft [1] = img.getSubImage(9*48 + 2*48, 48, 48, 48);
    	    movementRight [0] = img.getSubImage(9*48 + 0, 2*48, 48, 48);
    	    movementRight [1] = img.getSubImage(9*48 + 2*48, 2*48, 48, 48);
    	}
    	up=new Animation(movementUp, duration, false);
        down=new Animation(movementDown, duration, false);
        right=new Animation(movementRight, duration, false);
        left=new Animation(movementLeft, duration, false);
        this.id=id;
    }
	
}
