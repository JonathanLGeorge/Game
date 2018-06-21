/*
 * Java Class final Project 
 * 05/13/2016
 * 
 */
package gameproject2016;

import java.awt.Canvas;
import java.awt.image.BufferStrategy;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;



public class GameProject2016 extends Canvas implements Runnable {

    private static final long serialVersionUID = 1550691097823471818L;

    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;

    private Thread thread;
    private boolean running = false;
    
    private Random r;
    private Handler handler;
    private HUD hud;
    private Spawn spawner;
    private Menu menu;
    
    
    public enum STATE{
        Menu,
        Game,
        Help,
        End;
    };
    
    public STATE gameState = STATE.Menu;

    public GameProject2016() {
        handler = new Handler();
        hud = new HUD();
        menu = new Menu(this, handler, hud);
        this.addKeyListener(new KeyInput(handler)); // tells program that we have(key) inputs, listen for them
       this.addMouseListener(menu);
        r = new Random();
        
        
        new Window(WIDTH, HEIGHT, "Let's Build a game!", this);
        
        spawner = new Spawn(handler, hud);
        
        
        if(gameState == STATE.Game){
           handler.addObjects(new Player(WIDTH/2-32, r.nextInt(HEIGHT/2-32),
                    ID.player, handler));
        //handler.addObjects(new BasicEnemy(r.nextInt(WIDTH), r.nextInt(HEIGHT/2-32),
                   // ID.BasicEnemy, handler));
        handler.addObjects(new BasicEnemy(r.nextInt(GameProject2016.WIDTH),
                    r.nextInt(GameProject2016.HEIGHT), ID.BasicEnemy, handler));
        }
        
        /*for(int i = 0; i < 50; i++){ // this creats 50 
            handler.addObjects(new Player(r.nextInt(WIDTH), r.nextInt(HEIGHT),
                    ID.player));
        }
        */
      
        
        /* handler.addObjects(new Player(WIDTH/2-32, r.nextInt(HEIGHT/2-32),
                    ID.player, handler));
        //handler.addObjects(new BasicEnemy(r.nextInt(WIDTH), r.nextInt(HEIGHT/2-32),
                   // ID.BasicEnemy, handler));
        handler.addObjects(new BasicEnemy(r.nextInt(GameProject2016.WIDTH),
                    r.nextInt(GameProject2016.HEIGHT), ID.BasicEnemy, handler));
*/
    }
    /*
     runns thread
     */

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;

    }

    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            if (running) 
                render();
            
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;

            }

        }
        stop();
    }

    private void tick() {
        handler.tick();
        
        if(gameState == STATE.Game){
              hud.tick();
        spawner.tick();
        
        if(HUD.HEALTH <= 0){
            HUD.HEALTH = 100;
            gameState = STATE.End;
            
        }
        } else if (gameState == STATE.Menu || gameState == STATE.End){
            menu.tick();
        }
        
        //hud.tick();
       // spawner.tick();

    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }
        
        Graphics g = bs.getDrawGraphics();
        
        
        g.setColor(Color.black);
        g.fillRect(0,0,WIDTH, HEIGHT);
        
        handler.render(g);
        
        if(gameState == STATE.Game){
           hud.render(g);  
        } else if (gameState == STATE.Menu || gameState == STATE.Help ||
                gameState == STATE.End){
            menu.render(g);
        }
        
       // hud.render(g); // needs to go under handler, that way object dont obscure HUD
        
        g.dispose();
        bs.show();

    }
    
    public static int clamp(int var, int min, int max){
        if ( var >= max){ // this will make player object not espcape screen
            return var = max;
        } else if (var <= min) {
            return var = min;
        } else {
            return var;
        }
    }

    public static void main(String[] args) {
        new GameProject2016();
    }

}
