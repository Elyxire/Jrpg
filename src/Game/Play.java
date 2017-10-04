package Game;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.tiled.TiledMap;

public class Play extends BasicGameState{
	
	private SpriteSheet Sperso;
	private Animation sprite,down,up,left,right;
	private float X ,Y;
	int direction;
	int[] duration={200,200};
	private TiledMap map;
	int id;
	Maps m;
	private float xCamera, yCamera;
	Perso p;
	boolean talk=false;
	public static boolean m1=false;
	public static boolean m2=false;
	public static int persoId=0;
	Music music;
	
	public Play(int State){
	}
	
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		X= 100f;Y=200f;
		id=0;
		m=new Maps(id);
		
		xCamera=X;yCamera=Y;
		
		p = new Perso(0,duration);
        sprite=p.down;
        direction=0;
        map=new TiledMap(m.path);
        gc.setTargetFrameRate(60);
		music=new Music("res/mus1.ogg");
		music.loop();
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		//camera
		if (m.path=="res/maps/map4.tmx" || m.path=="res/maps/map5.tmx"){
			g.translate(gc.getWidth() / 2 - (int) this.xCamera, 
		    gc.getHeight() / 2 - (int) this.yCamera);
			}
		
		map.render(0,0,0);
		map.render(0,0,1);
		map.render(0, 0, 2);
		if(m.path!="res/maps/map2.tmx"){
			map.render(0, 0, 3);
		}
		if(m1 && m.path=="res/maps/map2.tmx"){
		map.render(0, 0, 3);
		}
		sprite.draw((int)X,(int)Y);
		
