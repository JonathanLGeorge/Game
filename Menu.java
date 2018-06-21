package gameproject2016;

import static gameproject2016.GameProject2016.HEIGHT;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import gameproject2016.GameProject2016.STATE;
import static gameproject2016.GameProject2016.WIDTH;
import java.util.Random;

public class Menu extends MouseAdapter {

    private GameProject2016 game;
    private Handler handler;
    private Random r = new Random();
    private HUD hud;

    public Menu(GameProject2016 game, Handler handler, HUD hud) {
        this.game = game;
        this.hud = hud;
        this.handler = handler;
    }

    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();

        if (game.gameState == STATE.Menu) {

            // Play button
            if (mouseOver(mx, my, 210, 150, 200, 64)) {
                game.gameState = STATE.Game;
                handler.addObjects(new Player(GameProject2016.WIDTH / 2 - 32,
                        GameProject2016.HEIGHT / 2 - 32, ID.player, handler));
        //handler.addObjects(new BasicEnemy(r.nextInt(WIDTH), r.nextInt(HEIGHT/2-32),
                // ID.BasicEnemy, handler));
                handler.addObjects(new BasicEnemy(r.nextInt(GameProject2016.WIDTH),
                        r.nextInt(GameProject2016.HEIGHT), ID.BasicEnemy, handler));
            }

            //Quit button
            if (mouseOver(mx, my, 210, 350, 200, 64)) {
                System.exit(1);
            }

            // Help button
            if (mouseOver(mx, my, 210, 250, 200, 64)) {
                game.gameState = STATE.Help;
            }
        }
        // back button for help menu
        if(game.gameState == STATE.Help){
            if(mouseOver(mx, my, 210, 350, 200, 64)){
                game.gameState = STATE.Menu;
                return;
            }
        }
        if(game.gameState == STATE.End){
            if(mouseOver(mx, my, 210, 350, 200, 64)){
                //game.gameState = STATE.Game;
               System.exit(1);
                
            }      
        }
    }

    public void mouseReleased(MouseEvent e) {

    }

    private boolean mouseOver(int mx, int my, int x, int y,
            int width, int height) {

        if (mx > x && mx < x + width) {
            if (my > y && my < y + height) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public void tick() {

    }

    public void render(Graphics g) {
        if (game.gameState == STATE.Menu) {

            Font fnt = new Font("arial", 1, 50);
            Font fnt2 = new Font("arial", 1, 50);

            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString("Menu", 240, 70);

            g.setFont(fnt2);
            g.drawRect(210, 150, 200, 64);
            g.drawString("Play", 260, 200);

            g.drawRect(210, 250, 200, 64);
            g.drawString("Help", 260, 300);

            g.drawRect(210, 350, 200, 64);
            g.drawString("Quit", 260, 400);

        } else if (game.gameState == STATE.Help) {
            Font fnt = new Font("arial", 1, 50);
            Font fnt2 = new Font("arial", 1, 20);

            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString("Menu", 240, 70);

            g.setFont(fnt2);
            g.drawString("Use WSAD keys to move.Try to avoid moving objects",
                    50, 200);

            g.setFont(fnt);
            g.drawRect(210, 350, 200, 64);
            g.drawString("Back", 260, 400);
        } else if (game.gameState == STATE.End) {
            Font fnt = new Font("arial", 1, 50);
            Font fnt2 = new Font("arial", 1, 20);

            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString("Game Over", 200, 70);

            g.setFont(fnt2);
            g.drawString("Your score is: " + hud.getScore(), 
                    50, 200);

            g.setFont(fnt);
            g.drawRect(210, 350, 200, 64);
            g.drawString("Quit", 260, 400);
        }

    }
}
