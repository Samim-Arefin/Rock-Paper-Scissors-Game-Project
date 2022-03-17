package samim;

import javax.swing.JLabel;
public class ImageRemove implements Runnable {
    private JLabel PlayerOne,PlayerTwo;
    
    public ImageRemove(JLabel PlayerOne,JLabel PlayerTwo)
    {
       this.PlayerOne=PlayerOne;
       this.PlayerTwo=PlayerTwo;
       new Thread(this,"Update").start();
    }
    
    @Override
    public void run()
    {
        try {
            Thread.sleep(1000);
            PlayerOne.setVisible(false);
            PlayerTwo.setVisible(false);
        } catch (InterruptedException ex) {
           
        }
    }
}
