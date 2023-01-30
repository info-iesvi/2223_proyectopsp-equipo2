import java.io.*;
import java.net.Socket;

public class Cliente {

    public static void main(String[] args) throws Exception {
        Socket cliente = new Socket("localhost", 5000);

        // Se crean los flujos de entrada y salida
        PrintWriter mensajeSalida = new PrintWriter(cliente.getOutputStream(), true);
        BufferedReader mensajeEntrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));

        // Flujo de entrada
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        String comando = "";
        String respuesta = "";

        do {
            LectorDeComandos.menu();
            System.out.println("Cliente> ");
            comando = entrada.readLine();
            mensajeSalida.println(comando); // Envío del comando al servidor
            respuesta = mensajeEntrada.readLine(); // Recibo respuesta del servidor
            System.out.println("Servidor> " + respuesta);
        }
        while (!comando.equalsIgnoreCase("exit"));

        mensajeSalida.close();
        mensajeEntrada.close();
        entrada.close();
        cliente.close();
    }
}
