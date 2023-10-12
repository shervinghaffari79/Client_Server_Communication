import javax.xml.crypto.Data;
import java.net.*;
import java.io.*;
import java.util.Date;
import java.util.Scanner;

class Client{
    public static void main(String args[])throws Exception{

        Socket socket=new Socket("localhost",5000);

        DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        DataInputStream input = new DataInputStream(socket.getInputStream());

        String line = " ";

        while (!line.equals("over")){
            line=bufferedReader.readLine();
            outputStream.writeUTF(line);

            if (line.equals("time"))
                System.out.println(input.readUTF());
        }
    }}