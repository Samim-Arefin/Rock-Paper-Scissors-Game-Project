
package samim;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class MultiplePlayerTwo extends JFrame implements Runnable,ActionListener {

    private final JPanel ThreadPanel,GamePanel, ButtonPanel,ChatPanel,HeaderPanel,MessageAreaPanel;
    private final JLabel GameNameLabel,PlayerOneScoreLabel;
    private final JLabel PlayerOneLabel, PlayerTwoLabel,Active;
    private final JLabel PlayerOneScoreInfoLabel,PlayerTwoScoreInfoLabel,PlayerTwoScoreLabel;
    private final JTextField MessageField;
    private final JTextPane MessagePane;
    private final StyledDocument Style;
    private final SimpleAttributeSet Align;
    private final JScrollPane MessageAreaScroll;
    private final JButton Rock, Paper, Scissors,Send;
    private ServerSocket serversocket;
    private Socket socket;
    private DataInputStream din;
    private DataOutputStream dout;
    private int playerone_score=0,playertwo_score=0,playeronecount=0,playertwocount=0;
    private int senddata=0,receivedata=0,firstsend=0,count=5;
    private String out="",str="";
    private Boolean check=false,flag=false,buttonclick=true;
    
    
     private void ButtonPerform(JButton obj)
    {
        obj.setBorderPainted(false);
       // obj.setContentAreaFilled(false);
        obj.setFocusPainted(false);
        //obj.setOpaque(false);
    }
     
    public MultiplePlayerTwo() {
        setTitle("Player Two");
        this.setSize(750, 650);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
      //  this.setUndecorated(true);
        this.setVisible(true);
       // this.setResizable(false);
        
        ThreadPanel=new JPanel();
        ThreadPanel.setBounds(0, 0, 750, 150);
        ThreadPanel.setLayout(null);
        this.add(ThreadPanel);
        GameNameLabel=new JLabel();
        GameNameLabel.setBounds(0, 0, 750, 150);
        ThreadPanel.add(GameNameLabel);
        
        GamePanel = new JPanel();
        GamePanel.setBounds(0, 150, 500, 300);
        GamePanel.setBackground(Color.WHITE);
        GamePanel.setLayout(null);
        this.add(GamePanel); 
        
        HeaderPanel = new JPanel();
        HeaderPanel.setBounds(500, 150, 250, 50);
        this.add(HeaderPanel);
        HeaderPanel.setLayout(null);
        HeaderPanel.setBackground(new Color(0,198,255));
        Active=new JLabel();
        HeaderPanel.add(Active);
        Active.setBounds(85, 0, 250, 50);
        Active.setFont(new Font("Dancing Script",Font.BOLD,12));
        Active.setText("Message");
        Active.setForeground(Color.WHITE);
        
        
        MessageAreaPanel=new JPanel();
        this.add(MessageAreaPanel);
        MessageAreaPanel.setBounds(500,200, 250, 220);
        MessageAreaPanel.setLayout(null);
        
        
        
        MessagePane=new JTextPane();
        MessagePane.setBackground(new Color(253, 249, 249));
        MessagePane.setEditable(false);
        Style = MessagePane.getStyledDocument();
        Align= new SimpleAttributeSet();
        StyleConstants.setItalic(Align, true);
        StyleConstants.setForeground(Align, Color.DARK_GRAY);
        StyleConstants.setBackground(Align, new Color(213, 224, 227));
        StyleConstants.setAlignment(Align, StyleConstants.ALIGN_LEFT);
        Style.setParagraphAttributes(0, Style.getLength(), Align, false);  
        MessagePane.setCharacterAttributes(Align, true);
        MessagePane.setFont(new Font("Dancing Script",Font.BOLD,12));
        
        
        MessageAreaScroll = new JScrollPane(MessagePane, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        MessageAreaScroll.setBounds(0, 0, 240, 220);
        MessageAreaScroll.setBorder(BorderFactory.createEmptyBorder());
        MessageAreaPanel.add(MessageAreaScroll);
        
        ChatPanel = new JPanel();
        this.add(ChatPanel);
        ChatPanel.setBounds(500, 420, 250, 30);
        ChatPanel.setLayout(null);
        MessageField=new JTextField();
        ChatPanel.add(MessageField);
        MessageField.setBounds(0,0,170,30);
        Send=new JButton("Send");
        ChatPanel.add(Send);
        Send.setBounds(170, 0, 80, 30);
        Send.setBackground(new Color(0,198,255));
        Send.setForeground(Color.WHITE);
        ButtonPerform(Send);
        
        
        
        ButtonPanel = new JPanel();
        ButtonPanel.setBounds(0, 450, 750, 300);
        ButtonPanel.setLayout(null);
        this.add(ButtonPanel);

        Rock = new JButton("Rock");
        Rock.setBounds(10, 60, 130, 40);
        Rock.setBackground(Color.LIGHT_GRAY);
        Rock.setForeground(Color.WHITE);
        
        ButtonPerform(Rock);
        Paper = new JButton("Paper");
        Paper.setBounds(160, 60, 130, 40);
        Paper.setBackground(Color.LIGHT_GRAY);
        Paper.setForeground(Color.WHITE);
        ButtonPerform(Paper);
        
        Scissors = new JButton("Scissors");
        Scissors.setBounds(310, 60, 130, 40);
        Scissors.setBackground(Color.LIGHT_GRAY);
        Scissors.setForeground(Color.WHITE);
        ButtonPerform(Scissors);
        
        ButtonPanel.add(Rock);
        ButtonPanel.add(Paper);
        ButtonPanel.add(Scissors);
        
        Rock.addActionListener(this);
        Paper.addActionListener(this);
        Scissors.addActionListener(this);
        Send.addActionListener(this);
        
        
        PlayerOneScoreInfoLabel=new JLabel();
        PlayerOneScoreLabel=new JLabel();
        PlayerTwoScoreInfoLabel=new JLabel();
        PlayerTwoScoreLabel=new JLabel();
        ButtonPanel.add(PlayerOneScoreInfoLabel);
        ButtonPanel.add(PlayerOneScoreLabel);
        ButtonPanel.add(PlayerTwoScoreInfoLabel);
        ButtonPanel.add(PlayerTwoScoreLabel);
        PlayerOneScoreInfoLabel.setBounds(550,0,150,40);
        PlayerOneScoreInfoLabel.setFont(new Font(Font.SERIF,Font.BOLD,25));
        PlayerOneScoreInfoLabel.setText("Player One: ");
        PlayerOneScoreInfoLabel.setForeground(new Color(56, 74, 114));
        PlayerOneScoreLabel.setBounds(675,0,100,40);
        PlayerOneScoreLabel.setFont(new Font(Font.SERIF,Font.BOLD,25));
        String PlayerOneScore=Integer.toString(playerone_score);
        PlayerOneScoreLabel.setText(PlayerOneScore);
        PlayerOneScoreLabel.setForeground(Color.BLACK);
        
        PlayerTwoScoreInfoLabel.setBounds(550,10,200,100);
        PlayerTwoScoreInfoLabel.setFont(new Font(Font.SERIF,Font.BOLD,25));
        PlayerTwoScoreInfoLabel.setText("Player Two: ");
        PlayerTwoScoreInfoLabel.setForeground(new Color(110, 56, 114));
        PlayerTwoScoreLabel.setBounds(677,40,150,40);
        PlayerTwoScoreLabel.setFont(new Font(Font.SERIF,Font.BOLD,25));
        String PlayerTwoScore=Integer.toString(playertwo_score);
        PlayerTwoScoreLabel.setText(PlayerTwoScore);
        PlayerTwoScoreLabel.setForeground(Color.BLACK);
        
        ButtonPanel.setBackground(new Color(152, 152, 152));

        
        
        
        
        PlayerOneLabel = new JLabel();
        PlayerOneLabel.setBounds(0, 5, 227, 227);
        GamePanel.add( PlayerOneLabel);
        PlayerTwoLabel = new JLabel();
        PlayerTwoLabel.setBounds(260, 0, 227, 227);
        GamePanel.add(PlayerOneLabel);
        GamePanel.add(PlayerTwoLabel);
        new MultiplePlayerGameName(GameNameLabel);
        new Thread(this,"Player Two").start();
    }
    
     @Override
    public void actionPerformed(ActionEvent ae)
    {
         if(ae.getSource()==Rock)
         {
             try {
                  if((str.isEmpty()==true)&& firstsend==0)
                  {
                      buttonclick=false;
                      PlayerOneLabel.setIcon(new ImageIcon("res\\rock.png"));
                      PlayerOneLabel.setVisible(true);
                      out = "Rock11!!22@@33??4";
                      dout.writeUTF(out);
                      check=true;
                      firstsend++;
                      flag=true;
                  }
                  else if ((!(str.isEmpty()) == true)) {
                      if (receivedata==1) {
                          
                          receivedata=2;
                          PlayerOneLabel.setIcon(new ImageIcon("res\\rock.png"));
                          PlayerOneLabel.setVisible(true);
                          out = "Rock11!!22@@33??4";
                          new ImageUpdate().ServerImageUpdate(PlayerTwoLabel, str);
                          PlayerTwoLabel.setVisible(true);
                          if ((new Score().ScoreUpdate(out, str)) == 1) {
                              playerone_score++;
                              String PlayerOneScore = Integer.toString(playerone_score);
                              PlayerOneScoreLabel.setText(PlayerOneScore);
                          } else if ((new Score().ScoreUpdate(out, str)) == -1) {
                              playertwo_score++;
                              count--;
                              String PlayerTwoScore = Integer.toString(playertwo_score);
                              PlayerTwoScoreLabel.setText(PlayerTwoScore);
                          }
                          new ImageRemove(PlayerOneLabel,PlayerTwoLabel);
                          buttonclick=true;
                          str = "";
                          firstsend=0;
                          dout.writeUTF(out);
                      }
                 }
                 
             } catch (IOException ex) {
                 
             }
         }
         else if(ae.getSource()==Paper)
         {
             try {
                 if((str.isEmpty()==true)&& firstsend==0)
                  {
                      buttonclick=false;
                      PlayerOneLabel.setIcon(new ImageIcon("res\\paper.png"));
                      PlayerOneLabel.setVisible(true);
                      out = "Paper11!!22@@33??4";
                      dout.writeUTF(out);
                      check=true;
                      firstsend++;
                      flag=true;
                  }
                  else if ((!(str.isEmpty()) == true)) {
                      if (receivedata==1) {
                          receivedata=2;
                          PlayerOneLabel.setIcon(new ImageIcon("res\\paper.png"));
                          PlayerOneLabel.setVisible(true);
                          out = "Paper11!!22@@33??4";
                          new ImageUpdate().ServerImageUpdate(PlayerTwoLabel, str);
                          PlayerTwoLabel.setVisible(true);
                          if ((new Score().ScoreUpdate(out, str)) == 1) {
                              playerone_score++;
                              String PlayerOneScore = Integer.toString(playerone_score);
                              PlayerOneScoreLabel.setText(PlayerOneScore);
                          } else if ((new Score().ScoreUpdate(out, str)) == -1) {
                              playertwo_score++;
                              count--;
                              String PlayerTwoScore = Integer.toString(playertwo_score);
                              PlayerTwoScoreLabel.setText(PlayerTwoScore);
                          }
                          new ImageRemove(PlayerOneLabel,PlayerTwoLabel);
                          buttonclick=true;
                          str = "";
                          firstsend=0;
                          dout.writeUTF(out);
                      }
                 }
             } catch (IOException ex) {
                
             }
         }
         else if(ae.getSource()==Scissors)
         {
             try {
                  if((str.isEmpty()==true)&& firstsend==0)
                  {
                      buttonclick=false;
                      PlayerOneLabel.setIcon(new ImageIcon("res\\scissors.png"));
                      PlayerOneLabel.setVisible(true);
                      out = "Scissors11!!22@@33??4";
                      dout.writeUTF(out);
                      check=true;
                      firstsend++;
                      flag=true;
                  }
                  else if ((!(str.isEmpty()) == true)) {
                      if (receivedata==1) {
                          receivedata=2;
                          PlayerOneLabel.setIcon(new ImageIcon("res\\scissors.png"));
                          PlayerOneLabel.setVisible(true);
                          out = "Scissors11!!22@@33??4";
                          new ImageUpdate().ServerImageUpdate(PlayerTwoLabel, str);
                          PlayerTwoLabel.setVisible(true);
                          if ((new Score().ScoreUpdate(out, str)) == 1) {
                              playerone_score++;
                              String PlayerOneScore = Integer.toString(playerone_score);
                              PlayerOneScoreLabel.setText(PlayerOneScore);
                          } else if ((new Score().ScoreUpdate(out, str)) == -1) {
                              playertwo_score++;
                              count--;
                              String PlayerTwoScore = Integer.toString(playertwo_score);
                              PlayerTwoScoreLabel.setText(PlayerTwoScore);
                          }
                          new ImageRemove(PlayerOneLabel,PlayerTwoLabel);
                          buttonclick=true;
                          str = "";
                          firstsend=0;
                          dout.writeUTF(out);
                      }
                 }
             } catch (IOException ex) {
             }
         }
         else if(ae.getSource()==Send)
         {
             try {
                 if (buttonclick == true) {
                     out = MessageField.getText();
                     if ((out.equals("Rock11!!22@@33??4")) || (out.equals("Paper11!!22@@33??4")) || (out.equals("Scissors11!!22@@33??4")))
                     {
                         UIManager UI=new UIManager();
                         UI.put("OptionPane.background", Color.WHITE);
                         UI.put("Panel.background", new Color(225, 245, 213));
                         JOptionPane.showOptionDialog(ChatPanel,"<html><div color=red>You Can't Send Message!!","Error",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE, null, new Object[]{}, null);    
                         MessageField.setText("");
                     }
                     else if (!(out.trim().isEmpty()) == true) {
                         if (playeronecount == 0) {
                             MessagePane.setText(MessagePane.getText() + "\nPlayer One: " + out);
                             MessageField.setText("");
                             dout.writeUTF(out);
                             playeronecount++;
                             playertwocount++;
                         } else {
                             MessagePane.setText(MessagePane.getText() + "\n\nPlayer One: " + out);
                             MessageField.setText("");
                             dout.writeUTF(out);
                         }

                     }
                 }
                 else
                 {
                         UIManager UI=new UIManager();
                         UI.put("OptionPane.background", Color.WHITE);
                         UI.put("Panel.background", new Color(225, 245, 213));
                         JOptionPane.showOptionDialog(ChatPanel,"<html><div color=red>You Can't Send Message!!","Error",JOptionPane.DEFAULT_OPTION,JOptionPane.ERROR_MESSAGE, null, new Object[]{}, null);    
                         MessageField.setText("");
                 }
             } catch (IOException ex) {
             }
         }
    }

    @Override
    public void run() {
        try {
            System.out.println("Server Run");
            serversocket = new ServerSocket(2222);
            socket = serversocket.accept();
            din = new DataInputStream(socket.getInputStream());
            dout = new DataOutputStream(socket.getOutputStream());
            while (count!=0) {
                str = din.readUTF();
                if ((!(str.isEmpty()) == true) && flag == true) {
                    flag = false;
                } else if ((!(str.isEmpty()) == true) && flag == false) {
                    if ((str.equals("Rock11!!22@@33??4")) || (str.equals("Paper11!!22@@33??4")) || (str.equals("Scissors11!!22@@33??4"))) {
                        receivedata = 1;
                    }

                }

                if ((str.equals("Rock11!!22@@33??4")) || (str.equals("Paper11!!22@@33??4")) || (str.equals("Scissors11!!22@@33??4"))) {
                    buttonclick = false;
                    if (check == true) {
                        check = false;
                        new ImageUpdate().ServerImageUpdate(PlayerTwoLabel, str);
                        PlayerTwoLabel.setVisible(true);
                        if ((new Score().ScoreUpdate(out, str)) == 1) {
                            playerone_score++;
                            String PlayerOneScore = Integer.toString(playerone_score);
                            PlayerOneScoreLabel.setText(PlayerOneScore);
                        } else if ((new Score().ScoreUpdate(out, str)) == -1) {
                            playertwo_score++;
                            count--;
                            String PlayerTwoScore = Integer.toString(playertwo_score);
                            PlayerTwoScoreLabel.setText(PlayerTwoScore);
                        }
                        new ImageRemove(PlayerOneLabel, PlayerTwoLabel);
                        str = "";
                        firstsend = 0;
                        buttonclick = true;
                    }
                } else {
                    if (!(str.equals("End11!!22@@33??4")) == true) {
                        try {
                            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new BufferedInputStream(new FileInputStream("res\\messenger.wav")));
                            Clip clip = AudioSystem.getClip();
                            clip.open(audioInputStream);
                            clip.start();
                        } catch (Exception ex) {
                        }

                        if (playertwocount == 0) {
                            MessagePane.setText(MessagePane.getText() + "\nPlayer Two: " + str);
                            playertwocount++;
                            playeronecount++;
                            str = "";
                            firstsend = 0;
                        } else {
                            MessagePane.setText(MessagePane.getText() + "\n\nPlayer Two: " + str);
                            str = "";
                            firstsend = 0;
                        }
                    } else {
                        count=0;
                    }
                }
              
            }
            dout.writeUTF("End11!!22@@33??4");
            if(count==0 || str.equals("End11!!22@@33??4"))
            {
                new MultiplePlayerGameOver(playerone_score);
                this.setVisible(false);
            }
            din.close();
            dout.close();
            socket.close();
            serversocket.close();
        } catch (IOException ex) {
        }
    }

}
