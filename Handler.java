package gameproject2016;

import java.util.LinkedList;
import java.awt.Graphics;

public class Handler {
    
    LinkedList<GameObject> object = new LinkedList<GameObject>();
    
    public void tick(){
        for (int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);
            
            tempObject.tick();
        }
    }
    public void render(Graphics g){
        for (int i = 0; i <object.size(); i++){
            GameObject tempObject = object.get(i);
            
            tempObject.render(g);
        }
    }
    
    public void addObjects(GameObject object){
        this.object.add(object);
    }
    
    public void removeObject(GameObject object){
        this.object.remove(object);
    }
}
