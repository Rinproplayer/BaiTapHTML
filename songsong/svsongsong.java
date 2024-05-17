package songsong;

import java.net.ServerSocket;
import java.net.Socket;

public class svsongsong {
    private static Socket s;

    public static void main(String[] args) {
        try {
        ServerSocket ss = new ServerSocket(1234);
        while (true) {

            s = ss.accept();
            System.out.println("RUN SVV");
            severv t = new severv(s);
            t.start();
            
        }
        } catch (Exception e) {
            // TODO: handle exception
        }        
    }
    
}
