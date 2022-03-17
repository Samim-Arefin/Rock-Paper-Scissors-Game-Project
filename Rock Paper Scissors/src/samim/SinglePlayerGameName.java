package samim;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class SinglePlayerGameName implements Runnable {

    private final JLabel GameNameLabel;

    public SinglePlayerGameName(JLabel GameNameLabel) {
        this.GameNameLabel = GameNameLabel;
        new Thread(this,"Game Name").start();

    }

    @Override
    public void run() {
        while (true) {
            try {
                GameNameLabel.setIcon(new ImageIcon("res\\GameName1.png"));
                Thread.sleep(300);
                GameNameLabel.setIcon(new ImageIcon("res\\GameName2.png"));
                Thread.sleep(300);
                GameNameLabel.setIcon(new ImageIcon("res\\GameName3.png"));
                Thread.sleep(300);
                GameNameLabel.setIcon(new ImageIcon("res\\GameName4.png"));
                Thread.sleep(300);
                GameNameLabel.setIcon(new ImageIcon("res\\GameName5.png"));
                Thread.sleep(300);
                GameNameLabel.setIcon(new ImageIcon("res\\GameName6.png"));
                Thread.sleep(300);
                GameNameLabel.setIcon(new ImageIcon("res\\GameName7.png"));
                Thread.sleep(300);
                GameNameLabel.setIcon(new ImageIcon("res\\GameName8.png"));
                Thread.sleep(300);
                GameNameLabel.setIcon(new ImageIcon("res\\GameName9.png"));
                Thread.sleep(300);
                GameNameLabel.setIcon(new ImageIcon("res\\GameName10.png"));
                Thread.sleep(300);
            } catch (InterruptedException ex) {
            }
        }
    }
}
