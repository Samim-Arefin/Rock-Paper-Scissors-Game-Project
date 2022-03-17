
package samim;
public class Score {
    int check=0;
    public Score() {

    }

    public int ScoreUpdate(String Client, String Server) {
            
        if ((Client.equals("Rock11!!22@@33??4")) && (Server.equals("Scissors11!!22@@33??4"))) {
            check = 1;
        } else if ((Client.equals("Scissors11!!22@@33??4")) && (Server.equals("Paper11!!22@@33??4"))) {
            check = 1;
        } else if ((Client.equals("Paper11!!22@@33??4")) && (Server.equals("Rock11!!22@@33??4"))) {
            check = 1;
        } else if ((Server.equals("Rock11!!22@@33??4")) && (Client.equals("Scissors11!!22@@33??4"))) {
            check = -1;
        } else if ((Server.equals("Scissors11!!22@@33??4")) && (Client.equals("Paper11!!22@@33??4"))) {
            check = -1;
        } else if ((Server.equals("Paper11!!22@@33??4")) && (Client.equals("Rock11!!22@@33??4"))) {
            check = -1;
        }
        return check;
    }
}
