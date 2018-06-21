package gameproject2016;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.util.Random;
import java.awt.Rectangle;

public class Player extends GameObject{
    
    Random r = new Random();
    Handler handler;
    
    
    public Player(int x, int y, ID id, Handler handler){
        super(x,y,id);
        this.handler =  handler;
        
       // velX = r.nextInt(5) - 1; // this will move the object randomly
       // velY = r.nextInt(5) - 1;
    }
    
    public Rectangle getBounds(){
        return new Rectangle(x, y, 32, 32);
    }

    public void tick(){
        x += velX;
        y += velY;
        
        x = GameProject2016.clamp(x, 0, GameProject2016.WIDTH - 38);
        y = GameProject2016.clamp(y, 0, GameProject2016.HEIGHT - 64);
        
        collision();
    }
    
    private void collision(){
        for(int i = 0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);
            
            if (tempObject.getId() == ID.BasicEnemy || tempObject.getId() == 
                    ID.FastEnemy){
                //collision code // temp object is the enemyclass
                if(getBounds().intersects(tempObject.getBounds())){
                    HUD.HEALTH -= 2;
                }
            }
        }
    }
    

    public void render(Graphics g){
        Graphics2D g2D = (Graphics2D) g;
        
       // g.setColor(Color.green); these are colision boxes
        //g2D.draw(getBounds());
        
        g.setColor(Color.white);
        g.fillRect(x, y, 32, 32);
    }
}
