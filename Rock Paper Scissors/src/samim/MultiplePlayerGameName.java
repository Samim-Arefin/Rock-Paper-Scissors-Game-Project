package samim;


import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class MultiplePlayerGameName implements Runnable {

    private final JLabel GameNameLabel;

    public MultiplePlayerGameName(JLabel GameNameLabel) {
        this.GameNameLabel = GameNameLabel;
        new Thread(this,"Game Name").start();

    }

    @Override
    public void run() {
        while (true) {
            try {
                GameNameLabel.setIcon(new ImageIcon("res\\1.png"));
                Thread.sleep(300);
                GameNameLabel.setIcon(new ImageIcon("res\\2.png"));
                Thread.sleep(300);
                GameNameLabel.setIcon(new ImageIcon("res\\3.png"));
                Thread.sleep(300);
                GameNameLabel.setIcon(new ImageIcon("res\\4.png"));
                Thread.sleep(300);
                GameNameLabel.setIcon(new ImageIcon("res\\5.png"));
                Thread.sleep(300);
                GameNameLabel.setIcon(new ImageIcon("res\\6.png"));
                Thread.sleep(300);
                GameNameLabel.setIcon(new ImageIcon("res\\7.png"));
                Thread.sleep(300);
                GameNameLabel.setIcon(new ImageIcon("res\\8.png"));
                Thread.sleep(300);
                GameNameLabel.setIcon(new ImageIcon("res\\9.png"));
                Thread.sleep(300);
                GameNameLabel.setIcon(new ImageIcon("res\\10.png"));
                Thread.sleep(300);
            } catch (InterruptedException ex) {
            }
        }
    }
}
