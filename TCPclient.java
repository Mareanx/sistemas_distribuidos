import java.io.*;
import java.net.*;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        String serverHostname = "localhost"; // Endereço do servidor
        int port = 1234; // Porta do servidor
        
        Socket socket = new Socket(serverHostname, port);
        
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        
        String userInput;
        
        while ((userInput = stdIn.readLine()) != null) {
            out.println(userInput);
            System.out.println("Servidor diz: " + in.readLine());
        }
        
        out.close();
        in.close();
        stdIn.close();
        socket.close();
    }
}
