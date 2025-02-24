package gameproject2016;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.AlphaComposite;
import java.awt.Color;

public class Trial extends GameObject{
    private float alpha = 1;
    private Handler handler;
    private Color color;
    private int width, height;
    private float life;
    
    public Trial(int x, int y, ID id, Color color, int width, int height, 
            float life, Handler handler){
        super(x, y, id);
        this.color = color;
        this.width = width;
        this.height = height;
        this.life = life;
        this.handler = handler;
        
        // life =0.001 -0.1
    }
    
    public void tick(){
        if (alpha > life){
            alpha -= (life - 0.004f);
        } else {
            handler.removeObject(this);
        }
        
    }
    public void render(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setComposite(makeTransparent(alpha));
        
        g.setColor(color);
        g.fillRect(x, y, width, height);
        
        g2d.setComposite(makeTransparent(1)); // need this to make sure 
        //the thing you wanted is trasparent. otherside other object might glitch
    }
    
    private AlphaComposite makeTransparent(float alpha){
        int type = AlphaComposite.SRC_OVER;
        return(AlphaComposite.getInstance(type, alpha));
        //method that reders out trasparent trial
    }
    
    public Rectangle getBounds(){
        return null;
    }
}
