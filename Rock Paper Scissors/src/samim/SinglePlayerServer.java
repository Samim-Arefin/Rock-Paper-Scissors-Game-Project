
package samim;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;

public class SinglePlayerServer implements Runnable {

    private ServerSocket serversocket;
    private Socket socket;
    private DataInputStream din;
    private DataOutputStream dout;

    public SinglePlayerServer() {
        new Thread(this,"SingleClientServer").start();
    }

    @Override
    public void run() {
        try {
            System.out.println("Server Run");
            serversocket = new ServerSocket(2222);
            socket = serversocket.accept();
            din = new DataInputStream(socket.getInputStream());
            dout = new DataOutputStream(socket.getOutputStream());
            String str;
            int count = 5;
            ArrayList<String> List = new ArrayList<String>();
            List.add("Rock11!!22@@33??4");
            List.add("Paper11!!22@@33??4");
            List.add("Scissors11!!22@@33??4");
            while (count > 0) {
                str = din.readUTF();
                if(str.equals("End"))
                {
                    count=0;
                }
                else {
                    Random rand = new Random();
                    String Input = List.get(rand.nextInt(List.size()));
                    if ((new Score().ScoreUpdate(str, Input)) == -1) {
                        count--;
                    }
                    dout.writeUTF(Input);
                    dout.flush();
                }
            }
            din.close();
            dout.close();
            socket.close();
            serversocket.close();
        } catch (IOException ex) {
        }
    }
}

