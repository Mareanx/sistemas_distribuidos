import java.io.*;
import java.net.*;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234); // Porta de escuta
        
        System.out.println("Servidor TCP pronto para receber conexões...");
        
        Socket clientSocket = serverSocket.accept(); // Aguarda conexão do cliente
        
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        
        String inputLine;
        
        while ((inputLine = in.readLine()) != null) {
            System.out.println("Cliente diz: " + inputLine);
            out.println("Servidor recebeu: " + inputLine);
        }
        
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
}
