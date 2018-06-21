package gameproject2016;

import java.util.Random;

public class Spawn {

    private Handler handler;
    private HUD hud;
    private Random r = new Random();

    private int scoreKeep = 0;

    public Spawn(Handler handler, HUD hud) {
        this.handler = handler;
        this.hud = hud;
    }

    public void tick() {
        scoreKeep++;

        if (scoreKeep >= 200) {
            scoreKeep = 0;
            hud.setLevel(hud.getLevel() + 1);

            if (hud.getLevel() == 2) {
                handler.addObjects(new BasicEnemy(r.nextInt(GameProject2016.WIDTH),
                        r.nextInt(GameProject2016.HEIGHT), ID.BasicEnemy, handler));
            } else if (hud.getLevel() == 3) {
                handler.addObjects(new BasicEnemy(r.nextInt(GameProject2016.WIDTH),
                        r.nextInt(GameProject2016.HEIGHT), ID.BasicEnemy, handler));
            } else if (hud.getLevel() == 4) {
                handler.addObjects(new FastEnemy(r.nextInt(GameProject2016.WIDTH),
                        r.nextInt(GameProject2016.HEIGHT), ID.BasicEnemy, handler));
            } else if (hud.getLevel() == 5) {
                handler.addObjects(new BasicEnemy(r.nextInt(GameProject2016.WIDTH),
                        r.nextInt(GameProject2016.HEIGHT), ID.BasicEnemy, handler));
            } else if (hud.getLevel() == 6) {
                handler.addObjects(new BasicEnemy(r.nextInt(GameProject2016.WIDTH),
                        r.nextInt(GameProject2016.HEIGHT), ID.BasicEnemy, handler));
                handler.addObjects(new BasicEnemy(r.nextInt(GameProject2016.WIDTH),
                        r.nextInt(GameProject2016.HEIGHT), ID.BasicEnemy, handler));
            } else if (hud.getLevel() == 8) {
                handler.addObjects(new FastEnemy(r.nextInt(GameProject2016.WIDTH),
                        r.nextInt(GameProject2016.HEIGHT), ID.BasicEnemy, handler));
            } else if (hud.getLevel() == 9) {
                handler.addObjects(new FastEnemy(r.nextInt(GameProject2016.WIDTH),
                        r.nextInt(GameProject2016.HEIGHT), ID.BasicEnemy, handler));
            }
            else if (hud.getLevel() == 10) {
                handler.addObjects(new FastEnemy(r.nextInt(GameProject2016.WIDTH),
                        r.nextInt(GameProject2016.HEIGHT), ID.BasicEnemy, handler));
            }
        }

    }
}
