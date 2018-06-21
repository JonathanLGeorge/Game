package gameproject2016;
import java.awt.Graphics;
import java.awt.Color;

public class HUD {
    
    public static int HEALTH = 100;
    
    private int score = 0;
    private int level = 1;
    
    public void tick(){
        
        HEALTH = GameProject2016.clamp(HEALTH, 0, 100);
        score++;
    }
    
    public void render(Graphics g){
        g.setColor(Color.gray);
        g.fillRect(15, 15, 200, 32);
        g.setColor(Color.green);
        g.fillRect(15, 15, HEALTH * 2, 32);
        g.setColor(Color.white);
        g.drawRect(15, 15, 200, 32);
        
        g.drawString("Score: " + score, 15, 64); // position of text
        g.drawString("Level: " + level, 15, 80);
    }
    
    public void score(int score){
        this.score = score;
    }
    public int getScore(){
        return score;
    }
    public int getLevel(){
        return level;
    }
    public void setLevel(int level){
        this.level = level;
    }
}