		map.render(0, 0, 4);
		if(talk && m.path=="res/maps/map1.tmx"){
		map.render(0, 0, 5);      //après collision avec le png
		}
		if(!m1 && m.path=="res/maps/map2.tmx"){
		map.render(0, 0, 5);
		}
		if(m.path=="res/maps/map4.tmx"){
			map.render(0, 0,5);
		}
		if(m.path=="res/maps/map5.tmx"){
			map.render(0, 0,5);
		}
		map.render(0, 0,6);
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta ) throws SlickException {
		//System.out.println("X  "+X+"Y  "+Y+"futurX  "+getFuturX(delta)+"futurY  "+getFuturY(delta));
		Input input = gc.getInput();
		 if ((!talk) && input.isKeyDown(Input.KEY_S))
		 {
		     sprite = p.down;
		     direction=2;
		     sprite.update(delta);
		     Y += delta * 0.1f;
		     float futurX = getFuturX(delta);
		        float futurY = getFuturY(delta);
		        boolean collision1 = isCollision(futurX+15, futurY+43);
		        boolean collision2 = isCollision(futurX+33, futurY+43);
		     if(collision1 || collision2){
		    	 Y -= delta * 0.1f;
		     }
		     boolean teleport1 = isTeleport(futurX+5, futurY+43);
		        boolean teleport2 = isTeleport(futurX+43, futurY+43);
		     if(teleport1 || teleport2){
		    	 if(Math.abs(futurX-m.X2)<=48 && Math.abs(futurY-m.Y2)<=48){
			 	 id=m.nextId;
			 	 m=new Maps(id);
			 	 map=new TiledMap(m.path);
			 	 X=m.X1;
			 	 Y=m.Y1;
		    	 }else{
		    		 id=m.prevId;
				 	 m=new Maps(id);
				 	 map=new TiledMap(m.path);
				 	 X=m.X2;
				 	 Y=m.Y2;
		    	 }
			 }
		     
		     
		     
		     
		 }else if ((!talk) && input.isKeyDown(Input.KEY_Z))
		 {
		     sprite = p.up;
		     direction = 0;
		     sprite.update(delta);
		     Y -= delta * 0.1f;
		     
		     float futurX = getFuturX(delta);
		        float futurY = getFuturY(delta);
		        boolean collision1 = isCollision(futurX+15, futurY+5+24);     // -24 pour que la tête ne detecte pas les collisions
		        boolean collision2 = isCollision(futurX+33, futurY+5+24);
		     if(collision1 || collision2){
		    	 Y += delta * 0.1f;
		     }
		     boolean teleport1 = isTeleport(futurX+5, futurY+5);
		        boolean teleport2 = isTeleport(futurX+43, futurY+5);
		     if(teleport1 || teleport2){
		    	 if(Math.abs(futurX-m.X2)<=100 && Math.abs(futurY-m.Y2)<=100){  //si le perso est proche de X1,Y1 ou X2,Y2
			 	 id=m.nextId;
			 	 m=new Maps(id);
			 	 map=new TiledMap(m.path);
			 	 X=m.X1;
			 	 Y=m.Y1;
		    	 }else{
		    		 id=m.prevId;
				 	 m=new Maps(id);
				 	 map=new TiledMap(m.path);
				 	 X=m.X2;
				 	 Y=m.Y2;
		    	 }
			 }
		     if(m.path=="res/maps/map1.tmx"){
		     boolean png1 = isPng(futurX+5, futurY+5);
		        boolean png2 = isPng(futurX+43, futurY+5);
		     if((png1 || png2) && m.path=="res/maps/map1.tmx"){
		    	 talk=true;
			 }
		     }
		     if(m.path=="res/maps/map2.tmx") {
		     boolean monster1 = isMonster(futurX+5, futurY+5);
		        boolean monster2 = isMonster(futurX+43, futurY+5);
		     if((monster1 || monster2) && (!m1)){
		    	 m1=true;
		    	 sbg.enterState(2);
			 }
		     }
		     if(m.path=="res/maps/map5.tmx"){
		    	 if(Y<1700f){
		    	 boolean monster1 = isMonster(futurX+5, futurY+5);
			        boolean monster2 = isMonster(futurX+43, futurY+5);
			        if((monster1 || monster2) && (!m2)){
				    	 m2=true;
				    	 sbg.enterState(2);
					 }
		    	 }
		     }
		     
		 }else if ((!talk) && input.isKeyDown(Input.KEY_Q))
		 {
		     sprite = p.left;
		     direction=1;
		     sprite.update(delta);
		     X -= delta * 0.1f;
		     
		     float futurX = getFuturX(delta);
		        float futurY = getFuturY(delta);
		        boolean collision1 = isCollision(futurX+15, futurY+5+24);
		        boolean collision2 = isCollision(futurX+15, futurY+43);
		     if(collision1 || collision2){
		    	 X += delta * 0.1f;
		     }
		     boolean teleport1 = isTeleport(futurX+5, futurY+5);
		        boolean teleport2 = isTeleport(futurX+5, futurY+43);
		     if(teleport1 || teleport2){
		    	 if(Math.abs(futurX-m.X2)<=100 && Math.abs(futurY-m.Y2)<=100){
			 	 id=m.nextId;
			 	 m=new Maps(id);
			 	 map=new TiledMap(m.path);
			 	 X=m.X1;
			 	 Y=m.Y1;
		    	 }else{
		    		 id=m.prevId;
				 	 m=new Maps(id);
				 	 map=new TiledMap(m.path);
				 	 X=m.X2;
				 	 Y=m.Y2;
		    	 }
			 }
		     boolean png1 = isPng(futurX+5, futurY+5);
		        boolean png2 = isPng(futurX+5, futurY+43);
		     if((png1 || png2) && m.path=="res/maps/map1.tmx"){
		    	 talk=true;
			 }
		     
		     
		 }else if ((!talk) && input.isKeyDown(Input.KEY_D))
		 {
		     sprite = p.right;
		     direction=3;
		     sprite.update(delta);
		     X += delta * 0.1f;
		     float futurX = getFuturX(delta);
		        float futurY = getFuturY(delta);
		        boolean collision1 = isCollision(futurX+33, futurY+5+24);
		        boolean collision2 = isCollision(futurX+33, futurY+43);
		        
		     if(collision1 || collision2){
			     X -= delta * 0.1f;
		     }
		     boolean teleport1 = isTeleport(futurX+43, futurY+5);
		        boolean teleport2 = isTeleport(futurX+43, futurY+43);
		     if(teleport1 || teleport2){
		    	 if(Math.abs(futurX-m.X2)<=100 && Math.abs(futurY-m.Y2)<=100){
			 	 id=m.nextId;
			 	 m=new Maps(id);
			 	 map=new TiledMap(m.path);
			 	 X=m.X1;
			 	 Y=m.Y1;
		    	 }else{
		    		 id=m.prevId;
				 	 m=new Maps(id);
				 	 map=new TiledMap(m.path);
				 	 X=m.X2;
				 	 Y=m.Y2;
		    	 }
			 }
		     boolean png1 = isPng(futurX+43, futurY+5);
		        boolean png2 = isPng(futurX+43, futurY+43);
		     if((png1 || png2) && m.path=="res/maps/map1.tmx"){
		    	 talk=true;
			 }
		     
		     
		 }else if (input.isKeyPressed(Input.KEY_ESCAPE))
		 {
			 //restart the game
			 sbg.getState( 1 ).init(gc, sbg);
	         sbg.enterState( 0 );
	         
		 }else if (talk)
		 {
			 if(input.isKeyPressed(Input.KEY_H)){
				 p = new Perso(1,duration);
				 persoId=0;
				 talk=false;
			 }else if(input.isKeyPressed(Input.KEY_J)){
				 p = new Perso(2,duration);
				 persoId=1;
				 talk=false;
			 }else if(input.isKeyPressed(Input.KEY_K)){
				 p = new Perso(3,duration);
				 persoId=2;
				 talk=false;
			 }else if(input.isKeyPressed(Input.KEY_L)){
				 p = new Perso(4,duration);
				 persoId=3;
				 talk=false;
			 }
		 }
		 
		 this.xCamera = this.X;
		 this.yCamera = this.Y;
		 //camera suiveuse flottante
		 
		
	}
	
	public int getID(){
		return 1;
	}
	
	private boolean isCollision(float x, float y) {
	    int tileW = this.map.getTileWidth();
	    int tileH = this.map.getTileHeight();
	    int logicLayer = this.map.getLayerIndex("tile2");
	    Image tile = this.map.getTileImage((int) x / tileW, (int) y / tileH, logicLayer);
	    boolean collision = tile != null;
	    if (collision) {
	        Color color = tile.getColor((int) x % tileW, (int) y % tileH);
	        collision = color.getAlpha() > 0;
	    }
	    return collision;
	}
	
	private boolean isTeleport(float x, float y) {
	    int tileW = this.map.getTileWidth();
	    int tileH = this.map.getTileHeight();
	    int logicLayer = this.map.getLayerIndex("tile3");
	    Image tile = this.map.getTileImage((int) x / tileW, (int) y / tileH, logicLayer);
	    boolean teleport = tile != null;
	    if (teleport) {
	        Color color = tile.getColor((int) x % tileW, (int) y % tileH);
	        teleport = color.getAlpha() > 0;
	    }
	    return teleport;
	}
	
	private boolean isPng(float x, float y) {
	    int tileW = this.map.getTileWidth();
	    int tileH = this.map.getTileHeight();
	    int logicLayer = this.map.getLayerIndex("tile5");
	    Image tile = this.map.getTileImage((int) x / tileW, (int) y / tileH, logicLayer);
	    boolean png = tile != null;
	    if (png) {
	        Color color = tile.getColor((int) x % tileW, (int) y % tileH);
	        png = color.getAlpha() > 0;
	    }
	    return png;
	}
	private boolean isMonster(float x, float y) {
	    int tileW = this.map.getTileWidth();
	    int tileH = this.map.getTileHeight();
	    int logicLayer = this.map.getLayerIndex("tile6");
	    Image tile = this.map.getTileImage((int) x / tileW, (int) y / tileH, logicLayer);
	    boolean monster = tile != null;
	    if (monster) {
	        Color color = tile.getColor((int) x % tileW, (int) y % tileH);
	        monster = color.getAlpha() > 0;
	    }
	    return monster;
	}

	private float getFuturX(int delta) {
	    float futurX = this.X;
	    switch (this.direction) {
	    case 1: futurX = this.X - 0.1f * delta; break;
	    case 3: futurX = this.X + 0.1f * delta; break;
	    }
	    return futurX;
	}

	private float getFuturY(int delta) {
	    float futurY = this.Y;
	    switch (this.direction) {
	    case 0: futurY = this.Y - 0.1f * delta; break;
	    case 2: futurY = this.Y + 0.1f * delta; break;
	    }
	    return futurY;
	}
	
}
