package samim;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
public class HighScoreMode extends JFrame {
    private final JLabel HomePageLabel;
    private JButton SinglePlayer,MultiplePlayer,Back,Exit;
    
    private void ButtonPerform(JButton obj)
    {
        obj.setBorderPainted(false);
        //obj.setContentAreaFilled(false);
        obj.setFocusPainted(false);
      //  obj.setOpaque(false);
    }
    
    public HighScoreMode()
    {
        super("HighScoreMode");
        this.setSize(1000,700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);
        setLayout(null);
        this.setResizable(false);
        
        HomePageLabel=new JLabel(new ImageIcon("res\\HomePage.png"));
        HomePageLabel.setBounds(0, 0, 1000, 700);
        this.add(HomePageLabel);
        
        SinglePlayer=new JButton("Single Player");
        SinglePlayer.setBounds(80, 200, 170, 47);
        ButtonPerform(SinglePlayer);
        SinglePlayer.setBackground(new Color(56, 74, 114));
        SinglePlayer.setForeground(Color.WHITE);
        HomePageLabel.add(SinglePlayer);

        SinglePlayer.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new SinglePlayerHighScore();
                setVisible(false);
            }
        });
        
        
        MultiplePlayer=new JButton("Multiple Player");
        MultiplePlayer.setBounds(80, 260, 170, 47);
        ButtonPerform(MultiplePlayer);
        MultiplePlayer.setBackground(new Color(56, 74, 114));
        MultiplePlayer.setForeground(Color.WHITE);
        HomePageLabel.add(MultiplePlayer);

        MultiplePlayer.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new MultiplePlayerHighScore();
                setVisible(false);
            }
        });
        
        Back=new JButton("Back");
        Back.setBounds(30, 650, 100, 40);
        ButtonPerform(Back);
        Back.setBackground(new Color(56, 74, 114));
        Back.setForeground(Color.WHITE);
        HomePageLabel.add(Back);

        Back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new Home();
                setVisible(false);
            }
        });
        
        Exit=new JButton("Exit");
        Exit.setBounds(870, 650, 100, 40);
        ButtonPerform(Exit);
        Exit.setBackground(new Color(56, 74, 114));
        Exit.setForeground(Color.WHITE);
        HomePageLabel.add(Exit);

        Exit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
        
       this.setVisible(true);
    }
    
}