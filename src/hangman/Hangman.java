package hangman;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Hangman extends JFrame{
    private JPanel panel = new mainPanel();
    public Hangman(){
        add(panel);
    }
    public static void main(String args[]){
        JFrame frame = new Hangman();
        frame.setTitle("HANGMAN");
        frame.setSize(600,600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
    }
}