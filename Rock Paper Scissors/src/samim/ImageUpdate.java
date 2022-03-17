package samim;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ImageUpdate {
    public ImageUpdate()
    {
        
    }
    public void ServerImageUpdate(JLabel ServerLabel,String str)
    {
         if(str.equals("Rock11!!22@@33??4"))
         {
              ServerLabel.setIcon(new ImageIcon("res\\computerrock.png"));
         }
         else if(str.equals("Paper11!!22@@33??4"))
         {
             ServerLabel.setIcon(new ImageIcon("res\\computerpaper.png"));
         }
         else if(str.equals("Scissors11!!22@@33??4"))
         {
             ServerLabel.setIcon(new ImageIcon("res\\computerscissors.png"));
         }
    }
}
