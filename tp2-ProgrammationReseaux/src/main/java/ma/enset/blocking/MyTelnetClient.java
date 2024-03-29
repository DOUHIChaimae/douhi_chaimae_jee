package ma.enset.blocking;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class MyTelnetClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 1235);
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os, true);
            new Thread(() -> {
                try {
                    String request;
                    while ((request = br.readLine()) != null) {
                        String response = br.readLine();
                        System.out.println(response);
                    }
                } catch (IOException e) {
                    throw new RuntimeException();
                }
            }).start();
            Scanner scanner = new Scanner(System.in);
            while (true) {
                String request = scanner.nextLine();
                pw.println(request);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
