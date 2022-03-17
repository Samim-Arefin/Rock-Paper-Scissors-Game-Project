package samim;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
public class Home extends JFrame {
    private final JLabel HomePageLabel;
    private JButton PlayButton,HighScoreButton,AboutButton,InfoButton,ExitButton;
    
    private void ButtonPerform(JButton obj)
    {
        obj.setBorderPainted(false);
        obj.setContentAreaFilled(false);
        obj.setFocusPainted(false);
        obj.setOpaque(false);
    }
    
    public Home()
    {
        super("Home");
        this.setSize(1000,700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);
        setLayout(null);
        this.setResizable(false);
        HomePageLabel=new JLabel(new ImageIcon("res\\HomePage.png"));
        HomePageLabel.setBounds(0, 0, 1000, 700);
        this.add(HomePageLabel);
       
        PlayButton=new JButton();
        PlayButton.setBounds(20, 70, 156, 46);
        ButtonPerform(PlayButton);
        PlayButton.setIcon(new ImageIcon("res\\Play.png"));
        HomePageLabel.add(PlayButton);

        PlayButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new PlayMode();
                setVisible(false);
            }
        });

        HighScoreButton=new JButton();
        HighScoreButton.setBounds(20, 130, 156, 46);
        ButtonPerform(HighScoreButton);
        HighScoreButton.setIcon(  new ImageIcon("res\\HighScore.png"));
        HomePageLabel.add(HighScoreButton);

        HighScoreButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new HighScoreMode();
                setVisible(false);
            }
        });

        InfoButton=new JButton();
        InfoButton.setBounds(20, 190, 156, 46);
        ButtonPerform(InfoButton);
        InfoButton.setIcon(new ImageIcon("res\\Info.png"));
        HomePageLabel.add(InfoButton);

        InfoButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new Info();
                setVisible(false);
            }
        });
            
        AboutButton=new JButton();
        AboutButton.setBounds(20, 250, 156, 46);
        ButtonPerform(AboutButton);
        AboutButton.setIcon(new ImageIcon("res\\About.png"));
        HomePageLabel.add(AboutButton);

        AboutButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new About();
                setVisible(false);
            }
        });
            
        ExitButton=new JButton();
        ExitButton.setBounds(20, 310, 156, 46);
        ButtonPerform(ExitButton);
        ExitButton.setIcon(new ImageIcon("res\\Exit.png"));
        HomePageLabel.add(ExitButton);

        ExitButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
        this.setVisible(true);
    }
}

