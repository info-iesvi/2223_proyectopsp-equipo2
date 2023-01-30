import java.net.Socket;

public class LectorDeComandos {
    public static void menu() {
        System.out.println("-- MENÚ DE OPCIONES --");
        System.out.println("1. Libro");
        System.out.println("2. Frase");
        System.out.println("3. Exit");
    }

    public static String process(Socket cliente, String comando) {

        String[] libros = {"Catalina de Lancaster - María Jesús Álvarez",
                "Don Quijote de la Mancha - Miguel de Cervantes y Saavedra",
                "Cien años de soledad - Gabriel García Márquez",
                "El invierno del mundo - Ken Follet",
                "Africanus, el hijo del cónsul - Santiago Posteguillo"};

        String[] frases = {
                "No dejes para mañana lo que puedas hacer hoy - Pepe Grillo",
                "Un título abre puertas, el conocimiento las mantiene abiertas - jlr2",
                "Un lenguaje de programación es de bajo nivel cuando requiere que prestes atención a lo irrelenvante - Alan J. Perlis",
                "Hablar es barato. Enséñame el código - Linus Torvalds"
        };

        String mensaje;

        if (comando.equalsIgnoreCase("libro")) {
            mensaje = libros[(int)(Math.random()*5+1)];
        }
        else if (comando.equalsIgnoreCase("frase")) {
            mensaje = frases[(int)(Math.random()*4+1)];
        }
        else if (comando.equalsIgnoreCase("exit")) {
            mensaje = "Cliente " + cliente + " saliendo";
        }
        else {
            mensaje = "La petición no se puede resolver";
        }

        return mensaje;
    }
}