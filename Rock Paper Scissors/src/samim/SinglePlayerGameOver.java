package samim;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SinglePlayerGameOver extends JFrame implements Runnable {

    private final JPanel GameOverPanel, OthersPanel;
    private final JLabel GameOverLabel, ScoreLabel, ScoreInfoLabel;
    private final JButton Home,Exit;
    int Score;

    private void ButtonPerform(JButton obj) {
        obj.setBorderPainted(false);
        //obj.setContentAreaFilled(false);
        obj.setFocusPainted(false);
       // obj.setOpaque(false);
    }

    public SinglePlayerGameOver(int Score) {
        this.Score = Score;
        setTitle("GameOver");
        this.setSize(1000, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setUndecorated(true);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);

        GameOverPanel = new JPanel();
        GameOverPanel.setBounds(0, 0, 1000, 400);
        GameOverPanel.setLayout(null);
        this.add(GameOverPanel);

        GameOverLabel = new JLabel();
        GameOverLabel.setBounds(0, 0, 1000, 400);
        GameOverPanel.add(GameOverLabel);

        OthersPanel = new JPanel();
        OthersPanel.setBounds(0, 400, 1000, 300);
        OthersPanel.setLayout(null);
        OthersPanel.setBackground(new Color(253, 249, 249));
        this.add(OthersPanel);
        ScoreInfoLabel = new JLabel("Your Score:");

        ScoreInfoLabel.setBounds(380, 0, 200, 100);
        OthersPanel.add(ScoreInfoLabel);
        ScoreInfoLabel.setForeground(Color.DARK_GRAY);
        ScoreInfoLabel.setFont(new Font(Font.MONOSPACED, Font.BOLD, 25));

        ScoreLabel = new JLabel();
        ScoreLabel.setBounds(550, 0, 200, 100);
        OthersPanel.add(ScoreLabel);
        ScoreLabel.setForeground(new Color(16, 47, 125));
        ScoreLabel.setFont(new Font(Font.MONOSPACED, Font.BOLD, 25));
        String S = Integer.toString(Score);
        ScoreLabel.setText(S);

        File file = new File("res\\SinglePlayerHighScore.txt");
        try {
            Scanner SC = new Scanner(file);
            int high = SC.nextInt();
            if (Score > high) {
                FileOutputStream fos = new FileOutputStream("res\\SinglePlayerHighScore.txt");
                String score = Integer.toString(Score);
                try {
                    fos.write(score.getBytes());
                } catch (IOException ex) {
                }

            }

        } catch (FileNotFoundException ex) {

        }

        Home = new JButton("Home");
        OthersPanel.add(Home);
        Home.setBounds(40, 230, 100, 40);
        Home.setBackground(new Color(56, 74, 114));
        Home.setForeground(Color.WHITE);
        ButtonPerform(Home);

        Home.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new Home();
                setVisible(false);
            }
        });
        
        Exit = new JButton("Exit");
        OthersPanel.add(Exit);
        Exit.setBounds(850, 230, 100, 40);
        Exit.setBackground(new Color(56, 74, 114));
        Exit.setForeground(Color.WHITE);
        ButtonPerform(Exit);
        Exit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });

        new Thread(this, "GameOver").start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                GameOverLabel.setIcon(new ImageIcon("res\\GameOver2.png"));
                Thread.sleep(300);
                GameOverLabel.setIcon(new ImageIcon("res\\GameOver3.png"));
                Thread.sleep(300);
                GameOverLabel.setIcon(new ImageIcon("res\\GameOver4.png"));
                Thread.sleep(300);
                GameOverLabel.setIcon(new ImageIcon("res\\GameOver5.png"));
                Thread.sleep(300);
            } catch (InterruptedException ex) {
            }
        }
    }
}
