import java.net.*;
import java.io.*;
import java.util.Date;
import java.util.Scanner;

class Server{
    public static void main(String args[])throws Exception{

        ServerSocket serverSocket=new ServerSocket(5000);
        Socket socket = serverSocket.accept();
        System.out.println("connected");
        DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
        DataInputStream inputStream = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        DataInputStream inputStream1 = new DataInputStream(System.in);
        String line = " ";
        while (!line.equals("over")){

            line = inputStream.readUTF();

            if (line.equals("time"))
                outputStream.writeUTF("Server : " + new Date());
            else
                System.out.println("Client : " + line);

        }
    }

}