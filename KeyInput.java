package gameproject2016;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    private Handler handler;
private boolean[] keyDown = new boolean[4];
    
    
    public KeyInput(Handler handler) {
        this.handler = handler;
        
        keyDown[0] = false; //w
        keyDown[1] = false; // s
        keyDown[2] = false; // d
        keyDown[3] = false; //a
        
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i); // use temp object for base

            if (tempObject.getId() == ID.player) {
            //key events for player

                if (key == KeyEvent.VK_W) {
                    tempObject.setVelY(-5);
                // tempObject.setY(tempObject.getY()-1);
                    //pretend tempObject is ID.player
                    
                    keyDown[0] = true;
                }
                if (key == KeyEvent.VK_S) {
                    tempObject.setVelY(5);
                    
                     keyDown[1] = true;
                }
                if (key == KeyEvent.VK_D) {
                    tempObject.setVelX(5);
                    
                     keyDown[2] = true;
                }
                if (key == KeyEvent.VK_A) {
                    tempObject.setVelX(-5);
                    
                     keyDown[3] = true;
                }
            }
        }
        if(key == KeyEvent.VK_ESCAPE){ // this will close the program pres esc
            System.exit(1);
        }

        //System.out.println(key); when you run code, you can see the printed ascii value for each key
    }

    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i); // use temp object for base

            if (tempObject.getId() == ID.player) {
            //key events for player

                if (key == KeyEvent.VK_W) {
                  //  tempObject.setVelY(0); **this is code version 2
                // tempObject.setY(tempObject.getY()-1);
                    //pretend tempObject is ID.player
                    
                    keyDown[0] = false;
                }
                if (key == KeyEvent.VK_S) {
                   // tempObject.setVelY(0);
                     keyDown[1] = false;
                }
                if (key == KeyEvent.VK_D) {
                    //tempObject.setVelX(0);
                    keyDown[2] = false;
                }
                if (key == KeyEvent.VK_A) {
                    //tempObject.setVelX(0);
                    keyDown[3] = false;
                }
                    
                    //vertical movment
                    if(!keyDown[0] && !keyDown[1]){
                        tempObject.setVelY(0);
                    }
                    //horizontal movment
                    if(!keyDown[2] && !keyDown[3]){
                        tempObject.setVelX(0);
                    }
                }
            }
        }

    }

