import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class HiloServidor extends Thread {
    BufferedReader mensajeEntrada;
    PrintWriter mensajeSalida;
    Socket cliente;

    public HiloServidor(Socket socket) throws IOException {
        this.cliente = socket;

        // Se crean flujos de entrada y salida con el cliente
        mensajeSalida = new PrintWriter(socket.getOutputStream(), true);
        mensajeEntrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public void run() {
        String comando = "";

        while (!comando.equalsIgnoreCase("exit")) {
            try {
                comando = mensajeEntrada.readLine(); // obtener comando
            } catch (IOException ex) {
                throw new RuntimeException();
            }
            mensajeSalida.println(LectorDeComandos.process(this.cliente, comando)); // Enviar respuesta
        }

        try {
            mensajeSalida.close();
            mensajeEntrada.close();
            cliente.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
