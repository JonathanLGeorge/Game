/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject2016;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

public class Window extends Canvas{
    private static final long serialVersionUID = -240840600533728354L;
    
    public Window(int with, int height, String title, GameProject2016 game) {
        JFrame frame = new JFrame(title); // creats jframe
        
        frame.setPreferredSize(new Dimension(with, height)); // seting up new
        frame.setMaximumSize(new Dimension(with, height)); // dimentions 
        frame.setMinimumSize(new Dimension(with, height));
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // exit in frame
        frame.setResizable(false); // user cant resize
        frame.setLocationRelativeTo(null); // makes window start in middlewindow
        frame.add(game);
        frame.setVisible(true); //you can see the frame!
        game.start(); // runs the start method 
    }
}
