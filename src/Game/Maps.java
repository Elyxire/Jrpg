package Game;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public class Maps {
	public String path="res/maps/map0.tmx";
	public float X1,Y1,X2,Y2;
	public int prevId,nextId;
	Maps(int id){
		if(id==0){
			path="res/maps/map0.tmx";
			X1 = 100f;                     //X1,Y1 :position à l'entrée et X2,Y2 :position à la sortie
			Y1 = 200f;
			X2 = 388f;
			Y2 = 528f;
			nextId = 1;
		}else if(id==1){
			path="res/maps/map1.tmx";
			X1 = 246f;
			Y1 = 294f;
			X2 = 387f;
			Y2 = 50f;
			prevId = 0;
			nextId = 2;
		}else if(id==2){
			path="res/maps/map2.tmx";
			X1 = 336f;
			Y1 = 432f;
			X2 = 480f;
			Y2 = 50f;
			prevId = 1;
			nextId = 3;
		
		}else if(id==3){
			path="res/maps/map3.tmx";
			X1 = 384f;
			Y1 = 432f;
			X2 = 384f;
			Y2 = 48f;
			prevId = 2;
			nextId = 4;
		
	
		}else if(id==4){
			path="res/maps/map4.tmx";
			X1 = 1008f;
			Y1 = 2304f;
			X2 = 1008f;
			Y2 = 768f;
			prevId = 3;
			nextId = 5;
		
		}else if(id==5){
			path="res/maps/map5.tmx";
			X1 = 384f;
			Y1 = 2256f;
			X2 = 0f;
			Y2 = 0f;
			prevId = 4;
		}
	}
	}
	

