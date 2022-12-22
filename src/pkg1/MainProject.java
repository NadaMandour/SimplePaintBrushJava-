/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1;

import javax.swing.JFrame;

/**
 *
 * @author 20127
 */
public class MainProject {
      public static void main(String[] args) {
        JFrame frame= new JFrame();
        frame.setTitle("Paint Brush" );
      MyProjectPanel panel =new MyProjectPanel();
        frame.setContentPane(panel);
        frame.setSize(900,600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }  
    
}
