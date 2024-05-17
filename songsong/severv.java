package songsong;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class severv extends Thread{
    Socket s;
     severv(){}
     severv(Socket s){
        this.s = s;
    }
    @Override
    public void run(){
        try {
            
            DataInputStream in = new DataInputStream(s.getInputStream());
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            while (true) {
                try {
                    
                    double a = in.readDouble();
                    double b = in.readDouble();
                    out.writeDouble(a+b);

                } catch (Exception e) {
                    // TODO: handle exception
                    s.close();
                    break;
                }
                
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    
}
