package gameproject2016;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Rectangle;

public class BasicEnemy extends GameObject {
    
    private Handler handler;

    public BasicEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        
        this.handler = handler;

        velX = 5;
        velY = 5;
    }
    
    public Rectangle getBounds(){
        return new Rectangle(x, y, 16, 16);
    }

    public void tick() {
        x += velX;
        y += velY;

        if (y <= 0 || y >= GameProject2016.HEIGHT - 50) {
            velY *= -1; //when object hits wall velocity is reversed 
        }
        if (x <= 0 || x >= GameProject2016.WIDTH - 20) {
            velX *= -1; //when object hits wall velocity is reversed
        }
        
        handler.addObjects(new Trial(x, y, ID.Trial, Color.red, 16, 16, 0.05f, 
                handler));
    }

    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(x, y, 16, 16);
    }

}
