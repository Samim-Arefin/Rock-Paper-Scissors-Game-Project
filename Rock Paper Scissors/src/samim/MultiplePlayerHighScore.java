
package samim;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JPanel;
public class MultiplePlayerHighScore extends JFrame{
    private final JPanel HighScorePanel,OthersPanel;
    private final JLabel HighScore,HighScoreInfoLabel,HighScoreLabel;
    private final JButton Back,Exit;
    private void ButtonPerform(JButton obj)
    {
        obj.setBorderPainted(false);
        obj.setFocusPainted(false);
    }
    
    public MultiplePlayerHighScore()
    {
        super("HighScore");
        this.setSize(1000, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setUndecorated(true);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
        
        HighScorePanel = new JPanel();
        HighScorePanel.setBounds(0, 0, 1000, 400);
        HighScorePanel.setLayout(null);
        this.add(HighScorePanel);
       
        HighScore=new JLabel();
        HighScore.setBounds(0, 0, 1000, 400);
        HighScorePanel.add(HighScore);
       
        
        OthersPanel = new JPanel();
        OthersPanel.setBounds(0, 400, 1000, 300);
        OthersPanel.setLayout(null);
        OthersPanel.setBackground(Color.DARK_GRAY);
        this.add(OthersPanel);
        
         HighScoreInfoLabel = new JLabel("High Score:");
         HighScoreInfoLabel.setBounds(380, 0, 200, 100);
         OthersPanel.add(HighScoreInfoLabel);
         HighScoreInfoLabel.setForeground(Color.CYAN);
         HighScoreInfoLabel.setFont(new Font(Font.MONOSPACED, Font.BOLD, 25));
         HighScoreLabel = new JLabel();
         HighScoreLabel.setBounds(550, 0, 200, 100);
         OthersPanel.add(HighScoreLabel);
        
        
        File file=new File("res\\MultiplePlayerHighScore.txt");
        try {
            Scanner SC=new Scanner(file);
            int Score=SC.nextInt();
            HighScoreLabel.setForeground(Color.WHITE);
            HighScoreLabel.setFont(new Font(Font.MONOSPACED, Font.BOLD, 25));
            String S = Integer.toString(Score);
            HighScoreLabel.setText(S);
            
        } catch (FileNotFoundException ex) {
            
        }
        
        
        
        Back=new JButton("Back");
        Back.setBounds(40, 230, 100, 40);
        ButtonPerform(Back);
        OthersPanel.add(Back);
        Back.setBackground(new Color(56, 74, 114));
        Back.setForeground(Color.WHITE);

        Back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new HighScoreMode();
                setVisible(false);
            }
        });
            
        Exit=new JButton("Exit");
        Exit.setBounds(855, 230, 100, 40);
        ButtonPerform( Exit);
        OthersPanel.add( Exit);
        Exit.setBackground(new Color(56, 74, 114));
        Exit.setForeground(Color.WHITE);

        Exit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
             
        HighScore.setIcon(new ImageIcon("res\\HighScore.jpg"));
    }
}
