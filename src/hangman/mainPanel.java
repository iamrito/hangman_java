package hangman;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class mainPanel extends JPanel{
    private int left;
    private int count = 0;
    private JLabel givenWord = new JLabel();
    private JTextField inputGuess = new JTextField(1);
    private char[] guessedLetter;
    private char[] inputWord;
    private String word;
    private char[] wordChars;
    public mainPanel(){
        setLayout(new GridLayout(7,1));
        Font largeFont = new Font("TimesRoman", Font.BOLD, 20);
        word = JOptionPane.showInputDialog(null,"Give a word", "Give A Word", JOptionPane.INFORMATION_MESSAGE);
        int no_of_missing_letters = word.length() * 2 / 3;
        word = word.toLowerCase();
        wordChars = word.toCharArray();
        inputWord = wordChars;
        for(int i = 0 ; i < no_of_missing_letters ; i++){
            int missingPosition = (int)(Math.random()*inputWord.length);
            if(inputWord[missingPosition] != '*')
                inputWord[missingPosition] = '*';
            else
                i--;
        }
        givenWord.setText(new String(inputWord));
        givenWord.setHorizontalAlignment(JLabel.CENTER);
        givenWord.setFont(largeFont);
        add(givenWord);
        inputGuess.setFont(largeFont);
        inputGuess.setHorizontalAlignment(JTextField.CENTER);
        add(inputGuess);
        inputGuess.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               int c = 0;
               guessedLetter = (inputGuess.getText()).toCharArray();
               for(int j = 0 ; j < wordChars.length ; j++){
                   wordChars = word.toCharArray();
                   if(guessedLetter[0] == wordChars[j] && inputWord[j] == '*'){
                       inputWord[j] = guessedLetter[0];
                       givenWord.setText(new String(inputWord));
                       c++;
                       repaint();
                       break;
                   }
                }
               if(c == 0){
                   count++;
                   repaint();
               }
               left = 0;
               for(int k = 0 ; k < wordChars.length; k++){
                   if(inputWord[k] == '*')
                       left++;
               }
               if(left == 0){
                   JOptionPane.showMessageDialog(null,"Congratulations.\nYou Win","WON",JOptionPane.INFORMATION_MESSAGE);
                   System.exit(1);
               }
           };
        });
    }
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        if(count >= 1)
            g.drawLine(100, 200, 100, 500);
        if(count >=2)
            g.drawLine(100, 200, 350, 200);
        if(count >=3)
            g.drawLine(350, 200, 350, 250);
        if(count >= 4)
            g.drawOval(325, 250, 50, 50);
        if(count >= 5){
            g.drawLine(350, 300, 400, 350);
            g.drawLine(350, 300, 300, 350);}
        if(count >= 6)
            g.drawLine(350, 300, 350, 400);
        if(count >= 7){
            g.drawLine(350, 400, 300, 450);
            g.drawLine(350, 400, 400, 450);}
        if(count >= 8){
            JOptionPane.showMessageDialog(null, "GAME OVER","GAME OVER",JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }}
}
