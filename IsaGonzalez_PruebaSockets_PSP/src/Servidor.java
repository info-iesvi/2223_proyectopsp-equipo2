import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) throws IOException {
        ServerSocket servidor = new ServerSocket(5000);
        int cantidadClientes = 0;

        while (cantidadClientes <= 3) {
            Socket cliente;
            cliente = servidor.accept(); // Esperando al cliente
            cantidadClientes++;

            HiloServidor hilo = new HiloServidor(cliente);
            hilo.start(); // Se atiende al cliente

            if (cantidadClientes > 3) {
                System.out.println("Servidor> SERVIDOR FINALIZADO");
                servidor.close();
            }
        }
    }
}
