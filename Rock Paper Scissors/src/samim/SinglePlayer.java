package samim;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import javax.swing.*;

public class SinglePlayer extends JFrame implements Runnable,ActionListener {

    private final JPanel ThreadPanel,GamePanel, ButtonPanel;
    private final JLabel ServerLabel, ClientLabel,PlayerScoreLabel,GameNameLabel,GameLabel;
    private final JLabel PlayerScoreInfoLabel,ComputerScoreInfoLabel,ComputerScoreLabel;
    private final JButton Rock, Paper, Scissors,Back;
    private Socket socket;
    private DataInputStream din;
    private DataOutputStream dout;
    private int score=0,computer_score=0;
    private String out="",str="";
    

     private void ButtonPerform(JButton obj)
    {
        obj.setBorderPainted(false);
       // obj.setContentAreaFilled(false);
        obj.setFocusPainted(false);
        //obj.setOpaque(false);
    }
    
    public SinglePlayer() {
        setTitle("Game");
        this.setSize(1000, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);
        this.setVisible(true);
        this.setResizable(false);
        
        ThreadPanel=new JPanel();
        ThreadPanel.setBounds(0, 0, 1000, 200);
        ThreadPanel.setLayout(null);
        this.add(ThreadPanel);
        GameNameLabel=new JLabel();
        GameNameLabel.setBounds(0, 0, 1000, 200);
        ThreadPanel.add(GameNameLabel);
        
        GamePanel = new JPanel(); // main panel
        GamePanel.setBounds(0, 200, 1000, 250);
        GamePanel.setBackground(Color.WHITE);
        GamePanel.setLayout(null);
        this.add(GamePanel); 
        GameLabel=new JLabel();
        
        ButtonPanel = new JPanel();
        ButtonPanel.setBounds(0, 450, 1000, 250);
        ButtonPanel.setBackground(new Color(152, 152, 152));
        ButtonPanel.setLayout(null);
        this.add(ButtonPanel);

        Rock = new JButton("Rock");
        ButtonPanel.add(Rock);
        Rock.setBounds(10, 60, 130, 40);
        Rock.setBackground(Color.LIGHT_GRAY);
        Rock.setForeground(Color.WHITE);
        ButtonPerform(Rock);
        
        Paper = new JButton("Paper");
        ButtonPanel.add(Paper);
        Paper.setBounds(160, 60, 130, 40);
        Paper.setBackground(Color.LIGHT_GRAY);
        Paper.setForeground(Color.WHITE);
        ButtonPerform(Paper);
        
        Scissors = new JButton("Scissors");
        ButtonPanel.add(Scissors);
        Scissors.setBounds(310, 60, 130, 40);
        Scissors.setBackground(Color.LIGHT_GRAY);
        Scissors.setForeground(Color.WHITE);
        
        ButtonPerform(Scissors);
        Back=new JButton("Back");
        ButtonPanel.add(Back);
        Back.setBackground(Color.DARK_GRAY);
        Back.setForeground(Color.WHITE);
        Back.setBounds(835, 180, 130, 40);
        ButtonPerform(Back);

        Back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try {
                    dout.writeUTF("End");
                    din.close();
                    dout.close();
                    socket.close();
                } catch (IOException ioException) {
                }

                new Home();
                setVisible(false);
            }
        });
        
        
        Rock.addActionListener(this);
        Paper.addActionListener(this);
        Scissors.addActionListener(this);
        
        
        PlayerScoreInfoLabel=new JLabel();
        PlayerScoreLabel=new JLabel();
        ComputerScoreInfoLabel=new JLabel();
        ComputerScoreLabel=new JLabel();
        ButtonPanel.add(PlayerScoreInfoLabel);
        ButtonPanel.add(PlayerScoreLabel);
        ButtonPanel.add(ComputerScoreInfoLabel);
        ButtonPanel.add(ComputerScoreLabel);
        PlayerScoreInfoLabel.setBounds(838,0,100,40);
        PlayerScoreInfoLabel.setFont(new Font(Font.SERIF,Font.BOLD,25));
        PlayerScoreInfoLabel.setText("Player: ");
        PlayerScoreInfoLabel.setForeground(new Color(56, 74, 114));
        PlayerScoreLabel.setBounds(915,0,100,40);
        PlayerScoreLabel.setFont(new Font(Font.SERIF,Font.BOLD,25));
        String Score=Integer.toString(score);
        PlayerScoreLabel.setText(Score);
        PlayerScoreLabel.setForeground(Color.DARK_GRAY);
        
        ComputerScoreInfoLabel.setBounds(800,10,200,100);
        ComputerScoreInfoLabel.setFont(new Font(Font.SERIF,Font.BOLD,25));
        ComputerScoreInfoLabel.setText("Computer: ");
        ComputerScoreInfoLabel.setForeground(new Color(110, 56, 114));
        ComputerScoreLabel.setBounds(915,40,150,40);
        ComputerScoreLabel.setFont(new Font(Font.SERIF,Font.BOLD,25));
        String ComputerScore=Integer.toString(computer_score);
        ComputerScoreLabel.setText(ComputerScore);
       

        
        
        
        
        ClientLabel = new JLabel();
        ClientLabel.setBounds(130, 10, 227, 227);
        GamePanel.add(ClientLabel);
        ServerLabel = new JLabel();
        ServerLabel.setBounds(600, 5, 227, 227);
        GamePanel.add(ClientLabel);
        GamePanel.add(ServerLabel);
        new SinglePlayerGameName(GameNameLabel);
        new Thread(this,"Client").start();
        
    }


    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
         if(ae.getSource()==Rock)
         {
             try {
                 ClientLabel.setIcon(new ImageIcon("res\\rock.png"));
                 ClientLabel.setVisible(true);
                 out="Rock11!!22@@33??4";
                 dout.writeUTF(out);
             } catch (IOException ex) {
                 
             }
         }
         else if(ae.getSource()==Paper)
         {
             try {
                 ClientLabel.setIcon(new ImageIcon("res\\paper.png"));
                 out="Paper11!!22@@33??4";
                 ClientLabel.setVisible(true);
                 dout.writeUTF(out);
             } catch (IOException ex) {
                
             }
         }
         else if(ae.getSource()==Scissors)
         {
             try {
                 ClientLabel.setIcon(new ImageIcon("res\\scissors.png"));
                 out="Scissors11!!22@@33??4";
                 ClientLabel.setVisible(true);
                 dout.writeUTF(out);
             } catch (IOException ex) {
             }
         }
    }
    
    @Override
    public void run() {
         try {
            socket = new Socket("localhost", 2222);
            din = new DataInputStream(socket.getInputStream());
            dout = new DataOutputStream(socket.getOutputStream());
            int count=5;
            while (count>0) {
                    str = din.readUTF();
                    new ImageUpdate().ServerImageUpdate(ServerLabel, str);
                    ServerLabel.setVisible(true);
                    if((new Score().ScoreUpdate(out,str))==1)
                    {
                        score++;
                        String Score=Integer.toString(score);
                        PlayerScoreLabel.setText(Score);
                    }
                    else if((new Score().ScoreUpdate(out,str))==-1)
                    {
                        count--;
                        computer_score++;
                        String ComputerScore=Integer.toString(computer_score);
                        ComputerScoreLabel.setText(ComputerScore);
                    }
                    new ImageRemove(ClientLabel,ServerLabel);
            }
            if(count==0)
            {
                new SinglePlayerGameOver(score);
                this.setVisible(false);
            }
             din.close();
             dout.close();
             socket.close();
        } catch (IOException ex) {

        }
    }
}


