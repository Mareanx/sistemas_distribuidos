import java.net.*;

public class UDPServer {
    public static void main(String args[]) throws Exception {
        DatagramSocket serverSocket = new DatagramSocket(9876); // Porta de escuta
        
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];
        
        System.out.println("Servidor UDP pronto para receber pacotes...");
        
        while (true) {
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket); // Recebe o pacote
            
            String sentence = new String(receivePacket.getData());
            InetAddress IPAddress = receivePacket.getAddress();
            int port = receivePacket.getPort();
            
            System.out.println("Cliente diz: " + sentence);
            
            String capitalizedSentence = sentence.toUpperCase();
            sendData = capitalizedSentence.getBytes();
            
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
            serverSocket.send(sendPacket); // Envia a resposta
        }
    }
}
