import java.io.*;
import java.net.*;

public class UDPClient {
    public static void main(String args[]) throws Exception {
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        DatagramSocket clientSocket = new DatagramSocket();
        
        InetAddress IPAddress = InetAddress.getByName("localhost"); // Endereço do servidor
        byte[] sendData;
        byte[] receiveData = new byte[1024];
        
        String sentence = inFromUser.readLine();
        sendData = sentence.getBytes();
        
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
        clientSocket.send(sendPacket); // Envia o pacote
        
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        clientSocket.receive(receivePacket); // Recebe a resposta
        
        String modifiedSentence = new String(receivePacket.getData());
        
        System.out.println("Servidor diz: " + modifiedSentence);
        clientSocket.close();
    }
}
