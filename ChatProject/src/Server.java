import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Andrey_pers on 22.10.2016.
 */
public class Server {

    public static void main(String[] args) {

        int port = 6666;

        try {
            Socket socket = new ServerSocket(port).accept();

            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            DataOutputStream out = new DataOutputStream(outputStream);
            DataInputStream in = new DataInputStream(inputStream);

            String message = null;

            while(true){

                message=in.readUTF();
                System.out.println("Input message: "+message);
                out.writeUTF(message);
                out.flush();
            }

        }  catch (IOException e) {
            e.printStackTrace();
        }


    }
}
