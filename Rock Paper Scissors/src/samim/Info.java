package samim;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class Info extends JFrame {
    private final JLabel InfoLabel;
    private final JButton Back;
    
    private void ButtonPerform(JButton obj)
    {
        obj.setBorderPainted(false);
        //obj.setContentAreaFilled(false);
        obj.setFocusPainted(false);
       // obj.setOpaque(false);
    }
    
    public Info()
    {
        super("Info");
        this.setSize(1000,700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);
        setLayout(null);
        this.setResizable(false);
        InfoLabel=new JLabel( new ImageIcon("res\\GameInfo.jpg"));
        InfoLabel.setBounds(0, 0, 1000, 700);
        this.add(InfoLabel);
        
        Back=new JButton("Back");
        Back.setBounds(870, 650, 100, 40);
        ButtonPerform(Back);
        Back.setBackground(new Color(56, 74, 114));
        Back.setForeground(Color.WHITE);
        InfoLabel.add(Back);
        Back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new Home();
                setVisible(false);
            }
        });
        
        this.setVisible(true);
    }
}

