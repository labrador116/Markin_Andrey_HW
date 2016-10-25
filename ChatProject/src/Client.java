import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {

        int port = 6666;
        String address = "127.0.0.1";

        try {
            Socket socket = new Socket(InetAddress.getByName(address), port);

            InputStream input = socket.getInputStream();
            DataInputStream in = new DataInputStream(input);

            OutputStream output = socket.getOutputStream();
            DataOutputStream out = new DataOutputStream(output);

            String message = null;

            while (true) {
                message = new Scanner(System.in).nextLine();
                out.writeUTF(message);
                out.flush();

                message = in.readUTF();
                System.out.println("Message: " + message);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}