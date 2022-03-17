
package samim;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
public class SelectMode extends JFrame {
    private final JLabel HomePageLabel;
    private JButton Host,Player,Back,Exit;

    private void ButtonPerform(JButton obj)
    {
        obj.setBorderPainted(false);
        //obj.setContentAreaFilled(false);
        obj.setFocusPainted(false);
        //  obj.setOpaque(false);
    }

    public SelectMode()
    {
        super("SelectMode");
        this.setSize(1000,700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);
        setLayout(null);
        this.setResizable(false);

        HomePageLabel=new JLabel(new ImageIcon("res\\HomePage.png"));
        HomePageLabel.setBounds(0, 0, 1000, 700);
        this.add(HomePageLabel);

        Host=new JButton("Host");
        Host.setBounds(80, 200, 170, 47);
        ButtonPerform(Host);
        Host.setBackground(new Color(56, 74, 114));
        Host.setForeground(Color.WHITE);
        HomePageLabel.add(Host);

        Host.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //new IP();
                new MultiplePlayerTwo();
                setVisible(false);
            }
        });


        Player=new JButton("Player");
        Player.setBounds(80, 260, 170, 47);
        ButtonPerform(Player);
        Player.setBackground(new Color(56, 74, 114));
        Player.setForeground(Color.WHITE);
        HomePageLabel.add(Player);

        Player.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new MultiplePlayerOne();
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
                new PlayMode();
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